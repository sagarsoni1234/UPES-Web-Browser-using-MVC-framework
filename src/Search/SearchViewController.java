package Search;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SearchViewController {
	//public static String str=null;
	public static  WebEngine webEngine= null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public WebView FinalWebEngine;
    public static void receiver(String str) {
    	//receive from home page!
    	
    	try {
			webEngine.load(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void BB(MouseEvent event) {
    	webEngine.load("https://learn.upes.ac.in/");
    }

    @FXML
    void DoExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void GOback(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Home/HomeView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void LIB(MouseEvent event) {
    	webEngine.load("http://library.ddn.upes.ac.in:8081/upeslib/");//FINAL ENGINE TO BE SET

    }

    @FXML
    void SAP(MouseEvent event) {
    	webEngine.load("https://myupes.upes.ac.in/Login");//FINAL ENGINE TO BE SET

    }

    @FXML
    void TEST(MouseEvent event) {

    }

    @FXML
    void WEB(MouseEvent event) {
    	webEngine.load("https://www.upes.ac.in/");//FINAL ENGINE TO BE SET

    }

    @FXML
    void initialize() {
        assert FinalWebEngine != null : "fx:id=\"FinalWebEngine\" was not injected: check your FXML file 'SearchView.fxml'.";
         webEngine=FinalWebEngine.getEngine();
    }
}
