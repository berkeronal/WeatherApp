package com.kekod.weatherapp.util

import android.app.Activity
import android.os.Build
import android.view.WindowManager
import com.kekod.weatherapp.R

fun handleStatusBar(activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        activity.window.setDecorFitsSystemWindows(false)
    } else {
        //tema ayarla ve default statusbar color ver
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = activity.resources.getColor(R.color.splashBg, activity.theme)
    }
}