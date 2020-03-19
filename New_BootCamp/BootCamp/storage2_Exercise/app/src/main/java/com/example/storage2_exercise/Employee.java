package com.example.storage2_exercise;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee_table")
public class Employee{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public  String getAddress() {
        return address;
    }

    @ColumnInfo(name = "employee_name")
    private String name;

    @ColumnInfo(name = "employee_phone")
    private String phone;

    @ColumnInfo(name = "employee_address")
    private String address;

    public Employee(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

}
