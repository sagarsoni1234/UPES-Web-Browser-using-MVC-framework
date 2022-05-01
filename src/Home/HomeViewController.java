package Home;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import Search.SearchViewController;

public class HomeViewController {
	public static String suffix=null;
	WebEngine webEngine1= null;
	WebEngine webEngine2= null;
	WebEngine webEngine3= null;
	WebEngine webEngine4= null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView WEB3;

    @FXML
    private WebView WEB4;

    @FXML
    private WebView WEB1;


    @FXML
    private WebView WEB2;

    @FXML
    private TextField getText;
    
    @FXML
    void Search(ActionEvent event) throws IOException {
    	suffix=getText.getText();
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Search/SearchView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
		//page opened-->control started
    	@SuppressWarnings("unused")
		SearchViewController obj=new SearchViewController();
    	String preffix="https://www.google.com/search?q=";
    	String getter=preffix.concat(suffix);
    	SearchViewController.receiver(getter);
    }
    @FXML
    void BB(MouseEvent event) {
    	webEngine1.load("https://learn.upes.ac.in/");
    }

    @FXML
    void DoExit(ActionEvent event) {
    	System.exit(0);
    }


    @FXML
    void LIB(MouseEvent event) {
    	webEngine3.load("http://library.ddn.upes.ac.in:8081/upeslib/");

    }

  
    @FXML
    void SAP(MouseEvent event) {
    	webEngine2.load("https://myupes.upes.ac.in/Login");
    }

    @FXML
    void TEST(MouseEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Test/TestView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    	
    }
    @FXML
    void MAX1(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Search/SearchView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
		SearchViewController obj=new SearchViewController();
    	obj.receiver("https://learn.upes.ac.in/");//FINAL ENGINE TO BE SET
    }

    @FXML
    void MAX2(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Search/SearchView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    	SearchViewController obj=new SearchViewController();
    	obj.receiver("https://myupes.upes.ac.in/Login");//FINAL ENGINE TO BE SET
    }

    @FXML
    void MAX3(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Search/SearchView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    	SearchViewController obj=new SearchViewController();
    	obj.receiver("http://library.ddn.upes.ac.in:8081/upeslib/");//FINAL ENGINE TO BE SET
    	
    }

    @FXML
    void MAX4(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Search/SearchView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
		
    	SearchViewController obj=new SearchViewController();
    	obj.receiver("https://www.upes.ac.in/");//FINAL ENGINE TO BE SET
    }
    @FXML
    void WEB(MouseEvent event) {
    	webEngine4.load("https://www.upes.ac.in/");
    }
    @FXML
    void GOback(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/login/LoginView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    }
   

    @FXML
    void initialize() {
        assert WEB3 != null : "fx:id=\"WEB3\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert WEB4 != null : "fx:id=\"WEB4\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert WEB1 != null : "fx:id=\"WEB1\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert WEB2 != null : "fx:id=\"WEB2\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert getText != null : "fx:id=\"getText\" was not injected: check your FXML file 'HomeView.fxml'.";
       
        webEngine1 =WEB1.getEngine();
        webEngine2 =WEB2.getEngine();
        webEngine3 =WEB3.getEngine();
        webEngine4 =WEB4.getEngine();
    	
    }
}
