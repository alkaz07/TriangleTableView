package com.example.triangletableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.io.*;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import static java.nio.file.Files.readAllLines;

/*
сделать графическое приложение, которое грузит из файла список Треугольников
каждый треугольник задан 3 сторонами
Вывести в табличку или отдельными элементами все треугольники с указанием площади

+ делаем строки таблицы редактируемыми и даем возможность сохранить изменения в файл
 */
public class HelloController {
    @FXML
    TableView<ObservableTriangle> table;
    @FXML
    Button saveBtn;
    ObservableList<ObservableTriangle> triangles = FXCollections.observableArrayList();

    public void initialize() throws IOException {
        readTrianglesFromFile();
        initTable();
    }
    public void readTrianglesFromFile() throws IOException {
        List<String> list = readAllLines(new File("1.txt").toPath(), Charset.forName("UTF-8"));
        loadTriangles(list);
    }
    public void loadTriangles(List<String> lines){
        for (String str: lines) {
            ObservableTriangle oTr = new ObservableTriangle(str.split(" ")[0], str.split(" ")[1], str.split(" ")[2]);
            triangles.add(oTr);
        }
    }
    public void initTable()
    {
        table.getColumns().clear();
        TableColumn<ObservableTriangle, Double> columnA = new TableColumn<>("A");
        columnA.setCellValueFactory(new PropertyValueFactory<>("sideA"));
        columnA.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));


        TableColumn<ObservableTriangle, Double> columnB = new TableColumn<>("B");
        columnB.setCellValueFactory(new PropertyValueFactory<>("sideB"));
        columnB.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<ObservableTriangle, Double> columnC = new TableColumn<>("C");
        columnC.setCellValueFactory(new PropertyValueFactory<>("sideC"));
        columnC.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<ObservableTriangle, Double> columnArea = new TableColumn<>("Area");
        columnArea.setCellValueFactory(new PropertyValueFactory<>("area"));
        //columnArea.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));



        table.getColumns().add(columnA);
        table.getColumns().add(columnB);
        table.getColumns().add(columnC);
        table.getColumns().add(columnArea);
        table.setItems(triangles);
        table.setEditable(true);


    }


//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
}