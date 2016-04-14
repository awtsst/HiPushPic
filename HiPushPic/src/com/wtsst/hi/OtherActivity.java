package com.wtsst.hi;

import java.util.ArrayList;
import java.util.List;

import org.xutils.DbManager;
import org.xutils.DbManager.DaoConfig;
import org.xutils.x;
import org.xutils.ex.DbException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wtsst.app.User;
import com.wtsst.app.WtDb;

public class OtherActivity extends Activity {
	private TextView textView;
	private Button button;
	private Button addbutton;
	private DaoConfig daoConfig;
	private DbManager db;
	private StringBuffer builder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readdatabase);
		textView = (TextView) findViewById(R.id.textView);
		x.Ext.setDebug(BuildConfig.DEBUG);
		daoConfig = WtDb.getDaoConfig();
		db = x.getDb(daoConfig);
		button = (Button) findViewById(R.id.button);
		addbutton = (Button) findViewById(R.id.addbutton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				daoConfig = WtDb.getDaoConfig();
				db = x.getDb(daoConfig);
				try {
					User user = new User();
					user.setName("003");
					user.setUrl("http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg");
					db.saveOrUpdate(user);
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				StringBuffer data = query();
				textView.setText(data);
			}
		});
		addbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				daoConfig = WtDb.getDaoConfig();
				db = x.getDb(daoConfig);
				try {
					User user = new User();
					user.setName("003");
					user.setUrl("http://img.my.csdn.net/uploads/201309/01/1378037235_3453.jpg");
					db.saveOrUpdate(user);
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private StringBuffer query() {
		try {
			List<User> person = db.findAll(User.class);
			List<String> listStr = new ArrayList<String>();
			Log.e("person", person.toString());
			builder = new StringBuffer();
			for (User u : person) {
				listStr.add(u.getUrl());
			}
			// for(String s:listStr){
			// builder.append(s);
			// }
			String[] str = DbUtils.getUserStrArr();
			for (int i = 0; i < str.length; i++) {
				builder.append(str[i]);
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
		return builder;
	}

}
