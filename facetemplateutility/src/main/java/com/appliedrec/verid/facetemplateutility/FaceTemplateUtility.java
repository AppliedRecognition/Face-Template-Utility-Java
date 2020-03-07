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
public class FaceTemplateUtility {

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
    public static final float DEFAULT_STANDARD_DEVIATION = 0.1786f;
    private Float norm = null;
    private float standardDeviation = DEFAULT_STANDARD_DEVIATION;
    private IBase64 base64 = DEFAULT_BASE_64;

    private FaceTemplateUtility() {
    }

    private FaceTemplateUtility(Float norm, Float standardDeviation, IBase64 base64) {
        this.norm = norm;
        if (standardDeviation != null) {
            this.standardDeviation = standardDeviation;
        }
        if (base64 != null) {
            this.base64 = base64;
        }
    }

    //region Factory methods

    /**
     * Construct an instance of FaceTemplateUtility with default settings
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public static FaceTemplateUtility defaultInstance() {
        return new FaceTemplateUtility();
    }

    /**
     * Construct an instance of FaceTemplateUtility with unit norm (1)
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public static FaceTemplateUtility withUnitNorm() {
        return new FaceTemplateUtility(1f, null, null);
    }

    /**
     * Construct an instance of FaceTemplateUtility with the given standard deviation
     * @param standardDeviation Standard deviation to use when comparing face templates
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public static FaceTemplateUtility withStandardDeviation(float standardDeviation) {
        return new FaceTemplateUtility(null, standardDeviation, null);
    }

    /**
     * Construct an instance of FaceTemplateUtility with the given base 64 coder
     * @param base64 Base 64 coder to use when converting face templates to strings
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public static FaceTemplateUtility withBase64(IBase64 base64) {
        return new FaceTemplateUtility(null, null, base64);
    }

    //endregion

    //region Settings

    /**
     * Set the standard deviation to use when comparing face templates
     * @param standardDeviation Standard deviation
     * @return Instance of FaceTemplateUtility
     * @since 2.0.0
     */
    public FaceTemplateUtility setStandardDeviation(float standardDeviation) {
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
     */
    public FaceTemplateUtility setBase64(IBase64 base64) {
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
     */
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
    public float compareFaceTemplates(String template1, String template2) {
        return compareFaceTemplates(faceTemplateFromString(template1), faceTemplateFromString(template2));
    }

    /**
     * Compare two face templates
     * @param template1 First face template
     * @param template2 Second face template
     * @return Comparison score
     * @since 2.0.0
     */
    public float compareFaceTemplates(float[] template1, float[] template2) {
        float norm1;
        float norm2;
        if (this.norm != null) {
            norm1 = this.norm;
        } else {
            norm1 = this.getFaceTemplateNorm(template1);
        }
        if (this.norm != null) {
            norm2 = this.norm;
        } else {
            norm2 = this.getFaceTemplateNorm(template2);
        }
        return innerProduct(template1, template2) / (norm1 * norm2) / standardDeviation;
    }

    /**
     * Calculate norm for face template
     * @param template Face template
     * @return Norm
     * @since 2.0.0
     */
    public float getFaceTemplateNorm(float[] template) {
        return (float)Math.sqrt(innerProduct(template, template));
    }

    private float innerProduct(float[] template1, float[] template2) {
        float sum = 0;
        for (int i=0; i<template1.length && i<template2.length; i++) {
            sum += template1[i] * template2[i];
        }
        return sum;
    }

    //endregion

    //region Face template conversion

    /**
     * Convert face template to string
     * @param faceTemplate Face template to be converted
     * @return String representation of the face template
     * @since 2.0.0
     */
    public String stringFromFaceTemplate(float[] faceTemplate) {
        FloatBuffer floatBuffer = FloatBuffer.wrap(faceTemplate);
        byte[] bytes = new byte[faceTemplate.length * 4];
        ByteBuffer.wrap(bytes).asFloatBuffer().put(floatBuffer);
        return base64.encode(bytes);
    }

    /**
     * Convert string to face template
     * @param string String representing base 64 encoded face template
     * @return Face template
     * @since 2.0.0
     */
    public float[] faceTemplateFromString(String string) {
        byte[] bytes = base64.decode(string);
        FloatBuffer floatBuffer = ByteBuffer.wrap(bytes).asFloatBuffer();
        float[] faceTemplate = new float[floatBuffer.limit()];
        floatBuffer.get(faceTemplate);
        return faceTemplate;
    }

    //endregion
}
