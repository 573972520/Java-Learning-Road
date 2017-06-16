package com.rupeng.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class BaoKu {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://volcano:8080/Servlet5/user?action=registerSubmit&username=aaa&password=123&password2=123&yzm=aaa");
		InputStream stream = url.openStream();
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader buffReader = new BufferedReader(reader);
		buffReader.readLine();
		buffReader.close();
		reader.close();
		stream.close();
		
	}
}
