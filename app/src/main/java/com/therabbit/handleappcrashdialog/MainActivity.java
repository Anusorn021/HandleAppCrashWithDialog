package com.therabbit.handleappcrashdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("In ON CREATE -------------------");
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.activity_main);
		findViewById(R.id.crash_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer.parseInt("sjbbdhcbdc");
            }
        });
    }
}
