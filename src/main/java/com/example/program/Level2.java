package com.example.program;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    TextView number3;
    TextView number4;
    TextView textView6;
    TextView textView9;
    EditText rezolt;
    EditText Rezolt;

    Dialog dialog;
    Dialog dialogEnd2;


    Random r;
    int ran1, ran2;


    public int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View y) {
                try {
                    Intent intent = new Intent(Level2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception t) {
                }

            }
        });
        dialog= new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog3);
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
        dialogEnd2 = new Dialog(this);
        dialogEnd2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd2.setContentView(R.layout.dialogend2);
        dialogEnd2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd2.setCancelable(false);


        Button btncontinue2 = (Button) dialogEnd2.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level2.this, Level3.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialogEnd2.dismiss();

            }
        });
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8,
                R.id.point9, R.id.point10, R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        r = new Random();
        final TextView textView0 = (TextView) findViewById(R.id.textView9);
        final TextView textView1 = (TextView) findViewById(R.id.textView6);
        TextView textView2 = (TextView) findViewById(R.id.minus1);
        TextView textView3 = (TextView) findViewById(R.id.number3);
        TextView textView4 = (TextView) findViewById(R.id.number4);
         final Button cheack = (Button) findViewById(R.id.Cheack4);
        final EditText rezolt = (EditText) findViewById(R.id.Rezolt);

        cheack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int num1 = Integer.parseInt(rezolt.getText().toString());

                int rezolt = ran1 - ran2;
                if (event.getAction() == MotionEvent.ACTION_DOWN) {




                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (num1 == rezolt) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = count - 2;

                            }
                        }
                        for (int i = 0; i < 9; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }
                    if (count == 10) {
                        dialogEnd2.show();
                    } else {
                        ran1 = r.nextInt(10);
                        ran2 = r.nextInt(10);
                        textView1.setText("" + ran1);
                        textView0.setText("" + ran2);
                    }
                }
                return true;
            }
        });
        ran1 = r.nextInt(10);
        ran2 = r.nextInt(10);
        textView1.setText("" + ran1);
        textView0.setText("" + ran2);


        textView4.setText("?");
    }
}
