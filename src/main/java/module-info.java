module com.example.triangletableview {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.triangletableview to javafx.fxml;
    exports com.example.triangletableview;
}