package easyfit.easyfit.Profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.content.SharedPreferences;
import android.app.Activity;
import android.widget.ToggleButton;

import org.w3c.dom.Text;


import easyfit.easyfit.Exercices.ItemListActivity;
import easyfit.easyfit.ProfileSQL;
import easyfit.easyfit.R;
import android.util.Log;

public class CreationProfile extends AppCompatActivity {

    protected LinearLayout objectifLayout;
    protected LinearLayout startLayout;

    protected ProfileSQL bdProfile = new ProfileSQL(this);

    private static final int[] idArray = {R.id.checkBox2, R.id.checkBox3, R.id.checkBox4 };
    private CheckBox[] btObj = new CheckBox[idArray.length];

    public Profile userAccount;

    protected SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String PREFS_NAME = "MyPrefsFile";
        settings = getSharedPreferences(PREFS_NAME, 0);

        settings.edit().putBoolean("my_first_time", true).commit();
     if (settings.getBoolean("my_first_time", true)) {
            settings.edit().putBoolean("my_first_time", false).commit();
            setContentView(R.layout.activity_creation_profile);

            startLayout = (LinearLayout) findViewById(R.id.startLayout);
            objectifLayout = (LinearLayout) findViewById(R.id.ObjectiveMenu);

            userAccount = new Profile();
             userAccount.setEntrainementName("NULL");

            final CheckBox chooseObjectif = (CheckBox) findViewById(R.id.checkBox);
        chooseObjectif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chooseObjectif.isChecked()) {
                    showObjectifPanel();
                } else {
                    chooseObjectif.setChecked(false);
                    userAccount.setEntrainementProgram(false);
                    userAccount.setEntrainementName("NULL");
                    }
                }
            });
            Button validation = (Button) findViewById(R.id.valider);
            validation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveProfile();
                    launchApplication();
                }
            });
       }
      else{
           launchApplication();
       }
    }

    protected void showObjectifPanel() {
        startLayout.setVisibility(View.INVISIBLE);
        objectifLayout.setVisibility(View.VISIBLE);
        for (int i=0; i<idArray.length; i++) {
            final int b = i;
            btObj [b] = (CheckBox)findViewById(idArray[b]);
            btObj [b].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (b){
                        case 0:
                            userAccount.setEntrainementName("poids");
                            break;
                        case 1:
                            userAccount.setEntrainementName("muscle");
                            break;
                        case 2:
                            userAccount.setEntrainementName("affiner");
                            break;
                    }
                    userAccount.setEntrainementProgram(true);
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

    protected void saveProfile(){
        EditText name = (EditText) findViewById(R.id.nameEdit);
        EditText age = (EditText) findViewById(R.id.ageEdit);
        EditText poids = (EditText) findViewById(R.id.poidsEdit);
        EditText mail = (EditText) findViewById(R.id.mailEdit);
        EditText taille = (EditText) findViewById(R.id.sizeEdit);

        userAccount.setName(name.getText().toString());
        userAccount.setMail(mail.getText().toString());
        userAccount.setAge(Integer.parseInt(age.getText().toString()));
        userAccount.setPoids(Integer.parseInt(poids.getText().toString()));
        userAccount.setTaille(Float.parseFloat(taille.getText().toString()));

        bdProfile.addProfile(userAccount);
    }
}
