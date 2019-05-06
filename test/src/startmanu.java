

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class startmanu {
public static void main(String[]args) {
	JFrame mainapp=new MainApp();
    
    mainapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon myImageIcon = new ImageIcon("C:\\Users\\Vivi\\Desktop\\駱駝.PNG");
    mainapp.setIconImage(myImageIcon.getImage() );
    mainapp.setTitle("政大沙漠拓荒器");
    mainapp.setVisible(true);  
}
}
