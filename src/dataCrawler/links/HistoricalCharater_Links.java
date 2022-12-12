package dataCrawler.links;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HistoricalCharater_Links extends Links {
	public HistoricalCharater_Links() {
		super();
	}
	
	/**
	 * Collect links from https://nguoikesu.com/nhan-vat?start=0
	 * @param url
	 * @param sub = Domain
	 * @return
	 * @throws IOException
	 */
	@Override
	public ArrayList<String> setLinks(String url, String sub) throws IOException{
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		
		final Document doc = Jsoup.connect(url)
				.ignoreContentType(true)
				.timeout(0)
				.get();

// 		Append info from all pages
//		5 characters each page & 291 pages
		for(int i=0; i < 5*291 ;i+=5) {
			Document subDoc = Jsoup.connect(url)
					.ignoreContentType(true)
					.timeout(0)
					.get();
			url = url.replace(Integer.toString(i), Integer.toString(i+5));
			for(Element x: subDoc.select("h2 a")) {
				links.add(sub + x.attr("href"));
			}
		}
		return links;
	}
}


