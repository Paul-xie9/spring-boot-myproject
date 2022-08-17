package com.paul.minhr.mapper.mapperone;

import com.paul.minhr.model.Student;
//import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Paul.x
 * @Date 2022/8/16 23:04
 * @Description
 */
//@Mapper
public interface StudentMapperOne {
    /**
     * 更新数据
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 获取数据
     * @param id
     * @return
     */
    Student getStudentById(Long id);
}
