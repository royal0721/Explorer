



import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.OsmMercator;


public class NCCUPanel extends JPanel {
static JMapViewer map;
    private static final JPanel cards = new JPanel();
    private final String name="文山區";
    private Coordinate coordinate;

    public NCCUPanel( ) {
    	coordinate=new Coordinate(24.987594,121.576049 );
        map= new JMapViewer();
        /*按右鍵可以拖曳map,需要等待map下載時間*/
        map.setDisplayPosition(coordinate, 15);
        this.add(map);
        plotmaker();
   
    }
    
   public void plotmaker() {
	   /*plot your own location*/
	   /*use the sql to replace this method*/
	   Coordinate coordinate1=new Coordinate(24.9907279,121.5710437 );
	   map.addMapMarker(new MapMarkerDot("Ruins Coffee Roasters",coordinate1));
	   Coordinate coordinate2=new Coordinate(24.9878222,121.5759382);
	   map.addMapMarker(new MapMarkerDot("舒曼六號",coordinate2));
	   Coordinate coordinate3=new Coordinate(24.9888055,121.5745716);
	   map.addMapMarker(new MapMarkerDot("江記水盆羊肉",coordinate3));
	   Coordinate coordinate4=new Coordinate(24.9856652,121.5676046);
	   map.addMapMarker(new MapMarkerDot("貓茶町",coordinate4));	   
	   Coordinate coordinate5=new Coordinate(24.987744,121.575903);
	   map.addMapMarker(new MapMarkerDot("米塔義式廚房",coordinate5));	
	   Coordinate coordinate6=new Coordinate(24.9889073,121.5736643);
	   map.addMapMarker(new MapMarkerDot("Lecker里克德義廚房",coordinate6));	 
	   Coordinate coordinate7=new Coordinate(24.987073,121.5785784);
	   map.addMapMarker(new MapMarkerDot("金鮨日式料理",coordinate7));	 	   
	 

	 
   }
 

    public JPanel create() {
        JPanel jp=new NCCUPanel();
        return jp;
    }
}
