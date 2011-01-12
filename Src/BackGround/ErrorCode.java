/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;

/**
 *
 * @author Administrator
 */
public class ErrorCode {
    public static final int Success               = 0;
    // Errors for SQL
    public static final int SQLDriverNotFound     = 1;
    public static final int CannotConnectToSQL    = 2;    //无法连接到数据库
    public static final int SQLNotConnected       = 3;    //尚未连接到数据库
    public static final int SQLException          = 4;    //SQL语句执行失败
    public static final int UserAlreadyExists     = 5;
    public static final int UserNotExists         = 6;
    public static final int PasswordInvalid       = 7;
    public static final int CannotChangePassword  = 8;
    public static final int CannotChangeSignature = 9;
    public static final int FriendRecordAlreadyExists = 50;
    public static final int FriendRecordNotExists = 10;
    public static final int BookNotExists         = 11;
    

    // Errors for Network Services
    public static final int NetworkAdapterFailed  = 12;    //网卡故障
    public static final int NetworkServicesFailed = 13;    //无法连接网络
    public static final int FriendsNotOnline      = 14;    //用户不在线
    public static final int FireNotExists         = 15;
}
