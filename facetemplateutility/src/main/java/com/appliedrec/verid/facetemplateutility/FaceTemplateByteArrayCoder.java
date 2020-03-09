package com.appliedrec.verid.facetemplateutility;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 * Encodes face templates to byte arrays
 * @since 2.1.0
 */
public class FaceTemplateByteArrayCoder implements FaceTemplateCoder<byte[]> {

    /**
     * Encode face template to a byte array
     * @param faceTemplate Face template to encode
     * @return Face template encoded to byte array
     * @since 2.1.0
     */
    @Override
    public byte[] encodeFaceTemplate(float[] faceTemplate) {
        FloatBuffer floatBuffer = FloatBuffer.wrap(faceTemplate);
        byte[] bytes = new byte[faceTemplate.length * 4];
        ByteBuffer.wrap(bytes).asFloatBuffer().put(floatBuffer);
        return bytes;
    }

    /**
     * Decode face template from a byte array
     * @param encodedFaceTemplate Encoded face template
     * @return Face template
     * @since 2.1.0
     */
    @Override
    public float[] decodeFaceTemplate(byte[] encodedFaceTemplate) {
        FloatBuffer floatBuffer = ByteBuffer.wrap(encodedFaceTemplate).asFloatBuffer();
        float[] faceTemplate = new float[floatBuffer.limit()];
        floatBuffer.get(faceTemplate);
        return faceTemplate;
    }
}
