package com.qdgaming.domain.biz.scene.reporsitory;

import com.qdgaming.domain.biz.scene.model.SceneModel;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SceneRepository {
    SceneModel findById(Long id);

    String add(SceneModel sceneModel);

    List<SceneModel> list(int rows);
}
