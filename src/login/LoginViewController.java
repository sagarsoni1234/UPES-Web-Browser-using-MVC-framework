package login;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtUSER;
    public static String sap;

    @FXML
    private TextField txtPASS;

    @FXML
    void DoExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void Login(ActionEvent event) {
    	 java.sql.Connection con;
		 con=MySqlConnector.getConnection();
		 java.sql.PreparedStatement pst;

    	try {

			pst=con.prepareStatement(" select * from login where username=?");
			pst.setString(1,txtUSER.getText());
			sap=txtUSER.getText();
			ResultSet res=pst.executeQuery();
			 boolean count=false;
			 while(res.next()) {
				 count=true;
				 String PASS=res.getString("password");
				 System.out.println("user pass: "+txtPASS.getText() +" and correct pass is :"+ PASS);
				 if(PASS.equals(txtPASS.getText())) {
				 System.out.println("LOGIN SUCCESSFUL");
				 javafx.scene.Parent root=FXMLLoader.load(getClass().getResource("/Home/HomeView.fxml")); 
					//OR
					//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
					javafx.scene.Scene scene = new javafx.scene.Scene(root);
					javafx.stage.Stage stage=new javafx.stage.Stage();
					stage.setScene(scene);
					stage.show();
				 }
				 else {
					 System.out.println("Incorrect credientials\n");
					 showMsg("Incorrect details");
				 }
				 
			//pst.executeUpdate();
			showMsg("Saved!");
		}
    	}
			 catch (Exception e) {
			e.printStackTrace();
		}
    
    }
    void showMsg(String msg) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Ant Colony Algo Says:");
    	alert.setHeaderText("Result Updated");
    	alert.setContentText(msg);
    	alert.showAndWait();
    }
    Connection con;
    @FXML
    void initialize() {
        assert txtUSER != null : "fx:id=\"txtUSER\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert txtPASS != null : "fx:id=\"txtPASS\" was not injected: check your FXML file 'LoginView.fxml'.";
        con=MySqlConnector.getConnection();
    }
}
