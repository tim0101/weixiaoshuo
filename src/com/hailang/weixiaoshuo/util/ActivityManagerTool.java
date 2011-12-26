package com.hailang.weixiaoshuo.util;

import java.util.Stack;

import android.app.Activity;

public class ActivityManagerTool {
	private Stack<Activity> activityStack = new Stack<Activity>();
	private static ActivityManagerTool amTool;

	public static ActivityManagerTool getInstance() {
		if (amTool == null) {
			amTool = new ActivityManagerTool();
		}
		return amTool;
	}

	public boolean addActivity(Activity activity) {
		return activityStack.add(activity);
	}

	public Activity currentActivity() {
		return activityStack.lastElement();
	}

	public int getActivityStackNum() {
		return activityStack.size();
	}

	public void removeNewActivity() {
		Activity localActivity = activityStack.lastElement();
		if (localActivity != null)
			localActivity.finish();
	}

	public void removeActivity(Activity paramActivity) {
		if (paramActivity != null) {
			activityStack.remove(paramActivity);
			paramActivity.finish();
		}
	}
	public void removeAllActivityExceptNewOne(){
		while(!activityStack.empty()){
			removeActivity(activityStack.firstElement());
		}
	}
}
