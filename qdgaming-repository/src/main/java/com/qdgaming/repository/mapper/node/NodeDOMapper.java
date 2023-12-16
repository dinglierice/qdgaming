package com.qdgaming.repository.mapper.node;

import com.qdgaming.repository.orm.node.NodeDO;
import com.qdgaming.repository.orm.node.NodeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NodeDOMapper {
    long countByExample(NodeDOExample example);

    int deleteByExample(NodeDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NodeDO row);

    int insertSelective(NodeDO row);

    List<NodeDO> selectByExampleWithBLOBs(NodeDOExample example);

    List<NodeDO> selectByExample(NodeDOExample example);

    List<NodeDO> selectHead(int row);

    NodeDO selectByName(String name);

    NodeDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") NodeDO row, @Param("example") NodeDOExample example);

    int updateByExampleWithBLOBs(@Param("row") NodeDO row, @Param("example") NodeDOExample example);

    int updateByExample(@Param("row") NodeDO row, @Param("example") NodeDOExample example);

    int updateByPrimaryKeySelective(NodeDO row);

    int updateByPrimaryKeyWithBLOBs(NodeDO row);

    int updateByPrimaryKey(NodeDO row);
}