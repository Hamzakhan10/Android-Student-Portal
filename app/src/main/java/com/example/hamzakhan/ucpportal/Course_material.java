package com.example.hamzakhan.ucpportal;

import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Course_material extends AppCompatActivity {
    ArrayList<Course_material_get_data> arrayList;
    ArrayList<String> list = new ArrayList<String>();

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    private ActionBar.NavigationMode mView;
    public static final int DIALOG_DOWNLOAD_PROGRESS = 1;
    private Button startBtn;
    private DownloadManager downloadManager;
    ListView lv;
    Toolbar toolbar;
    String message,pass_data;
    String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_material);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");
        pass_data=bundle.getString("data");

       /* startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });*/
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
                            Intent a4 = new Intent(Course_material.this, Main_menu.class);
                            a4.putExtras(basket4);
                            startActivity(a4);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_announcement:
                        try {
                            Bundle basket3 = new Bundle();
                            basket3.putString("message", message);
                            Intent a3 = new Intent(Course_material.this, Announcements.class);
                            a3.putExtras(basket3);
                            startActivity(a3);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_leaves:
                        try {
                            Bundle basket2 = new Bundle();
                            basket2.putString("message", message);
                            Intent a2 = new Intent(Course_material.this, Leave_status.class);
                            a2.putExtras(basket2);
                            startActivity(a2);
                        }catch (Exception e) {}
                        break;
                    case R.id.nav_logout:
                        Intent next3=new Intent(Course_material.this ,student_login.class);
                        startActivity(next3);
                        break;
                    case R.id.nav_material:
                        try {
                            Bundle basket = new Bundle();
                            basket.putString("message", message);
                            Intent a = new Intent(Course_material.this, Material.class);
                            a.putExtras(basket);
                            startActivity(a);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_settings:
                        try {
                            Bundle basket22 = new Bundle();
                            basket22.putString("message", message);
                            Intent a22 = new Intent(Course_material.this, Settings.class);
                            a22.putExtras(basket22);
                            startActivity(a22);
                        }catch (Exception e){}
                        break;
                    case R.id.nav_transcript:
                        try {
                            Bundle basket11 = new Bundle();
                            basket11.putString("message", message);
                            Intent a11 = new Intent(Course_material.this, Catalog.class);
                            a11.putExtras(basket11);
                            startActivity(a11);
                        }catch (Exception e){}
                        break;
                    case R.id.navMy_courses:
                        try {
                            Bundle basket1 = new Bundle();
                            basket1.putString("message", message);
                            Intent a1 = new Intent(Course_material.this, Mycourses.class);
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
        new ReadJSON().execute("http://ucpportal.000webhostapp.com/get_course_material.php");
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(id==0)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(0));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==1)
                {
                    String ok="chap4.pdf";
                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(1));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==2)
                {
                    String ok="chap4.pdf";
                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(2));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==3)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(3));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==4)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(4));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==5)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(5));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==6)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(5));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==7)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(5));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==8)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(5));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==9)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(5));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }
                if(id==10)
                {

                    downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri=Uri.parse("http://ucpportal.000webhostapp.com/website/uploads/"+list.get(5));
                    DownloadManager.Request request=new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference =downloadManager.enqueue(request);
                }



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
                    list.add(courseObject.getString("courseFile"));
                    arrayList.add(new Course_material_get_data(
                            courseObject.getString("courseFile")

                    ));
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            Course_material_adapter adapter = new Course_material_adapter(
                    getApplicationContext(), R.layout.custom_list_layout_cm, arrayList
            );
            lv.setAdapter(adapter);
        }
    }


    private String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url=new URL(theUrl);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data= URLEncoder.encode("Login_id","UTF-8")+"="+URLEncoder.encode(message,"UTF-8")+"&"+
                    URLEncoder.encode("Oc_names","UTF-8")+"="+URLEncoder.encode(pass_data,"UTF-8");
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
