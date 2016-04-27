package easyfit.easyfit;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import easyfit.easyfit.Calendrier.calendar;
import easyfit.easyfit.Chronometer.Chrono;
import easyfit.easyfit.Exercices.ItemListActivity;
import easyfit.easyfit.Profile.CreationProfile;
import easyfit.easyfit.graphique.Graph;
import easyfit.easyfit.Podometer.Podometer;
import easyfit.easyfit.Program.program;

public class BaseDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected RelativeLayout frame;
    protected ShareDialog shareDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setNotifications();
        AppEventsLogger.activateApp(this);
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        shareDialog = new ShareDialog(this);


        setContentView(R.layout.activity_base_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frame = (RelativeLayout)findViewById(R.id.relativeframe);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setNotifications()
    {
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000, pendingIntent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id)
        {
            case R.id.nav_program:
                startActivity(new Intent(this, program.class));
                break;
            case R.id.nav_calendar:
                startActivity(new Intent(this, calendar.class));
                break;
            case R.id.nav_exercices:
                startActivity(new Intent(this, ItemListActivity.class));
                break;
            case R.id.nav_timer:
                startActivity(new Intent(this, Chrono.class));
                break;
            case R.id.profile:
                startActivity(new Intent(this, easyfit.easyfit.Profile.ProfileView.class));
                break;
            case R.id.graph:
                startActivity(new Intent(this, easyfit.easyfit.graphique.Graph.class));
                break;
            case R.id.podometer:
                startActivity(new Intent(this,Podometer.class));
                break;
            case R.id.nav_send:
                if(item.getItemId() != R.id.podometer) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{"FeedBack-noReply@EasyFit.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "EasyFit");
                    i.putExtra(Intent.EXTRA_TEXT, "Mes Scores EasyFit: \n Whoua Essaie de me battre :)");
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        throw ex;
                    }
                }
                break;

            case R.id.nav_share:
                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setContentTitle("Rejoignez moi sur Easyfit!")
                            .setContentDescription(
                                    "rejoignez moi!")
                            .setContentUrl(Uri.parse("https://www.easyfit.com/"))
                            .build();

                    shareDialog.show(linkContent);
                }
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
