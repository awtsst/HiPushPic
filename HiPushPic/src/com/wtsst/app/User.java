package com.wtsst.app;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "user")
public class User {
	@Column(name = "id", isId = true, autoGen = true)
	private int id;

	@Column(name="name")
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "url")
	private String url;

}
