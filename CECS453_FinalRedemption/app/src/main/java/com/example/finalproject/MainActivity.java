package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private Button mSignup;
    private Button mLogin;

    private Context context;
    private static HashMap<String, String> credentials;
    private static HashMap<String, String> idMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        DBHelper mydb = new DBHelper(this);

        credentials = mydb.getAllUsers();
        idMap = mydb.getAllUserID();
        mUsername = findViewById(R.id.txtUsername);
        mPassword = findViewById(R.id.txtPassword);
        mSignup = findViewById(R.id.btnSignup);
        mLogin = findViewById(R.id.btnLogin);

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                intent.putExtra("creds", credentials);
                startActivity(intent);
                Toast toast = Toast.makeText(context, "Sign up!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chkName = mUsername.getText().toString();
                String chkPass = mPassword.getText().toString();
                String message = "";

                if (credentials.containsKey(chkName) && credentials.get(chkName).equals(chkPass)) {
                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    intent.putExtra("id", idMap.get(chkName));
                    startActivity(intent);
                    message = "Success!";
                } else {
                    message = "Login failed!\nInvalid credentials!";
                    mPassword.setText("");
                }
                Toast toast = Toast.makeText(context, idMap.get(chkName), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        Toast toast = Toast.makeText(context, "getting table", Toast.LENGTH_LONG);
        toast.show();
        DBHelper mydb = new DBHelper(this);
        credentials = mydb.getAllUsers();
    }
}