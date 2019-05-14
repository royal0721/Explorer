

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class scraper {
	private ArrayList<Node>ar;
	private int c;
	private String url;
	public scraper(String url) throws IOException {
		ar=new ArrayList<Node>();
		this.c=0;
		this.url=url;
		scraper();
	}
	public void scraper() throws IOException {
	
	//https://ifoodie.tw/explore/list?poi=%E6%94%BF%E5%A4%A7&page=2
	Document doc = Jsoup.connect(url).get();

	Elements els = doc.getElementsByClass("jsx-1102741263");

		
	    for(Element data :els.select("img[alt]")){
	    	
	    String url1 = data.absUrl("src");

	    ar.add(new Node(data.attr("alt"),url1));
	    }
	
	Elements els1 = doc.select("div.jsx-1102741263.info");

	for(Element data :els1){		
		
			ar.get(c).SetTime(data.text());
			c=c+1;
		}
	c=0;
	Elements els2 = doc.select("div.jsx-1102741263.avg-price");
	
	for(Element data :els2){	
			
			ar.get(c).SetPrice(data.text());
			c=c+1;
		}
	c=0;
	Elements els3 = doc.select("div.jsx-1102741263.address-row");
	
	for(Element data :els3){
			
			ar.get(c).SetAddress(data.text());
			c=c+1;			
		}
}
	public ArrayList<Node> GetNodes(){
		return ar;
	}
}