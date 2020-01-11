package com.rongxianren.activtystudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("test_state", "save in onSaveInstanceState");
        Log.d(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState save state text =  " + savedInstanceState.get("test_state"));

    }

    public void toSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void toThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void toFourthActivity(View view) {
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    public void goOtherApply(View view) {
        Intent intent = new Intent();
        intent.setAction("com.rongxianren.ipc.bookManagerActivity");
        startActivity(intent);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("---  onRestart  ---");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("---  onStart  ---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("---  onResume  ---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("---  onPause  ---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("---  onStop  ---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("---  onDestroy  ---");
    }
}
