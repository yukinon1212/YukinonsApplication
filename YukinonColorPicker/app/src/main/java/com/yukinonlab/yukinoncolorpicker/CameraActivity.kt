package com.yukinonlab.yukinoncolorpicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yukinonlab.yukinoncolorpicker.PermissionPackage.ParmissionManager
import org.opencv.android.CameraBridgeViewBase
import org.opencv.android.OpenCVLoader
import org.opencv.core.Core
import org.opencv.core.Mat


class CameraActivity : AppCompatActivity(), CameraBridgeViewBase.CvCameraViewListener {
    private var m_cameraView: CameraBridgeViewBase? = null

    companion object {
        init {
            System.loadLibrary("opencv_java4")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.opencv_camera_view)
        ParmissionManager.getPermissionCamera(this)
        OpenCVLoader.initDebug()
        m_cameraView = findViewById(R.id.camera_view)
        m_cameraView!!.setCvCameraViewListener(this)
        m_cameraView!!.enableView()
    }


    override fun onCameraViewStarted(width: Int, height: Int) {

    }

    override fun onCameraViewStopped() {

    }

    override fun onCameraFrame(inputFrame: Mat?): Mat? {
        Core.bitwise_not(inputFrame, inputFrame)
        return inputFrame
    }
}