package com.dataart;

public class Main extends PolishStringMaker {

    public static void main(String[] args) {
        DataSource encoded = new FileDataSource("out/OutputDemo.txt");
        encoded.writeData("6-5*(7-4)");
        String StrFromFile = encoded.readData();
        String output = String.valueOf(calculate(StrFromFile));
        System.out.println(output);
    }
}
