package easyfit.easyfit;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import easyfit.easyfit.Exercices.ItemListExercice;
import easyfit.easyfit.Profile.ProfileView;
import easyfit.easyfit.Program.program;


public class AlarmReceiver extends BroadcastReceiver {
    private String[] strings = {"Hey come back training", "Don't skip leg day !", "No pain No gain"};
    int length = strings.length;
    Random random = new Random();
    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = GregorianCalendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int time = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        if (dayOfWeek == 4 && time == 11 )
        {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.drawable.ic_liste_exo)
                            .setContentTitle("EasyFit")
                            .setContentText(strings[random.nextInt(length)]);
            Intent resultIntent = new Intent(context, ProfileView.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(BaseDrawerActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            mBuilder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
            mBuilder.setAutoCancel(true);
            NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, mBuilder.build());
        }
    }
}
