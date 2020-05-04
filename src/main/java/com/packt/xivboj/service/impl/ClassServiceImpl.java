package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Class;
import com.packt.xivboj.domain.Course;
import com.packt.xivboj.domain.repository.ClassRepository;
import com.packt.xivboj.domain.repository.CourseRepository;
import com.packt.xivboj.service.ClassService;
import com.packt.xivboj.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;

    @Override
    public void addClass(Class aClass) {
        classRepository.addClass(aClass);
    }
}


