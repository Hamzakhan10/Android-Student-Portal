package com.example.hamzakhan.ucpportal;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

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
import java.net.URLEncoder;

public class Announcements extends AppCompatActivity {
    String JSON_STRING;
    String message;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    Annoucement_adapter annoucement_adapter;
    ListView listView;
    private DrawerLayout mDrawerLayout;
    private Button btn;
    private ActionBarDrawerToggle mtoggle;
    private ActionBar.NavigationMode mView;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);
        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mtoggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_account:
                        try {
                            Bundle basket4 = new Bundle();
                            basket4.putString("message", message);
                            Intent a4 = new Intent(Announcements.this, Main_menu.class);
                            a4.putExtras(basket4);
                            startActivity(a4);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_announcement:
                        try {
                            Bundle basket3 = new Bundle();
                            basket3.putString("message", message);
                            Intent a3 = new Intent(Announcements.this, Announcements.class);
                            a3.putExtras(basket3);
                            startActivity(a3);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_leaves:
                        try {
                            Bundle basket2 = new Bundle();
                            basket2.putString("message", message);
                            Intent a2 = new Intent(Announcements.this, Leave_status.class);
                            a2.putExtras(basket2);
                            startActivity(a2);
                        }catch (Exception e) {}
                        break;
                    case R.id.nav_logout:
                        Intent next3=new Intent(Announcements.this ,student_login.class);
                        startActivity(next3);
                        break;
                    case R.id.nav_material:
                        try {
                            Bundle basket = new Bundle();
                            basket.putString("message", message);
                            Intent a = new Intent(Announcements.this, Material.class);
                            a.putExtras(basket);
                            startActivity(a);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_settings:
                        try {
                            Bundle basket22 = new Bundle();
                            basket22.putString("message", message);
                            Intent a22 = new Intent(Announcements.this, Settings.class);
                            a22.putExtras(basket22);
                            startActivity(a22);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_transcript:
                        try {
                            Bundle basket11 = new Bundle();
                            basket11.putString("message", message);
                            Intent a11 = new Intent(Announcements.this, Catalog.class);
                            a11.putExtras(basket11);
                            startActivity(a11);
                        }catch (Exception e){}
                        break;
                    case R.id.navMy_courses:
                        try {
                            Bundle basket1 = new Bundle();
                            basket1.putString("message", message);
                            Intent a1 = new Intent(Announcements.this, Mycourses.class);
                            a1.putExtras(basket1);
                            startActivity(a1);
                        }catch (Exception e){};
                        break;
                }
                return false;
            }
        });
        new Announcements.Background_task2().execute();








    }
    public void start() {
        annoucement_adapter = new Annoucement_adapter(this, R.layout.row_layout_annoucements);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(annoucement_adapter);

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            int i=0;
           //String ann1[]={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
            String subiect,annoucment,date;
           // String cars[] = {"1111111111111111111111111111111111111111111111111111111111111111111111", "2", "3"};

               while (count < jsonArray.length()) {
                  JSONObject jo = jsonArray.getJSONObject(count);
                   subiect= jo.getString("subject");
                   date=jo.getString("date");
                   annoucment= jo.getString("annoucment");
            get_announcements get_announcements = new get_announcements(subiect,date,annoucment);
            annoucement_adapter.add(get_announcements);
                   count++;


              }
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ann1);
            //listView.setAdapter(adapter);



            //listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              //  @Override
                //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  //  TextView tv = (TextView) view;
                   // Toast.makeText(Announcements.this, tv.getText() + "  " + position, Toast.LENGTH_LONG).show();
                //}
            //});
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item))
            return true;
        {}
        return super.onOptionsItemSelected(item);


    }
    public class Background_task2 extends AsyncTask<Void,Void,String> {
        Context ctx;
        public int check;
        AlertDialog alertDialog;
        String json_url;
        public String ok;
        @Override
        protected void onPreExecute() {
            json_url="http://ucpportal.000webhostapp.com/get_announcements.php";
        }

        @Override
        protected String doInBackground(Void... params) {



            try {
                URL url=new URL(json_url);
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

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null ;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            json_string=result;
          start();


        }



    }



}
