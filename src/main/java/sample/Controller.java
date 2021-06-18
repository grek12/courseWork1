package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class Controller {
    public void openWIn() throws Exception {

        Window2 window2 = new Window2();

    }

    public void helpBut(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Информация");
        alert.setHeaderText("Справка о программе");
        alert.setContentText("\nОбъектная-программа «Риелторское агентство».\n" +
                "Данная программа хранит и обрабатывает данные о договорах купли/продажи недвижимости в риелторском агентстве. Учет организуется за счет ведения списка риэлторов с указанием фамилии и номера мобильного телефона. Для каждого риелтора создается отдельный список договоров с указанием фамилии клиента и суммы сделки.\n" +
                "Для объединения риелторов используется структура данных в виде неупорядоченного списка на основе массива. Для объединения договоров каждого риэлтора используется структура данных в виде адресной очереди без заголовочного элемента.\n" +
                "Выполнил: Долгов Александр Сергеевич.");

        alert.showAndWait();
    }

    public void exitBut(ActionEvent event) {
        System.exit(1);
    }
}