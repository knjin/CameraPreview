package com.knjin.prerect.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.knjin.prerect.activity.FaceActivity;
import com.knjin.prerect.camera.CameraInterface;
import com.knjin.prerect.util.GoogleGetFace;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by aheadle on 16/6/30.
 * faceactivity中使用的cameraSurfaceview预览界面
 */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "yanzi";
    CameraInterface mCameraInterface;
    Context mContext;
    SurfaceHolder mSurfaceHolder;
    public CameraSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        mContext = context;
        mSurfaceHolder = getHolder();
        mSurfaceHolder.setFormat(PixelFormat.TRANSPARENT);//translucent°ëÍ¸Ã÷ transparentÍ¸Ã÷
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mSurfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        Log.i(TAG, "surfaceCreated...");
        CameraInterface.getInstance().doOpenCamera(null, Camera.CameraInfo.CAMERA_FACING_BACK);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub
        Log.i(TAG, "surfaceChanged...");
        CameraInterface.getInstance().doStartPreview(mSurfaceHolder, 1.333f);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        Log.i(TAG, "surfaceDestroyed...");
        CameraInterface.getInstance().doStopCamera();
    }
    public SurfaceHolder getSurfaceHolder(){
        return mSurfaceHolder;
    }

}
