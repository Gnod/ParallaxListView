package com.gnod.parallaxlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class ParallaxActivity extends Activity {

    private ParallaxScollListView mListView;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax);

        mListView = (ParallaxScollListView) findViewById(R.id.layout_listview);
        View header = LayoutInflater.from(this).inflate(R.layout.listview_header, null);
        mImageView = (ImageView) header.findViewById(R.id.layout_header_image);

        mListView.setZoomRatio(ParallaxScollListView.ZOOM_X2);
        mListView.setParallaxImageView(mImageView);
        mListView.addHeaderView(header);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{
                        "First Item",
                        "Second Item",
                        "Third Item",
                        "Fifth Item",
                        "Sixth Item",
                        "Seventh Item",
                        "Eighth Item",
                        "Ninth Item",
                        "Tenth Item",
                        "....."
                }
        );
        mListView.setAdapter(adapter);
    }
}
