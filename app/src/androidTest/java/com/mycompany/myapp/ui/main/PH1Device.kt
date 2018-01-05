package com.mycompany.myapp.ui.main

import android.graphics.Point

/**
 * Created by stuart on 12/31/17.
 */

class PH1Device: DeviceDimensions() {
    override fun getPkgPos(): Point {
        return Point(1228, 414)
    }

    override fun getHactchPos(): Point {
        return Point(656,2450)
    }

    override fun getAcceptPkgPos(): Point {
        return Point(482, 1590)
    }

    override fun getResumeButton(): Point {
        return Point(656,1288)
    }
}