package com.example.hamzakhan.ucpportal;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hamzakhan.ucpportal.Adapter.WheelImageAdapter;
import com.example.hamzakhan.ucpportal.Data.ImageData;

import java.util.ArrayList;
import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ViewPager viewPager;
    CursorWheelLayout wheel_image;
    List<ImageData> lstimage;
    Context c;
    View v;


    public HomeFragment() {
        // Required empty public constructor



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v=inflater.inflate(R.layout.fragment_home,container,false);

        return v;
    }




}

