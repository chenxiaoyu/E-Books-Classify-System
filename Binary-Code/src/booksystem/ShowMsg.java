/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ShowMsg.java
 *
 * Created on 2010-12-12, 15:25:21
 */

package booksystem;

/**
 *
 * @author Administrator
 */
public class ShowMsg extends javax.swing.JFrame {

    /** Creates new form ShowMsg */
    public ShowMsg() {
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

        showMsgText = new javax.swing.JLabel();
        showMsgBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        showMsgText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showMsgText.setText("Error");

        showMsgBtn.setText("Ok");
        showMsgBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMsgBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showMsgText)
                    .addComponent(showMsgBtn))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(showMsgText)
                .addGap(30, 30, 30)
                .addComponent(showMsgBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMsgBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMsgBtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_showMsgBtnMouseClicked
 public void getPerblem(String per)
    {
        showMsgText.setText(per);
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowMsg().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton showMsgBtn;
    private javax.swing.JLabel showMsgText;
    // End of variables declaration//GEN-END:variables

}
