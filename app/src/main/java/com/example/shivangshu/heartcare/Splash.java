package com.example.shivangshu.heartcare;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;

import helper.connectivity;


public class Splash extends Activity {

    AnimationDrawable anim;
    connectivity conn;
    String name, sex, age;
    Cursor getDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ImageView splash = (ImageView) findViewById(R.id.splash);
        conn=new connectivity(Splash.this);
        try {
            BitmapDrawable frame10 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_10);
            BitmapDrawable frame9 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_9);
            BitmapDrawable frame8 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_8);
            BitmapDrawable frame7 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_7);
            BitmapDrawable frame6 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_6);
            BitmapDrawable frame5 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_5);
            BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_4);
            BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_3);
            BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_2);
            BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_1);
            BitmapDrawable frame0 = (BitmapDrawable) getResources().getDrawable(R.drawable.a_start);
            anim = new AnimationDrawable();
            anim.addFrame(frame10, 200);
            anim.addFrame(frame9, 200);
            anim.addFrame(frame8, 300);
            anim.addFrame(frame7, 200);
            anim.addFrame(frame6, 400);
            anim.addFrame(frame5, 500);
            anim.addFrame(frame4, 100);
            anim.addFrame(frame3, 100);
            anim.addFrame(frame2, 50);
            anim.addFrame(frame1, 300);
            anim.addFrame(frame0, 500);


            anim.setOneShot(false);
            splash.setBackgroundDrawable(anim);
            anim.start();
            Thread timer = new Thread(){
                public void run(){
                    try{
                        sleep(3700);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    finally{
                        name=conn.searchName();
                        Log.e("name is----",name);
                        if(!name.equalsIgnoreCase("")) {
                            getDetails = conn.searchAll();
                            if (getDetails.moveToFirst()) {
                                do {
                                    name = getDetails.getString(1);
                                    sex = getDetails.getString(2);
                                    age = getDetails.getString(3);
                                } while (getDetails.moveToNext());
                            }
                        }
                        Intent openStartingPoint = new Intent(getApplicationContext(), Register.class);
                        if(!name.equalsIgnoreCase("")) {
                            openStartingPoint.putExtra("name", name);
                            openStartingPoint.putExtra("age",age);
                            openStartingPoint.putExtra("sex",sex.charAt(0));
                        }else{
                            openStartingPoint.putExtra("name","");
                        }
                        startActivity(openStartingPoint);
                        finish();


                    }
                }
            };
            timer.start();


        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
          /*  handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                 anim.start();
                   handler.removeCallbacks();
                }
            },200);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        /*final String imageNames[]= {"me","me1"};
        Thread timer = new Thread(){
            public void run(){
                try{
                   splash.setImageResource(R.drawable.me);
                    sleep(100);

                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    Intent openStartingPoint = new Intent(getApplicationContext(), Register.class);
                    startActivity(openStartingPoint);
                    finish();
                }
            }
        };
        timer.start();*/





