package com.yukinonlab.yukinoncolorpicker

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.opencv.android.OpenCVLoader
import kotlinx.android.synthetic.main.content_main.*

import com.yukinonlab.yukinoncolorpicker.PermissionPackage.ParmissionManager

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        init {
            System.loadLibrary("opencv_java4")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OpenCVLoader.initDebug()
        topContents.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onClick(v: View?) {
        Log.d("test", "aaaaaa")
        ParmissionManager.getPermissionCamera(this)

        if(!OpenCVLoader.initDebug()){
            Log.d("OpenCV", "Failed");
        }else{
            Log.d("OpenCV", "successfully built !");
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
