package easyfit.easyfit.Podometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import easyfit.easyfit.R;

public class Podometer extends easyfit.easyfit.BaseDrawerActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView count;
    private TextView meter;
    private TextView calories;
    private double valueMeter = 0;
    boolean activityRunning;

    @Override
    protected void onCreate(Bundle savedInstanteState)
    {
        super.onCreate(savedInstanteState);
        getLayoutInflater().inflate(R.layout.podometer_layout, frame);

        count = (TextView) findViewById(R.id.count);
        meter = (TextView) findViewById(R.id.meter);
        calories = (TextView) findViewById(R.id.calories);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null) {
            sensorManager.registerListener(this,countSensor,SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Error 404: Sensor.Step isn't available on your smartphone", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        activityRunning = false;
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(activityRunning)
        {
            count.setText(String.valueOf(event.values[0]));
            valueMeter = (double) event.values[0];
            meter.setText(String.valueOf(pasToMeter(valueMeter)));
            calories.setText(String.valueOf(pasToCalories(valueMeter)));
        }
    }

    private double pasToMeter(double value)
    {
        return value * 0.73 ;
    }

    private double pasToCalories(double value)
    {
        return value * 0.49 ;
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
