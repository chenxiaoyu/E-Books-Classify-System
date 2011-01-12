/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;

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
    String description;

    public BookItem()
    {
        bookName = "SE";
        bookISBN = "1111-111-111-111";
        location = "./SE.txt";
        branch = "default";
        author = "wq";
        id = "0";
        description = "Unkown";
    }

    /*public BookItem(String param1, String param2, String param3, String param4, String param5, String param6)
    {
        bookName = param1;
        bookISBN = param2;
        location = param3;
        branch = param4;
        author = param5;
        id = param6;
    }*/

    public BookItem(String id, String bookName, String bookISBN, String location, String branch, String author, String description)
    {
        this.id = id;
        this.bookName = bookName;
        this.bookISBN = bookISBN;
        this.location = location;
        this.branch = branch;
        this.author = author;
        this.description = description;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public void setBookISBN(String bookISBN)
    {
        this.bookISBN = bookISBN;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setBranch(String branch)
    {
        this.branch = branch;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getBookName()
    {
        return bookName;
    }

    public String getBookISBN()
    {
        return bookISBN;
    }

    public String getBookLocation()
    {
        return location;
    }

    public String getBranch()
    {
        return branch;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }
}
