package com.hailang.weixiaoshuo.bean;

import com.hailang.weixiaoshuo.R;

public class GridItemBean {
	private static GridItemBean instance;
	public static GridItemBean getInstance(){
		if(instance==null){
			instance=new GridItemBean();
		}
		return instance;
	}
	public Integer[] picId={
			 R.drawable.funny,
			 R.drawable.science,
			 R.drawable.affection,
			 R.drawable.philosophy,
			 R.drawable.horror,
			 R.drawable.animal,
			 R.drawable.history,
			 R.drawable.mystery,
			 R.drawable.hot
	 };
	 public String[] names={
		"搞笑",
		"科幻",
		"言情",
		"哲理",
		"惊悚",
		"动物",
		"历史",
		"玄幻",
		"热门"
	 };
}
