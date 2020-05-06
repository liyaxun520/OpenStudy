package com.lison.roomsqlquery.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "Department",foreignKeys = @ForeignKey(entity = Employee.class,parentColumns = "id",childColumns = "emp_id",onDelete = CASCADE))  //部门信息
public class Department {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String dept;
    @ColumnInfo(name = "emp_id")
    private int empId;

    public Department(String dept, int empId) {
        this.dept = dept;
        this.empId = empId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
