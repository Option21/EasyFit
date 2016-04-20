package easyfit.easyfit;

import android.content.Intent;
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

import easyfit.easyfit.Calendrier.calendar;
import easyfit.easyfit.Chronometer.Chrono;
import easyfit.easyfit.Exercices.ItemListActivity;
import easyfit.easyfit.Podometer.Podometer;
import easyfit.easyfit.Profile.CreationProfile;
import easyfit.easyfit.Profile.ProfileView;
import easyfit.easyfit.ProgramList.ProgramListActivity;
import easyfit.easyfit.graphique.graph;

public class BaseDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected RelativeLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id)
        {
            case R.id.nav_program:
                startActivity(new Intent(this, ProgramListActivity.class));
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
                startActivity(new Intent(this, ProfileView.class));
                break;
            case R.id.graph:
                startActivity(new Intent(this,graph.class));
                break;
            case R.id.podometer:
                startActivity(new Intent(this, Podometer.class));
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
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
