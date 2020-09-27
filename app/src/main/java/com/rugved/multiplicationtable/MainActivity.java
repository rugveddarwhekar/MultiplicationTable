package com.rugved.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar mySeekBar = findViewById(R.id.seekBar);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
                ListView myListView = findViewById(R.id.list_view);
                ArrayList<String> table = new ArrayList<>();

                for(int i = 1; i <= 10; i++){
                    table.add(value + " * " + i  + " = " + i*value);
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, table);
                myListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Toast.makeText(getApplicationContext(), "Value: " + value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}