package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.dto.StudentDto;
import com.example.demo.http.utils.result.Result;

public interface IStudentService extends IService<StudentEntity> {

    Result<?> addStudent(StudentDto studentDto);
}
