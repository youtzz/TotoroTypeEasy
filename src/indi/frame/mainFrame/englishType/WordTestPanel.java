package indi.frame.mainFrame.englishType;

import indi.fao.HandleCourseJsonFile;
import indi.fao.HandleWordTestType;
import indi.frame.mainFrame.interFace.ITypeUtilFunction;
import indi.model.faoModel.CourseFileDirReader;
import indi.model.faoModel.CourseFileDirReader.*;
import indi.model.faoModel.CourseInfo;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JOJO 单词测试的面板 此处有 BUG,发生的地点在JTabbedPane处，JTabbedPane初始化需要一个
 * Object[][]对象， 我将 此Object[][]对象通过model包中的CourseFileReader类的方法获得
 * 如果Object获得对象的方法放置到JTabbedPane初始化之前，再将此面板通过netBeansIDE拖放至父面板 EnglishTypePanel时
 * IDE会产生 "无法产生实例化" 的BUG,暂时不清楚BUG产生的原因 目前解决的方法时在此类的构造函数中初始化object[][]对象
 * @author JOJO DATA 2019/1/17/15:59 怀疑此 bug 与 netBeans
 * 编辑器的GUI设计模式的工作原理，或与文件路径设置有关 将文件路径设置为绝对路径后不会报错
 */
public final class WordTestPanel extends javax.swing.JLayeredPane implements ITypeUtilFunction {

    Reader fileReader = null;
    static char limitCharArry[] = new char[80];  //  每次只能从流中读取 80个字符
    static char nextLimiCharArry[] = new char[80];
    static int time = 0;  //  游戏时间
    static int right = 0;  //  游戏，
    CourseInfo courseInfo = null;  //  选择的课程信息
    StringBuffer outPutTextFieldStringBuffer = null;  //  输出文本框中的文字
    int index = 0;

    public WordTestPanel() {
        initComponents();
        initGame(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseCourse_InternalFrame = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        批量添加 = new javax.swing.JMenu();
        textChangeListener = new TextListener();
        inPutTextField = new javax.swing.JTextField();
        outPutTextField = new javax.swing.JTextField();
        returnButton = new javax.swing.JButton();
        showCourse_TextField = new javax.swing.JTextField();
        chooseCourse_Button = new javax.swing.JButton();
        backGround_jLabel = new javax.swing.JLabel();
        result_Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        keyBoardPanel1 = new indi.frame.mainFrame.englishType.keyBoardPanel();
        jLabel2 = new javax.swing.JLabel();

        chooseCourse_InternalFrame.setResizable(true);
        chooseCourse_InternalFrame.setVisible(false);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        CourseFileDirReader courseFileReader = new CourseFileDirReader(Choise.ENGLISHTYPE_WORDTEST);
        chooseCourse_Table.setModel(new javax.swing.table.DefaultTableModel(
            courseFileReader.getFileNameDoubleList(),
            new String [] {
                "", ""
            }) );
            chooseCourse_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            chooseCourse_Table.getTableHeader().setReorderingAllowed(false);
            /*  将表格的标题设置为空  */
            chooseCourse_Table.getTableHeader().setVisible(false);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setPreferredSize(new Dimension(0, 0));
            chooseCourse_Table.getTableHeader().setDefaultRenderer(renderer);
            chooseCourse_Table.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    chooseCourse_TableMouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(chooseCourse_Table);

            jTabbedPane1.addTab("默认课程", jScrollPane2);
            jTabbedPane1.addTab("自定义课程", jPanel2);

            chooseCourse_InternalFrame.getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

            jMenu1.setText("添加");

            jMenu2.setText("单个添加");
            jMenu1.add(jMenu2);

            批量添加.setText("批量添加");
            jMenu1.add(批量添加);

            jMenuBar1.add(jMenu1);

            chooseCourse_InternalFrame.setJMenuBar(jMenuBar1);

            setLayer(chooseCourse_InternalFrame, javax.swing.JLayeredPane.DRAG_LAYER);
            add(chooseCourse_InternalFrame);
            chooseCourse_InternalFrame.setBounds(540, 70, 410, 270);

            inPutTextField.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
            inPutTextField.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    inPutTextFieldKeyPressed(evt);
                }
            });
            (inPutTextField.getDocument()).addDocumentListener(textChangeListener);
            add(inPutTextField);
            inPutTextField.setBounds(46, 120, 888, 37);

            outPutTextField.setEditable(false);
            outPutTextField.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
            add(outPutTextField);
            outPutTextField.setBounds(46, 80, 888, 37);

            returnButton.setText("返回");
            returnButton.setToolTipText("返回上级");
            returnButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    returnButtonActionPerformed(evt);
                }
            });
            add(returnButton);
            returnButton.setBounds(20, 20, 69, 29);

            showCourse_TextField.setEditable(false);
            showCourse_TextField.setText("jTextField3");
            add(showCourse_TextField);
            showCourse_TextField.setBounds(790, 10, 105, 37);

            chooseCourse_Button.setText("...");
            chooseCourse_Button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    chooseCourse_ButtonActionPerformed(evt);
                }
            });
            add(chooseCourse_Button);
            chooseCourse_Button.setBounds(900, 10, 30, 37);

            backGround_jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indi/frame/mainFrame/englishType/imgs/gradient_background.png"))); // NOI18N
            add(backGround_jLabel);
            backGround_jLabel.setBounds(0, 0, 980, 566);
            setLayer(result_Panel, javax.swing.JLayeredPane.PALETTE_LAYER);
            add(result_Panel);
            result_Panel.setBounds(80, 170, 840, 60);

            jLabel1.setFont(new java.awt.Font("等线", 0, 18)); // NOI18N
            jLabel1.setText("首页 > 英语打字 > 单词练习");
            setLayer(jLabel1, javax.swing.JLayeredPane.PALETTE_LAYER);
            add(jLabel1);
            jLabel1.setBounds(100, 22, 240, 20);
            setLayer(keyBoardPanel1, javax.swing.JLayeredPane.PALETTE_LAYER);
            add(keyBoardPanel1);
            keyBoardPanel1.setBounds(46, 250, 890, 300);

            jLabel2.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
            jLabel2.setText("选择课程:");
            setLayer(jLabel2, javax.swing.JLayeredPane.PALETTE_LAYER);
            add(jLabel2);
            jLabel2.setBounds(700, 20, 80, 21);
        }// </editor-fold>//GEN-END:initComponents

    /*  "返回按钮" 的ActionPerformed, 用于返回上级面板  */
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        //  点击返回按钮后，重新初始化游戏数据，目的是为了清空用户上一次的输入
        initGame("course/englishType/wordTest/",showCourse_TextField.getText());  //  从showCourse_TextField中得到课程名
        EnglishTypePanel.englishTypeCardLayout.show(
                EnglishTypePanel.cardLayoutPanel, "homePagePanelCard");
    }//GEN-LAST:event_returnButtonActionPerformed

    /*  "课程选择按钮" 的ActionPerformed, 用于显示"选课"面板  */
    private void chooseCourse_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCourse_ButtonActionPerformed
        if (chooseCourse_InternalFrame.isVisible() == false) {
            chooseCourse_InternalFrame.setVisible(true);
        } else if (chooseCourse_InternalFrame.isVisible() == true) {
            chooseCourse_InternalFrame.setVisible(false);
        }
    }//GEN-LAST:event_chooseCourse_ButtonActionPerformed

    /*  课程列表的鼠标事件，用于切换打字课程  */
    private void chooseCourse_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseCourse_TableMouseClicked
        //得到选中的行列的索引值
        int row = chooseCourse_Table.getSelectedRow();
        int column = chooseCourse_Table.getSelectedColumn();
        //得到选中的单元格的值，表格中都是字符串
        Object value = chooseCourse_Table.getValueAt(row, column);
        String info = value.toString();
        if (info.equals("") == false) {
            showCourse_TextField.setText(info);
            initGame("course/englishType/wordTest/", info);  //  重新初始化游戏数据
            chooseCourse_InternalFrame.setVisible(false);  //  隐藏内联窗口
        }
    }//GEN-LAST:event_chooseCourse_TableMouseClicked

    private void inPutTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inPutTextFieldKeyPressed
        //  这个事件预留的目的是用于启动计时器
    }//GEN-LAST:event_inPutTextFieldKeyPressed

    /**
     * 初始化游戏数据 对文本框，游戏时间，游戏成绩进行初始化
     *
     * @param fileDir
     * @param fileName 读取的文件名
     */ //  仅实现文本框初始化
    @Override
    public void initGame(String fileDir, String fileName) {
        index = 0;

        //  如果存在 courseInfo 实例，将实例中的map清除
        //  担心 map 内存溢出的问题，不知道这样是否有效，姑且写着
        if (courseInfo != null) {
            courseInfo.getMap().clear();
            courseInfo.setMap(null);
        }

        //  如果参数为NULL, 对组件面板进行首次启动初始化
        if (fileDir == null && fileName == null) {
            /*  获取上一次的历史记录， 因为进度问题，这里没有写相关功能代码 */
            fileDir = /*System.getProperty("user.dir") + */ "course/englishType/wordTest/";
            fileName = "2000个最常用单词1.json";
        }

        try {
            courseInfo = HandleCourseJsonFile.getCourseInfo(fileDir, fileName);
            //  应该传递的是 String 还是 StringBuffer? 没有好的结论
            outPutTextFieldStringBuffer = new StringBuffer(handleTextString(courseInfo.getMap(), index));
            //  设置输出文本框中的文字
            outPutTextField.setText(outPutTextFieldStringBuffer.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "警告,当前选择的练习文件有误,请检查该文件或重新选择课程",
                    "警告，文件有误", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(WordTestPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //  设置 显示课程名文本框框 中的文字
            showCourse_TextField.setText(fileName);
            showCourse_TextField.setCaretPosition(0);  //  将光标定位到开头
            //  设置输入文本框
            if (inPutTextField.isEditable() == false) {  // 判断输入文本框是否可编辑 
                inPutTextField.setEditable(true);
            }
            inPutTextField.setText(null);  //  将输入文本框中的文字清空
            inPutTextField.requestFocus(); //  将焦点设置到输入文本框 
        }

        /* 初始化游戏进度面板 <--> 待实现 */
    }

    /*  测试此面板  */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new WordTestPanel());
        frame.setVisible(true);
    }

    /**
     * test
     *
     * @param map
     * @param index
     * @return
     */
    @Override
    public String handleTextString(Map<Integer, String> map, int index) {
        //  index 为 key,从 map 中读取 value, 将这个 value 拼接到 StringBuffer中
        StringBuffer stringBuffer = new StringBuffer(90);
        while (stringBuffer.length() < 80) {  //  此处的 80 是指显示文字的文本框一次显示80个字符最为合适
            if (map.containsKey(index)) {  //  如果 index 存在,进行拼接
                stringBuffer.append(map.get(index)).append(" ");  //  每个单词之间用空格隔开
                index++;
            } else {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);  //  删掉末尾的空格

        //  如果stringBuffer 长度大于80，需要退格
        while (stringBuffer.length() > 80) {
            index--;  //  得到末尾的这个单词的下标
            int start = stringBuffer.length() - map.get(index).length();  //  删除的起始位置
            int end = stringBuffer.length();  //  删除的末尾位置
            stringBuffer.delete(start, end);  //  删除这个单词, 该方法删除包含start，不包含end索引值的区间
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);  //  删除末尾的空格
        }
        
        this.index = index;  //  更新 index 的值
        return stringBuffer.toString();
    }

    /**
     * 内部类，实现Document监视器方法 注：此处使用绝对路径是不严谨的！碍于进度问题暂时不修改
     * 预计添加的功能，让用户自己选择打字音效，或是关闭音效
     */
    // <editor-fold defaultstate="collapsed" desc="TextListener Code"> 
    class TextListener implements DocumentListener {

        //创建audioclip对象
        AudioClip audioClipType = null;
        AudioClip audioClipError = null;
        //  文本光标位置
        int inPutTextFieldCaretPosition = 0;

        //  初始化两种音效媒体
        TextListener() {
            File file = new File("C:\\Users\\JOJO\\Desktop\\newTypeEasy\\music\\type.wav");
            try {
                //将file转换为url
                audioClipType = Applet.newAudioClip(file.toURI().toURL());
            } catch (MalformedURLException ex) {
                Logger.getLogger(WordTestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            file = new File("C:\\Users\\JOJO\\Desktop\\newTypeEasy\\music\\error.wav");
            try {
                //将file转换为url
                audioClipError = Applet.newAudioClip(file.toURI().toURL());
            } catch (MalformedURLException ex) {
                Logger.getLogger(WordTestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /**
         * 实现接口中的方法，此方法用作当用户在文本框中输入时，程序做出的响应：
         * 1、当用户插入（输入）字符时，判断输入正确还是错误，播放对应音效
         * 2、当文本光标长度与输出文本框中文字长度相等时，更新输出文本框
         * 3、当到达文件（打字的文件）末尾时，结算此次打字成绩
         * 注：DocumentEvent 中不能对swing对象直接修改，需要在新线程中修改
         */
        @Override
        public void insertUpdate(DocumentEvent e) {
            new Thread() {
                @Override
                public void run() {
                    audioClipType.play();
                }
            }.start();
            inPutTextFieldCaretPosition = inPutTextField.getCaretPosition();
            // @test <><><><><><><><><><> @test 
            System.out.println(inPutTextField.getCaretPosition() + " " + outPutTextFieldStringBuffer.length());
            if (inPutTextFieldCaretPosition >= (outPutTextFieldStringBuffer.length())) {
                outPutTextFieldStringBuffer.setLength(0);
                if (courseInfo.getMap().containsKey(index)) {
                    outPutTextFieldStringBuffer.append(handleTextString(courseInfo.getMap(), index));
                    java.awt.EventQueue.invokeLater(() -> {
                        outPutTextField.setText(outPutTextFieldStringBuffer.toString());
                        inPutTextField.setText(null);
                    });
                } else {
                    JOptionPane.showMessageDialog(WordTestPanel.this, "游戏结束，此次得分", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
                    java.awt.EventQueue.invokeLater(() -> {
                        inPutTextField.setEditable(false);  //  将输入文本框设置为不可选中
                    });
                }
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            //  当删除字符时播放音效
            new Thread() {
                public void run() {
                    audioClipError.play();
                }
            }.start();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    } // </editor-fold>

    private TextListener textChangeListener;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGround_jLabel;
    private javax.swing.JButton chooseCourse_Button;
    private javax.swing.JInternalFrame chooseCourse_InternalFrame;
    private final javax.swing.JTable chooseCourse_Table = new javax.swing.JTable();
    private javax.swing.JTextField inPutTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private indi.frame.mainFrame.englishType.keyBoardPanel keyBoardPanel1;
    private javax.swing.JTextField outPutTextField;
    private javax.swing.JPanel result_Panel;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField showCourse_TextField;
    private javax.swing.JMenu 批量添加;
    // End of variables declaration//GEN-END:variables
}
