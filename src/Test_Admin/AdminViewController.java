
package Test_Admin;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import login.MySqlConnector;

public class AdminViewController {
	public static  WebEngine webEngine= null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView webView;

    @FXML
    private TextField txtLink;

    @FXML
    void DoExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void GOback(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Test/TestView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void LinkReceiver(ActionEvent event) {
    	java.sql.Connection con;
		 con=MySqlConnector.getConnection();
		 java.sql.PreparedStatement pst;
    	
    	try {
			pst=con.prepareStatement("insert into getlink values(?)");
			pst.setString(1, txtLink.getText());
			pst.executeUpdate();
			showMsg("Saved!");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    void showMsg(String msg) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Admin Panel Says:");
    	alert.setHeaderText("Received Link Successfully!");
    	alert.setContentText(msg);
    	alert.showAndWait();
    }
    @FXML
    void server(ActionEvent event) {
    	webEngine.load("http://localhost/phpmyadmin/index.php?route=/sql&db=webbrowser&table=getlink&pos=0");
    	//webEngine.load("https://i1.sndcdn.com/artworks-gLucQSUoEiIwcP0u-HbkFXA-t500x500.jpgw");
    }

    @FXML
    void OpenADMIN(ActionEvent event) {
    	webEngine.load("https://s3.console.aws.amazon.com/");//S3 link
    }
    Connection con;
    @FXML
    void initialize() {
        assert webView != null : "fx:id=\"webView\" was not injected: check your FXML file 'AdminView.fxml'.";
        assert txtLink != null : "fx:id=\"txtLink\" was not injected: check your FXML file 'AdminView.fxml'.";
        con=MySqlConnector.getConnection();
        webEngine=webView.getEngine();
    }
}
