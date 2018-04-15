package com.example.hamzakhan.ucpportal;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;

import br.com.bloder.magic.view.MagicButton;

public class student_login extends AppCompatActivity {
    Button btn1,btn2;
    EditText ET_ID,ET_PASS;
    String Login_id,Login_pass;
    TextView tx;
    public void init()
    {
        btn1=(Button)findViewById(R.id.magic_button1);
        btn2=(Button)findViewById(R.id.magic_button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent next4=new Intent(student_login.this ,Main_menu.class);
                //startActivity(next4);
                user_login();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent next4=new Intent(student_login.this ,Main_menu.class);
                //startActivity(next4);
                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        ET_ID=(EditText)findViewById(R.id.stud_id);
        ET_PASS=(EditText)findViewById(R.id.stud_pass);
        tx=(TextView)findViewById(R.id.textView8);
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected())
        {
            tx.setVisibility(View.INVISIBLE);
            init();

        }
        else
        {

        }
    }
    public void user_login()
    {
        String ok="Login Failed try again";
        Login_id=ET_ID.getText().toString();
        Login_pass=ET_PASS.getText().toString();
        String method="login";
        Background_task background_task=new Background_task(this);
        background_task.execute(method,Login_id,Login_pass);

    }


}
