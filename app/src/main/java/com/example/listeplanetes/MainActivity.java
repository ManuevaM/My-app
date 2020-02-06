package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> planetes;

    ListView listview;
    PlaneteAdapter adapter;
    Button btnVerifier;
    Data data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Data();
        listview = findViewById(R.id.listView);
        btnVerifier= findViewById(R.id.btnVerifier);

        adapter = new PlaneteAdapter(data.planetes,getApplicationContext());
        listview.setAdapter(adapter);

        btnVerifier.setOnClickListener(verif);

        btnVerifier.setEnabled(false);



    }
    private View.OnClickListener verif = new View.OnClickListener() {
        @Override
        public void onClick(View v) {



        }
    };







}
