package com.appliedrec.verid.facetemplateutility;

import org.apache.commons.codec.binary.Base64;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.charset.Charset;

/**
 * Utility for comparing and converting Ver-ID face templates
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public abstract class FaceTemplateUtility<T> {

    /**
     * @deprecated 2.1.0 Using {@link FaceTemplateBase64Coder}
     */
    @Deprecated
    public static final IBase64 DEFAULT_BASE_64 = new IBase64() {
        @Override
        public byte[] decode(String string) {
            return Base64.decodeBase64(string);
        }

        @Override
        public String encode(byte[] bytes) {
            //noinspection CharsetObjectCanBeUsed
            return new String(Base64.encodeBase64(bytes), Charset.forName("UTF-8"));
        }
    };

    /**
     * Default standard deviation value
     * @since 2.0.0
     */
    public static final float DEFAULT_STANDARD_DEVIATION = 0.1786f;

    /**
     * Get face template coder for encoding and decoding face templates
     * @return Face template coder
     * @since 2.1.0
     */
    public abstract FaceTemplateCoder<T> getFaceTemplateCoder();

    private Float norm = null;
    private float standardDeviation = DEFAULT_STANDARD_DEVIATION;
    @Deprecated
    private IBase64 base64 = DEFAULT_BASE_64;

    private FaceTemplateUtility() {
    }

    //region Factory methods

    /**
     * Construct an instance of FaceTemplateUtility with default settings
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public static FaceTemplateUtility<float[]> defaultInstance() {
        return new FaceTemplateUtility<float[]>() {

            @Override
            public FaceTemplateCoder<float[]> getFaceTemplateCoder() {
                return new FaceTemplateCoder<float[]>() {
                    @Override
                    public float[] encodeFaceTemplate(float[] faceTemplate) {
                        return faceTemplate;
                    }

                    @Override
                    public float[] decodeFaceTemplate(float[] encodedFaceTemplate) {
                        return encodedFaceTemplate;
                    }
                };
            }
        };
    }

    /**
     * Construct an instance of FaceTemplateUtility with unit norm (1)
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public static FaceTemplateUtility<float[]> withUnitNorm() {
        FaceTemplateUtility<float[]> instance = FaceTemplateUtility.defaultInstance();
        instance.norm = 1f;
        return instance;
    }

    /**
     * Construct an instance of FaceTemplateUtility with the given standard deviation
     * @param standardDeviation Standard deviation to use when comparing face templates
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public static FaceTemplateUtility<float[]> withStandardDeviation(float standardDeviation) {
        FaceTemplateUtility<float[]> instance = FaceTemplateUtility.defaultInstance();
        return instance.setStandardDeviation(standardDeviation);
    }

    /**
     * Construct an instance of FaceTemplateUtility with the given base 64 coder
     * @param base64 Base 64 coder to use when converting face templates to strings
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     * @deprecated 2.1.0 Use {@link #withCoder(FaceTemplateCoder)}
     */
    @Deprecated
    public static FaceTemplateUtility<float[]> withBase64(IBase64 base64) {
        FaceTemplateUtility<float[]> instance = FaceTemplateUtility.defaultInstance();
        return instance.setBase64(base64);
    }

    /**
     * Construct an instance of FaceTemplateUtility with the given coder
     * @param coder Encodes and decodes face templates
     * @param <T> Type of value handled by the coder
     * @return Instance of FaceTemplateUtility
     * @since 2.1.0
     */
    public static <T> FaceTemplateUtility<T> withCoder(final FaceTemplateCoder<T> coder) {
        return new FaceTemplateUtility<T>() {
            @Override
            public FaceTemplateCoder<T> getFaceTemplateCoder() {
                return coder;
            }
        };
    }

    //endregion

    //region Settings

    /**
     * Set the standard deviation to use when comparing face templates
     * @param standardDeviation Standard deviation
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public FaceTemplateUtility<T> setStandardDeviation(float standardDeviation) {
        this.standardDeviation = standardDeviation;
        return this;
    }

    /**
     * Get the standard deviation to use when comparing face templates
     * @return Standard deviation
     * @since 2.0.0
     */
    public float getStandardDeviation() {
        return standardDeviation;
    }

    /**
     * Set the base 64 coder to use when converting face templates to strings
     * @param base64 Base 64 coder
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     * @deprecated 2.1.0 Use {@link #getFaceTemplateCoder()}
     */
    @Deprecated
    public FaceTemplateUtility<T> setBase64(IBase64 base64) {
        if (base64 != null) {
            this.base64 = base64;
        } else {
            this.base64 = DEFAULT_BASE_64;
        }
        return this;
    }

    /**
     * Get the base 64 coder to use when converting face templates to strings
     * @return Base 64 coder
     * @since 2.0.0
     * @deprecated 2.1.0 Use {@link #getFaceTemplateCoder()}
     */
    @Deprecated
    public IBase64 getBase64() {
        return base64;
    }

    //endregion

    //region Face comparison

    /**
     * Compare two face templates
     * @param template1 First face template
     * @param template2 Second face template
     * @return Comparison score
     * @since 2.0.0
     */
    public float compareFaceTemplates(T template1, T template2) {
        float norm1;
        float norm2;
        float[] t1 = getFaceTemplateCoder().decodeFaceTemplate(template1);
        float[] t2 = getFaceTemplateCoder().decodeFaceTemplate(template2);
        if (this.norm != null) {
            norm1 = this.norm;
            norm2 = this.norm;
        } else {
            norm1 = this.getRawFaceTemplateNorm(t1);
            norm2 = this.getRawFaceTemplateNorm(t2);
        }
        return innerProduct(t1, t2) / (norm1 * norm2) / standardDeviation;
    }

    /**
     * Calculate norm for face template
     * @param template Face template
     * @return Norm
     * @since 2.0.0
     */
    public float getFaceTemplateNorm(T template) {
        return getRawFaceTemplateNorm(getFaceTemplateCoder().decodeFaceTemplate(template));
    }

    private float innerProduct(float[] template1, float[] template2) {
        float sum = 0;
        for (int i=0; i<template1.length && i<template2.length; i++) {
            sum += template1[i] * template2[i];
        }
        return sum;
    }

    private float getRawFaceTemplateNorm(float[] template) {
        return (float)Math.sqrt(innerProduct(template, template));
    }

    //endregion

    //region Face template conversion

    /**
     * Convert face template to string
     * @param faceTemplate Face template to be converted
     * @return String representation of the face template
     * @since 2.0.0
     * @deprecated 2.1.0 Use {@link #getFaceTemplateCoder()}
     */
    @Deprecated
    public String stringFromFaceTemplate(T faceTemplate) {
        float[] template = getFaceTemplateCoder().decodeFaceTemplate(faceTemplate);
        FloatBuffer floatBuffer = FloatBuffer.wrap(template);
        byte[] bytes = new byte[template.length * 4];
        ByteBuffer.wrap(bytes).asFloatBuffer().put(floatBuffer);
        return base64.encode(bytes);
    }

    /**
     * Convert string to face template
     * @param string String representing base 64 encoded face template
     * @return Face template
     * @since 2.0.0
     * @deprecated 2.1.0 Use {@link #getFaceTemplateCoder()}
     */
    @Deprecated
    public T faceTemplateFromString(String string) {
        byte[] bytes = base64.decode(string);
        FloatBuffer floatBuffer = ByteBuffer.wrap(bytes).asFloatBuffer();
        float[] faceTemplate = new float[floatBuffer.limit()];
        floatBuffer.get(faceTemplate);
        return getFaceTemplateCoder().encodeFaceTemplate(faceTemplate);
    }

    //endregion
}
