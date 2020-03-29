package com.example.program;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Level4 extends AppCompatActivity {
public int count = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level4);
        final EditText rezolt = (EditText) findViewById(R.id.editText2);

        final  int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4,   R.id.point5, R.id.point6, R.id.point7, R.id.point8,
                R.id.point9, R.id.point10, R.id.point11, R.id.point12,R.id.point13, R.id.point14, R.id.point15, R.id.point16,   R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        rezolt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int num1 = Integer.parseInt(rezolt.getText().toString());

                if (event.getAction()==MotionEvent.ACTION_DOWN){

////
                }else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (num1 == 43) {
                        if (count < 20) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                }
                return true;
            }
        });
    }
}
