package com.appliedrec.verid.facetemplateutility;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;

/**
 * Encodes face templates to base 64 strings
 * @since 2.1.0
 */
public class FaceTemplateBase64Coder implements FaceTemplateCoder<String> {

    private FaceTemplateByteArrayCoder byteArrayCoder = new FaceTemplateByteArrayCoder();

    /**
     * Encode face template to base 64 string
     * @param faceTemplate Face template to encode
     * @return Face template encoded to base 64 string
     * @since 2.1.0
     */
    @Override
    public String encodeFaceTemplate(float[] faceTemplate) {
        //noinspection CharsetObjectCanBeUsed
        return new String(Base64.encodeBase64(byteArrayCoder.encodeFaceTemplate(faceTemplate)), Charset.forName("UTF-8"));
    }

    /**
     * Decode face template from base 64 string
     * @param encodedFaceTemplate Encoded face template
     * @return Face template
     * @since 2.1.0
     */
    @Override
    public float[] decodeFaceTemplate(String encodedFaceTemplate) {
        return byteArrayCoder.decodeFaceTemplate(Base64.decodeBase64(encodedFaceTemplate));
    }
}
