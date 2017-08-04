package com.rupeng.solrtest1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpSolrClient.Builder builder = new HttpSolrClient.Builder("http://127.0.0.1:8983/solr/movies");
		HttpSolrClient solrClient =builder.build();
		try
		{
			SolrInputDocument doc = new SolrInputDocument();
			doc.setField("id", "1");
			doc.setField("title", "泰坦尼克号");
			doc.setField("ed2k", "ed2k://aaa.avi/ssd");
			doc.setField("content", "1912年4月10日，号称 “世界工业史上的奇迹”的豪华客轮泰坦尼克号开始了自己的处女航，从英国的南安普顿出发驶往美国纽约。富家少女罗丝（凯特•温丝莱特）与母亲及未婚夫卡尔坐上了头等舱；另一边，放荡不羁的少年画家杰克（莱昂纳多·迪卡普里奥）也在码头的一场赌博中赢得了下等舱的船票。");
			solrClient.add(doc);//insert插入
			solrClient.commit();//提交
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				solrClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
