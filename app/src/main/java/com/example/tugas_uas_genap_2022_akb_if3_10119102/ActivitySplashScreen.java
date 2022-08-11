package com.example.tugas_uas_genap_2022_akb_if3_10119102;

/*
 * NIM : 10119102
 *Nama : Muhammad Alfiqh Nugraha
 *Kelas : if3
 *Email : m.alfiqnugraha@gmail.com
 * */

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugas_uas_genap_2022_akb_if3_10119102.R;


public class ActivitySplashScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashschreen);

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), ActivityWelcomeDialog.class));
            finish();
        }, 2000L); // membuat delay selama 2 detik
    }

}
