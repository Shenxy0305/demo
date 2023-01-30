package com.example.demo.controller;

import com.alibaba.fastjson2.JSON;
import com.example.demo.controller.vo.request.SecKillRequest;
import com.example.demo.controller.vo.request.StudentRequest;
import com.example.demo.entity.dto.SecKillDto;
import com.example.demo.entity.dto.StudentDto;
import com.example.demo.service.ISecKillService;
import com.example.demo.utils.enums.SexEnum;
import com.example.demo.utils.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Controller
@RestController
@RequestMapping(value = "/secKill")
public class SecKillController {

    @Autowired
    private ISecKillService secKillService;

    /**
     * spinlock
     * @param request id
     * @return Result
     */
    @RequestMapping(value = "/spinlock", method = RequestMethod.POST)
    public Result<?> secKill(@RequestBody @Valid SecKillRequest.Request request) {
        log.info("/secKill/spinlock -> prams:{}", JSON.toJSON(request));
        SecKillDto secKillDto = SecKillDto.builder().id(request.getId()).count(request.getCount()).build();
        log.info("/secKill/spinlock -> secKillDto:{}", JSON.toJSON(secKillDto));
        return secKillService.spinlock(secKillDto);
    }
}
