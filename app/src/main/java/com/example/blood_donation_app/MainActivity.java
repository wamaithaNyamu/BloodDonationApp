package com.example.blood_donation_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button allSignups,allLogins;
    private ViewPager sliderViewPager;
    private LinearLayout dots;
    private SliderAdapter sliderAdapter;
    private TextView[] nDots;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog= new ProgressDialog(this);
        sliderViewPager = (ViewPager) findViewById(R.id.viewPager) ;
        dots = (LinearLayout) findViewById(R.id.dots) ;
        sliderAdapter = new SliderAdapter(this);
        sliderViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        sliderViewPager.addOnPageChangeListener(viewListener);
        allSignups = findViewById(R.id.allSignups);
        allSignups.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait ...");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(MainActivity.this, onlySignup.class);
                progressDialog.dismiss();
                startActivity(intent);

//                finish();
            }
        });



        allLogins = findViewById(R.id.alllogins);
        allLogins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(MainActivity.this, onlyLogins.class);
                startActivity(intent);
//                finish();
            }
        });
    }

    public void addDotsIndicator(int position){
        nDots = new TextView[4];
        dots.removeAllViews();
        for(int i=0; i<nDots.length; i++){
            nDots[i]= new TextView(this);
            nDots[i].setText(Html.fromHtml("&#8226;"));            nDots[i].setTextSize(35);
            nDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            dots.addView(nDots[i]);
        }
        if(nDots.length >0 ){
            nDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

