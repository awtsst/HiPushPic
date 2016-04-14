package com.wtsst.hi;

import java.util.ArrayList;
import java.util.List;

import org.xutils.DbManager;
import org.xutils.DbManager.DaoConfig;
import org.xutils.x;
import org.xutils.ex.DbException;

import com.wtsst.app.User;
import com.wtsst.app.WtDb;

public class DbUtils {
	private static DaoConfig daoConfig;
	private static DbManager db;
	private static String[] arrays;

	public static String[] getUserStrArr() {
		x.Ext.setDebug(BuildConfig.DEBUG);
		daoConfig = WtDb.getDaoConfig();
		db = x.getDb(daoConfig);
		try {
			List<User> person = db.findAll(User.class);
			List<String> listStr = new ArrayList<String>();
			for (User u : person) {
				listStr.add(u.getUrl());
			}
			arrays = new String[listStr.size()];
			listStr.toArray(arrays);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return arrays;
	}
}
