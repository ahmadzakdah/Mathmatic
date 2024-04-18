package com.example.mathmatic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

public class EducationActivity extends AppCompatActivity {
    private Spinner spnMenu;
    private Button btnSearch, btnHome;
    private ListView lstItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        setupViews();

        populateSpinner();
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EducationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseItems db = new DatabaseItems();
                String cat = spnMenu.getSelectedItem().toString();

                List<MenuItem> result = db.getMenuItems(cat);
                MenuItem[] arr = result.toArray(new MenuItem[result.size()]);
                ArrayAdapter<MenuItem> adapter = new ArrayAdapter<MenuItem>(EducationActivity.this,
                        android.R.layout.simple_list_item_1, arr);
                lstItems.setAdapter(adapter);


            }
        });


    }

    private void populateSpinner() {
        DatabaseItems db = new DatabaseItems();
        String[] cats = db.getCategories();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cats);
        spnMenu.setAdapter(adapter);
    }

    private void setupViews() {
        spnMenu = findViewById(R.id.spnMenu);
        btnSearch = findViewById(R.id.btnSearch);
        btnHome = findViewById(R.id.homebtn);
        lstItems = findViewById(R.id.lstItems);
    }
}