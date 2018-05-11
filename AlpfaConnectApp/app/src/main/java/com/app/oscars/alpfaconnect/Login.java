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
//            case R.id.bLogin:
//                if (!loginEditViewsFilledProperly()){
//                    signIn(emailText.getText().toString(),
//                            passwordText.getText().toString());
//                }else{
//                    Toast.makeText(Login.this,
//                            "Please filled out both a valid email and password",
//                            Toast.LENGTH_LONG).show();
//                }
//                break;
            case R.id.bRegister:
                Intent intent = new Intent(Login.this, Register.class);
                if (!loginEditViewsFilledProperly()){
                    // Intent to register activity.
                    intent.putExtra("EMAIL", emailText.getText().toString());
                    intent.putExtra("PASSWORD", passwordText.getText().toString());
                }
                startActivity(intent);
                break;
        }
    }
}
