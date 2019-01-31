package indi.frame.mainFrame.interFace;

import java.util.Map;

/**
 * 定义了打字面板 (XXTypePanel) 中所需要的接口
 * @author JOJO
 */
public interface ITypeUtilFunction {

    /**
     *
     * @param fileDir
     * @param fileName
     */
    public void initGame(final String fileDir, final String fileName);

    /**
     *
     * @param map
     * @param index
     * @return
     */
    public String handleTextString(Map<Integer, String> map, int index);
}
