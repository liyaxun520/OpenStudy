package com.lison.roomsqlquery.model;

import androidx.room.ColumnInfo;

public class InnerJoinResult {
    @ColumnInfo(name="emp_id")
    private int empId;
    private String name;
    private String dept;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "InnerJoinResult{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
