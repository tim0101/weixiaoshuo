package com.hailang.weixiaoshuo.activity;

import com.hailang.weixiaoshuo.R;
import com.hailang.weixiaoshuo.adapter.IndexGridAdapter;
import com.hailang.weixiaoshuo.bean.GridItemBean;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class IndexActivity extends MenuActivity implements OnItemClickListener{
	
	private static final int GRID_ITEM_FUNNY=0;//搞笑
	private static final int GRID_ITEM_SCIENCE=1;//科幻
	private static final int GRID_ITEM_AFFCE=2;//言情
	private static final int GRID_ITEM_PHILO=3;//哲理
	private static final int GRID_ITEM_HORROR=4;//惊悚
	private static final int GRID_ITEM_ANIMAL=5;//动物
	private static final int GRID_ITEM_HISTORY=6;//历史
	private static final int GRID_ITEM_MYSTERY=7;//玄幻
	private static final int GRID_ITEM_HOT=8;//热门
	
	private GridView gridview;//网格
	private GridItemBean gridBean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		fullScreen();
		setContentView(R.layout.index);
		currentMenuId=id_Index;
		super.onCreate(savedInstanceState);
		this.addMenuActivity(this);
		
	      //取得GridView对象
	       gridview = (GridView) findViewById(R.id.gridview);
	       gridBean=GridItemBean.getInstance();
	       gridview.setAdapter(new IndexGridAdapter(this,gridBean));
	       gridview.setOnItemClickListener(this);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			showDialog(DIALOG_EXIT);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
/*		switch(arg2){
		case GRID_ITEM_FUNNY:
			break;
		case GRID_ITEM_SCIENCE:
			break;
		case GRID_ITEM_AFFCE:
			break;
		case GRID_ITEM_PHILO:
			break;	
		case GRID_ITEM_HORROR:
			break;	
		case GRID_ITEM_ANIMAL:
			break;
		case GRID_ITEM_HISTORY:
			break;
		case GRID_ITEM_MYSTERY:
			break;
		case GRID_ITEM_HOT:
			break;
		}*/
		String name=gridBean.names[arg2];
		Intent intent=new Intent(this,ContentViewActivity.class);
		intent.putExtra("girdItem", arg2);
		intent.putExtra("name", name);
		startActivity(intent);
	}
}
