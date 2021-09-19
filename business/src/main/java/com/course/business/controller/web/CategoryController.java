package com.course.business.controller.web;

import com.course.server.dto.CategoryDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/7
 */
@RestController("webCategoryController")
@RequestMapping("/web/category")
public class CategoryController {

    public static final String BUSINESS_NAME = "分类";

    @Resource
    private CategoryService categoryService;

    @PostMapping("/all")
    public ResponseDto all() {
        ResponseDto responseDto = new ResponseDto();
        List<CategoryDto> categoryDtoList = categoryService.all();
        responseDto.setContent(categoryDtoList);
        return responseDto;
    }
}
