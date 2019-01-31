package indi.fao;

import indi.model.faoModel.CourseInfo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 此类负责处理用户选择的课程文件
 *
 * @author JOJO
 */
public class HandleCourseJsonFile {

    /**
     * 此静态方法会读取文件，将文件信息存储到 CourseInfo 对象中，并返回这个对象
     *
     * @param fileDir 文件所在的路径
     * @param fileName 文件名
     * @return CourseInfo 对象
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static CourseInfo getCourseInfo(final String fileDir, final String fileName) throws FileNotFoundException, IOException {
        CourseInfo courseInfo = new CourseInfo();

        String filePath = fileDir + fileName;  //  设置文件路径
        Map<Integer, String> map = new TreeMap<>();

        StringBuilder stringBuffer;
        //  建立文件缓冲流 try-resourse-catch
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            stringBuffer = new StringBuilder();
            //  读取文件， 并将读取的内容放置 stringBuffer
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuffer.append(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        //  将 StringBuffer 转化成 JSON 对象
        JSONObject jsonObject = new JSONObject(stringBuffer.toString());
        JSONArray jSONArray = jsonObject.getJSONObject("content").getJSONArray("item");

        for (int i = 0; i < jSONArray.length(); i++) {
            map.put(jSONArray.getJSONObject(i).getInt("id"),
                    jSONArray.getJSONObject(i).getString("comparision"));
        }

        //  设置 courseInfo 所有变量值
        courseInfo.setCourseName(fileName);
        courseInfo.setCourseType(fileDir);
        courseInfo.setWordCount(jsonObject.getJSONObject("courseInfo").getString("wordCount"));
        courseInfo.setMap(map);

        return courseInfo;
    }

}
