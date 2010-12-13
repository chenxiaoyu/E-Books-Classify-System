/*
 *Author:曾仲
 *Contributer: 杨光 胡程远
 */
/*
 * MainFrame.java
 *
 * Created on 2010-12-12, 14:03:14
 */

package booksystem;
import javax.swing.*;
import ForeGround.BookItem;
import ForeGround.HandleXML;
import ForeGround.BookTableModel;
import javax.swing.table.TableModel;
import java.util.*;
/**
 *
 * @author Administrator
 */
public class MainFrame extends javax.swing.JFrame {

    private BookTableModel bookTableModel;
    private List<BookItem> bookList;
    private HandleXML xmlHander;
    /** Creates new form MainFrame */
    public MainFrame() {
       
        xmlHander = new HandleXML();
        bookList = xmlHander.readLocalList("", "");
        bookTableModel = new BookTableModel();
        bookTableModel.setBookList(bookList);
        initComponents();
        jTableBooks.updateUI();
    }

    private void updateBookTable()
    {
        bookList = xmlHander.readLocalList("", "");
        bookTableModel.setBookList(bookList);
        jTableBooks.updateUI();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonImportToLocalList = new javax.swing.JButton();
        jButtonDeleteFromLocalList = new javax.swing.JButton();
        jButtonAddBranch = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jLabelBranch = new javax.swing.JLabel();
        jComboBoxBranch = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBooks = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemImportBook = new javax.swing.JMenuItem();
        jMenuItemOpenBook = new javax.swing.JMenuItem();
        jMenuItemCreateBranch = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSaveLocalList = new javax.swing.JMenuItem();
        jMenuItemLoadLocalList = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuUser = new javax.swing.JMenu();
        jMenuLogIn = new javax.swing.JMenu();
        jMenuSignUp = new javax.swing.JMenu();
        jMenuChangeInfo = new javax.swing.JMenu();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAboutUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonImportToLocalList.setText("<<Import");
        jButtonImportToLocalList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonImportToLocalListMouseClicked(evt);
            }
        });

        jButtonDeleteFromLocalList.setText(">>Delete");
        jButtonDeleteFromLocalList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteFromLocalListMouseClicked(evt);
            }
        });

        jButtonAddBranch.setText("AddBranch");

        jButtonUpdate.setText("Update");
        jButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateMouseClicked(evt);
            }
        });

        jLabelBranch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBranch.setText("Branch");

        jComboBoxBranch.setEditable(true);
        jComboBoxBranch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTableBooks.setModel(bookTableModel);
        jScrollPane1.setViewportView(jTableBooks);

        jMenuFile.setText("File");

        jMenuItemImportBook.setText("ImportBooks");
        jMenuItemImportBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemImportBookMousePressed(evt);
            }
        });
        jMenuFile.add(jMenuItemImportBook);

        jMenuItemOpenBook.setText("OpenBook");
        jMenuItemOpenBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemOpenBookMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemOpenBookMousePressed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenBook);

        jMenuItemCreateBranch.setText("CreateBranch");
        jMenuFile.add(jMenuItemCreateBranch);
        jMenuFile.add(jSeparator1);

        jMenuItemSaveLocalList.setText("SaveLocalBooklist");
        jMenuFile.add(jMenuItemSaveLocalList);

        jMenuItemLoadLocalList.setText("LoadLocalBoollist");
        jMenuFile.add(jMenuItemLoadLocalList);
        jMenuFile.add(jSeparator2);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemExitMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemExitMousePressed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar1.add(jMenuFile);

        jMenuEdit.setText("Edit");
        jMenuBar1.add(jMenuEdit);

        jMenuUser.setText("User");

        jMenuLogIn.setText("LogIn");
        jMenuLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuLogInMouseClicked(evt);
            }
        });
        jMenuUser.add(jMenuLogIn);

        jMenuSignUp.setText("SignUp");
        jMenuSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSignUpMouseClicked(evt);
            }
        });
        jMenuUser.add(jMenuSignUp);

        jMenuChangeInfo.setText("ChangeInfo");
        jMenuUser.add(jMenuChangeInfo);

        jMenuBar1.add(jMenuUser);

        jMenuHelp.setText("Help");

        jMenuItemAboutUs.setText("AboutUs");
        jMenuItemAboutUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemAboutUsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemAboutUsMousePressed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAboutUs);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonImportToLocalList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDeleteFromLocalList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImportToLocalList)
                    .addComponent(jButtonDeleteFromLocalList))
                .addGap(18, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddBranch)
                    .addComponent(jButtonUpdate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBranch)
                    .addComponent(jComboBoxBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuLogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuLogInMouseClicked
        // TODO add your handling code here:
        UserLogin newLog = new UserLogin();
        newLog.setVisible(true);
    }//GEN-LAST:event_jMenuLogInMouseClicked

    private void jMenuSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSignUpMouseClicked
        // TODO add your handling code here:
        ShowMsg smg = new ShowMsg();
        smg.setVisible(true);
    }//GEN-LAST:event_jMenuSignUpMouseClicked

    private void jMenuItemAboutUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemAboutUsMouseClicked
        // TODO add your handling code here:
        //String about = "Team: Muse-Master"+"\n"+"Members:陈晓宇 胡程远 李志勋 吴凯发 杨光 曾仲";
        String about = "Team: Muse-Master";
        ShowMsg msg = new ShowMsg();
        msg.getPerblem(about);
        msg.setVisible(true);
    }//GEN-LAST:event_jMenuItemAboutUsMouseClicked

    private void jMenuItemExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemExitMouseClicked

    private void jMenuItemOpenBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemOpenBookMouseClicked
        // TODO add your handling code here:
        FileChooser fc = new FileChooser();
        fc.setVisible(true);
    }//GEN-LAST:event_jMenuItemOpenBookMouseClicked

    private void jMenuItemAboutUsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemAboutUsMousePressed
        // TODO add your handling code here:

        String about = "Team: Muse-Master";
        ShowMsg msg = new ShowMsg();
        msg.getPerblem(about);
        msg.setVisible(true);
    }//GEN-LAST:event_jMenuItemAboutUsMousePressed

    private void jMenuItemExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemExitMousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItemExitMousePressed

    private void jMenuItemOpenBookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemOpenBookMousePressed
        // TODO add your handling code here:
        FileChooser fc = new FileChooser();
        fc.setVisible(true);
    }//GEN-LAST:event_jMenuItemOpenBookMousePressed

    private void jButtonImportToLocalListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImportToLocalListMouseClicked
        // TODO add your handling code here:
        ImportLocalBook ilb = new ImportLocalBook();
        ilb.setVisible(true);
    }//GEN-LAST:event_jButtonImportToLocalListMouseClicked

    private void jButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseClicked
        // TODO add your handling code here:
        updateBookTable();
    }//GEN-LAST:event_jButtonUpdateMouseClicked

    private void jButtonDeleteFromLocalListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteFromLocalListMouseClicked
        // TODO add your handling code here:
        if( jTableBooks.getSelectedRow() == -1 )//No book is selected
            JOptionPane.showMessageDialog(this, "Please choose the book you want to delete!");
        else
        {
            if( JOptionPane.YES_OPTION== showDeleteDialog())
            {
                //updateBookTable();
                int selectedRow = jTableBooks.getSelectedRow();
                String selectedBookID = bookList.get(selectedRow).getId();
                xmlHander.deleteNode(selectedBookID);
                jTableBooks.clearSelection();
                jButtonUpdateMouseClicked(evt);
            }
        }
    }//GEN-LAST:event_jButtonDeleteFromLocalListMouseClicked

    private void jMenuItemImportBookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemImportBookMousePressed
        // TODO add your handling code here:
        ImportLocalBook ilb = new ImportLocalBook();
        ilb.setVisible(true);
    }//GEN-LAST:event_jMenuItemImportBookMousePressed

    private int showDeleteDialog()
    {
        Object[] options = { "OK", "CANCEL" };
        int returnVal = JOptionPane.showOptionDialog(this, "Are you SURE to remove this book?", "Warning",
        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
        null, options, options[0]);
        return returnVal;
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddBranch;
    private javax.swing.JButton jButtonDeleteFromLocalList;
    private javax.swing.JButton jButtonImportToLocalList;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBoxBranch;
    private javax.swing.JLabel jLabelBranch;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuChangeInfo;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAboutUs;
    private javax.swing.JMenuItem jMenuItemCreateBranch;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemImportBook;
    private javax.swing.JMenuItem jMenuItemLoadLocalList;
    private javax.swing.JMenuItem jMenuItemOpenBook;
    private javax.swing.JMenuItem jMenuItemSaveLocalList;
    private javax.swing.JMenu jMenuLogIn;
    private javax.swing.JMenu jMenuSignUp;
    private javax.swing.JMenu jMenuUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTableBooks;
    // End of variables declaration//GEN-END:variables

}
