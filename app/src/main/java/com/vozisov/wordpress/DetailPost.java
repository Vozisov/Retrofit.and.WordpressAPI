package com.vozisov.wordpress;

import android.net.ParseException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vozisov.wordpress.model.comments.Comments;
import com.vozisov.wordpress.model.posts.Posts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailPost extends AppCompatActivity {

    Posts post;
    List<Comments> comments;
    private Toolbar toolbar;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        LinearLayout comment = (LinearLayout) findViewById(R.id.comments);
        comment.setVisibility(View.INVISIBLE);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar); //NO PROBLEM !!!!
        getSupportActionBar().setTitle(R.string.app_title);
        getSupportActionBar().setSubtitle(R.string.app_full_name);

        final TextView title = (TextView) findViewById(R.id.title);
        //final TextView text = (TextView) findViewById(R.id.text);
        final TextView date = (TextView) findViewById(R.id.date);
        final WebView ww = (WebView) findViewById(R.id.ww);

        ww.getSettings().setJavaScriptEnabled(true);
        ww.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);

        final int post_id = getIntent().getIntExtra("post_id", 0);
        System.out.println(post_id);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<Posts> postcall = api.loadPost(post_id);

        postcall.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                if (response.isSuccessful()) {
                    post = response.body(); // have your all data
                    //System.out.println(post.getTitle().getRendered());
                    title.setText(Html.fromHtml(post.getTitle().getRendered()));
                    //text.setText(Html.fromHtml(post.getContent().getRendered()));

                    ww.loadData(getHtmlData(post.getContent().getRendered()), "text/html", "ru_RU");
                    Date dates = new Date();
                    String dateTime = "";
                    String dtStart = post.getDate();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    try {
                        dates = format.parse(dtStart);
                        System.out.println(dates);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                    try {
                        dateTime = dateFormat.format(dates);
                        //System.out.println("Current Date Time : " + dateTime);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    date.setText(dateTime);
                    progressBar.setVisibility(View.INVISIBLE);
                    getComments(post_id);
                }
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                System.out.println("fail");
            }
        });
    }

    private String getHtmlData(String bodyHTML) {
        String head = "<head><style>iframe, img, *{max-width: 100%; width:auto; height: auto;} " +
                "iframe, img {text-align: center; display:block; margin-left:auto; margin-right:auto;}" +
                "</style></head>";
        return "<html>" + head + "<body><div>" + bodyHTML + "</div></body></html>";
    }


    private void getComments(int post_id) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Comments>> postcomments = api.getComments(post_id);

        postcomments.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (response.isSuccessful()) {
                    comments = response.body();

                    if (comments.size() > 0) {
                        LinearLayout comment = (LinearLayout) findViewById(R.id.comments);
                        comment.setVisibility(View.VISIBLE);
                        ArrayList<HashMap<String, String>> arrayListCat = new ArrayList<>();
                        HashMap<String, String> map;

                        for (int i = 0; i < comments.size(); i++) {

                            TextView tw1 = new TextView(DetailPost.this);

                            LinearLayout.LayoutParams imageViewLayoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            tw1.setLayoutParams(imageViewLayoutParams1);
                            tw1.setTextSize(18);
                            tw1.setPadding(0, 16, 0, 8);
                            tw1.setText(Html.fromHtml(comments.get(i).getAuthorName()));
                            comment.addView(tw1);

                            TextView tw = new TextView(DetailPost.this);

                            LinearLayout.LayoutParams imageViewLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            tw.setLayoutParams(imageViewLayoutParams);
                            tw.setBackgroundColor(getResources().getColor(R.color.comment_bg_color));
                            tw.setTextSize(16);
                            tw.setPadding(16, 8, 16, 16);
                            tw.setText(Html.fromHtml(comments.get(i).getContent().getRendered()));
                            comment.addView(tw);

                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                System.out.println("fail");
            }
        });
    }


}
