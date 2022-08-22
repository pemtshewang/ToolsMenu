package com.example.toolsmenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.security.Provider;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    String[] activities  = {"View Image","View Message","View Map"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.options,activities);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String options = adapter.getItem(i);
                switch (options){
                    case "View Image":
                        Toast.makeText(getApplicationContext(),"You are viewing an Image",Toast.LENGTH_LONG).show();
                        break;
                    case "View Message":
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                        startActivity(intent);
                        break;
                    default:
                       Intent map = new Intent(MainActivity.this,MapNavigator.class);
                       startActivity(map);
                }
            }
        });

 }
}