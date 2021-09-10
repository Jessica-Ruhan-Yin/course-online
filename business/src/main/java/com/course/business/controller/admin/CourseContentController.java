package com.course.business.controller.admin;

import com.course.server.dto.CourseContentDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CourseContentService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/7
 */
@RestController
@RequestMapping("/admin/courseContent")
public class CourseContentController {

    public static final String BUSINESS_NAME = "课程内容";

    @Resource
    private CourseContentService courseContentService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        courseContentService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseContentDto courseContentDto) {

        // 保存校验
        ValidatorUtil.require(courseContentDto.getContent(), "课程内容");

        ResponseDto responseDto = new ResponseDto();
        courseContentService.save(courseContentDto);
        responseDto.setContent(courseContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        courseContentService.delete(id);
        return responseDto;
    }
}
