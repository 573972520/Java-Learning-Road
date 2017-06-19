package com.rupeng.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//将逻辑错误码放到errorCode中，把返回给浏览器的数据放到data中
public class AjaxResult {
	private String errorCode; //"ok"  "error"
	private Object data; //返回的数据
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().setDateFormat("yyy-MM-dd").create();
		return gson.toJson(this);
	}
}
