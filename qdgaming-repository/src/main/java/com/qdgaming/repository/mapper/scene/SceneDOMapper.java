package com.qdgaming.repository.mapper.scene;

import com.qdgaming.repository.orm.scene.SceneDO;
import com.qdgaming.repository.orm.scene.SceneDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SceneDOMapper {
    long countByExample(SceneDOExample example);

    int deleteByExample(SceneDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SceneDO row);

    List<SceneDO> selectHead(int rows);

    int insertSelective(SceneDO row);

    List<SceneDO> selectByExample(SceneDOExample example);

    SceneDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SceneDO row, @Param("example") SceneDOExample example);

    int updateByExample(@Param("row") SceneDO row, @Param("example") SceneDOExample example);

    int updateByPrimaryKeySelective(SceneDO row);

    int updateByPrimaryKey(SceneDO row);
}