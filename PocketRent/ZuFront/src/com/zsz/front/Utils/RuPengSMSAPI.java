package com.zsz.front.Utils;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.zsz.service.SettingService;
import com.zsz.tools.CommonUtils;

public class RuPengSMSAPI {
	
	public static RuPengSMSResult send(String code,String phoneNum)
	{
		// 从系统配置表中读取出用户名、appkey等
		SettingService settingService = new SettingService();
		String username = settingService.getValue("RuPengSMS.UserName");
		String appkey = settingService.getValue("RuPengSMS.AppKey");
		String templateId = settingService.getValue("RuPengSMS.TemplateId");
		// 构造请求的get字符串
		String sendUrl = "http://sms.rupeng.cn/SendSms.ashx?userName=" + CommonUtils.urlEncodeUTF8(username)
						+ "&appKey=" + CommonUtils.urlEncodeUTF8(appkey) + "&templateId=" + templateId + "&code="
						+ CommonUtils.urlEncodeUTF8(code) + "&phoneNum=" + phoneNum;
		try {
			String resp = IOUtils.toString(new URL(sendUrl),"UTF-8");// 发出http请求，获得响应报文
			Gson gson = CommonUtils.createGson();
			return gson.fromJson(resp,RuPengSMSResult.class);// 解析成java对象
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
