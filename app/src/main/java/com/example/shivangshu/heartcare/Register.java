package com.example.shivangshu.heartcare;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import helper.connectivity;

public class Register extends Activity {

    EditText name,age;
    connectivity conn;
    RadioGroup sex;
    RadioButton sexValue;
    Button register, continuee;

    static String nameValue,ageValue,sexValueString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        conn= new connectivity(Register.this);
        register=(Button)findViewById(R.id.Register);
        continuee=(Button)findViewById(R.id.Continue);
        Intent getIntent = getIntent();
        name= (EditText) findViewById(R.id.Name);
        age= (EditText) findViewById(R.id.Age);
        sex=(RadioGroup)findViewById(R.id.rgSex);
        if(!getIntent.getStringExtra("name").toString().equalsIgnoreCase("")){
            name.setText(getIntent.getStringExtra("name"));
            age.setText(getIntent.getStringExtra("age"));
            switch (getIntent.getCharExtra("sex",'M')){
                case 'M':
                    sex.check(R.id.M);
                    break;
                case 'F':
                    sex.check(R.id.F);
                    break;
                default:
                    sex.check(R.id.N);
            }

            continuee.setText("Continue as "+ getIntent.getStringExtra("name").toString() );
            continuee.setVisibility(View.VISIBLE);
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameValue=name.getText().toString();
                ageValue=age.getText().toString();
                int sexId=sex.getCheckedRadioButtonId();


                if(nameValue.equalsIgnoreCase("")||ageValue.equalsIgnoreCase("")||ageValue.equalsIgnoreCase("")|| sexId==0){
                    Toast.makeText(getApplicationContext(),"Please fill all the required field!",Toast.LENGTH_SHORT).show();
                }
                else{
                    sexValue = (RadioButton) findViewById(sexId);
                    sexValueString = sexValue.getText().toString();
                   conn.insert(nameValue,sexValueString.substring(0,1),ageValue);
                    Intent callToBluetooth= new Intent(getApplicationContext(),BluetoothData.class);
                    startActivity(callToBluetooth);

                }
            }
        });
        continuee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectProcess = new Intent(getApplicationContext(),BluetoothData.class);
                startActivity(selectProcess);
            }
        });


    }

}
