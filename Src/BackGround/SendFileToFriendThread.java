/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;
import BackGround.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
// 这个类负责监听好友请求消息，默认端口为1080
// 使用UDP协议来传输文件
public class SendFileToFriendThread extends Thread{
    //private final String RequestSendFile = "Request Send File.";
    //指定要传送的书籍的信息格式为："****"其中***为路径名

    private ServerSocket serverSocket;
    private List<BookItem> shareBookList;

    public SendFileToFriendThread(List<BookItem> shareBookList) throws IOException
    {
        serverSocket = new ServerSocket(Constants.FriendPort, Constants.FriendMaxBacklog);
        this.shareBookList = shareBookList;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Socket connection = serverSocket.accept();
                InputStreamReader in = new InputStreamReader(connection.getInputStream());
                char[] message = new char[100];
                in.read(message);
                if(message.toString().equals(Constants.RequestBookList))  //是否要求传送书籍列表
                {
                    ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
                    out.writeObject(shareBookList);
                    out.close();
                    continue;
                }
                else//  if(message.toString().equals(Constants.RequestBook))   // 要求传送书籍
                {
                    String Location = message.toString();
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    File book = new File(Location);
                    if(book.isFile() == false)      //如果指定的书籍不存在，那么传送出错信息
                    {
                        System.out.println(Constants.BookNotExists);
                        out.writeChars(Constants.BookNotExists);
                        out.close();
                        continue;
                    }
                    // 开始传送书籍数据
                    byte[] buffer = new byte[6000];
                    DataInputStream bookData = new DataInputStream(new FileInputStream(book));
                    int theLastBytes = bookData.read(buffer);
                    while(theLastBytes == 6000)    //当读取的是完整的记录时
                    {
                        out.write(buffer);
                        theLastBytes = bookData.read(buffer);
                    }
                    if(theLastBytes != -1)  // 传送最后一部分数据
                    {
                        out.write(buffer, 0, theLastBytes);
                    }
                }
            }
            catch (IOException ex) {
                Logger.getLogger(SendFileToFriendThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
