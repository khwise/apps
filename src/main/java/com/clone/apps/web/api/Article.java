package com.clone.apps.web.api;

/**
 * Created by kh.jin on 2019. 11. 5.
 */
public class Article {

    public Article() {

    }

    public Article(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer id;
    private String name;


}
