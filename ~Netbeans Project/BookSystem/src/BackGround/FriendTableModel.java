/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class FriendTableModel  extends AbstractTableModel{

    static int TABLE_COLUMN_COUNT = 4;
    //--------------------------------------------------
    List<User> friends;
    List<String> isOnLine;
    public void setFriendList(List<User> friends)
    {
        try {
            this.friends = friends;
            setStatus();
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(FriendTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(FriendTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setStatus() throws UnknownHostException, IOException
    {
        if(friends == null || friends.isEmpty())
            return;
        isOnLine = new LinkedList<String>();
        for(int i = 0; i<friends.size(); i++)
        {
            User friend = friends.get(i);
            InetAddress inet = InetAddress.getByName(friend.getIP());
            if(inet.isReachable(1000))
            {
                isOnLine.add("在线");
            }
            else
            {
                isOnLine.add("离线");
            }
        }
    }
    public int getRowCount()
    {
        //这里需要根据实际数据条数更改
        if(friends == null || friends.isEmpty())
            return 0;
        return friends.size();
    }
    public int getColumnCount()
    {
        //这里需要根据实际数据条数更改
        return TABLE_COLUMN_COUNT;
    }
    public String getValueAt(int row, int column)
    {
        
        //以下暂时使用测试版本的
        if(column == 0)//头像
        {
            return "Unkown";
        }
        else if(column == 1)//状态（是否在线）
        {
            return isOnLine.get(row);
        }
        else if(column == 2)//名字
        {
            return friends.get(row).getName();
        }
        else if(column == 3)//个性签名
        {
            return friends.get(row).getSignature();
        }
        return "Unkown";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }

    @Override
    public String getColumnName(int column)
    {
        if(column == 0)//respond to the attribute Book Name
        {
            return "头像";
        }
        else if(column == 1)//respond to the attribute Book ISBN
        {
            return "状态";
        }
        else if(column == 2)//respond to the attribute Book Author
        {
            return "名字";
        }
        else if(column == 3)//respond to the attribute Book Location
        {
            return "个性签名";
        }
        return "Unknown";
    }
}
