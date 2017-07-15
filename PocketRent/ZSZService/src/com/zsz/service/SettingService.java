package com.zsz.service;

import com.zsz.dao.utils.SettingDAO;
import com.zsz.dto.SettingDTO;

public class SettingService
{
	private SettingDAO dao = new SettingDAO();
	
	public void setValue(String name, String value)
	{
		dao.setValue(name, value);
	}

	public String getValue(String name, String defaultValue)
	{
		return dao.getValue(name, defaultValue);
	}


	public SettingDTO[] getAll()
	{
		return dao.getAll();

	}
}
