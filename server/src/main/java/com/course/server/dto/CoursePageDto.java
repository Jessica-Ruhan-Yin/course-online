package com.course.server.dto;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/19
 */
public class CoursePageDto extends PageDto{

    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CoursePageDto{");
        sb.append("Status='").append(Status).append('\'');
        sb.append(", page=").append(page);
        sb.append(", size=").append(size);
        sb.append(", total=").append(total);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
