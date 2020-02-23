package com.yukinonlab.yukinoncolorpicker.PermissionPackage

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class ParmissionManager {
    companion object {
        init {
        }

        fun getPermissionCamera(activity: Activity): Boolean {
            return if (ContextCompat.checkSelfPermission(
                    activity,
                    android.Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                val permissions = arrayOf<String>(Manifest.permission.CAMERA)
                ActivityCompat.requestPermissions(
                    activity,
                    permissions,
                    0
                )
                false
            } else {
                true
            }
        }
    }
}