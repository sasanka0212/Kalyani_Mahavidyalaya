package com.example.kalyanimahavidyalaya.ui.notice;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.example.kalyanimahavidyalaya.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.util.List;

public class DownloadNoticeActivity extends AppCompatActivity {

    private PhotoView showImage;
    private Button downloadImage;
    private String url, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_notice);

        showImage = findViewById(R.id.showImage);
        downloadImage = findViewById(R.id.downloadImage);

        url = getIntent().getStringExtra("image");
        title = getIntent().getStringExtra("imageName");
        if (url != null)
            Glide.with(this).load(url).into(showImage);

        downloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadImageNew(title, url);
            }
        });
    }

    private void downloadImageNew(String filename, String downloadUrlOfImage) {
        try {
            DownloadManager dm = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                dm = (DownloadManager) getSystemService(this.DOWNLOAD_SERVICE);
            }
            Uri downloadUri = Uri.parse(downloadUrlOfImage);
            DownloadManager.Request request = new DownloadManager.Request(downloadUri);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle(filename)
                    .setMimeType("image/jpeg/png") // Your file type. You can use this code to download other file types also.
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, File.separator + filename + ".jpg");
            dm.enqueue(request);
            Toast.makeText(this, "Image download started.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Image download failed.", Toast.LENGTH_SHORT).show();
        }
    }
}

    /*private void checkPermission() {
        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
                    @Override public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if(report.areAllPermissionsGranted()){
                            downloadImage();
                        }else{
                            Toast.makeText(DownloadNoticeActivity.this, "Allow all permissions", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {}
                }).check();
    }*/

    /*private void downloadImage() {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Downloading...");
        pd.setCancelable(false);
        pd.show();

        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        PRDownloader.download(url, file.getPath(), URLUtil.guessFileName(url, null, null))
                .build()
                .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                    @Override
                    public void onStartOrResume() {

                    }
                })
                .setOnPauseListener(new OnPauseListener() {
                    @Override
                    public void onPause() {

                    }
                })
                .setOnCancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel() {

                    }
                })
                .setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onProgress(Progress progress) {
                        long per = progress.currentBytes*100 / progress.totalBytes;
                        pd.setMessage("Downloading : " + per + "%");
                    }
                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        pd.dismiss();
                        Toast.makeText(DownloadNoticeActivity.this, "Downloading completed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Error error) {
                        pd.dismiss();
                        Toast.makeText(DownloadNoticeActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}*/