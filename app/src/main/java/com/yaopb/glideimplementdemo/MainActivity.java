package com.yaopb.glideimplementdemo;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.yaopb.lightimage.LightImage;
import com.yaopb.lightimage.RequestListener;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LightImage.with(this);
        //Glide.with(this).load(url).loading(R.mipmap.ic_launcher).into(imageview)


        String[] permission = new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_NETWORK_STATE};

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permission, 1);
        }
        final LinearLayout linearLayout = findViewById(R.id.contaier);

        findViewById(R.id.load_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                LightImage.with(MainActivity.this).loading(R.drawable.lalala).load("http://p0.meituan.net/wedding/c7a4d933e0c02185be327df500fa9241262862.png%402048w_2048h_0e_1l%7Cwatermark%3D0").setListener(new RequestListener() {
                    @Override
                    public boolean onSuccess(Bitmap bitmap) {
                        return false;
                    }

                    @Override
                    public boolean onFailed() {
                        return false;
                    }
                }).into(imageView);
                linearLayout.addView(imageView);
            }
        });
        findViewById(R.id.load_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < 10; i++) {
                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    LightImage.with(MainActivity.this).loading(R.drawable.lalala).load("http://p0.meituan.net/wedding/c7a4d933e0c02185be327df500fa9241262862.png").setListener(new RequestListener() {
                        @Override
                        public boolean onSuccess(Bitmap bitmap) {
                            return false;
                        }

                        @Override
                        public boolean onFailed() {
                            return false;
                        }
                    }).into(imageView);
                    linearLayout.addView(imageView);
                }
            }

        });
    }
}
