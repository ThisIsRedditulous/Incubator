package com.mycompany.myapp.ui.main

import android.graphics.Point

/**
 * Created by stuart on 12/31/17.
 */

class MotoXDevice: DeviceDimensions() {
    override fun getPkgPos(): Point {
        return Point(996, 255)
    }

    override fun getHactchPos(): Point {
        return Point(540, 1773)
    }

    override fun getAcceptPkgPos(): Point {
        return Point(342, 1140)
    }

    override fun getResumeButton(): Point {
        return Point(350,1100)
    }
}
