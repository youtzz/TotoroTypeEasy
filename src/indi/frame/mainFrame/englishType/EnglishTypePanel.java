package indi.frame.mainFrame.englishType;

import static indi.frame.mainFrame.MainFrame.centerPanel;
import static indi.frame.mainFrame.MainFrame.homePageCardLayout;
import indi.model.daoModel.LoginSuccess;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author JOJO
 */
public class EnglishTypePanel extends javax.swing.JPanel {
    
    /**
     *  卡片布局管理器 englishTypeCardLayout 负责 EnglishTypePanel.cardLayoutPanel 下3张页面
     *  "首页" = "homePagePanel, homePagePanelCard", 
     *  "单词练习" = "wordTestPanel, wordTestPanelCard", 
     *  "句子练习" = "sentenseTestPanel, sentenseTestPanelCard", 
     *  "文章练习" = "articleTestPanel, articleTestPanelCard"
     */
    public static CardLayout englishTypeCardLayout;
    private LoginSuccess loginSuccess;
    public EnglishTypePanel(LoginSuccess loginSuccess) {
        englishTypeCardLayout = new CardLayout();
        this.loginSuccess = loginSuccess;
        initComponents();
        resultPanel1.repaintResultPanel(loginSuccess);
    }
    //  这个无参的构造函数是为netBeans IDE 准备的，否则将此面板直接拖拽到另一个面板可能产生未知错误
    public EnglishTypePanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardLayoutPanel = new JPanel();
        homePagePanel = new JPanel();
        daohang_Label = new JLabel();
        wordTestButton = new JButton();
        sentenceTestButton = new JButton();
        articleTestButton = new JButton();
        returnButton = new JButton();
        resultPanel1 = new ResultPanel();
        background_Label = new JLabel();
        wordTestPanel1 = new WordTestPanel();

        FormListener formListener = new FormListener();

        //  之所以设置两次布局管理器，是因为 netbeans IDE
        //  自动生成的代码中的 card管理器是匿名的，且无法修改
        cardLayoutPanel.setLayout(new CardLayout());
        cardLayoutPanel.setLayout(englishTypeCardLayout);

        homePagePanel.setLayout(null);

        daohang_Label.setFont(new Font("等线", 0, 18)); // NOI18N
        daohang_Label.setText("首页 > 英语打字");
        homePagePanel.add(daohang_Label);
        daohang_Label.setBounds(100, 22, 140, 20);

        wordTestButton.setFont(wordTestButton.getFont().deriveFont(wordTestButton.getFont().getStyle() | Font.BOLD));
        wordTestButton.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/englishType/imgs/englishType_wordTest_icon.png"))); // NOI18N
        wordTestButton.setText("单词练习");
        wordTestButton.setHorizontalTextPosition(SwingConstants.CENTER);
        wordTestButton.setIconTextGap(19);
        wordTestButton.setMargin(new Insets(2, 14, 15, 14));
        wordTestButton.setVerticalAlignment(SwingConstants.BOTTOM);
        wordTestButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        wordTestButton.addActionListener(formListener);
        homePagePanel.add(wordTestButton);
        wordTestButton.setBounds(146, 235, 166, 164);

        sentenceTestButton.setFont(sentenceTestButton.getFont().deriveFont(sentenceTestButton.getFont().getStyle() | Font.BOLD));
        sentenceTestButton.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/englishType/imgs/englishType_sentenseTest_ion.png"))); // NOI18N
        sentenceTestButton.setText("句子练习");
        sentenceTestButton.setFocusPainted(false);
        sentenceTestButton.setHorizontalTextPosition(SwingConstants.CENTER);
        sentenceTestButton.setIconTextGap(19);
        sentenceTestButton.setMargin(new Insets(2, 14, 15, 14));
        sentenceTestButton.setVerticalAlignment(SwingConstants.BOTTOM);
        sentenceTestButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        sentenceTestButton.addActionListener(formListener);
        homePagePanel.add(sentenceTestButton);
        sentenceTestButton.setBounds(402, 235, 166, 164);

        articleTestButton.setFont(articleTestButton.getFont().deriveFont(articleTestButton.getFont().getStyle() | Font.BOLD));
        articleTestButton.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/englishType/imgs/englishType_articleTest_icon.png"))); // NOI18N
        articleTestButton.setText("文章练习");
        articleTestButton.setFocusPainted(false);
        articleTestButton.setHorizontalTextPosition(SwingConstants.CENTER);
        articleTestButton.setIconTextGap(19);
        articleTestButton.setMargin(new Insets(2, 14, 15, 14));
        articleTestButton.setVerticalAlignment(SwingConstants.BOTTOM);
        articleTestButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        articleTestButton.addActionListener(formListener);
        homePagePanel.add(articleTestButton);
        articleTestButton.setBounds(659, 235, 166, 164);

        returnButton.setText("返回");
        returnButton.addActionListener(formListener);
        homePagePanel.add(returnButton);
        returnButton.setBounds(20, 20, 69, 29);
        homePagePanel.add(resultPanel1);
        resultPanel1.setBounds(190, 60, 630, 100);

        background_Label.setIcon(new ImageIcon(getClass().getResource("/indi/frame/mainFrame/englishType/imgs/englishType_background.png"))); // NOI18N
        homePagePanel.add(background_Label);
        background_Label.setBounds(0, 0, 980, 566);

        cardLayoutPanel.add(homePagePanel, "homePagePanelCard");
        cardLayoutPanel.add(wordTestPanel1, "wordTestPanelCard");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(cardLayoutPanel, GroupLayout.PREFERRED_SIZE, 980, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(cardLayoutPanel, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements ActionListener {
        FormListener() {}
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == wordTestButton) {
                EnglishTypePanel.this.wordTestButtonActionPerformed(evt);
            }
            else if (evt.getSource() == sentenceTestButton) {
                EnglishTypePanel.this.sentenceTestButtonActionPerformed(evt);
            }
            else if (evt.getSource() == articleTestButton) {
                EnglishTypePanel.this.articleTestButtonActionPerformed(evt);
            }
            else if (evt.getSource() == returnButton) {
                EnglishTypePanel.this.returnButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void wordTestButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_wordTestButtonActionPerformed
        englishTypeCardLayout.show(cardLayoutPanel, "wordTestPanelCard");
    }//GEN-LAST:event_wordTestButtonActionPerformed

    private void sentenceTestButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_sentenceTestButtonActionPerformed
        JOptionPane.showMessageDialog(this, "功能尚未开放，敬请期待！", "提示", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_sentenceTestButtonActionPerformed

    private void articleTestButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_articleTestButtonActionPerformed
        JOptionPane.showMessageDialog(this, "功能尚未开放，敬请期待！", "提示", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_articleTestButtonActionPerformed

    private void returnButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        homePageCardLayout.show(centerPanel, "homePagePanelCard");
    }//GEN-LAST:event_returnButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton articleTestButton;
    private JLabel background_Label;
    public static JPanel cardLayoutPanel;
    private JLabel daohang_Label;
    private JPanel homePagePanel;
    private ResultPanel resultPanel1;
    private JButton returnButton;
    private JButton sentenceTestButton;
    private JButton wordTestButton;
    private WordTestPanel wordTestPanel1;
    // End of variables declaration//GEN-END:variables
}
