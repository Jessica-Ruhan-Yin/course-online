package com.course.server.mapper.my;

import com.course.server.dto.ResourceDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/9
 */
public interface MyUserMapper {

    List<ResourceDto> findResources(@Param("userId") String userId);
}
