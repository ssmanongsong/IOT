package com.example.david.hackaton_app;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    TextView txt;
    TextView loginPrompt;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.textUN);
        password = (EditText) findViewById(R.id.textPass);
        loginPrompt = (TextView) findViewById(R.id.textPrompt);

        txt = (TextView) findViewById(R.id.textButton1);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(username.getText().toString(), password.getText().toString());


            }
        });
        }
    private void validate(String userName, String userPass) {
        try{

            if ((userName.equals("passenger")) && (userPass.equals("1234"))){
                Intent intent = new Intent(this, Passenger.class);
                startActivity(intent);
            }

            else if ((userName.equals("conductor")) && (userPass.equals("qwerty"))){
                Intent intent = new Intent(this, Driver_Conductor.class);
                startActivity(intent);
            }

            else if ((userName.equals("verifier")) && (userPass.equals("verify1234"))){
                Intent intent = new Intent(this, Checker.class);
                startActivity(intent);
            }

            else {
                loginPrompt.setVisibility(View.VISIBLE);
            }
        }

        catch (Exception e) {

        }



    }
    }

