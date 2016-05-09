package com.example.shivangshu.heartcare;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ProcessSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_process_select1);

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart(){
        super.onStart();
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.content_process_select1);
        Intent getIntent=getIntent();
        final String age=getIntent.getStringExtra("Age");
        dialog.setTitle("Dialog box");

        Button button = (Button) dialog.findViewById(R.id.buttonCheckup);
        Button button1=(Button)dialog.findViewById(R.id.buttonCheckup1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent heartCheckup = new Intent(getApplicationContext(),Details.class);
                heartCheckup.putExtra("Age",age);
                startActivity(heartCheckup);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getBluetoothData = new Intent(getApplicationContext(), Calling.class);
                getBluetoothData.putExtra("Age", age);
                startActivity(getBluetoothData);
            }
        });
        dialog.show();

    }

}
