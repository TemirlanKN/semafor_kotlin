package com.trasty.kotlin_project_1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    var imgSemafor: ImageView? = null
    var counter:Int = 0
    var timer:Timer? = null
    var isRun = false
    var imgArray:IntArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgSemafor = findViewById(R.id.semaforImage)
    }

    fun onclickStartStop(view: View){
        view as ImageButton
        if (!isRun) {
            startStop()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
        } else {
            imgSemafor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            isRun = false
            counter = 0
        }

    }

    private fun startStop(){
        timer = Timer()
        timer?.schedule(object : TimerTask(){
            override fun run() {
                runOnUiThread(){
                    imgSemafor?.setImageResource(imgArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }
        }, 0, 1000)
    }
}