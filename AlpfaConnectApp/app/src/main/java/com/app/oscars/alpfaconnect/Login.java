package com.app.oscars.alpfaconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    public EditText emailText, passwordText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText = findViewById(R.id.etEmail);
        passwordText = findViewById(R.id.etPassword);
    }

    public boolean loginEditViewsFilledProperly(){
        return emailText.getText().toString().isEmpty() || passwordText.getText().toString().isEmpty();
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.bLogin:
                Intent intentOne = new Intent(Login.this, MainActivity.class);
                startActivity(intentOne);
                break;
            case R.id.bRegister:
                Intent intentTwo = new Intent(Login.this, Register.class);
                if (!loginEditViewsFilledProperly()){
                    // Intent to register activity.
                    intentTwo.putExtra("EMAIL", emailText.getText().toString());
                    intentTwo.putExtra("PASSWORD", passwordText.getText().toString());
                }
                startActivity(intentTwo);
                break;
        }
    }
}
