package easyfit.easyfit.Chronometer;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import easyfit.easyfit.BaseDrawerActivity;
import easyfit.easyfit.R;


public class Chrono extends BaseDrawerActivity {

    Chronometer c;
    long time;
    boolean stopped = true;
    int nbLap = 0;
    String lap1 = "", lap2 = "", lap3 = "";
    TextView laview, laview2, laview3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_chrono, frame);
        Button btn_start = (Button) findViewById(R.id.btn_start);
        Button btn_stop = (Button) findViewById(R.id.btn_stop);
        Button btn_reset = (Button) findViewById(R.id.btn_reset);
        Button bnt_lap = (Button) findViewById(R.id.btn_lap);
        laview = (TextView) findViewById(R.id.lap_view);
        laview2 = (TextView)findViewById(R.id.lap_view2);
        laview3 = (TextView)findViewById(R.id.lap_view3);

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
                laview.setText("");laview2.setText("");laview3.setText("");
            }
        });

        bnt_lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (nbLap)
                {
                    case 0:
                        laview.setText(c.getText().toString());
                        lap1 = c.getText().toString();
                        nbLap++;
                        break;
                    case 1:
                        laview2.setText(c.getText().toString());
                        lap2 = c.getText().toString();
                        nbLap++;
                        break;
                    case 2:
                        laview3.setText(c.getText().toString());
                        lap3 = c.getText().toString();
                        nbLap = 0;
                        break;
                    default:
                        break;


                }


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
        savedInstanceState.putString("lap1", laview.getText().toString());
        savedInstanceState.putString("lap2", laview2.getText().toString());
        savedInstanceState.putString("lap3", laview3.getText().toString());
        savedInstanceState.putInt("nbLap", nbLap);
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
            if(savedInstanceState.getString("lap1") != "" )
                laview.setText(savedInstanceState.getString("lap1").toString());
            if(savedInstanceState.getString("lap2") != "")
                laview2.setText(savedInstanceState.getString("lap2").toString());
            if(savedInstanceState.getString("lap3") != "")
                laview3.setText(savedInstanceState.getString("lap3").toString());
            nbLap = savedInstanceState.getInt("nbLap");

        }
        super.onRestoreInstanceState(savedInstanceState);
    }
}

