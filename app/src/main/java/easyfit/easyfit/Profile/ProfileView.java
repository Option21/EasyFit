package easyfit.easyfit.Profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import easyfit.easyfit.Exercices.ItemListActivity;
import easyfit.easyfit.ProfileSQL;
import easyfit.easyfit.R;

public class ProfileView extends AppCompatActivity {

    protected ProfileSQL bdProfile = new ProfileSQL(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        loadProfile();
        Button validation = (Button) findViewById(R.id.modifier);
        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchModification();
            }
        });
    }

    protected void loadProfile(){
        TextView name = (TextView) findViewById(R.id.nameEntry);
        TextView age = (TextView) findViewById(R.id.ageEntry);
        TextView poids = (TextView) findViewById(R.id.poidsEntry);
        TextView mail = (TextView) findViewById(R.id.mailEntry);
        TextView taille = (TextView) findViewById(R.id.tailleEntry);
        TextView program = (TextView) findViewById(R.id.programEntry);

        name.setText(bdProfile.getProfile(1).getName());
        age.setText(String.valueOf(bdProfile.getProfile(1).getAge()));
        poids.setText(String.valueOf(bdProfile.getProfile(1).getPoids()));
        mail.setText(bdProfile.getProfile(1).getMail());
        taille.setText(String.valueOf(bdProfile.getProfile(1).getTaille()));

        if(bdProfile.getProfile(1).getEntrainementProgram()) {
            program.setText(bdProfile.getProfile(1).getEntrainementName());
        }

    }

    protected void launchModification(){
        Intent launcher = new Intent(ProfileView.this, ProfileModification.class);
        startActivity(launcher);
    }
}
