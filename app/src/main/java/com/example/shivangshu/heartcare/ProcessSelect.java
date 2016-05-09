package com.example.shivangshu.heartcare;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class ProcessSelect extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

           }

    @Override
    protected void onStart(){
        super.onStart();
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.content_select_process);
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
                Intent getBluetoothData= new Intent(getApplicationContext(),Calling.class);
                getBluetoothData.putExtra("Age",age);
                startActivity(getBluetoothData);
            }
        });
            dialog.show();

    }


}
