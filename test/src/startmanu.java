

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
public static void main(String[]args) throws Exception {
    Foodlist fl=new Foodlist();
    fl.printNodes();
	JFrame mainapp=new MainApp();
    
    mainapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon myImageIcon = new ImageIcon("src\\image\\駱駝.PNG");
    mainapp.setIconImage(myImageIcon.getImage() );
    mainapp.setTitle("政大沙漠拓荒器");
    mainapp.setVisible(true);  
}

}