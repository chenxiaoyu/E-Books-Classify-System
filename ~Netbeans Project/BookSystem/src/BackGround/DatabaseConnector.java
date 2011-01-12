/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;
import java.net.UnknownHostException;
import java.sql.*;
import BackGround.BookItem;
import BackGround.ErrorCode;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Administrator
 */
//！！！使用单例设计模式，本应用程序全局只能生成一个DatabaseConnector类的实例
//！！！ 注意：这里暂时使用的是本机的数据库来测试的，以后测试需要改IP地址!
public class DatabaseConnector {
    private String databaseDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
    private String databaseURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ebook_system";//数据源
    private String login = "sa";    //默认用户权限
    private String password = "123456";
    private Connection connection;
    private String IP; //待用
    private String port;//待用
    //单例设计模式：
    private static DatabaseConnector dcInstance;

    private DatabaseConnector()
    {
        //！！！ 注意：这里暂时使用的是本机的数据库来测试的，以后测试需要改IP地址!
        //！！ 可以进行一些其他的初始化设计（可以使用对话框来初始化IP地址）
        // to accomplish this!!
    }

    public static DatabaseConnector getDatabaseConnectorInstance()
    {
        if(dcInstance == null)
            dcInstance = new DatabaseConnector();
        return dcInstance;
    }

    public int connect()
    {
        try
        {
            Class.forName(databaseDriver);//加载数据库引擎，返回给定字符串名的类
            connection = DriverManager.getConnection(databaseURL,login,password);//连接数据库对象
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("加载数据库引擎失败");
            return ErrorCode.SQLDriverNotFound;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("数据库连接错误");
            return ErrorCode.CannotConnectToSQL;
        }
        return ErrorCode.Success;
    }

    public int close()
    {
        try
        {
            connection.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }
        return ErrorCode.Success;
    }

    public int register(String userName, String password,String signature)
    {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ip);//可选提示

            String addUser = "INSERT INTO Users VALUES('";
            addUser = addUser + userName + "','" + password + "','" + ip +"','" + signature + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(addUser);
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.UserAlreadyExists;
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.NetworkServicesFailed;
        }

        return ErrorCode.Success;
    }

    /***
     * 如果用户登录系统的话，那么每一次都要刷新登录的IP地址
     *
     */
    public int login(String userName, String password)
    {
        try {
            if (isValidName(userName) != ErrorCode.Success) {
                return ErrorCode.UserNotExists;
            }
            if (isValidPassword(userName, password) != ErrorCode.Success) {
                return ErrorCode.PasswordInvalid;
            }
            
            String ip = InetAddress.getLocalHost().getHostAddress();
            String updateIP = "UPDATE Users SET ip = '" + ip + "' WHERE uname = '"
                    + userName + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateIP);
            
            return ErrorCode.Success;
        }
        
        catch (UnknownHostException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.NetworkServicesFailed;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }
    }

    public int isValidName(String userName)
    {
        try {
            String checkName = "SELECT * FROM Users WHERE uname = '"+ userName + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(checkName);

            if( resultSet.next() == false)
                return ErrorCode.UserNotExists;

            return ErrorCode.Success;
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }
    }

    private int isValidPassword(String userName, String password)
    {
        try {
            String checkPassword = "SELECT * FROM Users WHERE uname='" + userName
                    + "' AND upwd='" + password + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(checkPassword);

            if (resultSet.next() == false) {
                return ErrorCode.PasswordInvalid;
            }
            return ErrorCode.Success;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }
    }

    public int changePassword(String userName, String newPassword)
    {
        try {
            String changePassword = "UPDATE Users SET upwd = '" + newPassword
                    + "' WHERE uname = '" + userName + "'";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(changePassword);

            if (result == 0)
            {
                return ErrorCode.CannotChangePassword;
            }
            return ErrorCode.Success;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }
    }

    public int setSignature(String userName, String signature)
    {
        try {
            String setSignature = "UPDATE Users SET signature = '" + signature
                    + "' WHERE uname = '" + userName + "'";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(setSignature);

            if (result == 0)
            {
                return ErrorCode.CannotChangeSignature;
            }
            return ErrorCode.Success;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }
    }

    public int requestToBeFriend(String inviterName, String inviteeName)
    {
        try
        {
            // 修改数据库设计，为朋友表再增加一个status字段，用R表示请求，D表示拒绝，A表示同意
            String hasRecord = "SELECT * FROM Friends WHERE user1 = '" + inviterName
                    + "' AND user2 = '" + inviteeName + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(hasRecord);
            if (resultSet.next() == true) {
                resultSet.close();
                statement.close();
                return ErrorCode.FriendRecordAlreadyExists;
            }
            
            String requestToBeFriend = "INSERT INTO Friends VALUES('" + inviterName
                    + "', '" + inviteeName + "', '" + "R')";
            statement = connection.createStatement();
            statement.executeUpdate(requestToBeFriend);
            statement.close();
            return ErrorCode.Success;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }

    }

    public int acceptToBeFriend(String inviterName, String inviteeName)
    {
        try {
            String hasRecord = "SELECT * FROM Friends WHERE user1 = '" + inviterName
                    + "' AND user2 = '" + inviteeName + "' AND status = 'R'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(hasRecord);
            if (resultSet.next() != true) {
                resultSet.close();
                statement.close();
                return ErrorCode.FriendRecordNotExists;
            }

            String acceptToBeFriend = "UPDATE Friends SET status = 'A' WHERE user1 = '"
                    + inviterName + "' AND user2 = '" + inviteeName + "'";
            statement = connection.createStatement();
            statement.executeUpdate(acceptToBeFriend);
            statement.close();
            return ErrorCode.Success;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }

    }

    public int refuseToBeFriend(String inviterName, String inviteeName)
    {
        try {
            String hasRecord = "SELECT * FROM Friends WHERE user1 = '" + inviterName
                    + "' AND user2 = '" + inviteeName + "' AND status = 'R'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(hasRecord);
            if (resultSet.next() != true) {
                resultSet.close();
                statement.close();
                return ErrorCode.FriendRecordNotExists;
            }

            String refuseToBeFriend = "UPDATE Friends SET status = 'D' WHERE user1 = '"
                    + inviterName + "' AND user2 = '" + inviteeName + "'";
            statement = connection.createStatement();
            statement.executeUpdate(refuseToBeFriend);
            statement.close();
            return ErrorCode.Success;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return ErrorCode.SQLException;
        }
    }

    // 支持模糊查询
    public List<BookItem> searchBook(String byWhat, String value)
    {
        try
        {
            String searchBook = "SELECT * FROM Books WHERE " + byWhat + " LIKE '%"
                    + value + "%'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchBook);

            BookItem book;
            List<BookItem> bookList = new LinkedList<BookItem>();
            while(resultSet.next())
            {
                book = new BookItem();
                book.setId(resultSet.getString("bid"));
                book.setBookName(resultSet.getString("bname"));
                book.setBookISBN(resultSet.getString("ISBN"));
                book.setAuthor(resultSet.getString("author"));
                book.setBranch(resultSet.getString("branch"));
                book.setLocation(resultSet.getString("location"));
                book.setDescription(resultSet.getString("description"));
                bookList.add(book);
            }
            statement.close();
            resultSet.close();
            return bookList;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    // 支持模糊查询（在这一步，由于是通过数据库来访问的，所以只让它获取用户名，ip及用户的个性签名）
    public List<User> searchUser(String userName)
    {
        try
        {
            String searchUser = "SELECT * FROM Users WHERE uname LIKE '%" + userName + "%'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchUser);
            User user;
            List<User> userList = new LinkedList<User>();
            while(resultSet.next())
            {
                user = new User();
                user.setName(resultSet.getString("uname"));
                user.setIP(resultSet.getString("ip"));
                user.setSignature(resultSet.getString("signature"));
                userList.add(user);
            }

            resultSet.close();
            statement.close();
            return userList;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<User> getFriendList(String userName)
    {
        try
        {
            String searchFriendName1 = "SELECT user1 FROM Friends WHERE user2 = '" + userName
                    + "' AND status = 'A' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchFriendName1);
            User friend;
            List<User> friendList = new LinkedList<User>();
            while(resultSet.next())
            {
                friend = searchUserByName(resultSet.getString("user1"));
                friendList.add(friend);
            }

            String searchFriendName2 = "SELECT user2 FROM Friends WHERE user1 = '"
                    + userName +"' AND status = 'A'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(searchFriendName2);
            while(resultSet.next())
            {
                friend = searchUserByName(resultSet.getString("user2"));
                friendList.add(friend);
            }
            resultSet.close();
            statement.close();
            return friendList;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private User searchUserByName(String userName)
    {
        try
        {
            String searchUser = "SELECT * FROM Users WHERE uname = '" + userName + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchUser);
            User user;
            if(resultSet.next())
            {
                user = new User();
                user.setName(resultSet.getString("uname"));
                user.setIP(resultSet.getString("ip"));
                user.setSignature(resultSet.getString("signature"));
            }
            else
            {
                user = null;
            }
            resultSet.close();
            statement.close();
            return user;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //**************************************************************************
    // 由于上传下载功能牵涉到网络，暂时不做这一部分
    public int upload(BookItem book)
    {
        return ErrorCode.Success;
    }
    
    public int download(BookItem book)
    {
        return ErrorCode.Success;
    }
    //**************************************************************************
}
