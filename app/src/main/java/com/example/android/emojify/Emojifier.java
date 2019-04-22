package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;


/**
 * Created by DELL PC on 8/28/2018.
 */

public class Emojifier {
    static void DetectFaces(Context context, Bitmap bitmap){
    // create face Detector
        FaceDetector faceDetector = new FaceDetector.Builder(context).
                setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        //Build the Frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);
        Toast.makeText(context,"num of faces " + faces.size(),Toast.LENGTH_LONG).show();

        if(faces.size()==0){
            Toast.makeText(context,"no faces Detected ",Toast.LENGTH_LONG).show();
        }
        faceDetector.release();
    }

    static void getClassification(){

    }
}
