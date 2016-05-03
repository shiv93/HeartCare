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

public class BluetoothData extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

           }

    @Override
    protected void onStart(){
        super.onStart();
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.content_select_process);
        dialog.setTitle("Dialog box");

        Button button = (Button) dialog.findViewById(R.id.buttonCheckup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent heartCheckup = new Intent(getApplicationContext(),Details.class);
                startActivity(heartCheckup);
            }
        });
            dialog.show();

    }


}
