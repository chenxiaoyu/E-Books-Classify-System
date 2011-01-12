/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;

/**
 *
 * @author Administrator
 */
// 定义网络传输的各种通信“暗码”以及服务端口号
public class Constants {

    public static final int ServerPort = 8888;  // 系统服务器端口号
    public static final int FriendPort = 1080;  // 为朋友服务的端口号
    public static final int ServerMaxBacklog = 1000;    // 服务器接受的最大连接请求数
    public static final int FriendMaxBacklog = 20;      // 朋友接受的最大连接请求数

    public static final String RequestBookList = "Request Book List.";
    public static final String BookListNotExists = "Sorry, the shared book list doesn't exist.";
    public static final String BookListTransmitFailed = "Sorry, The shared book list failed to be transmitted.";
    public static final String BookListTransmitSuccess = "Congratulations! The shared book list has been transmitted successfully.";
    
    public static final String RequestBook = "Request to transmit a book.";
    public static final String BookNotExists = "Sorry, the requested book doesn't exist.";
    public static final String BookTransmitFailed = "Sorry, The requested book failed to be transmitted.";
    public static final String BookTransmitSuccess = "Congratulations! The requested book has been transmitted successfully.";

}
