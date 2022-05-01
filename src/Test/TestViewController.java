package Test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class TestViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void Admin(ActionEvent event) throws IOException   {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Test_Admin/AdminView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void DoExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void Student(ActionEvent event) throws IOException {
    	javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Test_Student/Test_StudView.fxml")); 
		//OR
		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
		javafx.scene.Scene scene = new javafx.scene.Scene(root);
		javafx.stage.Stage stage=new javafx.stage.Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void initialize() {

    }
}
