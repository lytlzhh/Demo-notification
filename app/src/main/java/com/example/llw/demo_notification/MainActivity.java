package com.example.llw.demo_notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;
    private Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = (Button) findViewById(R.id.button1);
        btnDelete = (Button) findViewById(R.id.button2);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
            Notification.Builder builder = new Notification.Builder(MainActivity.this);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                builder.setSmallIcon(R.drawable.a);
                builder.setContentIntent(pendingIntent);//设置动作
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.a));
                builder.setContentTitle("快乐每一天");
                builder.setContentText("hello word my name is lisi and what you name");
               builder.setSubText("hhhhhhhhhhhhhhhh");
                builder.setSubText("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());//这里的第一个参数是指该通知的唯一标识，第二个参数是指要返回notification的对象
               startActivity(intent);
                Toast.makeText(MainActivity.this, "你哈"+ builder.setContentText("hello word my name is lisi and what you name"), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
