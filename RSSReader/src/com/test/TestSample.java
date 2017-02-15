package com.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class TestSample {

	public static void main(String[] args) throws IllegalArgumentException, MalformedURLException, FeedException, IOException {

		String url = "http://rss.sina.com.cn/ent/hot_roll.xml";  
		//String url = "http://stackoverflow.com/feeds/tag?tagnames=rome";
		SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
		System.out.println(feed.getTitle());
	}
}


