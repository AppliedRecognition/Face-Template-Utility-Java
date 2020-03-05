package com.appliedrec.verid.facetemplateutility;

public class TestFaceTemplate {

    private String string;
    private float[] faceTemplate;

    public TestFaceTemplate(String string, float[] faceTemplate) {
        this.string = string;
        this.faceTemplate = faceTemplate;
    }

    public String getString() {
        return string;
    }

    public float[] getFaceTemplate() {
        return faceTemplate;
    }
}
