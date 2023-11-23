package com.qdgaming.repository.mapper;


import com.qdgaming.repository.orm.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    UserDO queryByUsername(String userName);
}
