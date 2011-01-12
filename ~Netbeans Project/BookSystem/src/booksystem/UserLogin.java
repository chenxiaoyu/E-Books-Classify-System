/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserLogin.java
 *
 * Created on 2010-12-12, 15:05:17
 */

package booksystem;

import BackGround.ClassGlobal;
import BackGround.DatabaseConnector;
import BackGround.ErrorCode;
import BackGround.User;
import javax.swing.JOptionPane;


/**
 *
 * @author Administrator
 */
public class UserLogin extends javax.swing.JFrame {
    private String userName;
    private String passWord;
    /** Creates new form UserLogin */
    public UserLogin() {
         userName = "yg";
         passWord = "123";
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

        jLabelUserName = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        buttonOK = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        show_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("用户登录");

        jLabelUserName.setText("用户名：");

        jLabelPassword.setText("密码：");

        buttonOK.setText("确定");
        buttonOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonOKMouseClicked(evt);
            }
        });

        buttonClear.setText("清除信息");
        buttonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUserName)
                    .addComponent(jLabelPassword))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(show_error)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonClear))
                    .addComponent(jPasswordField)
                    .addComponent(jTextFieldUserName))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUserName)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(show_error)
                    .addComponent(buttonOK)
                    .addComponent(buttonClear))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOKMouseClicked
        // TODO add your handling code here:
        String userNameTemp = jTextFieldUserName.getText().toString();
        String passWordTemp = jPasswordField.getText().toString();
        

        DatabaseConnector db_connector = DatabaseConnector.getDatabaseConnectorInstance();
        int con_state = db_connector.connect();

        int login_state = db_connector.login(userNameTemp, passWordTemp);
        if(login_state == ErrorCode.UserNotExists)
        {
            show_error.setText("用户不存在！");
            db_connector.close();
        }
        else if(login_state == ErrorCode.PasswordInvalid)
        {
            show_error.setText("密码不正确！");
            db_connector.close();
        }
        else
        {
            ClassGlobal cg = ClassGlobal.getInstance();
            if(cg.GlobalUser == null)
            {
                cg.GlobalUser = new User();
            }
            cg.GlobalUser.setName(userNameTemp);
            cg.GlobalUser.setPassword(passWordTemp);
            cg.loginState = true;
            cg.messageToShow = "欢迎登录！"+userNameTemp;
            JOptionPane.showMessageDialog(this, cg.messageToShow);
            this.dispose();
            db_connector.close();
        }
    }//GEN-LAST:event_buttonOKMouseClicked

    private void buttonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClearMouseClicked
        // TODO add your handling code here:
        //this.dispose();
        jTextFieldUserName.setText(null);
        jPasswordField.setText(null);
    }//GEN-LAST:event_buttonClearMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonOK;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUserName;
    private javax.swing.JLabel show_error;
    // End of variables declaration//GEN-END:variables

}