package com.course.business.controller.admin;

import com.course.server.dto.SmsDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.SmsService;
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
@RequestMapping("/admin/sms")
public class SmsController {

    public static final String BUSINESS_NAME = "短信验证码";

    @Resource
    private SmsService smsService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        smsService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody SmsDto smsDto) {

        // 保存校验
        ValidatorUtil.require(smsDto.getMobile(), "手机号");
        ValidatorUtil.length(smsDto.getMobile(), "手机号", 1, 50);
        ValidatorUtil.require(smsDto.getCode(), "验证码");
        ValidatorUtil.require(smsDto.getUse(), "用途");
        ValidatorUtil.require(smsDto.getAt(), "生成时间");
        ValidatorUtil.require(smsDto.getStatus(), "用途");

        ResponseDto responseDto = new ResponseDto();
        smsService.save(smsDto);
        responseDto.setContent(smsDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        smsService.delete(id);
        return responseDto;
    }
}
