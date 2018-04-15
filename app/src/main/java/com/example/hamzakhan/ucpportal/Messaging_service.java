package com.example.hamzakhan.ucpportal;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.widget.ListView;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by Hamza khan on 28/12/2017.
 */

public class Messaging_service extends com.google.firebase.messaging.FirebaseMessagingService{
    String JSON_STRING;
    String subiect;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String longmsg="";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        showNotification(remoteMessage.getData().get("message"));

    }

    private void showNotification(String message) {
        Intent i = new Intent(this,student_login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Ucp")
                .setContentText(message)
                .setSmallIcon(R.drawable.ucplogo)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(message))
                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                .setContentIntent(pendingIntent);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

        manager.notify(m,builder.build());
    }


    public void start() {


        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = jsonArray.length()-1;
                JSONObject jo = jsonArray.getJSONObject(count);
                subiect= jo.getString("subject");

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
