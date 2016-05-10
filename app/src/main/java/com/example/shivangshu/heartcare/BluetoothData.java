package com.example.shivangshu.heartcare;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BluetoothData extends AppCompatActivity {

    /*private BluetoothAdapter mBluetoothAdapter;
    Button jadoo;*/
    TextView hB, sp02, display;
    Button submit;

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_data2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        submit=(Button)findViewById(R.id.buttonHrtSp02);
        hB=(TextView)findViewById(R.id.HeartRate);
        sp02=(TextView)findViewById(R.id.SPO2);
        display=(TextView)findViewById(R.id.textViewDisplay);
        /*jadoo=(Button)findViewById(R.id.buttonInvisible);
        jadoo.setVisibility(View.VISIBLE);
        jadoo.setBackgroundColor(Color.TRANSPARENT);*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null){
            Toast.makeText(getApplicationContext(),"Bluetooth not enabled!",Toast.LENGTH_SHORT).show();
        }else {
            mBluetoothAdapter.enable();
            Toast.makeText(getApplicationContext(),"Bluetooth Turned On!",Toast.LENGTH_SHORT).show();
        }
        Random rand=new Random();
        int randomNumber=rand.nextInt((70-50)+1)+50;
        jadoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"Alert! Your heart data is critical, please contact doctor immediately.! Redirecting you to the calling page", Toast.LENGTH_LONG).show();
                Intent abc = new Intent(getApplicationContext(), Calling.class);
                startActivity(abc);
            }
        });*/

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hB.getText().toString().equalsIgnoreCase("")||sp02.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"One or more values cannot be empty.!",Toast.LENGTH_SHORT).show();
                }
                else {
                    if((Integer.parseInt(hB.getText().toString())<40)||(Integer.parseInt(hB.getText().toString()))>70){
                        Toast.makeText(getApplication(),"Alert! Your heart data is critical, please contact doctor immediately.! Redirecting you to the calling page", Toast.LENGTH_LONG).show();
                        Intent abc = new Intent(getApplicationContext(), Calling.class);
                        startActivity(abc);
                    }
                    if((Integer.parseInt(sp02.getText().toString())<40)||(Integer.parseInt(sp02.getText().toString()))>70){
                        Toast.makeText(getApplication(),"Alert! Your heart data is critical, please contact doctor immediately.! Redirecting you to the calling page", Toast.LENGTH_LONG).show();
                        Intent abc = new Intent(getApplicationContext(), Calling.class);
                        startActivity(abc);
                    }
                    else{
                        display.setText("You have a healthy heart measurements!");
                        display.setTextColor(Color.GREEN);
                    }
                }
            }
        });

    }



}
