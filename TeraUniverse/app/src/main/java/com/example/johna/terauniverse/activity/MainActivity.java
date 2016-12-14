package com.example.johna.terauniverse.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.johna.terauniverse.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton btnFB,btnCine;

    public final static String EXTRA_LAUNCHES = "EXTRA_LAUNCHES";
    public final static String EXTRA_SIZE = "EXTRA_SIZE";

    public final static int NUMBER_OF_LAUNCHES_REQUEST = 1;
    public final static int SIZE_REQUEST = 2;
    public final static int SMALL_SIZE = 14;
    public final static int MEDIUM_SIZE = 18;
    public final static int LARGE_SIZE = 22;
    public final static int DEFAULT_SIZE = SMALL_SIZE;

    private int size = LARGE_SIZE;
    private int launches = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Activity created");

        btnFB = (ImageButton) findViewById(R.id.buttonFB);
        btnCine = (ImageButton) findViewById(R.id.buttonCine);
        //btnFB.setBackgroundResource(R.drawable.go_anim);
        //AnimationDrawable goAnimation = (AnimationDrawable) btnRedirect.getBackground();
        //goAnimation.start();
        btnFB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                CharSequence text = "TERA Universe Facebook Page";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent intent = new Intent(MainActivity.this, FBActivity.class);
                startActivity(intent);
            }
        });
        btnCine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                CharSequence text = "Cinema Showtimes";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent intent = new Intent(MainActivity.this, CineActivity.class);
                startActivity(intent);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.info_dev, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton fabExit = (FloatingActionButton) findViewById(R.id.fabExit);
        fabExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform action on click
                Context context = getApplicationContext();
                //CharSequence text = R.string.good_bye;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, R.string.good_bye, duration);
                toast.show();
            }
        });
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_facebook) {
            Context context = getApplicationContext();
            CharSequence text = "TERA Universe Facebook Page";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent intent = new Intent(MainActivity.this, FBActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == NUMBER_OF_LAUNCHES_REQUEST) {
                launches = data.getIntExtra(EXTRA_LAUNCHES, 0);
            }
            size = data.getIntExtra(EXTRA_SIZE, size);
            //btnQuitter.setTextSize(size);
        }
    }
}
