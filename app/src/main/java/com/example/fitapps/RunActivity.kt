package com.example.fitapps

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RunActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run)
        val intent = Intent(this, EndRunActivity::class.java)
        val times = Chronometer(this)
        times.setTextColor(Color.BLACK)
        times.setTextSize(TypedValue.COMPLEX_UNIT_IN,0.75f)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        layoutParams.setMargins(30, 40, 120, 40)
        times.layoutParams = layoutParams

        val linearLayout = findViewById<LinearLayout>(R.id.l_layout)
        linearLayout?.addView(times)

        //access the button using id
        val btn = findViewById<Button>(R.id.btn)
        btn?.setOnClickListener(object : View.OnClickListener {

            var isWorking = false

            override fun onClick(v: View) {
                if (!isWorking) {
                    times.start()
                    isWorking = true
                } else {
                    times.stop()
                    isWorking = false
                    startActivity(intent)
                }

                btn.setText(if (isWorking) R.string.start else R.string.stop)

                Toast.makeText(this@RunActivity, getString(
                    if (isWorking)
                        R.string.working

                    else
                        R.string.stopped),
                    Toast.LENGTH_SHORT).show()
            }
        })
    }
}