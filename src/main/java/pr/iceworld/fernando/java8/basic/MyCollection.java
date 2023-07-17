package pr.iceworld.fernando.java8.basic;

import java.sql.*;
import java.util.Set;

public class MyCollection<T> {
    private Set<T> set;
    public Set<T> getCollection(){
        return this.set;
    }
//    public void TestCollection(MyCollection<?>collection){
//        Set<?>set = collection.getCollection();
//    }

//    public void TestCollection(MyCollection<?> collection){
//        Set<T> set = collection.getCollection();
//    }

    public void TestCollection(MyCollection<?> collection) throws ClassNotFoundException, SQLException {
//        Set<E> set = collection.getCollection();
        Math.random();

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //设置参数
        String url = "jdbc:oracle:thin:@127.0.0.1:1521/orcl1";
        String userName = "test1";
        String passWord = "00000000";

        //建立连接
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        //在建立了连接的基础上对数据库进行操作
        String sql = "select * from user_tables";

        PreparedStatement st = connection.prepareStatement(sql);
        st.executeQuery();
        ResultSet resultSet = st.executeQuery();

        //遍历结果
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }


        //关闭结果集
        resultSet.close();

        //关闭连接
        connection.close();

    }

}
