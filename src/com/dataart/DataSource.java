package com.dataart;

public interface DataSource {
    void writeData(String data);

    String readData();
}
