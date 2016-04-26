package easyfit.easyfit.Exercices;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.support.v7.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import easyfit.easyfit.BaseDrawerActivity;
import easyfit.easyfit.R;


public class ItemDetailActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_item_detail, frame);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);


        final int value = getIntent().getExtras().getInt("posExo");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (value)
                {
                    case 0:
                       // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zUk1BiL6Ajc")));
                        startActivity(YouTubeStandalonePlayer.createVideoIntent(ItemDetailActivity.this
                                , getApplicationContext().getResources().getString(R.string.DEVELOPER_KEY), "zUk1BiL6Ajc"));
                        Log.i("Video", "Video Playing....");
                        break;
                    case 1:
                       // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ZLRBO5wiPwM")));
                        startActivity(YouTubeStandalonePlayer.createVideoIntent(ItemDetailActivity.this
                                , getApplicationContext().getResources().getString(R.string.DEVELOPER_KEY), "ZLRBO5wiPwM"));
                        Log.i("Video", "Video Playing....");
                        break;
                    case 2:
                        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/OnKLnb2vsPI")));
                        startActivity(YouTubeStandalonePlayer.createVideoIntent(ItemDetailActivity.this
                                , getApplicationContext().getResources().getString(R.string.DEVELOPER_KEY), "OnKLnb2vsPI"));
                        Log.i("Video", "Video Playing....");
                        break;
                    case 3:
                        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/fypQ8tQ1OP0")));
                        startActivity(YouTubeStandalonePlayer.createVideoIntent(ItemDetailActivity.this
                                , getApplicationContext().getResources().getString(R.string.DEVELOPER_KEY), "fypQ8tQ1OP0"));
                        Log.i("Video", "Video Playing....");
                        break;
                    case 4:
                        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3XkA5q8bM1k")));
                        startActivity(YouTubeStandalonePlayer.createVideoIntent(ItemDetailActivity.this
                                , getApplicationContext().getResources().getString(R.string.DEVELOPER_KEY), "3XkA5q8bM1k"));
                        Log.i("Video", "Video Playing....");
                        break;
                    default:
                        Snackbar.make(view, "Aucune video Disponible", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                }
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
