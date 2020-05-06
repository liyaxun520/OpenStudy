package com.lison.roomsqlquery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.sqlite.db.SimpleSQLiteQuery;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lison.roomsqlquery.db.AppDatabase;
import com.lison.roomsqlquery.model.Department;
import com.lison.roomsqlquery.model.Employee;
import com.lison.roomsqlquery.model.InnerJoinResult;
import com.lison.roomsqlquery.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TAG ="MainActivity";
    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermission();
    }

    private void requestPermission() {
        Log.i(TAG,"requestPermission");
        // Here, thisActivity is the current activity
        if (PermissionChecker.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PermissionChecker.PERMISSION_GRANTED) {
            Log.i(TAG,"checkSelfPermission");
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.i(TAG,"shouldShowRequestPermissionRationale");
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            } else {
                Log.i(TAG,"requestPermissions");
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG,"onRequestPermissionsResult granted");

                } else {
                    Log.i(TAG,"onRequestPermissionsResult denied");
                    showWaringDialog();
                }
                return;
        }
    }
    private void showWaringDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("警告！")
                .setMessage("请前往设置->应用->PermissionDemo->权限中打开相关权限，否则功能无法正常运行！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 一般情况下如果用户不授权的话，功能是无法运行的，做退出处理
                        finish();
                    }
                }).show();
    }

    public void addUser(View view) {
        User users[] =new User[10];
        for (int i = 0; i < 10; i++) {
            users[i] = new User("lison"+i,10+i);
        }
        AppDatabase.getInstance(view.getContext()).getUserDao().insertUser(users);
    }

    public void deleteUser(View view) {
        Random random = new Random();
        int userId =random.nextInt(10);
        Log.e(TAG, "deleteUser:用户编号    "+userId );
        User user = AppDatabase.getInstance(view.getContext()).getUserDao().queryByUserId(userId);
        if (user != null) {
            AppDatabase.getInstance(view.getContext()).getUserDao().deleteUser(user);
        }
    }

    public void updateUser(View view) {
        User[] users = AppDatabase.getInstance(view.getContext()).getUserDao().queryAll();
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            user.setName("zs==="+i);
        }
        AppDatabase.getInstance(view.getContext()).getUserDao().updateUser(users);
    }

    public void queryUser(View view) {
        User[] users = AppDatabase.getInstance(view.getContext()).getUserDao().queryAll();
        for (User user : users) {
            Log.e(TAG, "queryUser:== "+user.toString() );
        }
    }

    public void queryEndUser(View view) {
        User user = AppDatabase.getInstance(view.getContext()).getUserDao().queryEndUser();
        if (user != null) {
            Log.e(TAG, "queryEndUser: "+user.toString() );
        }



    }



    public void insertEmployee(View view) {
        List<Employee> list = new ArrayList<>();
        Employee employee = new Employee("Paul",32,"California",20000.0);
        list.add(employee);
        employee = new Employee("Allen",25,"Texas",15000.0);
        list.add(employee);
        employee = new Employee("Teddy",23,"Norway",20000.0);
        list.add(employee);
        employee = new Employee("Mark",25,"Rich-Mond",65000.0);
        list.add(employee);
        employee = new Employee("David",27,"Texas",85000.0);
        list.add(employee);
        employee = new Employee("Kim",22,"South-Hall",45000.0);
        list.add(employee);
        employee = new Employee("James",24,"Houston",10000.0);
        list.add(employee);
        Object[] objectArray = list.toArray();
        for (Object o : objectArray) {
            if (o instanceof Employee) {
                Employee e = (Employee) o;
                AppDatabase.getInstance(this).getEmployeeDao().insertEmployees(e);
            }
        }
    }

    public void insertDepartment(View view) {
        List<Department> departmentList = new ArrayList<>();
        Department department = new Department("移动开发",1);
        departmentList.add(department);
        department = new Department("质量管理",2);
        departmentList.add(department);
        department = new Department("程序运维",7);
        departmentList.add(department);
        Object[] departments = departmentList.toArray();
        for (Object o : departments) {
            if (o instanceof Department) {
                Department depart = (Department) o;
                AppDatabase.getInstance(this).getDepartmentDao().insertDepartments(depart);
            }
        }
    }

    public void getDepartFromEmployee(View view) {
        List<InnerJoinResult> resultList = AppDatabase.getInstance(this).getDepartmentDao().getDepartFromEmployee();
        for (InnerJoinResult result : resultList) {
            Log.e(TAG, "getDepartFromEmployee: "+result.toString() );
        }

    }

    public void getUserBySql(View view) {
        String sql = "select * from user where id = 5 or id = 4";
        List<User> userSqlData = AppDatabase.getInstance(this).getUserSqlData(sql);
        Log.e(TAG, "getUserBySql: "+userSqlData.size() );
        for (User userSqlDatum : userSqlData) {
            Log.e(TAG, "getUserBySql: "+userSqlDatum.toString() );
        }
    }
}
