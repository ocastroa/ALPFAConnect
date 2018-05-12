package com.app.oscars.alpfaconnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;


public class RegisterTwo extends Activity {

//    private FirebaseAuth mAuth;
//    private Database DB = Database.getInstance();

    public EditText Major, HighestEdu, CurrentOcc, Password, PasswordAgain;
//    public Customer newCustomer;
//    public String TAG = "JUDE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);

//        newCustomer = new Customer();
//        mAuth = FirebaseAuth.getInstance();
        Major = findViewById(R.id.etMajor);
        HighestEdu = findViewById(R.id.etHighestEducation);
        CurrentOcc = findViewById(R.id.etCurrentOccupation);
        Password = findViewById(R.id.etPassword);
        PasswordAgain = findViewById(R.id.etPasswordAgain);

        // Set email and password fields to the previously entered.
        Intent registrationIntent = getIntent();
        Password.setText(registrationIntent.getStringExtra("PASSWORD"));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:
                if (requireFieldsFilled()) {
                    Intent intent = new Intent(RegisterTwo.this, ChooseTopics.class);
                    startActivity(intent);
                }
                break;
        }
    }

    public boolean requireFieldsFilled() {
        boolean emptyFields;

        String str_major = Major.getText().toString();
        if (TextUtils.isEmpty(str_major)) {
            Major.setError("Enter your major");
        }

        String str_highest_edu = HighestEdu.getText().toString();
        if (TextUtils.isEmpty(str_highest_edu)) {
            HighestEdu.setError("Enter your highest education");
        }

        String str_occupation = CurrentOcc.getText().toString();
        if (TextUtils.isEmpty(str_occupation)) {
            CurrentOcc.setError("Enter your current occupation");
        }

        String pword = Password.getText().toString();
        String pwordConfirm = PasswordAgain.getText().toString();

        if (TextUtils.isEmpty(pword)) {
            emptyFields = false;
            Password.setError("Enter your password");
        } else if(pword.compareTo(pwordConfirm) != 0){
            emptyFields = false;
            Toast.makeText(RegisterTwo.this,
                    "Make sure that you re-enter the same password", Toast.LENGTH_LONG).show();
        }

        else {
            emptyFields = true;
        }

        return emptyFields;
    }

//    public void registerCustomer(String uid){
//        Log.d(TAG, "creating a new customer");
//        newCustomer.initCustomer(Name.getText().toString(),
//                address.getText().toString(),
//                email.getText().toString(),
//                phone_number.getText().toString());
//        DB.createFirebaseCustomer(uid, newCustomer);
//    }
//
//    public void createNewUser(String email, String password){
//        Log.d(TAG, "creating new user");
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        Log.d(TAG, "completing registration");
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            if (user != null) {registerCustomer(user.getUid());}
//                            Intent intent = new Intent(register.this, Main_Menu.class);
//                            startActivity(intent);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//
//                            String errorMsg = task.getException().toString();
//
//                            Toast.makeText(register.this, errorMsg.substring(errorMsg.indexOf(":")),
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//    }
}
