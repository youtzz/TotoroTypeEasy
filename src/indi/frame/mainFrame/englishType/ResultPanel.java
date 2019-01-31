/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indi.frame.mainFrame.englishType;

import indi.model.daoModel.LoginSuccess;

/**
 *
 * @author JOJO
 * 此面板用于显示用户的最高成绩和平均成绩
 * 默认显示欢迎界面，如果不是新用户，显示成绩
 */
public class ResultPanel extends javax.swing.JPanel {

    public ResultPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showResult_Label = new javax.swing.JLabel();
        showLastLoginDate_Label = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        showResult_Label.setFont(new java.awt.Font("幼圆", 1, 24)); // NOI18N
        showResult_Label.setText("欢迎您来到龙猫打字通！");
        add(showResult_Label);
        showResult_Label.setBounds(20, 20, 840, 30);

        showLastLoginDate_Label.setFont(new java.awt.Font("等线", 1, 18)); // NOI18N
        showLastLoginDate_Label.setText("建议您先从\"单词练习开始\"，打好基本功，循环渐进，趣味学习！");
        add(showLastLoginDate_Label);
        showLastLoginDate_Label.setBounds(20, 70, 870, 20);
    }// </editor-fold>//GEN-END:initComponents
    
    /*  如果用户不是新用户，即存在游戏记录，使jlabel显示成绩  */
    public void repaintResultPanel(LoginSuccess loginSuccess) {
        int bestResult = loginSuccess.getBestResult();
        int averageResult = loginSuccess.getAverageResult();
        String lastLoginDate = loginSuccess.getLastLoginDate();
        System.out.println(loginSuccess.getBestResult()+" "+ loginSuccess.getAverageResult() + "" +loginSuccess.getUserName() +
                " " + loginSuccess.getLastLoginDate() + "" +loginSuccess.getPassWord());
        if ( (bestResult!=0) && (averageResult!=0) && (lastLoginDate!=null)) {
            showResult_Label.setText("最高成绩："+bestResult+"字/每分钟 " 
                    +"平均速度："+averageResult+"字/每分钟");
            showLastLoginDate_Label.setText("上次登录时间 "+lastLoginDate+" 建议您每天坚持打字练习！");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel showLastLoginDate_Label;
    private javax.swing.JLabel showResult_Label;
    // End of variables declaration//GEN-END:variables
}
