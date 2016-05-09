package com.example.shivangshu.heartcare;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DisplayAdvice extends AppCompatActivity {

    double linearRegValue;
    private double cBmi;
    private int cChl, cFam;
    String suggestion;
    private int cSmok, counter;
    private int cPhy;
    private double cAge;
    TextView display;
    private int cBmiH;
    private Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_advice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        counter=1;
        display=(TextView)findViewById(R.id.Display);
        call=(Button)findViewById(R.id.Call);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final Intent getDetails=getIntent();
        JSONObject details;
        try {
            details=new JSONObject(getDetails.getStringExtra("details"));
            double feet=Integer.parseInt(details.getString("feet"))*0.3048;
            double inches=Integer.parseInt(details.getString("inches"))*0.0254;
            double weight=Integer.parseInt(details.getString("weight"));
            double bmi=weight/Math.pow((feet + inches), 2);
            int age=Integer.parseInt(details.getString("Age"));
            if(age<23){
                cAge=0.1;
            }
            else if(age<28){
                cAge=0.2;
            }
            else if(age<33){
                cAge=0.3;
            }
            else{
                cAge=0.4;
            }

            if(19<=bmi && bmi<23){
                cBmi=0.1;
            }
            else if(bmi<29){
                cBmi=0.2;
            }
            else if(bmi<33){
                cBmi=0.3;
                cBmiH=1;
                            }
            else {
                cBmi=0.4;
                cBmiH=1;
            }

            String familyHist=details.getString("familyHistory");
            if(familyHist.equalsIgnoreCase("yes")){
                cFam=1;
            }
            else{
                cFam=0;
            }

            String smoking=details.getString("cigYNQ");
            if(smoking.equalsIgnoreCase("yes")){
                cSmok=1;
                            }
            else {
                suggestion=Integer.toString(counter)+".   You should immediately quit smoking"+"\n";
                counter++;
                cSmok=0;
            }

            String physicalAct=details.getString("physicalAct");
            if(physicalAct.equalsIgnoreCase("yes")){
                cPhy=1;
            }
            else{
                suggestion.concat(Integer.toString(counter)+".   Perform atleast 3 hours of physical activity per week!"+"\n");
                counter++;
                cPhy=0;

            }

            String cholestrol=details.getString("chlstrlYN");
            if(cholestrol.equalsIgnoreCase("yes")){
                cChl=1;
                            }
            else {
                cChl=0;
            }

            linearRegValue=0.2*cBmi+0.2*cChl+0.1*cAge+0.1*cSmok+0.1*cPhy+0.05*cFam;
            if(linearRegValue>0.4){
                display.setText("Alert! You are at risk. Please Consult a Doctor");
                call.setVisibility(View.VISIBLE);

            }
            else{
                if(details.getString("oil").equalsIgnoreCase("yes")){
                    suggestion.concat(Integer.toString(counter)+".   You should reduce the intake of oily foods!" + "\n");
                    counter++;
                }
                if (details.getString("fruits").equalsIgnoreCase("No")) {
                    suggestion.concat(Integer.toString(counter)+".   You must start consuming atleast 750 grams of fruits per week!" + "\n");
                    counter++;
                }
                if(cBmiH==1) {
                    suggestion.concat(Integer.toString(counter)+".   Your BMI level is high. Please follow a healthy diet with regular physical activity" + "\n");
                    counter++;
                }
                display.setText("RECCOMENDATIONS FOR YOU :"+"\n"+ suggestion);



                }



        } catch (JSONException e) {
            e.printStackTrace();
        }
call.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent abc= new Intent(getApplicationContext(),Calling.class);
        startActivity(abc);
        finish();
    }
});

    }
}


