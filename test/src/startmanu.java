
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bulenkov.darcula.DarculaLaf;
import com.seaglasslookandfeel.SeaGlassLookAndFeel;

public class startmanu {
	public static void main(String[] args) throws Exception {

		try {
			UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
			UIManager.setLookAndFeel(new DarculaLaf());
		}
		
		//UIManager.setLookAndFeel(new SeaGlassLookAndFeel());

		JFrame mainapp = new MainPanel();

		mainapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon myImageIcon = new ImageIcon("src\\image\\駱駝.PNG");
		mainapp.setIconImage(myImageIcon.getImage());
		mainapp.setTitle("政大沙漠拓荒器");
		mainapp.pack();
		mainapp.setVisible(true);

	}

}