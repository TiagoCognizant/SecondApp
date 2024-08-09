package com.example.secondapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.cognizantreveng.IAddListener;
import com.example.secondapp.databinding.ActivityAnyBinding;

public class AnyActivity extends AppCompatActivity {

    Button notifyButton;
    private ActivityAnyBinding binding;
    IAddListener iRemoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification();
            }
        });
        binding.btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openMainActivity1min();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Class<?> pack = IAddListener.class.getPackage();
                Intent intent = new Intent("ineed.add");
                intent.setPackage("package com.example.cognizantreveng");
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
        });
    }

    ServiceConnection connection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder aidlBinder) {
            Log.i("clientActivity", "Client Activity connected to Service");
            iRemoteService = IAddListener.Stub.asInterface(aidlBinder);
            int sum = 0;
            try {
                sum = iRemoteService.add(10,20);
                binding.tvSum.setText(""+ sum);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /**
    private void openMainActivity1min() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long triggerTime = System.currentTimeMillis() + 30 * 60;
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.set(AlarmManager.RTC, triggerTime, pendingIntent);
    }

    */
    private void showNotification() {
        Intent intent = new Intent (this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.baseline_child_care_24)
                .setContentTitle("title childs care")
                .setContentText("take care content")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.notify(321,builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "uber channel name promotions";
            String description = "channel description --- promotions";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this.
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}