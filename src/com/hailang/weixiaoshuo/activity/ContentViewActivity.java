package com.hailang.weixiaoshuo.activity;

import com.hailang.weixiaoshuo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ContentViewActivity extends BackTitelActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		fullScreen();
		setContentView(R.layout.content_view);
		
		currentMenuId=id_Index;
		Intent intent=getIntent();
		int gridItem=intent.getIntExtra("girdItem", 0);
		String name=intent.getStringExtra("name");
		initTextName(name);
		
		super.onCreate(savedInstanceState);
	}
}
