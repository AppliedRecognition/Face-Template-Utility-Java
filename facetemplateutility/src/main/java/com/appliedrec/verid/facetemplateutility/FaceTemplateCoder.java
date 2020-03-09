package com.appliedrec.verid.facetemplateutility;

/**
 * Interface for encoding and decoding face templates
 * @param <T> Type to which the templates will be encoded
 * @since 2.1.0
 */
public interface FaceTemplateCoder<T> {

    /**
     * Encode face template
     * @param faceTemplate Face template
     * @return Encoded face template
     * @since 2.1.0
     */
    T encodeFaceTemplate(float[] faceTemplate);

    /**
     * Decode face template
     * @param encodedFaceTemplate Encoded face template
     * @return Face template
     * @since 2.1.0
     */
    float[] decodeFaceTemplate(T encodedFaceTemplate);
}
