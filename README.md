![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fdev.ver-id.com%2Fartifactory%2Fgradle-release%2Fcom%2Fappliedrec%2Fverid%2Fface-template-utility%2Fmaven-metadata.xml) ![CI](https://github.com/AppliedRecognition/Face-Template-Utility-Java/workflows/CI/badge.svg?event=push)

# Face Template Utility

### Utility for converting and comparing raw [Ver-ID](https://github.com/AppliedRecognition/Ver-ID-UI-Android) face templates

## Installation
The library depends on `commons-codec:commons-codec:1.10` for converting face templates to base 64 strings.

Please add the following entries in your **build.gradle** file:

~~~groovy
repositories {
    maven {
        url "https://mvnrepository.com/artifact/commons-codec/commons-codec"
    }
    maven {
        url "https://dev.ver-id.com/artifactory/gradle-release"
    }
}

dependencies {
    implementation "com.appliedrec.verid:face-template-utility:2.0.0"
}
~~~

## Obtaining a raw face template

1. [Follow the instructions](https://github.com/AppliedRecognition/Ver-ID-UI-Android) to install Ver-ID SDK for Android.
2. Example function to detect a face and get its raw template:

    ~~~java
    @WorkerThread
    float[] rawFaceTemplateFromImage(Bitmap bitmap) throws Exception {
        VerIDFactory verIDFactory = new VerIDFactory(getContext());
        VerID verid = verIDFactory.createVerIDSync();
        if (verid.getFaceRecognition() instanceOf FaceRecognition) {
            VerIDImage image = new VerIDImage(bitmap);
            Face[] faces = verid.getFaceDetection().detectFacesInImage(image, 1);
            if (faces.length == 0) {
                throw new Exception("No face detected");
            }
            RecognizableFace[] recognizableFaces = verid.getFaceRecognition().createRecognizableFacesFromFaces(faces, image);
            return ((FaceRecognition)verid.getFaceRecognition()).getRawFaceTemplate(recognizableFaces[0]);
        } else {
            throw new Exception("Using face recognition implementation that does not support extracting raw face templates");
        }
    }
    ~~~
    
## Converting face templates to strings

If you're going to be storing raw face templates you may want to convert them to strings.

1. Convert face template to string:

    ~~~java
    String string = FaceTemplateUtility.defaultInstance().stringFromFaceTemplate(template);
    ~~~
2. Convert string to face template:

    ~~~java
    float[] faceTemplate = FaceTemplateUtility.defaultInstance().faceTemplateFromString(string);
    ~~~
    
## Comparing face templates

~~~java
bool areFaceTemplatesSimilar(float[] template1, float[] template2) {
    float threshold = 4.0f;
    float score = FaceTemplateUtility.defaultInstance().compareFaceTemplates(template1, template2);
    return score > threshold;
}
~~~

## Custom base 64 encoding and decoding
The library uses Apache Commons Codec for base 64. To use other implementation implement the `IBase64` interface and pass it to the `FaceTemplateUtility.withBase64(IBase64)` factory constructor:

~~~java
import android.util.Base64;

class AndroidBase64 implements IBase64 {
    @Override
    public byte[] decode(String string) {
        return Base64.decode(string, Base64.DEFAULT);
    }
    
    @Override
    public String encode(byte[] bytes) {
        //noinspection CharsetObjectCanBeUsed
        return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }
}
~~~

~~~java
FaceTemplateUtility faceTemplateUtility = FaceTemplateUtility.withBase64(new AndroidBase64());

// Or the equivalent:

FaceTemplateUtility faceTemplateUtility = FaceTemplateUtility.defaultInstance().setBase64(new AndroidBase64());
~~~

## [Reference documentation](https://appliedrecognition.github.io/Face-Template-Utility-Java)
