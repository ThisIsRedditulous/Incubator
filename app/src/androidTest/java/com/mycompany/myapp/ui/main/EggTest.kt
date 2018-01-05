package com.mycompany.myapp.ui.main

import android.content.Context
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.Until
import android.util.Log
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class EggTest{

    lateinit var deviceDimensions: DeviceDimensions

    @Before
    fun setup() {
        deviceDimensions = PH1Device()
    }

    @Test
    fun makeEggs(){
        val uidevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        while(true) {
            relaunchEggActivity(uidevice)

            Log.w("EggTest", "Clicking...")

            for (z in 1..5) {
                for (j in 1..5) {
                    val pos = deviceDimensions.getHactchPos()
                    uidevice.drag(pos.x-10,pos.y,pos.x+10,pos.y,500)//1 step =  5ms
                    justWait(uidevice, 5000)
                }
                Log.w("EggTest", "Checking for package...")

                for (j in 1..2) {
                    val pkgPos = deviceDimensions.getPkgPos()
                    val acceptPos = deviceDimensions.getAcceptPkgPos()
                    uidevice.click(pkgPos.x, pkgPos.y)//click top right corner (try to get package)
                    justWait(uidevice, 2000)
                    uidevice.click(acceptPos.x, acceptPos.y)//accept package (if available)
                    justWait(uidevice, 2000)
                }

            }

        }
//com.auxbrain.egginc/com.auxbrain.egginc.EggIncActivity
    }

    fun justWait(ud: UiDevice, howLong:Long){
        ud.wait(Until.hasObject(By.desc("asdf")) ,howLong)
    }

    fun relaunchEggActivity(device: UiDevice){
        device.pressHome()

        val context: Context = InstrumentationRegistry.getContext()
        val intent = context.packageManager.getLaunchIntentForPackage("com.auxbrain.egginc")
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        device.wait(Until.hasObject(By.pkg("com.auxbrain.egginc.EggIncActivity").depth(0)), 5000)

        justWait(device, 2000)
        val resumeBtnPos = deviceDimensions.getResumeButton()
        device.click(resumeBtnPos.x, resumeBtnPos.y)//click "Collect and Refill silos" incase we've been closed for a while
    }



}