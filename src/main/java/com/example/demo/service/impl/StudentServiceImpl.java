package com.example.demo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.IStudentService;
import com.example.demo.utils.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentEntity> implements IStudentService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> addStudent(StudentDto studentDto) {
        StudentEntity studentEntity = StudentEntity.builder().id(UUID.randomUUID().toString()).name(studentDto.getName()).age(studentDto.getAge()).sex(studentDto.getSex()).build();
        log.info("/student/add -> entity:{}", JSON.toJSON(studentEntity));
        int res = this.baseMapper.insert(studentEntity);
        return 1 == res ? Result.success("添加成功!", null) : Result.fail("添加失败!", null);
    }
}
