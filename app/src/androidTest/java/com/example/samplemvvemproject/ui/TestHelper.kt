package com.example.samplemvvemproject.ui

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage

fun findNavController(viewId: Int): NavController {
    val activity = getActivityInstance()!!
    return Navigation.findNavController(activity, viewId)
}

// Helper function to get the current activity
 fun getActivityInstance(): Activity? {
    var currentActivity: Activity? = null
    InstrumentationRegistry.getInstrumentation().runOnMainSync {
        val resumedActivities = ActivityLifecycleMonitorRegistry.getInstance()
            .getActivitiesInStage(Stage.RESUMED)
        if (!resumedActivities.isEmpty()) {
            currentActivity = resumedActivities.iterator().next()
        }
    }
    return currentActivity
}

