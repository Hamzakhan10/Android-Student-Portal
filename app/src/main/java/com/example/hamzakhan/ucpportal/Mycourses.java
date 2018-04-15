package com.example.hamzakhan.ucpportal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Mycourses extends AppCompatActivity {
    String json_string;
   String message;
    JSONObject jsonObject;
     String JSON_STRING;
    JSONArray jsonArray;
    ArrayList<Courses_get_data> arrayList;
    ListView lv;
    Annoucement_adapter annoucement_adapter;
    ListView listView;
    private DrawerLayout mDrawerLayout;
    private Button btn;
    private ActionBarDrawerToggle mtoggle;
    private ActionBar.NavigationMode mView;
    Toolbar toolbar;
    TabLayout tabLayout;
    String pass_data;

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
String[] data=new String[10];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycourses);
        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
                            Intent a4 = new Intent(Mycourses.this, Main_menu.class);
                            a4.putExtras(basket4);
                            startActivity(a4);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_announcement:
                        try {
                            Bundle basket3 = new Bundle();
                            basket3.putString("message", message);
                            Intent a3 = new Intent(Mycourses.this,Announcements.class);
                            a3.putExtras(basket3);
                            startActivity(a3);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_leaves:
                        try {
                            Bundle basket2 = new Bundle();
                            basket2.putString("message", message);
                            Intent a2 = new Intent(Mycourses.this, Leave_status.class);
                            a2.putExtras(basket2);
                            startActivity(a2);
                        }catch (Exception e) {}
                        break;
                    case R.id.nav_logout:
                        Intent next3=new Intent(Mycourses.this ,student_login.class);
                        startActivity(next3);
                        break;
                    case R.id.nav_material:
                        try {
                            Bundle basket = new Bundle();
                            basket.putString("message", message);
                            Intent a = new Intent(Mycourses.this, Material.class);
                            a.putExtras(basket);
                            startActivity(a);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_settings:
                        try {
                            Bundle basket22 = new Bundle();
                            basket22.putString("message", message);
                            Intent a22 = new Intent(Mycourses.this, Settings.class);
                            a22.putExtras(basket22);
                            startActivity(a22);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_transcript:
                        try {
                            Bundle basket11 = new Bundle();
                            basket11.putString("message", message);
                            Intent a11 = new Intent(Mycourses.this, Catalog.class);
                            a11.putExtras(basket11);
                            startActivity(a11);
                        }catch (Exception e){}
                        break;
                    case R.id.navMy_courses:
                        try {
                            Bundle basket1 = new Bundle();
                            basket1.putString("message", message);
                            Intent a1 = new Intent(Mycourses.this, Mycourses.class);
                            a1.putExtras(basket1);
                            startActivity(a1);
                        }catch (Exception e){};
                        break;
                }
                return false;
            }
        });

        arrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listview);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://ucpportal.000webhostapp.com/get_courses.php");
            }
        });



    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item))
            return true;
        {}
        return super.onOptionsItemSelected(item);


    }
    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray =  jsonObject.getJSONArray("server_response");

                for(int i =0;i<jsonArray.length(); i++){
                    JSONObject courseObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Courses_get_data(
                            courseObject.getString("Oc_names"),
                            courseObject.getString("sec_id")

                    ));
                    data[i]=courseObject.getString("Oc_names");
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            Custom_list_adapter adapter = new Custom_list_adapter(
                    getApplicationContext(), R.layout.custom_list_layout, arrayList
            );
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(getBaseContext(),"Selected :"+data[position],Toast.LENGTH_LONG).show();
                    Bundle basket4= new Bundle();
                    basket4.putString("message", message);
                    basket4.putString("data",data[position]);
                    Intent a4=new Intent(Mycourses.this,Result.class);
                    a4.putExtras(basket4);
                    startActivity(a4);


                }

            });

        }
    }


    private  String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url=new URL(theUrl);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data= URLEncoder.encode("Login_id","UTF-8")+"="+URLEncoder.encode(message,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();



            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();

            while((JSON_STRING=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(JSON_STRING+"\n");

            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }



}


