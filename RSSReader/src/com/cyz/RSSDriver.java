package com.cyz;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class RSSDriver {

	public static void rssDriven(String rssUrl) throws UnsupportedEncodingException, IOException{
		URL url = new URL(rssUrl);
		//URL url = new URL("http://rss.mydrivers.com/rss.aspx?Tid=1");
        // �򿪵��� URL �����Ӳ�����һ�����ڴӸ����Ӷ���� InputStream��
		
		// �������Ӷ��󣬲鿴content type
		URLConnection conn = url.openConnection();
		String content_type = conn.getHeaderField("Content-Type");
		String encoding = conn.getContentEncoding();
		
		System.out.println(content_type + " 123 ~~~~~~~~" + encoding + " ~~~~~~~~~~ " + conn.getHeaderFields());
		
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()), "UTF-8");
        int c;
        
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        
        reader.close();
	}
	
	@Test
	public void testName() throws Exception {
		rssDriven("http://rss.mydrivers.com/rss.aspx?Tid=1");
		
	}
	
	public static void main(String[] args){
		try {
			//��������֮��
//			rssDriven("http://rss.mydrivers.com/rss.aspx?Tid=1");
			
			//����֪�� http://www.zhihu.com/rss  https://link.zhihu.com/?target=http%3A//feeds.feedburner.com/zhihu-daily
			rssDriven("https://www.zhihu.com/rss");
				
			//��ѧ����� https://link.zhihu.com/?target=http%3A//songshuhui.net/feed
//			rssDriven("http://songshuhui.net/feed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
