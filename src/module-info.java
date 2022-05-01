module Web_Browser {
	requires javafx.controls;
	
	requires javafx.fxml;
	requires java.sql;
	requires javafx.web;
	requires java.desktop;
	requires javafx.graphics;
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens Home to javafx.graphics, javafx.fxml;
	opens Search to javafx.graphics,javafx.fxml;
	opens login to javafx.graphics,javafx.fxml;
	opens Test to javafx.graphics,javafx.fxml;
	opens Test_Admin to javafx.graphics,javafx.fxml;
	opens Test_Student to javafx.graphics,javafx.fxml;
}
