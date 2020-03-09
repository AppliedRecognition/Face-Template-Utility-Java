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
    implementation "com.appliedrec.verid:face-template-utility:2.1.0"
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
    float[] template; // Face template
    FaceTemplateBase64Coder coder = new FaceTemplateBase64Coder();
    String string = coder.encodeFaceTemplate(template);
    ~~~

2. Convert string to face template:

    ~~~java
    String templateString; // Face template encoded to string
    FaceTemplateBase64Coder coder = new FaceTemplateBase64Coder();
    float[] faceTemplate = coder.decodeFaceTemplate(templateString);
    ~~~
    
3. Note that as of version 2.1.0 you can use encoded templates in comparisons. Simply construct an instance of FaceTemplateUtility with a coder of your choice. For example, to use templates that are encoded to base 64 strings use:

    ~~~java
    FaceTemplateUtility<String> faceTemplateUtility = FaceTemplateUtility.withCoder(new FaceTemplateBase64Coder());
    ~~~
    
## Comparing face templates

~~~java
bool areFaceTemplatesSimilar(float[] template1, float[] template2) {
    float threshold = 4.0f;
    float score = FaceTemplateUtility.defaultInstance().compareFaceTemplates(template1, template2);
    return score > threshold;
}
~~~

## Custom face template encoding and decoding
The library contains encoders and decoders for converting face templates from/to `String` (`FaceTemplateBase64Coder`) and `byte[]` (`FaceTemplateByteArrayCoder`). You can write your own encoder and supply it to the `FaceTemplateUtility.withCoder(FaceTemplateCoder)` factory constructor.

Here is an example of a coder that encodes the face template to JSON:

~~~java
public class FaceTemplateJsonCoder implements FaceTemplateCoder<String> {

    private Gson gson = new Gson();

    @Override
    public String encodeFaceTemplate(float[] faceTemplate) {
        return gson.toJson(faceTemplate);
    }

    @Override
    public float[] decodeFaceTemplate(String encodedFaceTemplate) {
        return gson.fromJson(encodedFaceTemplate, float[].class);
    }
}
~~~

Pass the coder to the `FaceTemplateUtility.withCoder(FaceTemplateCoder)` factory constructor:

~~~java
FaceTemplateUtility<String> faceTemplateUtility = FaceTemplateUtility.withCoder(new FaceTemplateJsonCoder());
~~~

You can then pass your JSON-encoded templates to the utility's `compareFaceTemplates` function:

~~~java
String jsonTemplate1; // JSON-encoded face template
String jsonTemplate2; // JSON-encoded face template

float score = faceTemplateUtility.compareFaceTemplates(jsonTemplate1, jsonTemplate2);
~~~

## [Reference documentation](https://appliedrecognition.github.io/Face-Template-Utility-Java)
