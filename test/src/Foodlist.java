


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Foodlist {
	private scraper s;
	private scraper s2;
	private scraper s3;
	private scraper s4;
	public Foodlist() throws IOException {
		s=new scraper("https://ifoodie.tw/explore/list?poi=%E6%94%BF%E5%A4%A7");
		s2=new scraper("https://ifoodie.tw/explore/list?poi=%E6%94%BF%E5%A4%A7&page=2");
		s3=new scraper("https://ifoodie.tw/explore/list?poi=%E6%94%BF%E5%A4%A7&page=3");
		s4=new scraper("https://ifoodie.tw/explore/list?poi=%E6%94%BF%E5%A4%A7&page=4");	
	}
	public ArrayList<Node> GetAllNodes(){
		ArrayList<Node>sn=s.GetNodes();
		ArrayList<Node>s2n=s2.GetNodes();
		ArrayList<Node>s3n=s3.GetNodes();
		ArrayList<Node>s4n=s4.GetNodes();
		for(int i=0;i<s2n.size();i++) {
			sn.add(s2n.get(i));
		}
		for(int i=0;i<s3n.size();i++) {
			sn.add(s3n.get(i));
		}
		for(int i=0;i<s4n.size();i++) {
			sn.add(s4n.get(i));
		}
		return sn;
	}
	public void printNodes() throws Exception {
		ArrayList<Node>n=GetAllNodes();
		for(int i=0;i<n.size();i++) {
			System.out.println("Name:"+n.get(i).GetName()+",  Time:"+n.get(i).GetTime()+",  Price:"+n.get(i).GetPrice()+",  Address:"+n.get(i).GetAddress()+",  img:"+n.get(i).Geturl());
			//downloadPhotos(n.get(i).GetName(),n.get(i).GetName(), n.get(i).Geturl());
		}
	}
	  public void downloadPhotos(String USERID, String OID, String urlString) throws Exception {
	       
	       URL url = new URL(urlString);                      
	       URLConnection con = url.openConnection();          
	       InputStream is = con.getInputStream();            
	       byte[] bs = new byte[1024];                        
	       int len;                                           
	       String downloadDir = "C:\\Users\\Vivi\\git\\repository\\test\\src\\image";
	       //String downloadDir = "/Users/changhungchao/Desktop/Java/107-2/Explorer/bin/image";
	       File downloadFilePath = new File(downloadDir);
	       if(downloadFilePath.exists() == false)              
	       	 downloadFilePath.mkdirs();
	       String FILENAME = downloadDir+"\\"+OID+".jpg";      
	       //String FILENAME = downloadDir+"/"+OID+".jpg";
	       OutputStream os = new FileOutputStream(FILENAME);  
	       while ((len = is.read(bs)) != -1) {
	         os.write(bs, 0, len);
	       }
	                                                          
	       os.close();
	       is.close();
	   }

}
