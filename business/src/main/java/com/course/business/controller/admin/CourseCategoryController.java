package com.course.business.controller.admin;

import com.course.server.dto.CourseCategoryDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CourseCategoryService;
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
@RequestMapping("/admin/courseCategory")
public class CourseCategoryController {

    public static final String BUSINESS_NAME = "课程分类";

    @Resource
    private CourseCategoryService courseCategoryService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        courseCategoryService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseCategoryDto courseCategoryDto) {

        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        courseCategoryService.save(courseCategoryDto);
        responseDto.setContent(courseCategoryDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        courseCategoryService.delete(id);
        return responseDto;
    }
}
