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
		
		mListView = (ParallaxScollListView)findViewById(R.id.layout_listview);
		View header = LayoutInflater.from(this).inflate(R.layout.listview_header, null);
		mImageView = (ImageView)header.findViewById(R.id.layout_header_image);
		
		mListView.setParallaxImageView(mImageView);
		mListView.addHeaderView(header);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_expandable_list_item_1, 
				new String[]{
				"First Item",
				"Second Item",
				"Third Item",
				"....."
		});
		mListView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.parallax, menu);
		return true;
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		mListView.setViewsBounds(ParallaxScollListView.ZOOM_X2);
	}
	
}
