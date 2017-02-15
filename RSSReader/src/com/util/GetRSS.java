package com.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class GetRSS {

	public List parseRss(){
//		String rss = "http://rss.mydrivers.com/rss.aspx?Tid=1";
//		String rss = "http://rss.sina.com.cn/ent/hot_roll.xml"; 
//		String rss = "https://www.zhihu.com/rss";
		String rss = "http://www.ruanyifeng.com/blog/atom.xml";

		List entries = null;
		try {
			URL url = new URL(rss);
			XmlReader reader = new XmlReader(url);
			System.out.println("Rss源的编码格式为：" + reader.getEncoding()); 
			
			SyndFeedInput input = new SyndFeedInput();  
	        // 得到SyndFeed对象，即得到Rss源里的所有信息     
			SyndFeed feed = input.build(reader);  
			// 得到Rss新闻中子项列表     
            entries = feed.getEntries();
            
            //循环得到每个子项信息
            for (int i = 0; i < entries.size(); i++) {
            	SyndEntry entry = (SyndEntry) entries.get(i);
            	
               	System.out.println(entries.indexOf(entry));
            	
            	// 标题、连接地址、标题简介、时间是一个Rss源项最基本的组成部分     
                System.out.println("标题：" + entry.getTitle());  
                System.out.println("连接地址：" + entry.getLink());  
                SyndContent description = entry.getDescription();  
                System.out.println("标题简介：" + description.getValue());  
                System.out.println("发布时间：" + entry.getPublishedDate());  
                System.out.println("更新时间： " + entry.getUpdatedDate());

                // 以下是Rss源可先的几个部分     
                System.out.println("标题的作者：" + entry.getAuthor()); 
                
                // 此标题（目录）所属的范畴     
                List categoryList = entry.getCategories();  
                if (categoryList != null) {  
                    for (int m = 0; m < categoryList.size(); m++) {  
                        SyndCategory category = (SyndCategory) categoryList.get(m);  
                        System.out.println("此标题所属的范畴：" + category.getName());  
                    }
                }
                
                // 得到流媒体播放文件的信息列表     
                List enclosureList = entry.getEnclosures();  
                if (enclosureList != null) {
                    for (int n = 0; n < enclosureList.size(); n++) {  
                        SyndEnclosure enclosure = (SyndEnclosure) enclosureList.get(n);  
                        System.out.println("流媒体播放文件：" + entry.getEnclosures());  
                    }  
                }
                
                System.out.println();
			}
            
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entries;
		
	}
	
	public static void main(String[] args) {
		GetRSS test = new GetRSS();  
        test.parseRss(); 
	}
	
}
