package com.zsz.tools;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CheckBoxTag extends SimpleTagSupport {
	private String id;
	private String name;
	private String value;
	private String label;  //label显示文字
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspWriter out = this.getJspContext().getOut();
		//out.println("hello");
		
		//<input type="checkbox" id="cbVIP" name="vip" value="isVIP" /><label for="cbVIP">VIP会员</label>
		out.println("<input type='checkbox' id='");
		out.println(id);
		out.println("'name='");
		out.println(name);
		out.println("'value='");
		out.println(value);
		out.println("'/><label for='");
		out.println(id);
		out.println("'>");
		out.println(label);
		out.println("</label>");
	}
}
