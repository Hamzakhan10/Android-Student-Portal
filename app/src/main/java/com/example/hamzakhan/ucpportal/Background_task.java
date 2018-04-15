package com.example.hamzakhan.ucpportal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

import java.io.BufferedOutputStream;
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

/**
 * Created by Hamza khan on 27/11/2017.
 */

public class Background_task extends AsyncTask<String,Void,String>{
        Context ctx;
       public int check;
    AlertDialog alertDialog;
    String Login_url;
    public String ok;
    String Login_id;
    Background_task(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        Login_url="http://ucpportal.000webhostapp.com/login.php";
        alertDialog=new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login information....");

    }

    @Override
    protected String doInBackground(String... params) {

        String method=params[0];
        if(method.equals("login"))
        {
             Login_id=params[1];
            String Login_pass=params[2];
            try {
                URL url=new URL(Login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data= URLEncoder.encode("Login_id","UTF-8")+"="+URLEncoder.encode(Login_id,"UTF-8")+"&"+
                        URLEncoder.encode("Login_pass","UTF-8")+"="+URLEncoder.encode(Login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response ="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;

                }
                ok=response;
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null ;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {



         if(ok.equals("Login Failed try again"))
        {
            alertDialog.setMessage(result);
            alertDialog.show();

        }
        else
        {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
            //alertDialog.setMessage(result);
            //alertDialog.show();


            Bundle basket= new Bundle();
            basket.putString("message", Login_id);
            Intent a=new Intent(ctx,Main_menu.class);
            a.putExtras(basket);
            ctx.startActivity(a);
        }
    }




}
