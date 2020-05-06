//根据传入的sql语句进行查询数据
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