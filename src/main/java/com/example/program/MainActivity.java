package com.example.program;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.constraintlayout.widget.ConstraintLayout;


        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.graphics.drawable.AnimationDrawable;
        import android.os.Bundle;
        import android.transition.Slide;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import com.r0adkll.slidr.Slidr;

        import java.lang.invoke.ConstantCallSite;
        import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            Slidr.attach(this);

        TextView textView1 =(TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this,Level1.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });


        TextView textView2 =(TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this,Level2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView3 =(TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this,Level3.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        TextView textView4 =(TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this,Level4.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
    }

}



