package com.example.shivangshu.heartcare;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Details extends Activity {

    RelativeLayout weight,pastHistory, hightBP, cholestrol, diet, smoking, familyHistory, physicalActivy;
    Button buttonHeight,buttonHistory,buttonWeight, buttonHBP,buttonChlstrl,buttonDiet, buttonCig, buttonFamilyHistory, buttonPhysicalActivity;
    EditText feetValue, inchesValue, weightValue;
    RadioGroup history,highBPGroup, cholestrolConsumption, cholestrolValue, fishGroup, fruitGroup, grainsGroup, nutsGroup, butterGroup, margarineGroup, oilGroup, cig, cigExposed, physicalActivityRadio, familyHeartAttack;
    RadioButton historyValue,highBPValue, cholestrolYesNO, cholestrolRange, fishYesNo, fruitYesNo, grainsYesNo, nutsYesNo, butterYesNo, margarineYesNo, oilYesNo, cigYesNo,cigExposedRange,physicalActivityDuration, familyYesNo;
    Map<String,String> details= new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent getIntent=getIntent();
        final String age=getIntent.getStringExtra("Age");
        buttonHeight=(Button)findViewById(R.id.buttonHeight);
        buttonHistory=(Button)findViewById(R.id.buttonHistory);
        buttonHBP=(Button)findViewById(R.id.buttonHBP);
        buttonChlstrl=(Button)findViewById(R.id.buttonChlstrl);
        buttonWeight=(Button)findViewById(R.id.WeightSubmit);
        buttonDiet=(Button)findViewById(R.id.buttonDiet);
        buttonCig=(Button)findViewById(R.id.buttonCig);
        buttonFamilyHistory=(Button)findViewById(R.id.buttonfh);
        buttonPhysicalActivity=(Button)findViewById(R.id.buttonWalk);

        weight=(RelativeLayout)findViewById(R.id.rlW);
        pastHistory=(RelativeLayout)findViewById(R.id.rlPH);
        hightBP=(RelativeLayout)findViewById(R.id.RLHBP);
        cholestrol=(RelativeLayout)findViewById(R.id.RLChlrtl);
        diet=(RelativeLayout)findViewById(R.id.rldiet);
        smoking=(RelativeLayout)findViewById(R.id.rlsmoking);
        familyHistory=(RelativeLayout)findViewById(R.id.rlfh);
        physicalActivy=(RelativeLayout)findViewById(R.id.rlpa);

        feetValue=(EditText)findViewById(R.id.FeetValue);
        inchesValue=(EditText)findViewById(R.id.InchesValue);
        weightValue=(EditText)findViewById(R.id.weightValue);

        history=(RadioGroup)findViewById(R.id.radioHistory);
        highBPGroup=(RadioGroup)findViewById(R.id.radioHBP);
        cholestrolConsumption=(RadioGroup)findViewById(R.id.radioChlstrl);
        cholestrolValue=(RadioGroup)findViewById(R.id.radioChlstrNumber);
        fishGroup=(RadioGroup)findViewById(R.id.radioFishGroup);
        fruitGroup=(RadioGroup)findViewById(R.id.radioFruit);
        grainsGroup=(RadioGroup)findViewById(R.id.radioGrains);
        nutsGroup=(RadioGroup)findViewById(R.id.radioNuts);
        butterGroup=(RadioGroup)findViewById(R.id.radioButter);
        margarineGroup=(RadioGroup)findViewById(R.id.radioMargarine);
        oilGroup=(RadioGroup)findViewById(R.id.radioOil);
        cig=(RadioGroup)findViewById(R.id.radioCig);
        cigExposed=(RadioGroup)findViewById(R.id.radioCigDuration);
        physicalActivityRadio=(RadioGroup)findViewById(R.id.radioWalk);
        familyHeartAttack=(RadioGroup)findViewById(R.id.radiofh);


        buttonHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(feetValue.getText().toString().equalsIgnoreCase("")||inchesValue.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Please enter your height!", Toast.LENGTH_SHORT).show();
                }
                else{
                    details.put("feet",feetValue.getText().toString());
                    details.put("inches",feetValue.getText().toString());
                    weight.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weightValue.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Please enter your Weight!",Toast.LENGTH_SHORT).show();
                }
                else{
                    details.put("weight",weightValue.getText().toString());
                    pastHistory.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int historyId=history.getCheckedRadioButtonId();
                historyValue=(RadioButton)findViewById(historyId);
                String s1=historyValue.getText().toString();
                hightBP.setVisibility(View.VISIBLE);
                details.put("heartAttack",historyValue.getText().toString());

                            }
        });

        buttonHBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int highBPId= highBPGroup.getCheckedRadioButtonId();
                highBPValue=(RadioButton)findViewById(highBPId);
                String s2=highBPValue.getText().toString();
                cholestrol.setVisibility(View.VISIBLE);
                details.put("BP", highBPValue.getText().toString());


            }
        });

        buttonChlstrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int consumption=cholestrolConsumption.getCheckedRadioButtonId();
                cholestrolYesNO=(RadioButton)findViewById(consumption);
                String s3= cholestrolYesNO.getText().toString();
                details.put("chlstrlYN",cholestrolYesNO.getText().toString());


                int range= cholestrolValue.getCheckedRadioButtonId();
                cholestrolRange=(RadioButton)findViewById(range);
                String s4=cholestrolRange.getText().toString();
                details.put("chlstrlRange",cholestrolRange.getText().toString());
                diet.setVisibility(View.VISIBLE);

            }
        });
        buttonDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fishId= fishGroup.getCheckedRadioButtonId();
                fishYesNo=(RadioButton)findViewById(fishId);
                String s4=fishYesNo.getText().toString();
                details.put("fish",fishYesNo.getText().toString());


                int fruitId= fruitGroup.getCheckedRadioButtonId();
                fruitYesNo=(RadioButton)findViewById(fruitId);
                String s5=fruitYesNo.getText().toString();
                details.put("fruits",fruitYesNo.getText().toString());


                int grainId= grainsGroup.getCheckedRadioButtonId();
                grainsYesNo=(RadioButton)findViewById(grainId);
                String s6=fishYesNo.getText().toString();
                details.put("grains",grainsYesNo.getText().toString());


                int nutsId= nutsGroup.getCheckedRadioButtonId();
                nutsYesNo=(RadioButton)findViewById(nutsId);
                String s7=fishYesNo.getText().toString();
                details.put("nuts",nutsYesNo.getText().toString());


                int butterId= butterGroup.getCheckedRadioButtonId();
                butterYesNo=(RadioButton)findViewById(butterId);
                String s8=fishYesNo.getText().toString();
                details.put("butter",butterYesNo.getText().toString());


                int margarineId= margarineGroup.getCheckedRadioButtonId();
                margarineYesNo=(RadioButton)findViewById(margarineId);
                String s9=fishYesNo.getText().toString();
                details.put("margarine",margarineYesNo.getText().toString());


                int oilId= oilGroup.getCheckedRadioButtonId();
                oilYesNo=(RadioButton)findViewById(oilId);
                String s10=fishYesNo.getText().toString();
                details.put("oil",oilYesNo.getText().toString());


                smoking.setVisibility(View.VISIBLE);


            }
        });
        buttonCig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cigconfirm= cig.getCheckedRadioButtonId();
                cigYesNo=(RadioButton)findViewById(cigconfirm);
                String s11=cigYesNo.getText().toString();
                details.put("cigYNQ",cigYesNo.getText().toString());

                int cigDuration= cigExposed.getCheckedRadioButtonId();
                cigExposedRange=(RadioButton)findViewById(cigDuration);
                String s12= cigExposedRange.getText().toString();
                details.put("cigDuration",cigExposedRange.getText().toString());

                physicalActivy.setVisibility(View.VISIBLE);
            }
        });
        buttonPhysicalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int physicalActivityId=physicalActivityRadio.getCheckedRadioButtonId();
                physicalActivityDuration=(RadioButton)findViewById(physicalActivityId);
                String s13= physicalActivityDuration.getText().toString();
                                familyHistory.setVisibility(View.VISIBLE);
                details.put("physicalAct", physicalActivityDuration.getText().toString());

            }
        });
        buttonFamilyHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int familyHistoryId= familyHeartAttack.getCheckedRadioButtonId();
                familyYesNo=(RadioButton)findViewById(familyHistoryId);
                String s14=familyYesNo.getText().toString();
                details.put("familyHistory",familyYesNo.getText().toString());
                details.put("Age",age);
                JSONObject jobj = new JSONObject(details);
                Intent sendDetails= new Intent(getApplicationContext(),DisplayAdvice.class);
                sendDetails.putExtra("details",jobj.toString());
                startActivity(sendDetails);
                finish();
            }
        });
    }

}
