package com.qdgaming.domain.biz.scene.service;

import com.qdgaming.domain.biz.node.model.NodeModel;
import com.qdgaming.domain.biz.node.repository.NodeRepository;
import com.qdgaming.domain.biz.scene.model.SceneModel;
import com.qdgaming.domain.biz.scene.reporsitory.SceneRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/17 19:00
 */
@Service
public class SceneService {
    @Resource
    SceneRepository sceneRepository;

    @Resource
    NodeRepository nodeRepository;

    public SceneModel findById(Long id) {
        return sceneRepository.findById(id);
    }

    public String add(String name, String nodes) {
        if (StringUtils.isBlank(nodes)) {
            nodes = null;
        } else {
            if (!isNodesExist(nodes)) {
                return "添加失败，尚未配置相关节点";
            }
        }
        SceneModel sceneModel = SceneModel.builder().name(name).nodes(nodes).createTime(new Date()).updateTime(new Date()).build();
        return sceneRepository.add(sceneModel);
    }

    public List<SceneModel> list(int rows) {
        return sceneRepository.list(rows);
    }

    private boolean isNodesExist(String nodes) {
        List<String> nodeList = Arrays.asList(nodes.split(","));
        for (String node : nodeList) {
            NodeModel queryNode = nodeRepository.findByName(node);
            if (null == queryNode) {
                return false;
            }
        }
        return true;
    }

    public String genSqlById(Long id) {
        SceneModel sceneModel = sceneRepository.findById(id);
        if (null == sceneModel) {
            return null;
        }
        String nodes = sceneModel.getNodes();
        if (StringUtils.isBlank(nodes)) {
            return null;
        }

        List<String> nodeList = Arrays.asList(nodes.split(","));
        return null;
    }
}
