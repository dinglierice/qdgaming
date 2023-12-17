package com.qdgaming.repository.impl;

import com.qdgaming.domain.biz.scene.model.SceneModel;
import com.qdgaming.domain.biz.scene.reporsitory.SceneRepository;
import com.qdgaming.repository.mapper.node.NodeDOMapper;
import com.qdgaming.repository.mapper.scene.SceneDOMapper;
import com.qdgaming.repository.orm.convert.SceneConverter;
import com.qdgaming.repository.orm.scene.SceneDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/17 19:00
 */
public class SceneRepositoryImpl implements SceneRepository {
    @Resource
    SceneDOMapper sceneDOMapper;


    @Override
    public SceneModel findById(Long id) {
        return SceneConverter.convertSceneDO2SceneModel(sceneDOMapper.selectByPrimaryKey(id));
    }

    @Override
    @Transactional
    public String add(SceneModel sceneModel) {
        SceneDO sceneDO = SceneConverter.convertSceneModel2SceneDO(sceneModel);
        int insert = sceneDOMapper.insert(sceneDO);
        if (insert > 0) {
            return "新增场景成功";
        }
        return "新增场景失败或者无变动";
    }

    @Override
    public List<SceneModel> list(int rows) {
        return null;
    }
}
