package com.example.fitnesssdemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class WalkActivity extends AppCompatActivity implements SensorEventListener {

    TextView steps;
    TextView km_run;
    TextView kcal_run;
    SensorManager sensorManager;
    Sensor sensor;
    boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);

        steps = (TextView) findViewById ( R.id.stepsValue);
        km_run = (TextView) findViewById ( R.id.km_run);
        kcal_run = (TextView) findViewById ( R.id.kcal_run);

        sensorManager = (SensorManager) getSystemService ( Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume ();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor ( sensor.TYPE_ALL );
        if(countSensor != null){
            sensorManager.registerListener ( this,countSensor,SensorManager.SENSOR_DELAY_UI );
        }else {
            Toast.makeText ( this,"SENSOR NOT FOUND",Toast.LENGTH_SHORT ).show ();
        }
    }

    @Override
    protected void onPause() {
        super.onPause ();
        running = false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (running){
            steps.setText ( String.valueOf ( event.values[0] ) );
            km_run.setText ( String.valueOf ( event.values[0]*0.02 ));
            kcal_run.setText ( String.valueOf (((event.values[0]*30)/(100000)) ) );
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
