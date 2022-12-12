package dataCrawler.links;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class President_Links extends HistoricalCharater_Links{
	public President_Links() {
		super();
	}
	
	 /** Collect links from https://vi.wikipedia.org/wiki/Danh_sách_Chủ_tịch_nước_Việt_Nam"		
	 * @param url
	 * @param sub = Domain
	 * @return
	 * @throws IOException
	 */
	@Override
	public ArrayList<String> setLinks(String url, String sub) throws IOException {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		final Document doc = Jsoup.connect(url)
				.ignoreContentType(true)
				.timeout(0)
				.get();
		
		for(Element table: doc.select("table.wikitable")) {
			for(Element link : table.select("tr td:nth-of-type(2) a[href^=/]")) {				
				links.add(sub + link.attr("href"));
			}
		}
		return links;
	}
}
