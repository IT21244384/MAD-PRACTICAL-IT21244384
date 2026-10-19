package com.example.madlab05

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * The image starts in the centre and follows the tilt of the phone, read from the
 * accelerometer. Tilt right -> image moves right, tilt forward (top away) -> image moves up.
 */
class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    private lateinit var root: View
    private lateinit var image: ImageView

    // Current (smoothed) offset of the image from the centre, in pixels
    private var offsetX = 0f
    private var offsetY = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        root = findViewById(R.id.root)
        image = findViewById(R.id.imgAndroid)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (accelerometer == null) {
            Toast.makeText(this, R.string.no_accelerometer, Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_GAME)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null || event.sensor.type != Sensor.TYPE_ACCELEROMETER) return

        // How far the image may travel so that it stays fully on screen
        val maxX = (root.width - image.width) / 2f
        val maxY = (root.height - image.height) / 2f

        // Portrait: x is positive when the phone tilts LEFT, so invert it.
        // y is positive when the top of the phone tilts UP (towards you), which should move the image down.
        val targetX = TiltMapper.offsetFor(-event.values[0], maxX)
        val targetY = TiltMapper.offsetFor(event.values[1], maxY)

        offsetX = TiltMapper.smooth(offsetX, targetX)
        offsetY = TiltMapper.smooth(offsetY, targetY)

        image.translationX = offsetX
        image.translationY = offsetY
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not needed for this exercise
    }
}
