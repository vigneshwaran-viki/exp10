package com.example.exp10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.Toast;
public class AlarmReceiver extends BroadcastReceiver {
    //implement OnReceive Method
    @Override
    public void onReceive(Context context, Intent intent) {
        // we will use vibrator first
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(4000);
        Toast.makeText(context,"Alarm! Wake up! Wake up!",Toast.LENGTH_SHORT).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alarmUri == null){
            alarmUri =
                    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        // setting default ringtone
        Ringtone ringtone = RingtoneManager.getRingtone(context,alarmUri);
        ringtone.play();
    }
}