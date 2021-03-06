/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import BackGround.BookItem.*;
import BackGround.HandleXML.*;
/**
 *
 * @author Administrator
 */
public class BookTableModel extends AbstractTableModel{

    static int TABLE_COLUMN_COUNT = 4;
    //--------------------------------------------------
    List<BookItem> books;
    public void setBookList(List<BookItem> bookList)
    {
        books = bookList;
    }
    public List<BookItem> getBookList()
    {
        return books;
    }
    public int getRowCount()
    {
        //这里需要根据实际数据条数更改
        return books.size();
    }
    public int getColumnCount()
    {
        //这里需要根据实际数据条数更改
        return TABLE_COLUMN_COUNT;
    }
    public String getValueAt(int row, int column)
    {
        //以下暂时使用测试版本的
        if(column == 0)//respond to the attribute Book Name
        {
            return books.get(row).getBookName();
        }
        else if(column == 1)//respond to the attribute Book ISBN
        {
            return books.get(row).getBookISBN();
        }
        else if(column == 2)//respond to the attribute Book Author
        {
            return books.get(row).getAuthor();
        }
        else if(column == 3)//respond to the attribute Book Location
        {
            return books.get(row).getDescription();
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
            return "Name";
        }
        else if(column == 1)//respond to the attribute Book ISBN
        {
            return "ISBN";
        }
        else if(column == 2)//respond to the attribute Book Author
        {
            return "Author";
        }
        else if(column == 3)//respond to the attribute Book Location
        {
            return "Description";
        }
        return "Unknown";
    }
}
