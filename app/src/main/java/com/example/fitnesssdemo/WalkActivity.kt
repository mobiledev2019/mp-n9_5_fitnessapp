package com.example.fitnesssdemo
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_walk.*

class WalkActivity : AppCompatActivity(), SensorEventListener {

    internal var linear_walk: LinearLayout? = null

    var running = false
    var sensorManager:SensorManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linear_walk = findViewById<View>(R.id.linear_walk) as LinearLayout

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        linear_walk!!.setOnClickListener(View.OnClickListener {
            val i = Intent(this@WalkActivity, MainActivity::class.java)
            startActivity(i)
        })
    }

    override fun onResume() {
        super.onResume()
        running = true
        var stepsSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepsSensor == null) {
            Toast.makeText(this, "No Step Counter Sensor !", Toast.LENGTH_SHORT).show()
        } else {
            sensorManager?.registerListener(this, stepsSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onPause() {
        super.onPause()
        running = false
        sensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (running) {
            stepsValue.setText("" + event.values[0])
            km_run.setText("" + event.values[0]*0.02)
            kcal_run.setText("" + ((event.values[0]*30)/(100000)))
        }
    }
}