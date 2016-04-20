package easyfit.easyfit.Calendrier;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import java.util.Calendar;

import easyfit.easyfit.BaseDrawerActivity;
import easyfit.easyfit.R;

public class calendar extends BaseDrawerActivity{

    private DatePicker dpResult;
    private FloatingActionButton btnChangeDate;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.calendar_layout, frame);
        setCurrentDateOnView();
        addListenerOnButton();

    }
    public void addListenerOnButton() {

        btnChangeDate = (FloatingActionButton) findViewById(R.id.btnChangeDate);

        btnChangeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Musculation Time with EasyFit");
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Vous avez choisit l'exercice :");
                intent.putExtra(CalendarContract.Events.CALENDAR_COLOR_KEY, true);
                intent.putExtra(CalendarContract.Events.IS_ORGANIZER, "EasyFit");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "La Salle");
                startActivity(intent);
            }
        });
    }

    public void setCurrentDateOnView() {

        dpResult = (DatePicker) findViewById(R.id.dpResult);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        dpResult.init(year, month, day, null);

    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;
            dpResult.init(year, month, day, null);

        }
    };
}
