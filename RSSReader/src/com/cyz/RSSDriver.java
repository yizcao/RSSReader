package com.cyz;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.junit.Test;

public class RSSDriver {

	static String xmlOutput = "";
	public static void rssDriven(String rssUrl) throws UnsupportedEncodingException, IOException{
		URL url = new URL(rssUrl);
		//URL url = new URL("http://rss.mydrivers.com/rss.aspx?Tid=1");
        // 打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream。
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()), "UTF-8");
        int c;
        
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
            xmlOutput = xmlOutput + c;
        }
        reader.close();
        
	}
	
	@Test
	public void testName() throws Exception {
		rssDriven("http://rss.mydrivers.com/rss.aspx?Tid=1");
	}
	
	public static void main(String[] args){
		try {
			rssDriven("http://rss.mydrivers.com/rss.aspx?Tid=1");
			System.out.println("");
			System.out.println("????");
	        System.out.println(" ");
	        System.out.println(xmlOutput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
