package com.lison.roomsqlquery.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.lison.roomsqlquery.model.Employee;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface EmployeeDao {
    @Insert(onConflict = REPLACE)
    void insertEmployees(Employee... employees);


}
