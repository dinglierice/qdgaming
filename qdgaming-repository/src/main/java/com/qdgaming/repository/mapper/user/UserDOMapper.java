package com.qdgaming.repository.mapper.user;

import com.qdgaming.repository.orm.user.UserDO;
import com.qdgaming.repository.orm.user.UserDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDOMapper {
    long countByExample(UserDOExample example);

    int deleteByExample(UserDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDO row);

    int insertSelective(UserDO row);

    List<UserDO> selectByExample(UserDOExample example);

    UserDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UserDO row, @Param("example") UserDOExample example);

    int updateByExample(@Param("row") UserDO row, @Param("example") UserDOExample example);

    int updateByPrimaryKeySelective(UserDO row);

    int updateByPrimaryKey(UserDO row);

    UserDO selectByName(String userName);
}