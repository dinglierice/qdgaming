package com.qdgaming.repository.orm.convert;

import com.qdgaming.domain.biz.node.model.NodeModel;
import com.qdgaming.domain.biz.scene.model.SceneModel;
import com.qdgaming.repository.orm.node.NodeDO;
import com.qdgaming.repository.orm.scene.SceneDO;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/17 19:07
 */
public class SceneConverter {
    public static SceneModel convertSceneDO2SceneModel(SceneDO sceneDO) {
        if (sceneDO == null) {
            return null;
        }

        return SceneModel.builder()
                .id(sceneDO.getId())
                .createTime(sceneDO.getCreateTime())
                .updateTime(sceneDO.getUpdateTime())
                .nodes(sceneDO.getNodes())
                .name(sceneDO.getName())
                .build();
    }

    public static SceneDO convertSceneModel2SceneDO(SceneModel sceneModel) {
        if (sceneModel == null) {
            return null;
        }

        SceneDO sceneDO = SceneDO.builder()
                .name(sceneModel.getName())
                .nodes(sceneModel.getNodes())
                .build();
        sceneDO.setCreateTime(sceneModel.getCreateTime());
        sceneDO.setCreateTime(sceneModel.getUpdateTime());
        sceneDO.setId(sceneModel.getId());
        return sceneDO;
    }
}
