/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;
import BackGround.ErrorCode;
import BackGround.Constants;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
// 这个类负责请求/接收朋友传送的文件
public class ClientOfFriend {
    private User friend;    //保存朋友的详细信息（尤其是IP地址）
    Socket connection;      //网络连接套接字

    // 构造函数
    public ClientOfFriend(User friend) throws IOException
    {
        connection = new Socket(friend.getIP(), Constants.FriendPort);  // 创建套接字
        this.friend = friend;
    }

    // 向朋友发送传送书籍请求（！！待完善）
    public int requestBook(BookItem book) throws SocketException, IOException
    {
        //connection.setSoTimeout(800);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        return -1;
    }

    // 向朋友发送传送共享书籍列表请求
    public int requestSharedBookList()
    {
        return -1;
    }

    // 获取朋友的响应
    public int getResponse()
    {
        return -1;
    }

    // 这里需要用户选择下载文件保存位置，默认保存设置为本软件所在位置
    public int recieveBook()
    {
        return -1;
    }

    // 接收朋友的共享书籍列表
    public List<BookItem> recieveSharedBookList()
    {
        // 我的解决思路是： 朋友直接把自己电脑上的books.xml文件传过来，然后这个函数再将这个xml文件
        // 解析成List<BookItem>返回
        return null;
    }

}
