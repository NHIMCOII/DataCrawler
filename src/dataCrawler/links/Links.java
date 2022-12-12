package dataCrawler.links;

import java.io.IOException;
import java.util.ArrayList;

abstract class Links {
// ============================= Properties ==================================
	protected ArrayList<String> links;

// ============================= Methods ==================================	
	public Links() {
		links = new ArrayList<String>();
	}
	public ArrayList<String> getLinks() {
		return links;
	}

	public abstract ArrayList<String> setLinks(String url, String sub) throws IOException;

	public void printList(ArrayList<String> list) {
		for(String str : list) {
			System.out.println(str);
		}
	}	
}