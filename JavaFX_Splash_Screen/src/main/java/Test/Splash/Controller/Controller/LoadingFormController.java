package Test.Splash.Controller.Controller;

import Test.Splash.Controller.Service.LoadingTask;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoadingFormController {

    @FXML
    private AnchorPane AncFrontBar;

    @FXML
    private Label LblNumPrecentage;

    @FXML
    private Rectangle ReqBackBar;




    public void initialize(){
           LoadingTask();
    }





    public  void LoadingTask(){

        LoadingTask task = new LoadingTask();
        task.progressProperty().addListener((ob,oldValue, newValue) ->{
            String format = String.format("%.0f", newValue.doubleValue() * 100);

            LblNumPrecentage.setText(format+ "%");
            AncFrontBar.setPrefWidth(ReqBackBar.getWidth()*newValue.doubleValue());

            if (newValue.doubleValue()==1.0) {
                new Alert(Alert.AlertType.CONFIRMATION,"SucsessFull!").show();
            }
        });
        new Thread(task).start();
    }

}
