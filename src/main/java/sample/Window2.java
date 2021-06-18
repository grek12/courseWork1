package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Window2 {

    public Window2() throws Exception {//метод открытия второго окна
        Parent root = FXMLLoader.load(getClass().getResource("/sample2.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Риелторское агентство");
        stage.setScene(new Scene(root, 750, 450));
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

}
