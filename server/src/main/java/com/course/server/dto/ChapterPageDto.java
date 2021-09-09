package com.course.server.dto;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/9
 */
public class ChapterPageDto extends PageDto{
    private String courseId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "ChapterPageDto{" +
                "courseId='" + courseId + '\'' +
                "} " + super.toString();
    }
}
