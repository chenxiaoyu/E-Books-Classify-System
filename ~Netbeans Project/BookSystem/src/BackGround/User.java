/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;
import BackGround.BookItem;
import BackGround.ErrorCode;
import BackGround.DatabaseConnector;
import java.util.List;
/**
 *
 * @author Administrator
 */
// 只有用户使用与好友有关的功能时，才会用到这个类 （使用P2P对等设计！！）
public class User {
    private String name;
    private String password;
    private List<BookItem> bookList;
    private List<User> friendList;
    private String IP;
    private String signature;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    //*********************************************************************
    //*******************需要网络支持， 待完善！！***************************
    // 只能通过books.xml文件来获取书籍列表，这里需要通过网络来传输书籍列表文件
    public void setBookList()
    {
        // to accomplish this!
        // 只从中读取出“共享”属性的书籍信息！！
    }
    //*********************************************************************


    // 只能通过数据库来设置朋友列表
    public void setFriendList()
    {
        DatabaseConnector dc = DatabaseConnector.getDatabaseConnectorInstance();
        friendList = dc.getFriendList(name);
    }

    public void setIP(String IP)
    {
        this.IP = IP;
    }

    public void setSignature(String signature)
    {
        this.signature = signature;
    }

    public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }

    public String getIP()
    {
        return IP;
    }

    public String getSignature()
    {
        return signature;
    }
    
    // 只显示权限权限为共享的书籍
    public List<BookItem> getBookList()
    {
        return bookList;
    }

    public List<User> getFriendList()
    {
        return friendList;
    }

    //***************************待完善！***************************************
    // 由于上传下载功能牵涉到网络，暂时不做这一部分
    public int downLoadFromFriend(BookItem book)
    {
        return ErrorCode.Success;
    }
    public int upLoadToFriend(BookItem book)
    {
        return ErrorCode.Success;
    }
    //**************************************************************************
    
    public int acceptToBeFriend(String inviterName)
    {
        DatabaseConnector dc = DatabaseConnector.getDatabaseConnectorInstance();
        return dc.acceptToBeFriend(inviterName, name);
    }

    public int refuseToBeFriend(String inviterName)
    {
        DatabaseConnector dc = DatabaseConnector.getDatabaseConnectorInstance();
        return dc.refuseToBeFriend(inviterName, name);
    }

    public int changePassword(String oldPassword, String newPassword)
    {
        if(password.equals(oldPassword) == false)
            return ErrorCode.PasswordInvalid;

        DatabaseConnector dc = DatabaseConnector.getDatabaseConnectorInstance();
        int result = dc.changePassword(name, newPassword);
        if(result == ErrorCode.Success)
            password = newPassword;

        return result;
    }

        //更新1.1 by杨光：
    public void setUser(User tempUser)
    {
        this.name = tempUser.getName();
        this.IP = tempUser.getIP();
        this.bookList = tempUser.getBookList();
        this.friendList = tempUser.getFriendList();
        this.password = tempUser.getPassword();
        this.signature = tempUser.getSignature();
    }

}
