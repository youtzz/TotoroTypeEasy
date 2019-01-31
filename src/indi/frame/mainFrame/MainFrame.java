package indi.frame.mainFrame;

import indi.dao.HandleLoginSuccess;
import indi.frame.mainFrame.englishType.EnglishTypePanel;
import indi.model.daoModel.LoginSuccess;
import indi.model.daoModel.Loginer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author JOJO
 */
public class MainFrame extends javax.swing.JFrame {
    
    /**
     *  卡片布局管理器 homePageCardLayout 负责 MainFrame.centerPanel 下5张页面
     *  "首页" = "homePagePanel, homePagePanelCard", 
     *  "新手入门" = "newHandPanel, newHandPanelCard", 
     *  "英语打字" = "englishTypePanel, englishTypePanelCard", 
     *  "中文打字" = "pinyinTypePanel, pinyinTypePanelCard"
     *  "五笔打字" = "wubiTypePanel", wubiTypePanelCard"
     */
    public static CardLayout homePageCardLayout;
    private LoginSuccess loginSuccess;

    public MainFrame(Loginer loginer) {
        loginSuccess = new LoginSuccess(loginer);
        //  连接数据库，为 loginSucess 对象的各种属性赋值
        new HandleLoginSuccess().setLoginSuccessDate(loginSuccess);
        homePageCardLayout = new CardLayout();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new JLayeredPane();
        settingInternalFrame = new SettingInternalFrame();
        topPanel = new JPanel();
        titleBar_Label = new JLabel();
        buttonPanel = new JPanel();
        aboutButton = new JButton();
        settingButton = new JButton();
        jLabel1 = new JLabel();
        centerPanel = new JPanel();
        homePagePanel = new JPanel();
        aboutInternalFrame = new AboutInternalFrame();
        englishType_Button = new JButton();
        pinyinType_Button = new JButton();
        wubiType_Button = new JButton();
        newHand_Button = new JButton();
        homePageBackground_Label = new JLabel();
        englishTypePanel = new EnglishTypePanel(loginSuccess);

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welocme~龙猫打字通");
        setResizable(false);

        settingInternalFrame.setVisible(false);
        jLayeredPane1.setLayer(settingInternalFrame, JLayeredPane.DRAG_LAYER);
        jLayeredPane1.add(settingInternalFrame);
        settingInternalFrame.setBounds(270, 80, 188, 347);

        titleBar_Label.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/imgs/topPanel/newTitle.png"))); // NOI18N

        GroupLayout topPanelLayout = new GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(topPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(titleBar_Label)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(topPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(titleBar_Label)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLayeredPane1.add(topPanel);
        topPanel.setBounds(0, 0, 980, 104);

        buttonPanel.setBackground(new Color(105, 168, 236));
        buttonPanel.setLayout(null);

        aboutButton.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/imgs/buttonPanel/buttonPanel_message_icon.png"))); // NOI18N
        aboutButton.setToolTipText("关于");
        aboutButton.setFocusPainted(false);
        aboutButton.setRolloverEnabled(false);
        aboutButton.addActionListener(formListener);
        buttonPanel.add(aboutButton);
        aboutButton.setBounds(80, 1, 30, 29);

        settingButton.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/imgs/buttonPanel/buttonPanel_setting_icon.png"))); // NOI18N
        settingButton.setToolTipText("设置");
        settingButton.setFocusPainted(false);
        settingButton.setRolloverEnabled(false);
        settingButton.addActionListener(formListener);
        buttonPanel.add(settingButton);
        settingButton.setBounds(940, 1, 30, 29);

        jLabel1.setText("联系我们");
        buttonPanel.add(jLabel1);
        jLabel1.setBounds(5, 0, 80, 30);

        jLayeredPane1.add(buttonPanel);
        buttonPanel.setBounds(0, 670, 980, 30);

        //  之所以设置两次布局管理器，是因为 netbeans IDE
        //  自动生成的代码中的 card管理器是匿名的，且无法修改
        centerPanel.setLayout(new CardLayout());
        centerPanel.setLayout(homePageCardLayout);

        homePagePanel.setLayout(null);

        aboutInternalFrame.setVisible(false);
        homePagePanel.add(aboutInternalFrame);
        aboutInternalFrame.setBounds(290, 60, 410, 300);

        englishType_Button.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/imgs/centerPanel/newhomePage_englishType_icon.png"))); // NOI18N
        englishType_Button.setFocusPainted(false);
        englishType_Button.addActionListener(formListener);
        homePagePanel.add(englishType_Button);
        englishType_Button.setBounds(310, 230, 162, 162);

        pinyinType_Button.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/imgs/centerPanel/newhomePage_pinyinType_icon.png"))); // NOI18N
        pinyinType_Button.setFocusPainted(false);
        pinyinType_Button.addActionListener(formListener);
        homePagePanel.add(pinyinType_Button);
        pinyinType_Button.setBounds(520, 230, 162, 162);

        wubiType_Button.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/imgs/centerPanel/newhomePage_wubiType_icon.png"))); // NOI18N
        wubiType_Button.setFocusPainted(false);
        wubiType_Button.addActionListener(formListener);
        homePagePanel.add(wubiType_Button);
        wubiType_Button.setBounds(730, 230, 162, 162);

        newHand_Button.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/imgs/centerPanel/newhomePage_newHand_icon.png"))); // NOI18N
        newHand_Button.setFocusPainted(false);
        newHand_Button.addActionListener(formListener);
        homePagePanel.add(newHand_Button);
        newHand_Button.setBounds(99, 232, 162, 162);

        homePageBackground_Label.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/imgs/centerPanel/newhomePage_background.png"))); // NOI18N
        homePagePanel.add(homePageBackground_Label);
        homePageBackground_Label.setBounds(0, 0, 980, 566);

        centerPanel.add(homePagePanel, "homePagePanelCard");
        centerPanel.add(englishTypePanel, "englishTypePanelCard");

        jLayeredPane1.add(centerPanel);
        centerPanel.setBounds(0, 104, 980, 566);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements ActionListener {
        FormListener() {}
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == settingButton) {
                MainFrame.this.settingButtonActionPerformed(evt);
            }
            else if (evt.getSource() == englishType_Button) {
                MainFrame.this.englishType_ButtonActionPerformed(evt);
            }
            else if (evt.getSource() == pinyinType_Button) {
                MainFrame.this.pinyinType_ButtonActionPerformed(evt);
            }
            else if (evt.getSource() == wubiType_Button) {
                MainFrame.this.wubiType_ButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newHand_Button) {
                MainFrame.this.newHand_ButtonActionPerformed(evt);
            }
            else if (evt.getSource() == aboutButton) {
                MainFrame.this.aboutButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void englishType_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishType_ButtonActionPerformed
        homePageCardLayout.show(centerPanel, "englishTypePanelCard");
    }//GEN-LAST:event_englishType_ButtonActionPerformed

    private void pinyinType_ButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_pinyinType_ButtonActionPerformed
        JOptionPane.showMessageDialog(this, "功能尚未开放，敬请期待！", "提示", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_pinyinType_ButtonActionPerformed

    private void wubiType_ButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_wubiType_ButtonActionPerformed
        JOptionPane.showMessageDialog(this, "功能尚未开放，敬请期待！", "提示", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_wubiType_ButtonActionPerformed

    private void newHand_ButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_newHand_ButtonActionPerformed
        JOptionPane.showMessageDialog(this, "功能尚未开放，敬请期待！", "提示", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_newHand_ButtonActionPerformed

    private void settingButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed
        if (settingInternalFrame.isVisible() == false) {
            settingInternalFrame.setLocation(775, 320);
            settingInternalFrame.setVisible(true);
        } else if (settingInternalFrame.isVisible() == true) {
            settingInternalFrame.setVisible(false);
        }
    }//GEN-LAST:event_settingButtonActionPerformed

    private void aboutButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        if (aboutInternalFrame.isVisible() == false) {
            aboutInternalFrame.setLocation(300, 120);
            aboutInternalFrame.setVisible(true);
        } else if (aboutInternalFrame.isVisible() == true) {
            aboutInternalFrame.setVisible(false);
        }
    }//GEN-LAST:event_aboutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(new LoginSuccess(new Loginer())).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton aboutButton;
    private AboutInternalFrame aboutInternalFrame;
    private JPanel buttonPanel;
    public static JPanel centerPanel;
    private EnglishTypePanel englishTypePanel;
    private JButton englishType_Button;
    private JLabel homePageBackground_Label;
    private JPanel homePagePanel;
    private JLabel jLabel1;
    private JLayeredPane jLayeredPane1;
    private JButton newHand_Button;
    private JButton pinyinType_Button;
    private JButton settingButton;
    private SettingInternalFrame settingInternalFrame;
    private JLabel titleBar_Label;
    private JPanel topPanel;
    private JButton wubiType_Button;
    // End of variables declaration//GEN-END:variables
}
