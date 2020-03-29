package com.example.program;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.r0adkll.slidr.Slidr;

import java.util.Random;
import java.util.logging.Level;

public class Level1 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;
    EditText et_min, et_max;
    Button btncontinue;
    TextView tv_output;
    TextView textView2;



    Random r;

    int c = 0 ;


    int min, max, output,output2;

    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
     //   TextView relativeLayout = findViewById(R.id.tv_output);
       // AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
       // animationDrawable.setEnterFadeDuration(2000);
      //  animationDrawable.setExitFadeDuration(4000);
      //  animationDrawable.start();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        Button button1 =(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                try{
                    Intent intent = new Intent(Level1.this,MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception d){

                }
            }
        });
        dialog= new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);


        Button btncontinue =(Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
            dialog.show();


        dialogEnd= new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.setCancelable(false);


        Button btncontinue2 =(Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Level1.this,Level2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialogEnd.dismiss();

            }
        });


        final  int[] progress = {
             R.id.point1, R.id.point2, R.id.point3, R.id.point4,   R.id.point5, R.id.point6, R.id.point7, R.id.point8,
                R.id.point9, R.id.point10, R.id.point11, R.id.point12,R.id.point13, R.id.point14, R.id.point15, R.id.point16,   R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };

        r = new Random();

        tv_output = (TextView) findViewById(R.id.tv_output);
        textView2 = (TextView) findViewById(R.id.textView2);




                min= 0 ;
                max = 5;



                tv_output.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (event.getAction()==MotionEvent.ACTION_DOWN){
                            textView2.setEnabled(false);
                            if(output > output2){
                                tv_output.setText("true");


                            }else {
                                if (output == output2) {
                                    textView2.setText("=");

                                }
                                tv_output.setText("false");

                            }


                        }else if (event.getAction()==MotionEvent.ACTION_UP) {
                            if (output > output2){
                                if (count<20){
                                    count=count+1;
                                }
                                for (int i = 0 ; i < 20; i ++){
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points);
                                }
                                for (int i = 0; i<count; i++ ){
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points_green);
                                }

                            }else {
                                if (count>0){
                                    if (count==1){
                                        count=0;
                                    }else {
                                        count=count-2;

                                    }
                                }
                                for (int i = 0 ; i < 19; i ++){
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points);
                                }
                                for (int i = 0; i<count; i++ ){
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points_green);
                                }

                            }
                            if (count == 20){
                                dialogEnd.show();
                            }else {
                                output = r.nextInt(100) ;
                                output2 = r.nextInt(100) ;
                                tv_output.setText("" + output);
                                textView2.setText("" + output2);
                                textView2.setEnabled(true);


                            }


                        }

                        return true;
                    }
                });
                textView2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        tv_output.setEnabled(false);

                        if (event.getAction()==MotionEvent.ACTION_DOWN){
                            if(output2 >  output){
                                textView2.setText("true");


                            }else {
                                if (output == output2) {
                                    tv_output.setText("=");
                                }
                                textView2.setText("false");

                            }


                        }else if (event.getAction()==MotionEvent.ACTION_UP) {
                            if (output2 > output){
                                if (count<20){
                                    count=count+1;
                                }
                                for (int i = 0 ; i < 20; i ++){
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points);
                                }
                                for (int i = 0; i<count; i++ ){
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points_green);
                                }

                            }else {
                                if (count>0){
                                    if (count==1){
                                        count=0;
                                    }else {
                                        count=count-2;

                                    }
                                }
                                for (int i = 0 ; i < 19; i ++){
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points);
                                }
                                for (int i = 0; i<count; i++ ){
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points_green);
                                }

                            }
                            if (count == 20){
                                dialogEnd.show();

                            }else {
                                output = r.nextInt(100) ;
                                output2 = r.nextInt(100) ;
                                tv_output.setText("" + output);
                                textView2.setText("" + output2);
                                tv_output.setEnabled(true);


                            }


                        }



                        return true;
                    }
                });



                textView2.setEnabled(true);
                tv_output.setEnabled(true);
                output = r.nextInt(100) ;
                output2 = r.nextInt(100) ;
                tv_output.setText("" + output);
                textView2.setText("" + output2);




    }

}





