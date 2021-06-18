package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.*;
import java.util.Scanner;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;


public class Controller2 {
    Rieltors rieltors = new Rieltors("Flat");//создание объекта агенства с присвоением имени агентства
    @FXML
    private TextField txtFam;//объявление элемента управления для ввода текста(фамилия риелтора)

    @FXML
    private TextField txtNuM;//объявление элемента управления для ввода текста(номер риелтора)
    @FXML
    private TextField txtClientFam;//объявление элемента управления для ввода текста(фамилия клиента)

    @FXML
    private TextField txtClientPrice;//объявление элемента управления для ввода текста(цена сделки)
    @FXML
    private TableView<Realtor> table1;//объявление таблицы 1(риелторы)

    @FXML
    private TableColumn<Realtor, String> fam;//объявление колонки с данными фамилий риелтора (1-ая таблица)
    @FXML
    private TableColumn<Realtor, Float> SumAll;//объявление колонки с данными сум сделок риелтора (1-ая таблица)
    @FXML
    private TableColumn<Realtor, String> number;//объявление колонки с данными номеров риелтора (1-ая таблица)
    private ObservableList<Realtor> data = FXCollections.observableArrayList();//объявление вспомогательного списка для риелторов
    @FXML
    private TableView<Contracts> table2;//объявление таблицы 2(клиенты)

    @FXML
    private TableColumn<Contracts, String> clinetName;//объявление колонки с данными фамилий клиентов(2-ая таблица)

    @FXML
    private TableColumn<Contracts, Float> clientPrice;//объявление колонки с данными цен сделок(2-ая таблица)
    private ObservableList<Contracts> data2 = FXCollections.observableArrayList();//объявление вспомогательного списка для клиентов
    @FXML
    private Label sumAgentstvo;//строка с суммой сделок агентства
    @FXML

    protected void addTable() {//метод занесения риелторов в таблицу 1
        initData();
        sumAgentstvo.setText("Сумма сделок агентства: "+rieltors.sumAgentstvo());
        fam.setCellValueFactory(new PropertyValueFactory<>("Fam"));
        number.setCellValueFactory(new PropertyValueFactory<>("numberFam"));
        SumAll.setCellValueFactory(new PropertyValueFactory<>("priceSum"));
        table1.setItems(data);
    }//

    @FXML
    protected void addTable2() {//метод занесения клиентов в таблицу 2
        initData2();
        clinetName.setCellValueFactory(new PropertyValueFactory<>("Fam"));
        clientPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        table2.setItems(data2);
        addTable();
    }

    private void initData2() {//метод занесения данных клиентов в вспомогательный список
        int i = 0;
        Contracts temp = rieltors.getRealtor(getvalue()).getCont();
        data2.clear();
        while (temp != null) {
//            data2.setAll(temp);
            data2.add(i++, temp);

            temp = temp.getNextCont();
        }

    }

    private void initData() {//метод занесения данных риелторов в вспомогательный список
        data.setAll(rieltors.getRealtors());
    }

    public void addClient() {//метод добавления клиента(кнопка добавить клиента)
        if ((txtClientFam.getText().trim().isEmpty()) || (txtClientPrice.getText().trim().isEmpty())) {
            nullProblem();
        } else {
            rieltors.getRealtor(getvalue()).addContract(txtClientFam.getText(), Float.parseFloat(txtClientPrice.getText()));
        }
        txtClientFam.clear();
        txtClientPrice.clear();
    }

    public void nullProblem() {//метод вывода ошибки
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Не заполнены поля!");
        alert.setContentText("Поля не заполнены, заполните необходимые поля и повторите попытку!");
        alert.showAndWait();
    }

    public void removeClient() {//метод удаления клиента(кнопка удалить клиента)
        rieltors.getRealtor(getvalue()).removeContract();
        addTable2();
    }

    public void showProblem2() {//метод вывода ошибки
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Не выбран риелтор!");
        alert.setContentText("Риелтор не выбран, выберите риелтора в таблице и повторите попытку!");
        alert.showAndWait();
    }

    public void exitBut() {//метод выхода из программы(кнопка выход)
        System.exit(1);
    }

    public void helpBut() {//справка о программе
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

    public void help() {//помощь по работе с программой
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Информация");
        alert.setHeaderText("Помощь при работе с программой");
        alert.setContentText("| ДОБАВЛЕНИЕ РИЕЛТОРА: 1.Введите фамилию риелтора и номер телефона(если таблица пустая), иначе выберите риелтора в таблице кликом по строке и ведите фамилию риелтора и номер телефона; 2.Нажмите кнопку \"ДОБАВИТЬ(до)\" или \"ДОБАВИТЬ(после)\"; 3.В таблице появится добавленный риелтор.|\n" +
                "| ДОБАВЛЕНИЕ КЛИЕНТА РИЕЛТОРА:1.Выберите риелтора в таблице кликом по строке; 2.Введите фамилию клиента и цену сделки; 3.Нажмите на кнопку \"ДОБАВИТЬ КЛИЕНТА\".| \n" +
                "| УДАЛЕНИЕ РИЕЛТОРА: 1.Выберите риелтора в таблице кликом по строке; 2.Затем нажмите кнопку \"УДАЛИТЬ РИЕЛТОРА\".| \n" +
                "| УДАЛЕНИЕ КЛИЕНТА РИЕЛТОРА: 1.Выберите риелтора в таблице кликом по строке; 2.Затем нажмите кнопку \"УДАЛИТЬ КЛИЕНТА\".| \n" +
                "| УДАЛЕНИЕ ВСЕХ ДАННЫХ(ОЧИСТКА ТАБЛИЦ): 1.Нажмите кнопку \"Очистить таблицы\".| \n" +
                "| СОХРАНЕНИЕ И ЗАГРУЗКА осуществляется при нажатие кнопок \"СОХРАНИТЬ В ФАЙЛ\" и \"ЗАГРУЗИТЬ ИЗ ФАЙЛА\" ,либо нажмите на \"файл\" в левом углу и нажмите открыть/сохранить.|     ");

        alert.showAndWait();
    }

    public void addTo() {//метод добавления риелтора до(кнопка добавить(до) клиента)
        if ((txtFam.getText().trim().isEmpty()) || (txtNuM.getText().trim().isEmpty())) {
            nullProblem();
        } else {
            if (rieltors.addRealtorTo(getvalue(), txtFam.getText(), txtNuM.getText()) != (0)) {
                showProblems();
            }
        }
        txtFam.clear();
        txtNuM.clear();
    }

    public void addItem() {//метод добавления риелтора после(кнопка добавить(после) клиента)
        if ((txtFam.getText().trim().isEmpty()) || (txtNuM.getText().trim().isEmpty())) {
            nullProblem();
        } else {
            if (rieltors.addRealtorItem(getvalue(), txtFam.getText(), txtNuM.getText()) != (0)) {
                showProblems();
            }
        }

        txtFam.clear();
        txtNuM.clear();
    }

    public void showProblems() {//метод вывода ошибки
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Список заполнен!");
        alert.setContentText("Список заполнен, удалите одного или нескольких риелторов из списка!");
        alert.showAndWait();
    }

    public void remove() {//метод удаления риелтора(кнопка удалить риелтора)

        rieltors.remove(getvalue());
        addTable();
        table2.getItems().clear();
    }

    public String getvalue() {//метод получения данных выбранной строки
        if (rieltors.getRealtorCount() != 0) {
            int row = table1.getSelectionModel().getSelectedIndex();
            if (row == -1) {
                showProblem2();
            } else {
                String a = table1.getColumns().get(0).getCellObservableValue(row).getValue().toString();

                return a;
            }
        }
        return "a";
    }

    public void txtSetting() {//метод ограничения ввода символов
        txtNuM.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (isDigit(input) != true) {
                e.consume();
            }
            if (txtNuM.getText().length() >= 11) {
                e.consume();
            }
        });

        txtClientPrice.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (isLetter(input) == true) {
                e.consume();
            }
            if(".0123456789".contains(e.getCharacter())!=true){
            e.consume();
            }
        });
    }

    public void txtSetting2() {//метод ограничения ввода символов
        txtFam.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (isLetter(input) != true) {
                e.consume();
            }
        });
        txtClientFam.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (isLetter(input) != true) {
                e.consume();
            }
        });
    }

    public void cleanTable() {//метод очистки таблиц(удаления риелторов и его клиентов)
        rieltors.removeAll();
        sumAgentstvo.setText("Сумма сделок агентства: "+rieltors.sumAgentstvo());
        table1.getItems().clear();
        table2.getItems().clear();

    }


    public void showClient() {//метод вывода клиентов выбранного риелтора
        Contracts temp = rieltors.getRealtor(getvalue()).getCont();
        if (temp == null) {
            table2.getItems().clear();
        } else {
            addTable2();
        }
    }

    @FXML
    public void clickItem() {//метод выбора риелтора
        table1.setOnMouseClicked(event -> {
            showClient();
        });
    }

    @FXML
    private void saveFile() {//метод сохраения данных в файл
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Save Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT (*.txt)", "*.txt");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(stage);//Указываем текущую сцену
        if (file != null) {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(rieltors.data() + "end");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }//
        }
    }


    @FXML
    private void openFile() {//метод загрузки данных из файл
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Open Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT (*.txt)", "*.txt");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);//Указываем текущую сцену CodeNote.mainStage
        if (file != null) {
            try {
                Scanner in = new Scanner(file);
                String s;
                String foo;
                String name = null;
                cleanTable();
                while (in.hasNextLine()) {
                    s = in.nextLine();
                    if (s.equals("{")) {
                        s = in.nextLine();
                        while (!"}".equals(s)) {
                            String words2[] = s.split(" ");
                            String num = words2[1];
                            rieltors.getRealtor(name).addContract(words2[0], Float.parseFloat(num));
                            s = in.nextLine();
                        }
                    }
                    if (s.equals("}")) {
                        s = in.nextLine();
                    }
                    if (s.equals("end")) {
                        break;
                    }
                    String words[] = s.split(" ");
                    foo = words[1];
                    name = words[0];
                    rieltors.addRealtorFile(words[0], foo);
                }
                addTable();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}