package com.course.server.mapper.my;

import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/9
 */
public interface MyCourseMapper {
    int updateTime(@Param("courseId") String courseId);
}
