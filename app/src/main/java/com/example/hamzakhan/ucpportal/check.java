package com.example.hamzakhan.ucpportal;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class check extends AppCompatActivity {
    private ViewPager viewPager;
    TextView tx;
    String message;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_header);
        tx=(TextView)findViewById(R.id.textView);







    }


}
