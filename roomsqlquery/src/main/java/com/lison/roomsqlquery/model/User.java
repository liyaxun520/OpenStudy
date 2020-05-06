package com.lison.roomsqlquery.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)//主键是否自动增长，默认为false
    private int id;
    private String name;
    private int age;
    private String userSql;

    public User() {
    }

    public User(int id, String name, int age, String userSql) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userSql = userSql;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sql=" + userSql +
                '}';
    }

    public String getUserSql() {
        return userSql;
    }

    public void setUserSql(String userSql) {
        this.userSql = userSql;
    }
}
