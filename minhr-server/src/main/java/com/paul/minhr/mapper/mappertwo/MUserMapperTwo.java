package com.paul.minhr.mapper.mappertwo;

import com.paul.minhr.model.MUser;
//import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Paul.x
 * @Date 2022/8/16 23:04
 * @Description
 */
//@Mapper
public interface MUserMapperTwo {
    /**
     * 更新数据
     * @param user
     * @return
     */
    int updateUser(MUser user);

    /**
     * 获取数据
     * @param id
     * @return
     */
    MUser getUserById(Long id);
}
