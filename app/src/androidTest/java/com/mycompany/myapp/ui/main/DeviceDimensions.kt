package com.mycompany.myapp.ui.main

import android.graphics.Point

/**
 * Created by stuart on 12/31/17.
 */


abstract class DeviceDimensions {
    abstract fun getPkgPos(): Point
    abstract fun getHactchPos(): Point
    abstract fun getAcceptPkgPos(): Point
    abstract fun getResumeButton(): Point
}
