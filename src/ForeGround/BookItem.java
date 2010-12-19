/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ForeGround;

/**
 *
 * @author Administrator
 */
public class BookItem {
    String id;
    String bookName;
    String bookISBN;
    String location;
    String branch;
    String author;
    

    public BookItem()
    {
        bookName = "SE";
        bookISBN = "1111-111-111-111";
        location = "./SE.txt";
        branch = "default";
        author = "wq";
        id = "0";
    }

    public BookItem(String param1, String param2, String param3, String param4, String param5, String param6)
    {
        bookName = param1;
        bookISBN = param2;
        location = param3;
        branch = param4;
        author = param5;
        id = param6;
    }

    public void setBookName(String name)
    {
        this.bookName = name;
    }

    public void setBookISBN(String name)
    {
        this.bookISBN = name;
    }

    public void setLocation(String name)
    {
        this.location = name;
    }

    public void setBranch(String name)
    {
        this.branch = name;
    }

    public void setAuthor(String name)
    {
        this.author = name;
    }

    public void setId(String name)
    {
        this.id = name;
    }

    public String getBookName()
    {
        return this.bookName;
    }

    public String getBookISBN()
    {
        return this.bookISBN;
    }

    public String getBookLocation()
    {
        return this.location;
    }

    public String getBranch()
    {
        return this.branch;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getId()
    {
        return this.id;
    }
}
