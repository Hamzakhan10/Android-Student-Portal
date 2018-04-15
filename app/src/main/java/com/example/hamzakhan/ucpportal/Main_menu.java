package com.example.hamzakhan.ucpportal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamzakhan.ucpportal.Adapter.WheelImageAdapter;
import com.example.hamzakhan.ucpportal.Data.ImageData;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import github.hellocsl.cursorwheel.CursorWheelLayout;

import static java.security.AccessController.getContext;

public class Main_menu extends AppCompatActivity  implements CursorWheelLayout.OnMenuSelectedListener{

    private TextView tv;
    public TextView txtView;
    String message;

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if(parent.getId()==R.id.wheel_image)
        {
            if(lstimage.get(pos).imageDescription=="Time table")
            {
                Toast.makeText(getBaseContext(),"Selected :"+lstimage.get(pos).imageDescription,Toast.LENGTH_LONG).show();
                try {
                    Bundle basket = new Bundle();
                    basket.putString("message", message);
                    Intent a = new Intent(Main_menu.this, Time_table.class);
                    a.putExtras(basket);
                    startActivity(a);
                }catch (Exception e){}

            }
            else if(lstimage.get(pos).imageDescription=="Settings")
            {
                Toast.makeText(getBaseContext(),"Selected :"+lstimage.get(pos).imageDescription,Toast.LENGTH_LONG).show();
                try{
                Bundle basket1= new Bundle();
                basket1.putString("message", message);
                Intent a1=new Intent(Main_menu.this,Settings.class);
                a1.putExtras(basket1);
                startActivity(a1);}catch (Exception e){}
            }
            else if(lstimage.get(pos).imageDescription=="Annoucements")
            {
                Toast.makeText(getBaseContext(),"Selected :"+lstimage.get(pos).imageDescription,Toast.LENGTH_LONG).show();
                try {
                    Bundle basket = new Bundle();
                    basket.putString("message", message);
                    Intent a = new Intent(Main_menu.this, Announcements.class);
                    a.putExtras(basket);
                    startActivity(a);
                }catch (Exception e){}
            }
            else if(lstimage.get(pos).imageDescription=="Result")
            {
                Toast.makeText(getBaseContext(),"Selected :"+lstimage.get(pos).imageDescription,Toast.LENGTH_LONG).show();
                try {
                    Bundle basket = new Bundle();
                    basket.putString("message", message);
                    Intent a = new Intent(Main_menu.this, Mycourses.class);
                    a.putExtras(basket);
                    startActivity(a);
                }catch (Exception e){}

            }
            else if(lstimage.get(pos).imageDescription=="Leave Status")
            {
                Toast.makeText(getBaseContext(),"Selected :"+lstimage.get(pos).imageDescription,Toast.LENGTH_LONG).show();
                try {
                    Bundle basket = new Bundle();
                    basket.putString("message", message);
                    Intent a = new Intent(Main_menu.this, Leave_status.class);
                    a.putExtras(basket);
                    startActivity(a);
                }catch (Exception e){}
            }
            else if(lstimage.get(pos).imageDescription=="Event")
            {
                Toast.makeText(getBaseContext(),"Selected :"+lstimage.get(pos).imageDescription,Toast.LENGTH_LONG).show();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.adabkidunya.com/ems"));
                startActivity(browserIntent);
            }
            else
            {
                Toast.makeText(getBaseContext(),"Spin the wheel :"+lstimage.get(pos).imageDescription,Toast.LENGTH_LONG).show();

            }

        }


    }

    private DrawerLayout mDrawerLayout;
    private Button btn;
    private ActionBarDrawerToggle mtoggle;
    private ActionBar.NavigationMode mView;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    CursorWheelLayout wheel_image;
    List<ImageData> lstimage;
    TextView marquee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

       Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");


        Get_student_id get_student_id=new Get_student_id(message);
        Set_student_id set_student_id=new Set_student_id(this,R.layout.menu_header);
        set_student_id.add(get_student_id);

        //Toast.makeText(getBaseContext(),"Selected :"+message,Toast.LENGTH_LONG).show();
     //  LayoutInflater inflater=getLayoutInflater();
       // View view=inflater.inflate(R.layout.menu_header,null);
        //TextView txt=(TextView)view.findViewById(R.id.textView);
        //txt.setText("okk");
      toolbar=(Toolbar)findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
       // tabLayout=(TabLayout)findViewById(R.id.tablelayout);
        //viewPager=(ViewPager)findViewById(R.id.viewpager);
        //viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        //viewPagerAdapter.addFragments(new HomeFragment(),"Home");
        //viewPagerAdapter.addFragments(new TopFreeFragment(),"Settings");
        //viewPagerAdapter.addFragments(new TopPaidFragment(),"Logout");
        //viewPager.setAdapter(viewPagerAdapter);
       // tabLayout.setupWithViewPager(viewPager);


        TextView tv = (TextView) this.findViewById(R.id.MarqueeText);
        tv.setSelected(true);  // Set focus to the textview

        viewPager=(ViewPager)findViewById(R.id.viewPPager);
        ViewPagerAdapter2 viewPagerAdapter2 =new ViewPagerAdapter2(this);
        viewPager.setAdapter(viewPagerAdapter2);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);

        initViews();
        LoadData();
        wheel_image.setOnMenuSelectedListener(this);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mtoggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_account:
                        try {
                            Bundle basket4 = new Bundle();
                            basket4.putString("message", message);
                            Intent a4 = new Intent(Main_menu.this, Main_menu.class);
                            a4.putExtras(basket4);
                            startActivity(a4);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_announcement:
                        try {
                            Bundle basket3 = new Bundle();
                            basket3.putString("message", message);
                            Intent a3 = new Intent(Main_menu.this, Announcements.class);
                            a3.putExtras(basket3);
                            startActivity(a3);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_leaves:
                        try {
                            Bundle basket2 = new Bundle();
                            basket2.putString("message", message);
                            Intent a2 = new Intent(Main_menu.this, Leave_status.class);
                            a2.putExtras(basket2);
                            startActivity(a2);
                        }catch (Exception e) {}
                        break;
                    case R.id.nav_logout:
                        Intent next3=new Intent(Main_menu.this ,student_login.class);
                        startActivity(next3);
                        break;
                    case R.id.nav_material:
                        try {
                            Bundle basket = new Bundle();
                            basket.putString("message", message);
                            Intent a = new Intent(Main_menu.this, Material.class);
                            a.putExtras(basket);
                            startActivity(a);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_settings:
                        try {
                            Bundle basket22 = new Bundle();
                            basket22.putString("message", message);
                            Intent a22 = new Intent(Main_menu.this, Settings.class);
                            a22.putExtras(basket22);
                            startActivity(a22);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_transcript:
                        try {
                            Bundle basket11 = new Bundle();
                            basket11.putString("message", message);
                            Intent a11 = new Intent(Main_menu.this, Catalog.class);
                            a11.putExtras(basket11);
                            startActivity(a11);
                        }catch (Exception e){}
                        break;
                    case R.id.navMy_courses:
                        try {
                            Bundle basket1 = new Bundle();
                            basket1.putString("message", message);
                            Intent a1 = new Intent(Main_menu.this, Mycourses.class);
                            a1.putExtras(basket1);
                            startActivity(a1);
                        }catch (Exception e){};
                        break;
                }
                return false;
            }
        });


    }
    private void LoadData() {
        lstimage=new ArrayList<>();
        lstimage.add(new ImageData(R.drawable.loading7,"."));
        lstimage.add(new ImageData(R.drawable.pass,"Settings"));
        lstimage.add(new ImageData(R.drawable.eventss,"Event"));
        lstimage.add(new ImageData(R.drawable.cale,"Leave Status"));
        lstimage.add(new ImageData(R.drawable.megaphone,"Annoucements"));
        lstimage.add(new ImageData(R.drawable.time_table,"Time table"));
        WheelImageAdapter imageAdapter=new WheelImageAdapter(getBaseContext(),lstimage);
        wheel_image.setAdapter(imageAdapter);
    }

    private void initViews() {
        wheel_image=(CursorWheelLayout)findViewById(R.id.wheel_image);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item))
            return true;
        {}
                return super.onOptionsItemSelected(item);


    }


public class MyTimerTask extends TimerTask
{

    @Override
    public void run() {
        Main_menu.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(viewPager.getCurrentItem()==0)
                {
                    viewPager.setCurrentItem(1);}
                else if(viewPager.getCurrentItem()==1)
                {viewPager.setCurrentItem(2);}
                else {
                    viewPager.setCurrentItem(0);
                }
            }
        });
    }
}


}
