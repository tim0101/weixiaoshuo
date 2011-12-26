package com.hailang.weixiaoshuo.adapter;

import com.hailang.weixiaoshuo.R;
import com.hailang.weixiaoshuo.bean.GridItemBean;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.GridView;
import android.widget.TextView;

//该类用于主界面的列表显示提供数据源
public class IndexGridAdapter extends BaseAdapter{
	
   private Context mContext;
   private Integer[] mThumbIds;
   private String[] names;
   private LayoutInflater layoutInflater;
   //设置上下文
   public IndexGridAdapter(Context c,GridItemBean bean)
   {
     mContext=c;
     mThumbIds=bean.picId;
     names=	bean.names;
     layoutInflater=LayoutInflater.from(c);
   }
   public int  getCount() {
	  // TODO Auto-generated method stub
	  return mThumbIds.length;
   }

   public View getView(int position, View convertView, ViewGroup parent) {
	   if(null == convertView)
	   {
		   convertView = layoutInflater.inflate(R.layout.grid_item, null);
	   }
	   ImageView iv = (ImageView)convertView.findViewById(R.id.appsviewcell_image);
	   TextView tv = (TextView)convertView.findViewById(R.id.appsviewcell_text);
	   iv.setImageResource(mThumbIds[position]);
	   String appname = names[position];
	   tv.setText(appname);
	   return convertView;
    }

    public Object getItem(int position) {
	   // TODO Auto-generated method stub
	   return position;
    }

    public long getItemId(int position) {
	   // TODO Auto-generated method stub
	  return 0;
    }
}


