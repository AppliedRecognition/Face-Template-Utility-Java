package com.appliedrec.verid.facetemplateutility;

import org.apache.commons.codec.binary.Base64;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 * Utility for comparing and converting Ver-ID face templates
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class FaceTemplateUtility {

    private static final float STANDARD_DEVIATION = 0.1786f;

    //region Face comparison

    /**
     * Compare two face templates using unit norms
     * @param template1 First face template
     * @param template2 Second face template
     * @return Comparison score
     * @since 1.0.0
     */
    public static float compareFaceTemplates(String template1, String template2) {
        return compareFaceTemplates(faceTemplateFromString(template1), faceTemplateFromString(template2));
    }

    /**
     * Compare two face templates using unit norms
     * @param template1 First face template
     * @param template2 Second face template
     * @return Comparison score
     * @since 1.0.0
     */
    public static float compareFaceTemplates(float[] template1, float[] template2) {
        return innerProduct(template1, template2) / STANDARD_DEVIATION;
    }

    /**
     * Compare two face templates using given norms
     * @param template1 First face template
     * @param norm1 First face template norm
     * @param template2 Second face template
     * @param norm2 Second face template norm
     * @return Comparison score
     * @since 1.0.0
     */
    public static float compareFaceTemplates(float[] template1, float norm1, float[] template2, float norm2) {
        return innerProduct(template1, template2) / (norm1 * norm2) / STANDARD_DEVIATION;
    }

    /**
     * Get norm for face template
     * @param template Face template
     * @return Norm
     * @since 1.0.0
     */
    public static float getNormForTemplate(float[] template) {
        return (float)Math.sqrt(innerProduct(template, template));
    }

    private static float innerProduct(float[] template1, float[] template2) {
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
     * @since 1.0.0
     */
    public static String stringFromFaceTemplate(float[] faceTemplate) {
        FloatBuffer floatBuffer = FloatBuffer.wrap(faceTemplate);
        byte[] bytes = new byte[faceTemplate.length * 4];
        ByteBuffer.wrap(bytes).asFloatBuffer().put(floatBuffer);
        return Base64.encodeBase64String(bytes);
    }

    /**
     * Convert string to face template
     * @param string String representing base 64 encoded face template
     * @return Face template
     * @since 1.0.0
     */
    public static float[] faceTemplateFromString(String string) {
        byte[] bytes = Base64.decodeBase64(string);
        FloatBuffer floatBuffer = ByteBuffer.wrap(bytes).asFloatBuffer();
        float[] faceTemplate = new float[floatBuffer.limit()];
        floatBuffer.get(faceTemplate);
        return faceTemplate;
    }

    //endregion
}
