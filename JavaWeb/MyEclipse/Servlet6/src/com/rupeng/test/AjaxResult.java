package com.rupeng.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//���߼�������ŵ�errorCode�У��ѷ��ظ�����������ݷŵ�data��
public class AjaxResult {
	private String errorCode; //"ok"  "error"
	private Object data; //���ص�����
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
