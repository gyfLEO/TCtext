import java.sql.*;

public class MySQL{
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/study";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "gyf123456";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            //连接数据库
            System.out.println("连接数据库。。。");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //实例化statement对象,并查询结果存储到result中
            System.out.println("实例化statement对象。。。");
            stmt = conn.createStatement();
            String sql;
            sql = "select id,name,url from websites";
            ResultSet result = stmt.executeQuery(sql);

            //打印出查询到的结果
            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String url = result.getString("url");

                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("url: " + url);

            }
            //关闭result、statement、connection
            result.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null) stmt.close();
            }catch (SQLException e1){
                System.out.println(e1);
            }

            try{
                if(conn!=null) conn.close();
            }catch (SQLException e2){
                System.out.println(e2);
            }
        }
        System.out.println("over~");
    }
}