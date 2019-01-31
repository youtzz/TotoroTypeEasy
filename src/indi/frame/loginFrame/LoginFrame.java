package indi.frame.loginFrame;

import indi.dao.HandleLoginDate;
import indi.frame.mainFrame.MainFrame;
import indi.model.daoModel.Loginer;
import indi.model.daoModel.RootLoginer;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author JOJO
 */
public class LoginFrame extends javax.swing.JFrame {

    private indi.model.daoModel.Loginer loginer;  //  登陆 model 对象
    
    public LoginFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        /*
        //  利用此代码可以让背景图以面板绘制的方式程序
        jLayeredPane = new javax.swing.JLayeredPane() {
            @Override
            public void paintComponent (Graphics g) {
                super.paintComponent(g);
                ImageIcon image=new ImageIcon(getClass().getResource("/loginFrame/login_background.jpg"));        //获取图像
                image.setImage(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_FAST)); //调整图像的分辨率以适应容器
                image.paintIcon(this, g,0, 0);
            }
        };
        */
        jLayeredPane = new JLayeredPane();
        login_Button = new JButton();
        userName_jLabel = new JLabel();
        userPassword_jLabel = new JLabel();
        userName_jTextField = new JTextField();
        regist_button = new JButton();
        title_jLabel = new JLabel();
        userPassword_jPasswordField = new JPasswordField();
        registerInternalFrame = new RegisterInternalFrame();
        rootLogin_button = new JButton();
        background_jLabel = new JLabel();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome~龙猫打字通");

        login_Button.setIcon(new ImageIcon(getClass().getResource("/indi/frame/loginFrame/imgs/loginFrame_loginButton_icon.jpg"))); // NOI18N
        login_Button.addActionListener(formListener);
        jLayeredPane.add(login_Button);
        login_Button.setBounds(272, 340, 198, 28);

        userName_jLabel.setIcon(new ImageIcon(getClass().getResource("/indi/frame/loginFrame/imgs/loginFrame_name_icon.png"))); // NOI18N
        jLayeredPane.add(userName_jLabel);
        userName_jLabel.setBounds(190, 210, 60, 40);

        userPassword_jLabel.setIcon(new ImageIcon(getClass().getResource("/indi/frame/loginFrame/imgs/loginFrame_password_icon.png"))); // NOI18N
        jLayeredPane.add(userPassword_jLabel);
        userPassword_jLabel.setBounds(190, 280, 60, 30);

        userName_jTextField.setFont(new Font("Monospaced", 0, 20)); // NOI18N
        userName_jTextField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        userName_jTextField.setOpaque(false);
        jLayeredPane.add(userName_jTextField);
        userName_jTextField.setBounds(270, 218, 198, 28);

        regist_button.setText("注册");
        regist_button.addActionListener(formListener);
        jLayeredPane.add(regist_button);
        regist_button.setBounds(190, 460, 69, 29);

        title_jLabel.setIcon(new ImageIcon(getClass().getResource("/indi/frame/loginFrame/imgs/loginFrame_title.png"))); // NOI18N
        jLayeredPane.add(title_jLabel);
        title_jLabel.setBounds(144, 0, 440, 110);

        userPassword_jPasswordField.setForeground(new Color(105, 168, 236));
        userPassword_jPasswordField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        userPassword_jPasswordField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        userPassword_jPasswordField.setOpaque(false);
        jLayeredPane.add(userPassword_jPasswordField);
        userPassword_jPasswordField.setBounds(270, 280, 198, 28);

        registerInternalFrame.setVisible(false);
        jLayeredPane.setLayer(registerInternalFrame, JLayeredPane.DRAG_LAYER);
        jLayeredPane.add(registerInternalFrame);
        registerInternalFrame.setBounds(230, 100, 295, 332);

        rootLogin_button.setText("游客登陆");
        rootLogin_button.addActionListener(formListener);
        jLayeredPane.add(rootLogin_button);
        rootLogin_button.setBounds(290, 460, 105, 29);

        background_jLabel.setIcon(new ImageIcon(getClass().getResource("/indi/frame/loginFrame/imgs/loginFrame_background.jpg"))); // NOI18N
        jLayeredPane.add(background_jLabel);
        background_jLabel.setBounds(0, 0, 700, 500);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLayeredPane, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLayeredPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements ActionListener {
        FormListener() {}
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == login_Button) {
                LoginFrame.this.login_ButtonActionPerformed(evt);
            }
            else if (evt.getSource() == regist_button) {
                LoginFrame.this.regist_buttonActionPerformed(evt);
            }
            else if (evt.getSource() == rootLogin_button) {
                LoginFrame.this.rootLogin_buttonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents
    
    /* "登陆" 按钮的 ActionPerfomed */
    private void login_ButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_login_ButtonActionPerformed
        /**
        * 按下此按钮时,先通过 checkUserEnterDate() 方法检测用户输入格式是否正确 随后 为 Loginer类 对象
        * loginer 赋值 调用 checkLoginSuccess() 方法判断登陆是否成功
        */
        if (checkUserEnterDate() == true) {
            loginer = new Loginer();
            loginer.setUserName(userName_jTextField.getText());
            loginer.setPassWord(String.valueOf(userPassword_jPasswordField.getPassword()));
            checkLoginSuccess();
        }
    }//GEN-LAST:event_login_ButtonActionPerformed

    /* "注册" 按钮的 ActionPerformed */
    private void regist_buttonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_regist_buttonActionPerformed
        if (registerInternalFrame.isVisible() == false) {
            registerInternalFrame.setVisible(true);
            //  每次打开内联窗体时，重新设置内联窗体位置
            registerInternalFrame.setLocation(230, 100);
            //  每次打开内联窗体时，将文本框清空,并将重新设置焦点
            registerInternalFrame.setEmptyAndSetFocus();
        } else if (registerInternalFrame.isVisible() == true) {
            registerInternalFrame.setVisible(false);
        }
    }//GEN-LAST:event_regist_buttonActionPerformed

    /*  "游客登陆" 按钮的 ActionPerformed  */
    private void rootLogin_buttonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rootLogin_buttonActionPerformed
        LoginFrame.this.setVisible(false);  //  隐藏当前窗口
        LoginFrame.this.dispose();          //  并释放线程
        /*  开启新的 MainFrame类 GUi线程，并传入一个匿名 RootLoginer 对象  */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame(new RootLoginer()).setVisible(true);
        });
    }//GEN-LAST:event_rootLogin_buttonActionPerformed

    /**
     *
     * 此方法用于检测用户输入的数据格式是否有误 如果有误，显示 Dialog 对话框，并将焦点聚焦至输入有误的 textField 对象
     */
    private boolean checkUserEnterDate() {
        if (userName_jTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "用户名不能为空，请重新输入", "输入有误", JOptionPane.WARNING_MESSAGE);
            userName_jTextField.requestFocus();
        } else if (String.valueOf(userPassword_jPasswordField.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "请输入密码！", "输入有误", JOptionPane.WARNING_MESSAGE);
            userPassword_jPasswordField.requestFocus();
        } else {
            return true;
        }

        return false;
    }

    /**
     *
     * 此方法用于通过 checkUserEnterdate() 方法确保用户输入格式正确后,将登陆信息与数据库匹配 接收来自
     * HandHandleLoginDate().checkLoginDate() 方法的返回值 给出对应的 Dialog 对话框
     * 当用户登陆成功后，将当前 LoginFrame 类窗口进程关闭， 创建新的 MainFrame类 GUi线程
     */
    private void checkLoginSuccess() {
        
        int loginSuccess = new HandleLoginDate().checkLoginDate(loginer);

        switch (loginSuccess) {
            case 0:  //  此值为用户输入用户名不存在
                JOptionPane.showMessageDialog(this, "用户名不存在，请重新输入", "用户名不存在", JOptionPane.WARNING_MESSAGE);
                break;
            case -1:    //  此值为用户输入用户名存在，但密码输入错误
                JOptionPane.showMessageDialog(this, "密码错误，请重新输入", "密码错误", JOptionPane.WARNING_MESSAGE);
                break;
            case 1:     //  此值为用户输入用户名，密码皆正确
                JOptionPane.showMessageDialog(this, "登陆成功！", "登陆成功", JOptionPane.INFORMATION_MESSAGE);
                LoginFrame.this.setVisible(false);  //  隐藏当前窗口
                LoginFrame.this.dispose();          //  并释放线程               
                /*  开启新的 MainFrame类 GUi线程  */
                java.awt.EventQueue.invokeLater(() -> {
                    new MainFrame(loginer).setVisible(true);
                });
                break;
            default:
                break;
        }
    }

    /* 以下为 NetBeans IDE 自动生成的 GUi 组件变量声明代码 */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel background_jLabel;
    private JLayeredPane jLayeredPane;
    private JButton login_Button;
    private JButton regist_button;
    private RegisterInternalFrame registerInternalFrame;
    private JButton rootLogin_button;
    private JLabel title_jLabel;
    private JLabel userName_jLabel;
    private JTextField userName_jTextField;
    private JLabel userPassword_jLabel;
    private JPasswordField userPassword_jPasswordField;
    // End of variables declaration//GEN-END:variables
}
