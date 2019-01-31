package indi.frame.loginFrame;

import indi.dao.HandleInsertRegisterDate;
import indi.model.daoModel.Registrar;
import java.util.Date;
import javax.swing.*;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 * @author JOJO
 * 此类是一个内联窗口，用于登陆窗口中的注册事项
 */
public class RegisterInternalFrame extends javax.swing.JInternalFrame {
    
    private indi.model.daoModel.Registrar register;  //  model 对象
    
    /**
     * Creates new form RegisteInternalFrame
     */
    public RegisterInternalFrame() {
        initComponents();     
    }
    
    /* 以下代码由 netbeans 设计模式自动生成 */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userName_TextField = new javax.swing.JTextField();
        userPassword_TextField_original = new javax.swing.JTextField();
        userPassword_TextField_repeated = new javax.swing.JTextField();
        regist_jButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Sing Up");
        setVisible(true);

        regist_jButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        regist_jButton.setForeground(new java.awt.Color(240, 240, 240));
        regist_jButton.setText("注册");
        regist_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regist_jButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Password again");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(regist_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userPassword_TextField_repeated)
                        .addComponent(userPassword_TextField_original)
                        .addComponent(userName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPassword_TextField_original, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(userPassword_TextField_repeated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(regist_jButton)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /* "注册" 按钮的 ActionPerformed */
    private void regist_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regist_jButtonActionPerformed
        /**
         *  响应用户注册时，先由checkUserEnterDate 函数判断用户的输入是否合理
         *  再由HandleInsertDate类向数据库导入数据
         */
        if (checkUserEnterDate() == true) {
            register = new Registrar();
            register.setUserName(userName_TextField.getText());
            register.setPassWord(userPassword_TextField_original.getText());
            //  以年月日形式获取当前注册日期
            register.setRegisterDate(String.format("%tY-%<tm-%<td", new Date()));
            checkRegistSuccess();
        }
    }//GEN-LAST:event_regist_jButtonActionPerformed
    
    /**
     * 
     *  方法调用后，检查用户姓名，用户输入的密码，用户输入的确认密码是否正确
     *  正确返回 true , 有误返回 false
     */
    // <editor-fold defaultstate="collapsed" desc="private boolean checkUserEnterDate () 方法 Code">
    private boolean checkUserEnterDate () {
        String checkUsername, checkUserPassword_original, checkUserPassword_repeated;
        checkUsername = userName_TextField.getText();
        checkUserPassword_original = userPassword_TextField_original.getText();
        checkUserPassword_repeated = userPassword_TextField_repeated.getText();
        
        if (checkUsername.equals("")) {
            JOptionPane.showMessageDialog(this, "用户名不能为空，请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
        
        } else if (checkUsername.matches("[a-z|A-Z|0-9|_]+") == false) {
            JOptionPane.showMessageDialog(this, "不能输入数字或字母或下划线以外的字符，请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
        
        } else if (checkUsername.length() > 8) {
            JOptionPane.showMessageDialog(this, "用户名不能超过8个字符，请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
        
        } else if (checkUserPassword_original.equals("")) {
            JOptionPane.showMessageDialog(this, "密码不能为空，请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
        
        } else if (checkUserPassword_original.matches("[a-z|A-Z|0-9|\\p{Punct}]+") == false) {
            JOptionPane.showMessageDialog(this, "不能输入非法字符，请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
        
        } else if (checkUserPassword_original.length() >= 14) {
            JOptionPane.showMessageDialog(this, "密码不能超过14位，请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
        
        } else if (checkUserPassword_repeated.equals("")) {
            JOptionPane.showMessageDialog(this, "请再次输入密码", "输入有误", JOptionPane.WARNING_MESSAGE);
        } else if (checkUserPassword_original.equals(checkUserPassword_repeated) != true) {
            JOptionPane.showMessageDialog(this, "两次密码不相等，请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
        } else {
            return true;
        }
        
        return false;
    } //</editor-fold>
    
    /**
     *  
     *  方法调用后,HandleInsertRegisterDate 类中的 writeRegisterModel() 方法返回值
     *  判断注册是否成功
     */
    // <editor-fold defaultstate="collapsed" desc="private void checkRegistSuccess () 方法 Code">
    private void checkRegistSuccess () {
        //  利用 HandleInsertRegisterDate 类中的 writeRegisterModel 方法返回值进行判断
        int loginSuccess = new HandleInsertRegisterDate().writeRegisterModel(register);
        
        switch (loginSuccess) {
            case 0:     //  此值为新注册用户名已存在
                JOptionPane.showMessageDialog(this, "用户名已存在,请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
                break;
            case -1:    //  此值为数据库写入语句出错     
                JOptionPane.showMessageDialog(this, "数据库写入失败,请检查数据库配置是否正确", "写入有误", JOptionPane.WARNING_MESSAGE);
                break;
            case 1:     //  此值为注册成功
                JOptionPane.showMessageDialog(this, "注册成功！,请记住用户名："+userName_TextField.getText(), "注册成功", JOptionPane.INFORMATION_MESSAGE);
                setEmptyAndSetFocus();  //  清空用户的历史输入
                RegisterInternalFrame.this.setVisible(false);  //  关闭当前注册窗口  
                break;
            default:
                break;
        }
    }  // </editor-fold>
    
    /**
     * 
     * 此方法用于将内联窗口中的三个文本框清空，并将焦点设置到 userName_TextField 上
     */
    public void setEmptyAndSetFocus () {
        userName_TextField.setText("");
        userPassword_TextField_original.setText("");
        userPassword_TextField_repeated.setText("");
        userName_TextField.requestFocus();
    }
    
    // 以下为 netBeans IDE 设计模式下自动生成的代码
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton regist_jButton;
    private javax.swing.JTextField userName_TextField;
    private javax.swing.JTextField userPassword_TextField_original;
    private javax.swing.JTextField userPassword_TextField_repeated;
    // End of variables declaration//GEN-END:variables
}
