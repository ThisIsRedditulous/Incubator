package com.mycompany.myapp.ui.main

import android.content.Context
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.Until
import android.util.Log
import org.junit.Test
import org.junit.runner.RunWith

class EggTest{

    @Test
    fun makeEggs(){
        val uidevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        while(true) {
            relaunchEggActivity(uidevice)

            Log.w("EggTest", "Clicking...")

            for (z in 1..5) {
                for (j in 1..5) {
                    for (i in 1..50) {
                        uidevice.click(540, 1773)
                    }
                    justWait(uidevice, 5000)
                }
                Log.w("EggTest", "Checking for package...")

                for (j in 1..2) {
                    uidevice.click(996, 255)//click top right corner (try to get package)
                    justWait(uidevice, 2000)
                    uidevice.click(342, 1140)//accept package (if available)
                    justWait(uidevice, 2000)
                }

                uidevice.click(123, 1818)//click research (incase we accidentally opened housing)
                justWait(uidevice, 2000)
                uidevice.click(123, 1818)//exit research
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
        device.click(350,1100)//click "Collect and Refill silos" incase we've been closed for a while
    }



}