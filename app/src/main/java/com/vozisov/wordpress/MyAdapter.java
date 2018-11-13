package com.vozisov.wordpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends SimpleAdapter {

    private ArrayList<HashMap<String, String>> results;
    private Context context;

    public MyAdapter(Context context,
                     ArrayList<HashMap<String, String>> data, int resource,
                     String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.results = data;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {

        View v = view;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_posts, null);
        }
        TextView text1 = (TextView) v.findViewById(R.id.text1);
        text1.setText(results.get(position).get("Name"));
        TextView text2 = (TextView) v.findViewById(R.id.text2);
        text2.setText(results.get(position).get("Desc"));
        ImageView image = (ImageView) v.findViewById(R.id.imageView);
        if (results.get(position).get("Media") != "") {
            //System.out.println("pos - "+position);
            //System.out.println("http://sportactiv.ru/wp-content/uploads/" + results.get(position).get("Media"));
            Picasso.with(context).load("http://sportactiv.ru/wp-content/uploads/" + results.get(position).get("Media")).into(image);
        } else {
            image.setImageResource(R.mipmap.ic_launcher);
        }
        return v;
    }
}