package com.hailang.weixiaoshuo.activity;

import com.hailang.weixiaoshuo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class WelcomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//设置全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.welcome);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent=new Intent(WelcomeActivity.this, IndexActivity.class);
				startActivity(intent);
				WelcomeActivity.this.finish();
			}
		},2000);
	}
	@Override
	protected void onStart() {
		super.onStart();
	}
}
