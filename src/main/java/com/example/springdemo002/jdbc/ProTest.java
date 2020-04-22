package com.example.springdemo002.jdbc;


import javax.xml.crypto.Data;

public class ProTest {
    private int 商品ID;
    private String 商品名;
    private int 商品价格;
    private String 供应商;
    private Data 生成日期;
    private int 商品数量;

    public int get商品ID() {
        return 商品ID;
    }

    public void set商品ID(int 商品ID) {
        this.商品ID = 商品ID;
    }

    public String get商品名() {
        return 商品名;
    }

    public void set商品名(String 商品名) {
        this.商品名 = 商品名;
    }

    public int get商品价格() {
        return 商品价格;
    }

    public void set商品价格(int 商品价格) {
        this.商品价格 = 商品价格;
    }

    public String get供应商() {
        return 供应商;
    }

    public void set供应商(String 供应商) {
        this.供应商 = 供应商;
    }

    public Data get生成日期() {
        return 生成日期;
    }

    public void set生成日期(Data 生成日期) {
        this.生成日期 = 生成日期;
    }

    public int get商品数量() {
        return 商品数量;
    }

    public void set商品数量(int 商品数量) {
        this.商品数量 = 商品数量;
    }

    @Override
    public String toString() {
        return "ProTest{" +
                "商品ID=" + 商品ID +
                ", 商品名='" + 商品名 + '\'' +
                ", 商品价格=" + 商品价格 +
                ", 供应商='" + 供应商 + '\'' +
                ", 生成日期=" + 生成日期 +
                ", 商品数量=" + 商品数量 +
                '}';
    }
}
