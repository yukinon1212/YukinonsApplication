package com.yukinonlab.yukinoncolorpicker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yukinonlab.yukinoncolorpicker.PermissionPackage.ParmissionManager
import kotlinx.android.synthetic.main.content_main.*
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity(), View.OnClickListener {

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

        if(!ParmissionManager.getPermissionCamera(this)){
            return
        }

        if(!OpenCVLoader.initDebug()){
            Log.d("OpenCV", "Failed")
            return
        }else{
            Log.d("OpenCV", "successfully built !")
        }
        startActivity(Intent(this, CameraActivity::class.java))

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
