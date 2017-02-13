package snowroller.servicenotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new MyIntentService().getActionFooIntent(getApplicationContext(),"test","test");

        final PendingIntent pIntent = PendingIntent.getService(getApplicationContext(),
                1, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                10000, pIntent);

//        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        alarm.cancel(pIntent);

        //MyIntentService.startActionFoo(this, "", "");

      /*  ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate
                (new Runnable() {
                    public void run() {
                        // call service
                        MyIntentService.startActionFoo(MainActivity.this,"","");
                        Log.i("Android", "restarting Service");
                    }
                }, 0, 1, TimeUnit.MINUTES);
*/

    }

    public void startButton(View v)
    {
        Intent intent = new MyIntentService().getActionFooIntent(getApplicationContext(),"test","test");

        final PendingIntent pIntent = PendingIntent.getService(getApplicationContext(),
                1, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                10000, pIntent);

    }
    public void stopButton(View v)
    {
        Intent intent = new MyIntentService().getActionFooIntent(getApplicationContext(),"test","test");

        final PendingIntent pIntent = PendingIntent.getService(getApplicationContext(),
                1, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(pIntent);
    }

}
