
import java.sql.*;
import java.util.ArrayList;
import java.io.File;
import java.io.OutputStream;

public class sqliteloading {
	private Foodlist fl;
	private PreparedStatement ps;
	private ArrayList<Node> nodes;
	private ArrayList<String> str;
	private Connection c;
	private Statement stmt;
	public sqliteloading() throws Exception {
		Class.forName("org.sqlite.JDBC");
	    c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    fl=new Foodlist();
		nodes=fl.GetAllNodes();
		str=new ArrayList<String>();		
		createTable();
		setTable();
		System.out.println();
	}	
	public void createTable() throws Exception {
		try {		      
		      stmt = c.createStatement();
		      String sql = "DROP TABLE IF EXISTS RESTAURANT ;CREATE TABLE RESTAURANT "+
		    		  	   "(NAME    VARCHAR(30) PRIMARY KEY, "+
		    		  	   " TYPE    VARCHAR(15),"+
		    		  	   " TIME    VARCHAR(30), "+		    		  	   
		    		  	   " PRICE   VARCHAR(20), "+
		    		  	   " ADDRESS VARCHAR(50), "+
		    		  	   " IMG     VARCHAR(50), "+
		    		  	   " MAPIMG  VARCHAR(50));";
		      stmt.executeUpdate(sql);
		      stmt.close();		      		      
		 }	  catch ( Exception e ) {
			  e.printStackTrace();		 
		    }		   		    
	}
	public void setTable() throws Exception {
		try{
			c.setAutoCommit(false);
			for(int i=0;i<nodes.size();i++) {
				String sql = "INSERT INTO RESTAURANT (NAME,TYPE,TIME,PRICE,ADDRESS,IMG,MAPIMG) " +
	              "VALUES (?, ?, ?, ?, ?, ?, ?)"; 
				ps=c.prepareStatement(sql);
				ps.setString(1, nodes.get(i).GetName());
				ps.setString(2, null);
				ps.setString(3, nodes.get(i).GetTime());
				ps.setString(4, nodes.get(i).GetPrice());
				ps.setString(5, nodes.get(i).GetAddress());					
				ps.setString(6, "src\\image\\"+nodes.get(i).GetName()+".jpg");
				ps.setString(7, "src\\image\\Map_"+nodes.get(i).GetName()+".png");
				ps.executeUpdate();
				c.commit();				
			}		      
			ps.close();	
			updateType();
		}	catch ( Exception e ) {
			e.printStackTrace();
		 }
	}
	public ArrayList<String> select(String n) throws Exception{
	    try {
	    	str.clear();
	    	String sql =  "SELECT * FROM RESTAURANT WHERE TYPE LIKE ? OR NAME LIKE ?";		    	    			    			    			
	    	ps = c.prepareStatement(sql);
	    	ps.setString(1, "%"+n+"%");
	    	ps.setString(2, "%"+n+"%");
	    	ResultSet rs = ps.executeQuery();
	    	while ( rs.next() ) {	    	  
	    		String name = rs.getString("name");
	    		String type = rs.getString("type");
	    		String time = rs.getString("time");
	    		String price = rs.getString("price");
	    		if(price==null) {price="無";}
	    		String address = rs.getString("address");
	    		String img = rs.getString("img");		    				
	    		str.add("店家名稱: "+name+"\n種類: "+type+"\n營業時間: "+time+"\n價位: "+price+"\n地址: "+address+"\n");
	    		
	    		str.add(img);
	    	}
	        rs.close();
	        stmt.close();		    	  	      
	     } catch ( Exception e ) {
	      e.printStackTrace();	      
	    }return str;	    
	}
	
	public ArrayList<String> selectName(String n) throws Exception{
	    try {
	    	str.clear();
	    	String sql =  "SELECT * FROM RESTAURANT WHERE TYPE LIKE ? OR NAME LIKE ?";		    	    			    			    			
	    	ps = c.prepareStatement(sql);
	    	ps.setString(1, "%"+n+"%");
	    	ps.setString(2, "%"+n+"%");
	    	ResultSet rs = ps.executeQuery();
	    	while ( rs.next() ) {	    	  
	    		String name = rs.getString("name");
	    		String type = rs.getString("type");
	    		String time = rs.getString("time");
	    		String price = rs.getString("price");
	    		if(price==null) {price="無";}
	    		String address = rs.getString("address");
	    		String img = rs.getString("img");		    				
	    		str.add(name);
	    	}
	        rs.close();
	        stmt.close();		    	  	      
	     } catch ( Exception e ) {
	      e.printStackTrace();	      
	    }return str;	    
	}
	
	public void insert(String n,String tp,String t,String p,String a) throws Exception{
		try{
			String sql = "INSERT INTO RESTAURANT (NAME,TYPE,TIME,PRICE,ADDRESS,IMG,MAPIMG) " +		
	              "VALUES (?, ?, ?, ?, ? ,?, ?)";         
			ps = c.prepareStatement(sql);
			ps.setString(1, n);
			ps.setString(2, tp);
			ps.setString(3, t);
			ps.setString(4, p);
			ps.setString(5, a);					
			ps.setString(6, "src\\image\\"+n+".jpg");
			ps.setString(7, "src\\image\\Map_"+n+".png");
			ps.executeUpdate();		
			ps.close();						
		}	catch ( Exception e ) {
			e.printStackTrace();
		}
    }
	public void update(String n,String tp,String t,String p,String a) throws Exception{
        try{
        	String sql = "UPDATE RESTAURANT SET TYPE=?,TIME=?,PRICE=?,ADDRESS=?,IMG=? WHERE NAME = ?,MAPIMG=?";               
        	ps = c.prepareStatement(sql);               
        	ps.setString(1, tp);
        	ps.setString(2, t);
        	ps.setString(3, p);
        	ps.setString(4, a);					
        	ps.setString(5, "src\\image\\"+n+".jpg");
        	ps.setString(6, n);
        	ps.setString(7, "src\\image\\Map_"+n+".png");
        	ps.executeUpdate();
        	ps.close();
        }	catch ( Exception e ) {
    		e.printStackTrace();
   	 	}
    }
	public void delete(String n) throws Exception{		
		String sql = "DELETE FROM RESTAURANT WHERE NAME = ?";       		
		ps = c.prepareStatement(sql);       
		ps.setString(1, n);
		ps.executeUpdate();
		ps.close();       
    }		 	
	public void updateType() throws Exception{
		try{
			stmt=c.createStatement();
        	String sql = "UPDATE RESTAURANT SET TYPE='下午茶'  WHERE NAME ='Ruins Coffee Roasters'";               
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='西式,德式'  WHERE NAME ='舒曼六號 Schumann''s Bistro No. 6'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='中式'  WHERE NAME ='江記水盆羊肉'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='下午茶'  WHERE NAME ='貓茶町'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='西式,義式'  WHERE NAME ='米塔義式廚房'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='西式,德式,義式'  WHERE NAME ='Lecker里克德義廚房'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='日式'  WHERE NAME ='金鮨日式料理'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='下午茶'  WHERE NAME ='小公寓'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='日式'  WHERE NAME ='松町和風小舖'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='西式,義式,早午餐'  WHERE NAME ='鄰居家動手工作室NEXT DOOR CAFE'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='中式'  WHERE NAME ='滇味廚房'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='早午餐'  WHERE NAME ='TAIGA 針葉林'";
  			stmt.executeUpdate(sql);
  			sql = "UPDATE RESTAURANT SET TYPE='日式'  WHERE NAME ='樂山食堂'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='西式,美式'  WHERE NAME ='Juicy Bun Burger 就是棒 美式餐廳'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='中式'  WHERE NAME ='四川飯館'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='冰品,甜點'  WHERE NAME ='逢玉冰果室'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='早午餐,早餐'  WHERE NAME ='三一活力早餐 (原三三早餐二店)'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='冰品'  WHERE NAME ='顧人願冰館'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='日式'  WHERE NAME ='東京小城'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='韓式'  WHERE NAME ='韓大佬韓式精緻料理'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='早午餐,早餐'  WHERE NAME ='Arty Burger(政大店)'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='飲料'  WHERE NAME ='龍角咖啡Dragon horn coffee'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='冰品,甜點'  WHERE NAME ='明池豆花'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='冰品,甜點'  WHERE NAME ='磨豆花棧'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='日式'  WHERE NAME ='加賀日式料理'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='葉記鴨肉飯'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='泰式,中式,南洋料理'  WHERE NAME ='小曼谷滇泰料理'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='西式'  WHERE NAME ='李氏兄弟44號餐酒館'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='甜點'  WHERE NAME ='揉道Nubun不老麵糰'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='早餐'  WHERE NAME ='古早味蛋餅飯糰'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='麵疙瘩‧烤肉飯'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='敏忠餐廳'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='京華小館'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='下午茶'  WHERE NAME ='道南館│自家烘焙咖啡'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='越式,南洋料理'  WHERE NAME ='越南大食館'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='中式'  WHERE NAME ='潮飯'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='韓式'  WHERE NAME ='阿里郎韓國小吃'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='早午餐,早餐'  WHERE NAME ='Go! Cafe 早午餐'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='飲料'  WHERE NAME ='No. 8+9 一起冰沙吧'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='永康街左撇子'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='港式'  WHERE NAME ='陽城燒臘店'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='早餐'  WHERE NAME ='木柵水煎包'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='私房麵'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='冰品,甜點'  WHERE NAME ='廟邊阿珠芋圓'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='中式,泰式,南洋料理' WHERE NAME ='呷麵騎士'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='港式,中式'  WHERE NAME ='巴東蜀味'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='MY麵屋'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='早餐'  WHERE NAME ='溫家包子舖'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='日式'  WHERE NAME ='鬼匠拉麵-木柵店'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式,早餐'  WHERE NAME ='龐家肉羹'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='中式'  WHERE NAME ='粵海熱炒100'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='飲料'  WHERE NAME ='咖啡大亨'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='永旺水餃'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='西式,義式'  WHERE NAME ='Trattoria al Sole 豔陽下義大利小餐館'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式,早餐'  WHERE NAME ='阿葉米粉湯'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='悅來牛肉麵'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='三媽臭臭鍋（新光店）'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='中式,台式'  WHERE NAME ='飽飽食府'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='馬來西亞菜,南洋料理'  WHERE NAME ='波波恰恰大馬風味餐'";
        	stmt.executeUpdate(sql);
        	sql = "UPDATE RESTAURANT SET TYPE='台式'  WHERE NAME ='佳味自助餐'";
        	stmt.executeUpdate(sql);   
        	stmt.close();
        }	catch ( Exception e ) {
    		e.printStackTrace();
   	 	}
	}
	public void closeC() throws Exception {
		 c.close();
	 }	
}
