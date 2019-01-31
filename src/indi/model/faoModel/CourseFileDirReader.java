package indi.model.faoModel;

import java.io.*;

/**
 *
 * @author JOJO 此类用于封装课程选项
 * ！注：因为进度原因，此处文件地址暂时使用了绝对路径，项目打成 jar包后是会报错的！
 */
public class CourseFileDirReader {

    /*  常量枚举  */
    public static enum Choise {
        //  英文打字下的 单词 练习
        ENGLISHTYPE_WORDTEST,
        //  英文打字下的 句子 练习
        ENGLISHTYPE_SENTENSETEST,
        //  英文打字下的 文章 练习
        ENGLISHTYPE_ARTICLETEST;
    }

    private String[] fileNameList;
    private Object[][] object;
    private File dirFile;

    public CourseFileDirReader(Choise choise) {
        if (null != choise) switch (choise) {
            case ENGLISHTYPE_WORDTEST:
                setDirFileAndlist("course\\englishType\\wordTest");
                break;
            case ENGLISHTYPE_SENTENSETEST:
                setDirFileAndlist("course\\englishType\\sentenseTest");
                break;
            case ENGLISHTYPE_ARTICLETEST:
                setDirFileAndlist("course\\englishType\\articleTest");
                break;
            default:
                break;
        }
    }

    /*  得到类的 fileNameList 成员变量  */
    public String[] getFileNameList() {
        return fileNameList;
    }
    /*  得到类的 object[][] 成员变量  */ 
    public Object[][] getFileNameDoubleList() {
        return object;
    }
    public int getObjectRow () {
        return object.length;
    }
    
    /*  得到类的 fileNameList 成员变量，将其转化为二维字符串数组  */
    public void setFileNameDoubleList() {

        int row = fileNameList.length / 2;  //  计算数组的长度
        if ((fileNameList.length % 2) != 0) {  //  如果文件数为奇数，则数组增加一行
            row += 1;
        }
        object = new String[row][2];  //  新建二维数组

        int times = fileNameList.length / 2;  //  计算循环的次数
        int b = 0, count = 0;
        for (row = 0; count < times; count++) {
            //  交替赋值
            object[row][0] = fileNameList[b];
            b++;
            object[row][1] = fileNameList[b];
            row++;
            b++;
        }
        
        //  如果文件数量是奇数，为多维数组的最后一行赋值
        if ((fileNameList.length % 2) != 0) {
            object[times][0] = fileNameList[b];
            object[times][1] = "";
        }
    }

    private void setDirFileAndlist(String dirFileString) {
        dirFile = new File(dirFileString);
        fileNameList = dirFile.list(new CourseFileDirReader.FileAccept());
        setFileNameDoubleList();
    }

    /*  用内部类实现 FileAccept接口  */
    private class FileAccept implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".json");
        }

    }

    // test this class
//    public static void main(String[] args) {
//        String strs[] = new CourseFileDirReader(Choise.ENGLISHTYPE_WORDTEST).getFileNameList();
//        int x = new CourseFileDirReader(Choise.ENGLISHTYPE_WORDTEST).getFileNameList().length;
//        for (int i = 0; i < x; i++) {
//            System.out.println(strs[i]);
//        }
//        System.out.println("该文件夹下一共有" + x + "个.txt文件");
//
//        String strs2[][] = new CourseFileDirReader(Choise.ENGLISHTYPE_WORDTEST).getFileNameDoubleList();
//        for (int a = 0; a < 5; a++) {
//            for (int b = 0; b < 2; b++) {
//                System.out.println(strs2[a][b]);
//            }
//        }
//    }


}
