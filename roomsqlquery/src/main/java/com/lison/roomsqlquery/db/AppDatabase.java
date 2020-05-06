package com.lison.roomsqlquery.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Environment;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SimpleSQLiteQuery;

import com.lison.roomsqlquery.dao.DepartmentDao;
import com.lison.roomsqlquery.dao.EmployeeDao;
import com.lison.roomsqlquery.dao.UserDao;
import com.lison.roomsqlquery.model.Department;
import com.lison.roomsqlquery.model.Employee;
import com.lison.roomsqlquery.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Database(entities = {User.class,
                     Employee.class,
                    Department.class},version = 1,exportSchema = false)
public abstract class
AppDatabase extends RoomDatabase {

    private static final String DB_NAME = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"lisonDB"+File.separator+"UserDatabase.db";
    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                DB_NAME)
//                .addMigrations(new Migration(1,2) {
//                    @Override
//                    public void migrate(@NonNull SupportSQLiteDatabase database) {
//                        database.execSQL("ALTER table user add column userSql TEXT");
//                    }
//                })
//
                .allowMainThreadQueries()
                .build();
    }

    public abstract UserDao getUserDao();
    public abstract EmployeeDao getEmployeeDao();
    public abstract DepartmentDao getDepartmentDao();


    public List<User> getUserSqlData(String sql) {
        //根据传入的sql语句进行查询数据
        List<User> users =  new ArrayList<User>();
        Cursor cursor = query(new SimpleSQLiteQuery(sql));
        if (cursor instanceof SQLiteCursor) {
            while (cursor.moveToNext()){
                int anInt = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                String sqlMsg = cursor.getString(3);
                users.add(new User(anInt,name,age,sqlMsg));
            }
        }
        return users;
    }
}
