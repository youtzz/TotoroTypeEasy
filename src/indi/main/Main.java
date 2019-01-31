/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indi.main;

import indi.frame.loginFrame.LoginFrame;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.InsetsUIResource;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 *
 * @author JOJO
 */
public class Main {

    public static void main(String args[]) {

        /* Set the BeautyEye look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        //  BeautyEye是一款Java Swing跨平台外观（look and feel）实现；
        //  得益于Android的GUI基础技术，BeautyEye的实现完全不同于其它外观；
        //  BeautyEye是免费的，您可以研究、学习甚至商业用途。
        //  代码托管： https://github.com/JackJiang2011/beautyeye       
        try {

            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
            UIManager.put("RootPane.setupButtonVisible", false);
            UIManager.put("TabbedPane.tabAreaInsets", new InsetsUIResource(0, 0, 0, 0));
//            UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(0, 0, 2, 0));
//            UIManager.put("TabbedPane.tabInsets", new InsetsUIResource(3, 10, 9, 10));
            Font frameTitleFont = (Font) UIManager.get("InternalFrame.titleFont");
            frameTitleFont = frameTitleFont.deriveFont(Font.PLAIN);
            UIManager.put("InternalFrame.titleFont", frameTitleFont);
//            UIManager.put("InternalFrame.titleFont", new Font("Monospaced", Font.BOLD, 15));

            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

}
