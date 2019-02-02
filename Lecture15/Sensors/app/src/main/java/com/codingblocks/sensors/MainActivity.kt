package com.codingblocks.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.Sensor.*
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity(), SensorEventListener {

    private val sensorManager: SensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    lateinit var proximitySensorValues: FloatArray
    lateinit var accelerometerSensorValues: FloatArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //This is the accelerometer sensor

//        val sensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
//
//        Log.e("TAG", "Number of sensors present are ${sensors.size}")
//
//        for (s in sensors) {
////            Log.e("TAG", s.toString())
//            Log.e("TAG", "Sensor's name is ${s.name}")
////            Log.e("TAG", "Sensor's id is ${s.id}")
//            Log.e("TAG", "Sensor's vendor is ${s.vendor}")
//            Log.e("TAG", "Sensor's power consumption is ${s.power}")
//            Log.e("TAG", "Sensor's max range is ${s.maximumRange}")
//            Log.e("TAG", "Sensor's resolution is ${s.resolution}")
//            Log.e("TAG", "Sensor's max event count is ${s.fifoMaxEventCount}")
//            Log.e("TAG", "Sensor's max delay is ${s.maxDelay}")
//            Log.e("TAG", "Sensor's min is ${s.minDelay}")
//            Log.e("TAG", "Sensor's type is ${s.type}")
//            Log.e("TAG", "Sensor's version is ${s.version}")
//            Log.e("TAG", "Sensor's type in String is ${s.stringType}")
//            Log.e("TAG", "_________________________________")
//        }


    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let { sensorEvent ->

            when (sensorEvent.sensor.type) {

                TYPE_PROXIMITY -> {
                    proximitySensorValues = sensorEvent.values
                    sensorEvent.values.forEachIndexed { index, fl ->
                        Log.e("TAG", "Proximity Sensor's value at index $index is $fl")
                    }
                }

                TYPE_ACCELEROMETER -> {
                    accelerometerSensorValues = sensorEvent.values
                    sensorEvent.values.forEachIndexed { index, fl ->
                        Log.e("TAG", "Accelerometer Sensor's value at index $index is $fl")
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val accelerometer: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        sensorManager.registerListener(this, accelerometer, 100000)
        sensorManager.registerListener(this, proximity, 100000)
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(this)
    }

}
