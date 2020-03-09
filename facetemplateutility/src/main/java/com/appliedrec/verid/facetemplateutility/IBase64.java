package com.appliedrec.verid.facetemplateutility;

/**
 * Abstraction of base 64 encoding and decoding
 * @since 2.0.0
 * @deprecated 2.1.0 Use {@link FaceTemplateBase64Coder}
 */
@Deprecated
public interface IBase64 {

    /**
     * Encode byte array to base 64 string
     * @param bytes Data to encode
     * @return Base 64 string
     * @since 2.0.0
     */
    String encode(byte[] bytes);

    /**
     * Decode byte array from base 64 string
     * @param string Base 64 string to decode
     * @return Byte array
     * @since 2.0.0
     */
    byte[] decode(String string);
}
