/*
 *Author:曾仲
 *Contributer: 吴凯发 杨光
 */

package ForeGround;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
*
* 在XML文档中实现增、删、改、查
* @author Stone
*
*/
public class HandleXML {
/**
  * 采用DOM方式
  * @author Stone
  *
  */

  /**
   * 获得doc对象
   * @param fileName
   * @return
   */
    public Document getDocument(String fileName){
       Document document = null;
       try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(new File(fileName));

       }catch(Exception e){
        e.printStackTrace();
       }

        return document;
  }
  /**
   * 将改动持久到文件
   * @param doc
   * @param distFileName
   */
  public void modifyFile(Document doc,String distFileName){
       try{
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer tfer = tf.newTransformer();
            DOMSource dsource = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File("books.xml"));
            tfer.transform(dsource, sr);
       }catch(Exception e){
            e.printStackTrace();
       }
 }
  /**
   * 解析
   * @param fileName
   */
  public void paseXml(String fileName){
        Document document = getDocument(fileName);
        NodeList nodeList = document.getElementsByTagName("Book");
        for(int i=0;i<nodeList.getLength();i++){
            StringBuilder sb = new StringBuilder();

            sb.append("id："+document.getElementsByTagName("id").item(i).getFirstChild().getNodeValue());
            sb.append(" , ");
            sb.append("BookName："+document.getElementsByTagName("BookName").item(i).getFirstChild().getNodeValue());
            sb.append(" , ");
            sb.append("BookISBN："+document.getElementsByTagName("BookISBN").item(i).getFirstChild().getNodeValue());
            sb.append(" , ");
            sb.append("BookAuthor："+document.getElementsByTagName("BookAuthor").item(i).getFirstChild().getNodeValue());
            sb.append(" , ");
            sb.append("BookBranch："+document.getElementsByTagName("BookBranch").item(i).getFirstChild().getNodeValue());
            sb.append(" , ");
            sb.append("BookLocation："+document.getElementsByTagName("BookLocation").item(i).getFirstChild().getNodeValue());
            System.out.println(sb.toString());
        }
  }
  /**
   * 创建一个新的书籍
   * @param item
   */
  public void addNewNode(BookItem item){
    try{
        Document document = getDocument("books.xml");
        NodeList nodeList = document.getElementsByTagName("Books");
        //创建新的节点
        Node bookNode = document.createElement("Book");
        Node idNode = document.createElement("id");
        idNode.appendChild(document.createTextNode(item.getId()));
        Node nameNode = document.createElement("BookName");
        nameNode.appendChild(document.createTextNode(item.getBookName()));
        Node ISBNNode = document.createElement("BookISBN");
        ISBNNode.appendChild(document.createTextNode(item.getBookISBN()));
        Node authorNode = document.createElement("BookAuthor");
        authorNode.appendChild(document.createTextNode(item.getAuthor()));
        Node branchNode = document.createElement("BookBranch");
        branchNode.appendChild(document.createTextNode(item.getBranch()));
        Node locationNode = document.createElement("BookLocation");
        locationNode.appendChild(document.createTextNode(item.getBookLocation()));
        // 添加节点
        bookNode.appendChild(idNode);
        bookNode.appendChild(nameNode);
        bookNode.appendChild(ISBNNode);
        bookNode.appendChild(authorNode);
        bookNode.appendChild(branchNode);
        bookNode.appendChild(locationNode);
        nodeList.item(0).appendChild(bookNode);
        // 此时真正的处理将新数据添加到文件中（磁盘）
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer tfer = tf.newTransformer();
        DOMSource dsource = new DOMSource(document);
        StreamResult sr = new StreamResult(new File("books.xml"));
        tfer.transform(dsource, sr);
   }catch(Exception e){
        e.printStackTrace();
   }

   paseXml("books.xml");
  }
  /**
   * 删除一个节点
   * @param id
   */
  public void deleteNode(String id){
        Document document = getDocument("books.xml");

        NodeList nodeList = document.getElementsByTagName("id");
        for(int i=0;i<nodeList.getLength();i++){
            String value = nodeList.item(i).getFirstChild().getTextContent();
            if(id!=null && id.equalsIgnoreCase(value)){
                Node parentNode = nodeList.item(i).getParentNode();
                document.getFirstChild().removeChild(parentNode);
            }
        }
        modifyFile(document,"books.xml");
  }
  
  /**
   * 根据id修改某个节点的内容
   * @param id
   */
  public void updateNode(String id){

   Document document = getDocument("books.xml");
   NodeList nodeList = document.getElementsByTagName("BookName");
   for(int i=0;i<nodeList.getLength();i++){
        String value = nodeList.item(i).getFirstChild().getTextContent();
        if(id!=null && id.equalsIgnoreCase(value)){
            Node parentNode = nodeList.item(i).getParentNode();
            NodeList nl = parentNode.getChildNodes();
            for(int j=0;j<nl.getLength();j++){
                String modifyNode= nl.item(j).getNodeName();
                if(modifyNode.equalsIgnoreCase("BookISBN")){
                    nl.item(j).getFirstChild().setTextContent("111-111-111-111");
                }
            }
        }
   }
   modifyFile(document,"books.xml");
  }

/**
 * 读取xml文件
 * @return
 */
public List<BookItem> readLocalList(String paraName, String paraValue)
    {
    try
        {
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();  //获取一个DocumentBuilderFactory的实例
            DocumentBuilder db=dbf.newDocumentBuilder(); //使用工厂生成一个DocumentBuilder
            File file=new File("books.xml"); //打开文件，获得句柄
            Document doc=db.parse(file); //使用dom解析xml文件
            NodeList products=doc.getElementsByTagName("Book"); //将所有节点名为product的节点取出
            Element productElement; //元素对象，声明

            List<BookItem> list = new LinkedList<BookItem>();

            for (int i = 0; i < products.getLength(); i++) //循环处理对象
            {
                BookItem itemTemp = new BookItem();

                productElement=(Element)products.item(i); //将每个Product赋值给元素

                //String BookName=productElement.getAttribute("BookName"); //取得元素的属性“id” <product id="a">……取得这样的a
               // itemTemp.setBookName(BookName);

                String id=doc.getElementsByTagName("id").item(i).getFirstChild().getNodeValue(); //取得第i个节点的第一个字节点，取得节点中的值<name>book</name>取得这样的book
                itemTemp.setId(id);

                String BookName=doc.getElementsByTagName("BookName").item(i).getFirstChild().getNodeValue(); //取得第i个节点的第一个字节点，取得节点中的值<name>book</name>取得这样的book
                itemTemp.setBookName(BookName);

                String BookISBN=doc.getElementsByTagName("BookISBN").item(i).getFirstChild().getNodeValue(); //取得第i个节点的第一个字节点，取得节点中的值<name>book</name>取得这样的book
                itemTemp.setBookISBN(BookISBN);

                String BookAuthor=doc.getElementsByTagName("BookAuthor").item(i).getFirstChild().getNodeValue(); //取得第i个节点的第一个字节点，取得节点中的值<name>book</name>取得这样的book
                itemTemp.setAuthor(BookAuthor);

                String BookBranch=doc.getElementsByTagName("BookBranch").item(i).getFirstChild().getNodeValue(); //取得第i个节点的第一个字节点，取得节点中的值<name>book</name>取得这样的book
                itemTemp.setBranch(BookBranch);

                String BookLocation=doc.getElementsByTagName("BookLocation").item(i).getFirstChild().getNodeValue();
                itemTemp.setLocation(BookLocation);

                if(paraName.equals("id") )
                {
                    if (itemTemp.getId().equals(paraValue))
                        list.add(itemTemp);
                }

                if(paraName.equals("BookName"))
                {
                    if (itemTemp.getBookName().equals(paraValue))
                        list.add(itemTemp);
                }

                if(paraName.equals("BookAuthor"))
                {
                    if (itemTemp.getAuthor().equals(paraValue))
                        list.add(itemTemp);
                }

                if(paraName.equals("BookBranch"))
                {
                    if (itemTemp.getBranch().equals(paraValue))
                        list.add(itemTemp);
                }

                if(paraName.equals("BookISBN"))
                {
                    if (itemTemp.getBookISBN().equals(paraValue))
                        list.add(itemTemp);
                }

                if(paraName.isEmpty())
                {
                        list.add(itemTemp);
                }
            }
            return list;
         }
    catch(Exception e)
         {
                e.printStackTrace();
                return null;
         }
    }
    public String getTheLastBookItemID()
   {
        try
        {
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();  //获取一个DocumentBuilderFactory的实例
            DocumentBuilder db=dbf.newDocumentBuilder(); //使用工厂生成一个DocumentBuilder
            File file=new File("books.xml"); //打开文件，获得句柄
            Document doc=db.parse(file); //使用dom解析xml文件
            NodeList products=doc.getElementsByTagName("Book"); //将所有节点名为product的节点取出
            int length =  products.getLength();
            String id=doc.getElementsByTagName("id").item(length -1).getFirstChild().getNodeValue(); //取得第i个节点的第一个字节点，取得节点中的值<name>book</name>取得这样的book
            System.out.println(id+"done");
            return id;
       }
        catch(Exception e)
         {
                e.printStackTrace();
                return null;
         }
    }
}



