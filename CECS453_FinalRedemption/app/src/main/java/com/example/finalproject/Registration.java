package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsername;
    private EditText mPassword;
    private EditText mRetypePass;
    private EditText mEmail;
    private EditText mPhone;
    private Button mSubmit;
    Context context;
    private static HashMap<String, String> credentials;
    private AwesomeValidation awesomeValidation;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        context = getApplicationContext();
        DBHelper mydb = new DBHelper(this);
        mUsername = findViewById(R.id.txtUsername);
        mPassword = findViewById(R.id.txtPassword);
        mRetypePass = findViewById(R.id.txtRetype);
        mEmail = findViewById(R.id.txtEmail);
        mPhone = findViewById(R.id.txtPhone);
        mSubmit = findViewById(R.id.btnSubmit);

        Intent intent = getIntent();
        credentials = mydb.getAllUsers();

        //Handles validating the fields used to create a new user
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.txtUsername, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.username_err);
        awesomeValidation.addValidation(this, R.id.txtPassword, "^[A-Za-z0-9\\s]{1,}[\\.]{0,1}[A-Za-z0-9\\s]{0,}$", R.string.password_err);
        awesomeValidation.addValidation(this, R.id.txtRetype, "^[A-Za-z0-9\\s]{1,}[\\.]{0,1}[A-Za-z0-9\\s]{0,}$", R.string.password_err);
        awesomeValidation.addValidation(this, R.id.txtEmail, Patterns.EMAIL_ADDRESS, R.string.email_err);
        awesomeValidation.addValidation(this, R.id.txtPhone, "^[1-9]{2}[0-9]{8}$", R.string.phone_err);

        mSubmit.setOnClickListener(this);
    }


    private void submitForm() {
        if (mPassword.getText().toString().equals(mRetypePass.getText().toString()) && (!credentials.containsKey(mUsername.getText().toString()))) {
            if (awesomeValidation.validate()) {
                DBHelper mydb = new DBHelper(this);
                Toast.makeText(this, "Sign up successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                credentials.put(mUsername.getText().toString(), mPassword.getText().toString());
                String username = mUsername.getText().toString();
                mydb.insertUser(mUsername.getText().toString(),mPassword.getText().toString(),mEmail.getText().toString());

               // intent.putExtra("creds", credentials);
                startActivity(intent);
                finish();
            }
        } else {
            Toast.makeText(this, "Passwords do not match or\nusername is already taken!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mSubmit) {
            submitForm();
        }
    }
}