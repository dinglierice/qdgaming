package com.qdgaming.application.biz.scene;

import com.qdgaming.domain.biz.scene.model.SceneModel;
import com.qdgaming.domain.biz.scene.service.SceneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/17 19:19
 */
@Service
public class SceneReadService {
    @Resource
    SceneService sceneService;

    public SceneModel findById(Long id) {
        return sceneService.findById(id);
    }

    public List<SceneModel> list(int rows) {
        return sceneService.list(rows);
    }

    public String add(String name, String nodes) {
        return sceneService.add(name, nodes);
    }

    public String genSql(Long id) {
        return sceneService.genSqlById(id);
    }
}
