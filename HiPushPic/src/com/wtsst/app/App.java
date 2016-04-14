package com.wtsst.app;

import org.xutils.BuildConfig;
import org.xutils.x;

import android.app.Application;

public class App extends Application{
	@Override
	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
		
		
		
	}
}
