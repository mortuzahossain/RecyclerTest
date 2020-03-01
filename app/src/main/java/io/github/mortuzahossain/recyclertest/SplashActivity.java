package io.github.mortuzahossain.recyclertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.mortuzahossain.recyclertest.util.AppAnimation;
import io.github.mortuzahossain.recyclertest.util.NetworkAvailability;

import static io.github.mortuzahossain.recyclertest.NavigationModel.getData;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivityTag";

    public static final String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String SERVICE_SUCCESS = "bd.quantum.quantumwallpaper.SERVICE_SUCCESS";
    public static final String SERVICE_FAILED = "bd.quantum.quantumwallpaper.SERVICE_FAILED";
    TextView tv_splash_check_connection;
    BroadcastReceiver netAvailablleReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            netAvailableMessage(NetworkAvailability.isOnline(SplashActivity.this));
        }
    };
    IntentFilter filter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv_splash_check_connection = findViewById(R.id.tv_splash_check_connection);
        animateIcon();

    }


    private void netAvailableMessage(boolean networkAvailable) {
        if(networkAvailable){

            tv_splash_check_connection.setText(R.string.internet_connected);
            tv_splash_check_connection.setBackgroundColor(getResources().getColor(R.color.colorGreen) );
            tv_splash_check_connection.setTextColor(Color.WHITE);
            AppAnimation.fadeOutAnimation(tv_splash_check_connection,2000);
//            Handler handler = new Handler();
//            Runnable delayrunnable = () -> tv_splash_check_connection.setVisibility(View.GONE);
//            handler.postDelayed(delayrunnable, 3000);
            Log.d(TAG, "netAvailableMessage: Available");

            getDataFromInternet();
            
            
        }else {

            Log.d(TAG, "netAvailableMessage: UnAvailable");


            tv_splash_check_connection.setText(R.string.no_internet_connection);
            tv_splash_check_connection.setBackgroundColor(getResources().getColor(R.color.colorRed));
            tv_splash_check_connection.setTextColor(Color.WHITE);
            tv_splash_check_connection.setVisibility(View.VISIBLE);
            AppAnimation.fadeInAnimation(tv_splash_check_connection,3000);

        }
    }

    private void getDataFromInternet() {
        Log.d(TAG, "getDataFromInternet: Getting data from internet.");
    }


    private void animateIcon() {
        ImageView ivIcon = findViewById(R.id.ivIcon);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        ivIcon.startAnimation(animation);
    }


    @Override
    protected void onResume() {

        super.onResume();
        filter.addAction(CONNECTIVITY_CHANGE);
        registerReceiver(netAvailablleReceiver, filter);
    }
    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: Call Cancel");
        
//        if(call != null){
//            call.cancel();
//        }
        try {
            unregisterReceiver(netAvailablleReceiver);
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("Receiver not registered")) {
                Log.d(TAG,"Tried to unregister the reciver when it's not registered");
            } else {
                throw e;
            }
        }

    }
}
