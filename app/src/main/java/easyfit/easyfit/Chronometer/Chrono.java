package easyfit.easyfit.Chronometer;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;

import easyfit.easyfit.BaseDrawerActivity;
import easyfit.easyfit.R;


public class Chrono extends BaseDrawerActivity {

    Chronometer c;
    long time;
    boolean stopped = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_base_drawer);

        //frame = (RelativeLayout)findViewById(R.id.ChronoLayout);
        getLayoutInflater().inflate(R.layout.activity_chrono, frame);
        Button btn_start = (Button) findViewById(R.id.btn_start);
        Button btn_stop = (Button) findViewById(R.id.btn_stop);
        Button btn_reset = (Button) findViewById(R.id.btn_reset);

        assert (btn_start != null && btn_stop != null && btn_reset != null);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!stopped)
                    c.setBase(SystemClock.elapsedRealtime());
                else
                    c.setBase(SystemClock.elapsedRealtime() - getTime(c));
                c.start();
                stopped = false;
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.stop();
                stopped = true;
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setBase(SystemClock.elapsedRealtime());
            }
        });

        c = (Chronometer)findViewById(R.id.c);

    }

    private long getTime(Chronometer c) {
        long stoppedMilli = 0;
        String ChronoText = c.getText().toString();
        String array[] = ChronoText.split(":");
        if(array.length == 2) {
            stoppedMilli = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) * 1000;
        }
        else if(array.length == 3) {
            stoppedMilli = Integer.parseInt(array[0]) * 60 *60 * 1000
                    + Integer.parseInt(array[1]) * 60 * 1000
                    + Integer.parseInt(array[2]) * 1000;
        }
        return stoppedMilli;
    }



    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("ChronoTime", c.getBase());
        savedInstanceState.putLong("Time", getTime(c));
        savedInstanceState.putBoolean("Stopped", stopped);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState.containsKey("ChronoTime")) {
            c.setBase(SystemClock.elapsedRealtime() - savedInstanceState.getLong("Time"));
            if(!savedInstanceState.getBoolean("Stopped"))
            {
                c.setBase(SystemClock.elapsedRealtime() - getTime(c));
                c.start();
                stopped = false;
            }

        }
        super.onRestoreInstanceState(savedInstanceState);
    }

}

