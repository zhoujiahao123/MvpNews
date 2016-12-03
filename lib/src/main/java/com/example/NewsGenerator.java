package com.example;


import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class NewsGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1,"example.com.mvpnews");
        addNewsInfo(schema);
            new DaoGenerator().generateAll(schema,"app/src/main/java-gen");

    }
    public static void addNewsInfo(Schema schema){
        Entity news = schema.addEntity("News");
        news.addIdProperty().primaryKey();
        news.addStringProperty("title");
        news.addStringProperty("date");
        news.addStringProperty("contentUrl");
        news.addStringProperty("imageUrl");
    }
}
