package com.vozisov.wordpress.servises;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

import com.vozisov.wordpress.Api;
import com.vozisov.wordpress.Config;
import com.vozisov.wordpress.MainActivity;
import com.vozisov.wordpress.R;
import com.vozisov.wordpress.model.posts.Posts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRefresh extends Service {

    Call<List<Posts>> callp;
    List<Posts> posts;
    List<Posts> all_posts = new ArrayList<>();

    public PostRefresh() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Служба запущена",
                Toast.LENGTH_SHORT).show();
////////////
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        callp = api.loadPosts(1);

        callp.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful()) {
                    posts = response.body(); // have your all data

                    //System.out.println(posts);
                    all_posts.addAll(posts);
                    System.out.println(all_posts.get(0));
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                System.out.println("fail");
            }
        });
////////////
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_logo))
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)
                        .setContentTitle("Новая запись в блоге")
                        .setContentText("Notification text");

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        builder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, builder.build());


        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
