package com.example.mathmatic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartupActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String CardNum = "cardKey";
    public static final String ZipCode = "zipKey";
    public static final String ExpireDate = "datelKey";

    SharedPreferences sharedpreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_startup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ed1=(EditText)findViewById(R.id.cardField);
        ed2=(EditText)findViewById(R.id.zipField);
        ed3=(EditText)findViewById(R.id.dateField);

        b1=(Button)findViewById(R.id.savebtn);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String card  = ed1.getText().toString();
                String zip  = ed2.getText().toString();
                String date  = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(CardNum, card);
                editor.putString(ZipCode, zip);
                editor.putString(ExpireDate, date);
                editor.apply();
                Toast.makeText(StartupActivity.this,"Saved",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(StartupActivity.this, ComingSoon.class);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button homebtn = findViewById(R.id.homebtn);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void LoadData(View view) {
        String cardnum = sharedpreferences.getString(CardNum,"");
        String zipcode = sharedpreferences.getString(ZipCode,"");
        String expiredate = sharedpreferences.getString(ExpireDate,"");
        ed1.setText(cardnum);
        ed2.setText(zipcode);
        ed3.setText(expiredate);
    }
}