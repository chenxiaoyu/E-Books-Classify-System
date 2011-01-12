/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddFriend.java
 *
 * Created on 2011-1-11, 20:49:31
 */

package booksystem;

import BackGround.ClassGlobal;
import BackGround.DatabaseConnector;
import BackGround.ErrorCode;
import BackGround.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class AddFriend extends javax.swing.JFrame {

    /** Creates new form AddFriend */
    public AddFriend() {
        
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("添加朋友");

        jLabel1.setFont(new java.awt.Font("黑体", 1, 14));
        jLabel1.setText("朋友的名字");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 1, 12));
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("若申请朋友被拒绝，则不可以再次申请。");

        jButton1.setText("确定");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        DatabaseConnector db_connector = DatabaseConnector.getDatabaseConnectorInstance();
        ClassGlobal cg = ClassGlobal.getInstance();
        db_connector.connect();
        String myName = cg.GlobalUser.getName();
        String friendName = jTextField1.getText().toString();
        if(friendName == null)
        {
            ShowMsg smg = new ShowMsg();
            cg.messageToShow = "请输入要添加的朋友姓名！";
            smg.setLocationRelativeTo(this);
            smg.setVisible(true);
        }
        else if(db_connector.isValidName(friendName) != ErrorCode.Success)
        {
            ShowMsg smg = new ShowMsg();
            cg.messageToShow = "该用户不存在！";
            smg.setLocationRelativeTo(this);
            smg.setVisible(true);
        }
        else
        {
            int request_state = db_connector.requestToBeFriend(cg.GlobalUser.getName(), friendName);

            if(request_state == ErrorCode.FriendRecordAlreadyExists)
            {
                ShowMsg smg = new ShowMsg();
                cg.messageToShow = "已存在该好友！";
                smg.setLocationRelativeTo(this);
                smg.setVisible(true);
            }
            else if(request_state == ErrorCode.Success)
            {
                ShowMsg smg = new ShowMsg();
                cg.messageToShow = "好友已添加！";
                smg.setLocationRelativeTo(this);
                smg.setVisible(true);
                db_connector.close();
                this.dispose();
            }
        }

    }//GEN-LAST:event_jButton1MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFriend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}