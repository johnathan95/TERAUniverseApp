package com.example.johna.terauniverse.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.johna.terauniverse.R;
import com.example.johna.terauniverse.activity.FBActivity;
import com.example.johna.terauniverse.activity.GenresActivity;
import com.example.johna.terauniverse.activity.SettingsActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton btnFB,btnCine,btnDownload,btnInsta,btnMaps,btnWeb, btnTwitter, btnYoutube;

    public final static String EXTRA_LAUNCHES = "EXTRA_LAUNCHES";
    public final static String EXTRA_SIZE = "EXTRA_SIZE";
    public final static String EXTRA_TERA = "EXTRA_TERA";

    public final static int TERA_FB = 1;
    public final static int TERA_INSTA = 2;
    public final static int TERA_WEB = 3;
    public final static int TERA_TWITTER = 4;
    public final static int TERA_YT = 5;

    private final static int EXIT_DIALOG = 1;
    private final static int ABOUT_DIALOG = 2;
    private final static int HELP_DIALOG = 3;

    public final static int NUMBER_OF_LAUNCHES_REQUEST = 1;
    public final static int SIZE_REQUEST = 2;
    public final static int SMALL_SIZE = 14;
    public final static int MEDIUM_SIZE = 18;
    public final static int LARGE_SIZE = 22;
    public final static int DEFAULT_SIZE = SMALL_SIZE;

    private int size = LARGE_SIZE;
    private int launches = 0;

    private AlertDialog exitDialog;
    private AlertDialog aboutDialog;
    private AlertDialog helpDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Activity created");


        btnFB = (ImageButton) findViewById(R.id.buttonFB);
        btnCine = (ImageButton) findViewById(R.id.buttonCine);
        btnDownload = (ImageButton) findViewById(R.id.buttonDownload);
        btnInsta = (ImageButton) findViewById(R.id.buttonInsta);
        btnMaps = (ImageButton) findViewById(R.id.buttonMaps);
        btnWeb = (ImageButton) findViewById(R.id.buttonWeb);
        btnTwitter = (ImageButton) findViewById(R.id.buttonTwitter);
        btnYoutube = (ImageButton) findViewById(R.id.buttonYoutube);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();

                Toast.makeText(context, R.string.download_tera, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DownloadActivity.class);
                startActivity(intent);
            }
        });

        btnFB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, R.string.facebook_tera, duration);
                toast.show();

                Intent intent = new Intent(MainActivity.this, FBActivity.class);
                intent.putExtra(EXTRA_TERA, TERA_FB);
                startActivity(intent);
            }
        });
        btnInsta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, R.string.insta_tera, duration);
                toast.show();

                Intent intent = new Intent(MainActivity.this, FBActivity.class);
                intent.putExtra(EXTRA_TERA, TERA_INSTA);
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, R.string.web_tera, duration);
                toast.show();

                Intent intent = new Intent(MainActivity.this, FBActivity.class);
                intent.putExtra(EXTRA_TERA, TERA_WEB);
                startActivity(intent);
            }
        });
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, R.string.yt_tera, duration);
                toast.show();

                Intent intent = new Intent(MainActivity.this, FBActivity.class);
                intent.putExtra(EXTRA_TERA, TERA_YT);
                startActivity(intent);
            }
        });
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, R.string.twitter_tera, duration);
                toast.show();

                Intent intent = new Intent(MainActivity.this, FBActivity.class);
                intent.putExtra(EXTRA_TERA, TERA_TWITTER);
                startActivity(intent);
            }
        });
        btnCine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context,R.string.movies_tera, duration);
                toast.show();

                Intent intent = new Intent(MainActivity.this, GenresActivity.class);
                startActivity(intent);
            }
        });
        btnMaps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                CharSequence text = "Service Maps";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                //Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                //startActivity(intent);
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
                int duration = Toast.LENGTH_SHORT;

                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);

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
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder;
        switch (id) {
            case EXIT_DIALOG:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Exit");
                builder.setIcon(R.drawable.logo0);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        exitDialog.dismiss();
                    }
                });
                exitDialog = builder.create();
                return exitDialog;
            case HELP_DIALOG:
                ImageView imageHelp = new ImageView(this);
                imageHelp.setImageResource(R.drawable.logo0);
                builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.help);
                //  builder.setMessage(R.string.long_help);
                builder.setIcon(R.drawable.logo0);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        helpDialog.dismiss();
                    }
                }).
                        setView(imageHelp);
                helpDialog = builder.create();
                return helpDialog;
            case ABOUT_DIALOG:
                ImageView imageAbout = new ImageView(this);
                imageAbout.setImageResource(R.drawable.logo0);
                builder = new AlertDialog.Builder(this);
                // builder.setTitle(R.string.about);
                // builder.setIcon(R.drawable.logo_app);
                // builder.setMessage(R.string.long_about);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        aboutDialog.dismiss();
                    }
                }).setView(imageAbout);
                aboutDialog = builder.create();
                return aboutDialog;
            default:
                return null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_help:
                showDialog(HELP_DIALOG);
                return true;
            case R.id.action_settings:
                //Intent intent = new Intent(this, SettingsActivity.class);
                //intent.putExtra(EXTRA_SIZE, size);
                //startActivityForResult(intent, SIZE_REQUEST);
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_facebook) {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, R.string.facebook_tera, duration);
            toast.show();

            Intent intent = new Intent(MainActivity.this, FBActivity.class);
            intent.putExtra(EXTRA_TERA, TERA_FB);
            startActivity(intent);
            System.out.println("TeraU fb page redirection ok");
        } else if (id == R.id.nav_movie) {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, R.string.movies_tera, duration);
            toast.show();

            Intent intent = new Intent(MainActivity.this, GenresActivity.class);
            startActivity(intent);
            System.out.println("TeraU movie details page redirection ok");
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.shared_pref) {
            Intent intent = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_help) {

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
