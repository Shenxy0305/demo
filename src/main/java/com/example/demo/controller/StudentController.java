package com.example.demo.controller;

import com.alibaba.fastjson2.JSON;
import com.example.demo.controller.vo.request.StudentRequest;
import com.example.demo.entity.dto.StudentDto;
import com.example.demo.service.IStudentService;
import com.example.demo.http.utils.enums.SexEnum;
import com.example.demo.http.utils.result.Result;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addStudent(@RequestBody @Valid StudentRequest.addRequest request) {
        log.info("/student/add -> prams:{}", JSON.toJSON(request));
        StudentDto studentDto = StudentDto.builder().name(request.getName()).age(request.getAge()).sex(SexEnum.getByName(request.getSex()).code).build();
        log.info("/student/add -> studentDto:{}", JSON.toJSON(studentDto));
        return studentService.addStudent(studentDto);
    }
}
