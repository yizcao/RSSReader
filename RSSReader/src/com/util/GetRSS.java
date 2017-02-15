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
			System.out.println("RssԴ�ı����ʽΪ��" + reader.getEncoding()); 
			
			SyndFeedInput input = new SyndFeedInput();  
	        // �õ�SyndFeed���󣬼��õ�RssԴ���������Ϣ     
			SyndFeed feed = input.build(reader);  
			// �õ�Rss�����������б�     
            entries = feed.getEntries();
            
            //ѭ���õ�ÿ��������Ϣ
            for (int i = 0; i < entries.size(); i++) {
            	SyndEntry entry = (SyndEntry) entries.get(i);
            	
               	System.out.println(entries.indexOf(entry));
            	
            	// ���⡢���ӵ�ַ�������顢ʱ����һ��RssԴ�����������ɲ���     
                System.out.println("���⣺" + entry.getTitle());  
                System.out.println("���ӵ�ַ��" + entry.getLink());  
                SyndContent description = entry.getDescription();  
                System.out.println("�����飺" + description.getValue());  
                System.out.println("����ʱ�䣺" + entry.getPublishedDate());  
                System.out.println("����ʱ�䣺 " + entry.getUpdatedDate());

                // ������RssԴ���ȵļ�������     
                System.out.println("��������ߣ�" + entry.getAuthor()); 
                
                // �˱��⣨Ŀ¼�������ķ���     
                List categoryList = entry.getCategories();  
                if (categoryList != null) {  
                    for (int m = 0; m < categoryList.size(); m++) {  
                        SyndCategory category = (SyndCategory) categoryList.get(m);  
                        System.out.println("�˱��������ķ��룺" + category.getName());  
                    }
                }
                
                // �õ���ý�岥���ļ�����Ϣ�б�     
                List enclosureList = entry.getEnclosures();  
                if (enclosureList != null) {
                    for (int n = 0; n < enclosureList.size(); n++) {  
                        SyndEnclosure enclosure = (SyndEnclosure) enclosureList.get(n);  
                        System.out.println("��ý�岥���ļ���" + entry.getEnclosures());  
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
