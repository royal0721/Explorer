

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class startmanu {
public static void main(String[] args) throws Exception {    
	sqliteloading sql=new sqliteloading();
    ArrayList<String> s=new ArrayList<String>();
	s=sql.select("");
    for(int i=0;i<s.size();i=i+2) {
	System.out.println(s.get(i));
	File file=new File(s.get(i+1));
    }
    
	JFrame mainapp=new MainPanel();
    
    mainapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon myImageIcon = new ImageIcon("src\\image\\駱駝.PNG");
    mainapp.setIconImage(myImageIcon.getImage() );
    mainapp.setTitle("政大沙漠拓荒器");
    mainapp.pack();
    mainapp.setVisible(true); 
	
    sql.closeC();
}

}
