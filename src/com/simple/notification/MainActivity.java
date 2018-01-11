package com.simple.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {
	NotificationCompat.Builder builder;
    NotificationManager manager;
    String data;
    Handler hand;
    int time=0;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hand=new Handler();
        
        builder = new NotificationCompat.Builder(this);
        
        manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        
        Runnable run=new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				builder.setContentText(String.valueOf(time)+"Sec elapsed");
				time = time+10;
				builder.setContentTitle("Timer");
				builder.setSmallIcon(R.drawable.download);
				manager.notify(0,builder.build());
				hand.postDelayed(this,10000);
			}
        	
			
        };
        hand.post(run);
	}
}
