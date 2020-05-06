package com.lison.roomsqlquery.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lison.roomsqlquery.model.User;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Query("SELECT `id`,`name`,`age` FROM user")   //``符号在键盘esc下
    User[] queryAll();

    @Query("SELECT `id`,`name`,`age` FROM user order by `id` desc limit 1")
    User queryEndUser();

    @Query("SELECT `id`,`name`,`age` FROM user where id =:id")
    User queryByUserId(int id);

//    @Query("SELECT `id`,`name`,`age` FROM user ")
//    User queryBySql(String sql);

    @Insert(onConflict = REPLACE)
    void insertUser(User ...users);

    @Delete
    void deleteUser(User ...users);

    @Update
    void updateUser(User ... users);
}
