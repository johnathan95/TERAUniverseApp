package com.example.johna.terauniverse.activity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.johna.terauniverse.R;

public class DownloadActivity extends AppCompatActivity {
    private Button button;
    DownloadManager downloadManager;
    //Context context = getApplicationContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        button = (Button) findViewById(R.id.download_pdf_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "msg msg", Toast.LENGTH_SHORT).show();
                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://www.esiea.fr/wp-content/uploads/2014/09/Plaquette_ESIEA_par_l_Alternance.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);
            }
        });
    }
}

