package easyfit.easyfit.Profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import easyfit.easyfit.Exercices.ItemListActivity;
import easyfit.easyfit.ProfileSQL;
import easyfit.easyfit.R;

public class ProfileModification extends AppCompatActivity {

    protected LinearLayout objectifLayout;
    protected LinearLayout startLayout;

    protected ProfileSQL bdProfile = new ProfileSQL(this);

    private static final int[] idArray = {R.id.checkBox2, R.id.checkBox3, R.id.checkBox4};
    private CheckBox[] btObj = new CheckBox[idArray.length];

    public Profile userAccount;

    protected SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_modification);
        startLayout = (LinearLayout) findViewById(R.id.startLayoutModif);
        objectifLayout = (LinearLayout) findViewById(R.id.ObjectiveMenuModif);

        userAccount = new Profile();
        loadProfile();

        final CheckBox chooseObjectif = (CheckBox) findViewById(R.id.checkboxModif);
        chooseObjectif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chooseObjectif.isChecked()) {
                    showObjectifPanel();
                } else {
                    chooseObjectif.setChecked(false);
                    userAccount.setEntrainementProgram(false);
                }
            }
        });
        Button validation = (Button) findViewById(R.id.valideButton);
        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
                launchApplication();
            }
        });
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
        Intent launcher = new Intent(ProfileModification.this, ProfileView.class);
        startActivity(launcher);
    }

    protected void saveProfile(){
        EditText name = (EditText) findViewById(R.id.nameModif);
        EditText age = (EditText) findViewById(R.id.ageModif);
        EditText poids = (EditText) findViewById(R.id.poidsModif);
        EditText mail = (EditText) findViewById(R.id.mailModif);
        EditText taille = (EditText) findViewById(R.id.sizeModif);

        userAccount.setName(name.getText().toString());
        userAccount.setMail(mail.getText().toString());
        userAccount.setAge(Integer.parseInt(age.getText().toString()));
        userAccount.setPoids(Integer.parseInt(poids.getText().toString()));
        userAccount.setTaille(Float.parseFloat(taille.getText().toString()));

        bdProfile.updateProfile(userAccount);
    }

    protected void loadProfile(){
        EditText name = (EditText) findViewById(R.id.nameModif);
        EditText age = (EditText) findViewById(R.id.ageModif);
        EditText poids = (EditText) findViewById(R.id.poidsModif);
        EditText mail = (EditText) findViewById(R.id.mailModif);
        EditText taille = (EditText) findViewById(R.id.sizeModif);

        name.setText(bdProfile.getProfile(1).getName());
        age.setText(String.valueOf(bdProfile.getProfile(1).getAge()));
        poids.setText(String.valueOf(bdProfile.getProfile(1).getPoids()));
        mail.setText(bdProfile.getProfile(1).getMail());
        taille.setText(String.valueOf(bdProfile.getProfile(1).getTaille()));
    }
}
