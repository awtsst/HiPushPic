package com.wtsst.app;

import java.io.File;

import org.xutils.DbManager;
import org.xutils.DbManager.DaoConfig;
import org.xutils.DbManager.DbUpgradeListener;

import android.os.Environment;

public class WtDb {
	  static DbManager.DaoConfig daoConfig;
	    public static DaoConfig getDaoConfig(){
	        File file=new File(Environment.getExternalStorageDirectory().getPath());
	        if(daoConfig==null){
	            daoConfig=new DbManager.DaoConfig()
	            .setDbName("shiyan.db")
	            .setDbVersion(1)
	            .setAllowTransaction(true)
	            .setDbUpgradeListener(new DbUpgradeListener() {
	                @Override
	                public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

	                }
	            });
	        }
	        return daoConfig;
	    }

}
