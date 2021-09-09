package com.course.server.dto;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/9
 */
public class SectionPageDto extends PageDto{
    private String courseId;
    private String chapterId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    public String toString() {
        return "SectionPageDto{" +
                "page=" + page +
                ", size=" + size +
                ", total=" + total +
                ", list=" + list +
                ", courseId='" + courseId + '\'' +
                ", chapterId='" + chapterId + '\'' +
                "} " + super.toString();
    }
}
