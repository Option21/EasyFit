package easyfit.easyfit.Profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.content.SharedPreferences;
import android.app.Activity;
import android.widget.ToggleButton;

import easyfit.easyfit.Exercices.ItemListActivity;
import easyfit.easyfit.ProgramList.ProgramListActivity;
import easyfit.easyfit.R;

public class CreationProfile extends AppCompatActivity {

    protected LinearLayout objectifLayout;
    protected LinearLayout startLayout;

    private static final int[] idArray = {R.id.checkBox2, R.id.checkBox3, R.id.checkBox4 };
    private CheckBox[] btObj = new CheckBox[idArray.length];

    public Profile userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String PREFS_NAME = "MyPrefsFile";

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

       // if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            setContentView(R.layout.activity_creation_profile);

            startLayout = (LinearLayout) findViewById(R.id.startLayout);
            objectifLayout = (LinearLayout) findViewById(R.id.ObjectiveMenu);

            userAccount = new Profile();

            final CheckBox chooseObjectif = (CheckBox) findViewById(R.id.checkBox);
            chooseObjectif.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(chooseObjectif.isChecked()) {
                        showObjectifPanel();
                    }
                    else {
                        chooseObjectif.setChecked(false);
                        userAccount.setEntrainementProgram(false);
                    }
                }
            });
            settings.edit().putBoolean("my_first_time", false).commit();

            Button validation = (Button) findViewById(R.id.valider);
            validation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchApplication();
                }
            });
       // }
      /*  else{
            launchApplication();
        }*/
    }

    protected void showObjectifPanel() {
        startLayout.setVisibility(View.INVISIBLE);
        objectifLayout.setVisibility(View.VISIBLE);
        for (int i=0; i<idArray.length; i++) {
            final int b = i;
            btObj [b] = (CheckBox)findViewById(idArray[b]); // Fetch the view id from array
            btObj [b].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hiddeObjectifPanel();
                }
            });
        }
    }

    protected void hiddeObjectifPanel(){
        startLayout.setVisibility(View.VISIBLE);
        objectifLayout.setVisibility(View.INVISIBLE);
        userAccount.setEntrainementProgram(true);
    }

    protected void launchApplication(){
        Intent launcher = new Intent(CreationProfile.this, ItemListActivity.class);
        startActivity(launcher);
    }

}
