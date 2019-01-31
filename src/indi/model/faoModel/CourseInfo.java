package indi.model.faoModel;

import java.util.Map;

/**
 *
 * @author JOJO
 */
public class CourseInfo {
    
    private String courseType;
    private String courseName;
    private String wordCount;
    private Map<Integer, String> textMap;
    
    public String getCourseType() {
        return courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getWordCount() {
        return wordCount;
    }

    public Map<Integer, String> getMap() {
        return textMap;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setWordCount(String wordCount) {
        this.wordCount = wordCount;
    }

    public void setMap(Map<Integer, String> textMap) {
        this.textMap = textMap;
    }
}
