package com.example.triangletableview;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ObservableTriangle {
    ObservableList<ObservableTriangle> triangles = FXCollections.observableArrayList();

    SimpleDoubleProperty sideA = new SimpleDoubleProperty();
    SimpleDoubleProperty sideB = new SimpleDoubleProperty();
    SimpleDoubleProperty sideC = new SimpleDoubleProperty();

    private SimpleDoubleProperty perimeter = new SimpleDoubleProperty();
    private SimpleDoubleProperty area = new SimpleDoubleProperty();

    {//секция инициализации
        this.sideA.addListener((s1, o,n)->{
            this.perimeter.set(perimeter());
            this.area.set(area());
        });
        this.sideB.addListener((s1, o,n)->{
            this.perimeter.set(perimeter());
            this.area.set(area());
        });
        this.sideC.addListener((s1, o,n)->{
            this.perimeter.set(perimeter());
            this.area.set(area());
        });
    }


    public double getSideA() {
        return sideA.get();
    }

    public SimpleDoubleProperty sideAProperty() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA.set(sideA);
      // area.set(area());
    }

    public double getSideB() {
        return sideB.get();
    }

    public SimpleDoubleProperty sideBProperty() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB.set(sideB);
    }

    public double getSideC() {
        return sideC.get();
    }

    public SimpleDoubleProperty sideCProperty() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC.set(sideC);
    }

    public double getPerimeter() {
        return perimeter.get();
    }

    public SimpleDoubleProperty perimeterProperty() {
        return perimeter;
    }

   // public void setPerimeter(double perimeter) {
   //     this.perimeter.set(perimeter);
    //}

    public double getArea() {
        return area.get();
    }

    public SimpleDoubleProperty areaProperty() {
        return area;
    }

//    public void setArea(double area) {
//        this.area.set(area);
//    }


    public ObservableTriangle(SimpleDoubleProperty sideA, SimpleDoubleProperty sideB, SimpleDoubleProperty sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public ObservableTriangle(String sideA, String sideB, String sideC) {
        this.sideA.set(Double.parseDouble(sideA));
        this.sideB.set(Double.parseDouble(sideB));
        this.sideC.set(Double.parseDouble(sideC));
    }

    public ObservableTriangle(double a, double b, double c) {
        setSideA(a);
        setSideB(b);
        setSideC(c);
    }

    double perimeter()
    {
        return sideA.get()+sideB.get()+sideC.get();
    }
    double area()
    {
        double p = perimeter.get()/2;
        return Math.sqrt(p*(p-sideA.get())*(p-sideB.get())*(p-sideC.get()));
    }

    public void loadTriangles(List<String> lines){
        for (String str: lines) {
            ObservableTriangle oTr = new ObservableTriangle(str.split(" ")[0], str.split(" ")[1], str.split(" ")[2]);
            triangles.add(oTr);
        }
    }



}
