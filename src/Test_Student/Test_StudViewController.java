package Test_Student;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import login.LoginViewController;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import login.MySqlConnector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class Test_StudViewController {
	public static  WebEngine webEngine= null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView webView;

    @FXML
    private ProgressBar PROGRESSBAR;

    @FXML
    private ComboBox<String> COMBOBOX1;

    @FXML
    private TextField timer;

   public static long timereceiver=0;
  
    @FXML
    private ComboBox<String> COMBOBOX3;

    @FXML
    private ComboBox<String> COMBOBOX2;

    @FXML
    private ComboBox<String> COMBOBOX4;

    @FXML
    private ComboBox<String> COMBOBOX5;

    @FXML
    private ComboBox<String> COMBOBOX6;

    @FXML
    private ComboBox<String> COMBOBOX7;

    @FXML
    private ComboBox<String> COMBOBOX8;

    @FXML
    void END(ActionEvent event) {
      showMsg2("Test ends!");
      System.exit(0);
    }
    

    @SuppressWarnings("unused")
	@FXML
    void Start(ActionEvent event) throws InterruptedException {
    	java.sql.Connection con;
		 con=MySqlConnector.getConnection();
		 java.sql.PreparedStatement pst;
		 
		 try {
				pst=con.prepareStatement("select * from getlink where NUMBER=?");
				pst.setInt(1,1);
				ResultSet rset=pst.executeQuery();
				boolean count=false;
				while(rset.next()) {
					count=true;
					String link1=rset.getString("LINK");	
					System.out.println(link1);
					
					webEngine.load(link1);
					//rset.close();
					showMsg("TEST STarted|");	
					
					timer.setText(""+timereceiver);
					System.out.println(timereceiver);
				}
				
				if(count==false) {
					System.out.println("INVALID");
					showMsg("Data not Fenched!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	 
    }
    @FXML
    void timer(ActionEvent event) {
    	//start test in any starting hour (advisible)
    	Calendar now = Calendar.getInstance();
        System.out.println(now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE));
    		timer.setText(""+now.get(Calendar.MINUTE));
    	
    }
    static float increase=(float) 0.0;
    @FXML
    void COMBOCLICK1(MouseEvent event) {
    	increase=(float) (increase+0.125);
       PROGRESSBAR.setProgress(increase);
    }

    @FXML
    void COMBOCLICK2(MouseEvent event) {
    	increase=(float) (increase+0.125);
    	 PROGRESSBAR.setProgress(increase);
    }

    @FXML
    void COMBOCLICK3(MouseEvent event) {
    	increase=(float) (increase+0.125);
    	 PROGRESSBAR.setProgress(increase);
    }

    @FXML
    void COMBOCLICK4(MouseEvent event) {
    	increase=(float) (increase+0.125);
   	 PROGRESSBAR.setProgress(increase);
    }

    @FXML
    void COMBOCLICK5(MouseEvent event) {
    	increase=(float) (increase+0.125);
   	 PROGRESSBAR.setProgress(increase);
    }

    @FXML
    void COMBOCLICK6(MouseEvent event) {
    	increase=(float) (increase+0.125);
   	 PROGRESSBAR.setProgress(increase);
    }

    @FXML
    void COMBOCLICK7(MouseEvent event) {
    	increase=(float) (increase+0.125);
   	 PROGRESSBAR.setProgress(increase);
    }

    @FXML
    void COMBOCLICK8(MouseEvent event) {
    	increase=(float) (increase+0.125);
   	 PROGRESSBAR.setProgress(increase);
    }

   

  
    void showMsg(String msg) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Session Started:");
    	alert.setHeaderText("Timer started");
    	alert.setContentText(msg);
    	alert.showAndWait();
    }
    void showMsg2(String msg) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Are you sure you want to exit? ");
    	alert.setHeaderText("Test will be ended");
    	alert.setContentText(msg);
    	alert.showAndWait();
    }

    @FXML
    void Submit(ActionEvent event) {
    	login.LoginViewController OBJ=new login.LoginViewController();
    	String sap=OBJ.sap;
    	System.out.println(sap);
    	java.sql.Connection con;
		 con=MySqlConnector.getConnection();
    		 java.sql.PreparedStatement pst;
    		 try {
    			 pst=con.prepareStatement("insert into result values(?,?,?,?,?,?,?,?,?)");
    			 pst.setString(1, sap);
    			 pst.setString(2, COMBOBOX1.getEditor().getText());
    			 pst.setString(3, COMBOBOX2.getEditor().getText());
    			 pst.setString(4, COMBOBOX3.getEditor().getText());
    			 pst.setString(5, COMBOBOX4.getEditor().getText());
    			 pst.setString(6, COMBOBOX5.getEditor().getText());
    			 pst.setString(7, COMBOBOX6.getEditor().getText());
    			 pst.setString(8, COMBOBOX7.getEditor().getText());
    			 pst.setString(9, COMBOBOX8.getEditor().getText());
    			 pst.execute();
    			 System.out.println("RESULT SUBMITTED!");
    			 showMsg3("ALL QUESTIONS ARE SAVED!");
    			 
    			 
    			 
    		 }
    		 catch(Exception e) {
    			 e.printStackTrace();
    		 }
				
    }
    void showMsg3(String msg) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Are you sure you want to submit? ");
    	alert.setHeaderText("Test will be ended!");
    	alert.setContentText(msg);
    	alert.showAndWait();
    }
    Connection con;
    @FXML
    void initialize() {
    	con=MySqlConnector.getConnection();
        assert webView != null : "fx:id=\"webView\" was not injected: check your FXML file 'Test_StudView.fxml'.";
        assert PROGRESSBAR != null : "fx:id=\"PROGRESSBAR\" was not injected: check your FXML file 'Test_StudView.fxml'.";
        assert COMBOBOX1 != null : "fx:id=\"COMBOBOX1\" was not injected: check your FXML file 'Test_StudView.fxml'.";
        assert timer != null : "fx:id=\"timer\" was not injected: check your FXML file 'Test_StudView.fxml'.";
        assert COMBOBOX2 != null : "fx:id=\"COMBOBOX2\" was not injected: check your FXML file 'Test_StudView.fxml'.";
        webEngine =webView.getEngine();
        ArrayList<String> ary=new ArrayList<String>(Arrays.asList("A","B","C","D"));
    	COMBOBOX1.getItems().addAll(ary);
    	COMBOBOX2.getItems().addAll(ary);
    	COMBOBOX3.getItems().addAll(ary);
    	COMBOBOX4.getItems().addAll(ary);
    	COMBOBOX5.getItems().addAll(ary);
    	COMBOBOX6.getItems().addAll(ary);
    	COMBOBOX7.getItems().addAll(ary);
    	COMBOBOX8.getItems().addAll(ary);
    	
    }
}

	
	
