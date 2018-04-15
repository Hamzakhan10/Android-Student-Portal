package com.example.hamzakhan.ucpportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    Button btn1,btn2;
    EditText ET_ID,ET_PASS,Et_old;
    String Login_id,Login_pass,old_pass;
    TextView tx;
    String message;
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
                try
                {
                Bundle basket4= new Bundle();
                basket4.putString("message", message);
                Intent a4=new Intent(Settings.this,Main_menu.class);
                a4.putExtras(basket4);
                startActivity(a4);}
                catch (Exception e){}

            }
        });


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");


        ET_ID=(EditText)findViewById(R.id.stud_id);
        ET_PASS=(EditText)findViewById(R.id.stud_pass);
        Et_old=(EditText)findViewById(R.id.stud_old_pass);
        init();

    }
    public void user_login()
    {
        Login_id=ET_ID.getText().toString();
        Login_pass=ET_PASS.getText().toString();
        old_pass=Et_old.getText().toString();

        String method="update";
        Background_task_update background_task_update=new Background_task_update(this);
        background_task_update.execute(method,Login_id,Login_pass,old_pass,message);

    }

}
