package com.lison.roomsqlquery.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.lison.roomsqlquery.model.Department;
import com.lison.roomsqlquery.model.InnerJoinResult;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DepartmentDao {

    @Insert(onConflict = REPLACE)
    void insertDepartments(Department... departments);

    @Query("select emp_id,name,dept from Employee Inner join Department On Employee.id = Department.emp_id")
    List<InnerJoinResult> getDepartFromEmployee();
}
