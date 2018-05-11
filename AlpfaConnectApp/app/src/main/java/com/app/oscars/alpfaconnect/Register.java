package com.app.oscars.alpfaconnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends Activity {

//    private FirebaseAuth mAuth;
//    private Database DB = Database.getInstance();

    public EditText Name, Email, Chapter, Education, GraduationYear;
//    public Customer newCustomer;
//    public String TAG = "JUDE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        newCustomer = new Customer();
//        mAuth = FirebaseAuth.getInstance();
        Name = findViewById(R.id.etName);
        Email = findViewById(R.id.etEmail);
        Chapter = findViewById(R.id.etChapter);
        Education = findViewById(R.id.etEducation);
        GraduationYear = findViewById(R.id.etGraduationYear);

        // Set email and password fields to the previously entered.
        Intent registrationIntent = getIntent();
        Email.setText(registrationIntent.getStringExtra("EMAIL"));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bNext:
                if (requireFieldsFilled()) {
                    Intent intent = new Intent(Register.this, RegisterTwo.class);
                    startActivity(intent);
                }
                break;
        }
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public boolean requireFieldsFilled() {
        boolean emptyFields;

        String str_name = Name.getText().toString();
        if (TextUtils.isEmpty(str_name)) {
            Name.setError("Enter your name");
        }

        String str_chapter = Chapter.getText().toString();
        if (TextUtils.isEmpty(str_chapter)) {
            Chapter.setError("Enter the city of your chapter");
        }

        String str_edu = Education.getText().toString();
        if (TextUtils.isEmpty(str_edu)) {
            Education.setError("Enter your school or Alma Mater");
        }

        String str_grad_year = GraduationYear.getText().toString();
        if (TextUtils.isEmpty(str_grad_year)) {
            GraduationYear.setError("Enter your graduation year");
        }

        String str_email = Email.getText().toString();
        if (TextUtils.isEmpty(str_email)) {
            emptyFields = false;
            Email.setError("Enter your email");
        } else if (!validateEmail(str_email)) {
            emptyFields = false;
            Email.setError("Enter correct format");
        }

        else {
            emptyFields = true;
        }

        return emptyFields;
    }
}
