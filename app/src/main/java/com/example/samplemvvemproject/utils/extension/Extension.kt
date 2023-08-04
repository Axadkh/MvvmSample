package com.example.samplemvvemproject.utils.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.Locale


fun View.hideKeyboard() {
    try {
        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if (inputManager.isAcceptingText) {
            inputManager.hideSoftInputFromWindow(windowToken, 0)
        }
    } catch (ex: Exception) {
ex.printStackTrace()
    }

    fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
        observe(lifecycleOwner, object : Observer<T> {
            override fun onChanged(t: T) {
                observer.onChanged(t)
                removeObserver(this)
            }


        })
    }
}


fun View.keyboardListener(onOpen:((Boolean)->Unit)){
   addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
    if (bottom < oldBottom) {
        onOpen(true)
    } else {
        onOpen(false)
    }
}
}

fun Context.setAppLocale(language: String): Context {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = resources.configuration
    config.setLocale(locale)
    config.setLayoutDirection(locale)
    return createConfigurationContext(config)
}

fun View.openKeyBoard(){
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun Activity.isDarkTheme():Boolean{
    return try {

        when (resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                true
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                false
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                false
            }
            else -> {
                false
            }
        }
    }catch (ex:Exception){
        false
    }

}

@SuppressLint("DiscouragedApi", "InternalInsetResource")
 fun Activity.getSoftKeyboardHeight(): Int {
    val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else {
        0
    }
}

@SuppressLint("DiscouragedApi", "InternalInsetResource")
 fun Activity.getStatusBarHeight(): Int {
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else {
        0
    }
}

@SuppressLint("DiscouragedApi", "InternalInsetResource")
fun Activity.navigationBarHeight(): Int {
    val resourceId: Int = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else 0

}

fun Activity.hasNavBar(): Boolean {
   return try {
        val view = findViewById<View>(android.R.id.content)
        val insets = view.rootWindowInsets
        return insets?.systemWindowInsetBottom ?: 0 > 0
    }catch (ex:Exception){
        true
    }
}


fun Activity.isSmallDevice(): Boolean {
    val configuration = resources.configuration
    val screenSize = configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
    return screenSize == Configuration.SCREENLAYOUT_SIZE_SMALL || screenSize == Configuration.SCREENLAYOUT_SIZE_NORMAL
}


fun Activity.isTabletDevice(): Boolean {
    var isTablet = false
    val configuration = resources.configuration
    if (configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
        // For XLarge screens, check if the device is a tablet based on density
        val metrics = DisplayMetrics()
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            display.getRealMetrics(metrics)
        } else {
            display.getMetrics(metrics)
        }
        if (metrics.densityDpi == DisplayMetrics.DENSITY_DEFAULT || metrics.densityDpi == DisplayMetrics.DENSITY_HIGH || metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH || metrics.densityDpi == DisplayMetrics.DENSITY_XXHIGH || metrics.densityDpi == DisplayMetrics.DENSITY_XXXHIGH) {
            // Density check passed, consider it as a tablet
            isTablet = true
        }
    }
    return isTablet
}


fun Activity.isTablet(): Boolean {
    val screenLayout = resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
    return screenLayout == Configuration.SCREENLAYOUT_SIZE_LARGE ||
            screenLayout == Configuration.SCREENLAYOUT_SIZE_XLARGE
}



