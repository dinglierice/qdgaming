package com.qdgaming.domain.biz.node.service;

import com.qdgaming.domain.biz.node.model.NodeModel;
import com.qdgaming.domain.biz.node.repository.NodeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/17 10:29
 */
@Service
public class NodeService {
    @Resource
    NodeRepository nodeRepository;

    public NodeModel save(String nodeName, String script) {
        NodeModel build = NodeModel.builder().nodeName(nodeName)
                .script(script)
                .createTime(new Date())
                .updateTime(new Date()).build();
        return nodeRepository.insert(build);
    }

    public List<NodeModel> list(int rows) {
        return nodeRepository.list(rows);
    }


    public String update(Long id, String nodeName, String script) {
        NodeModel build = NodeModel.builder().id(id)
                .nodeName(nodeName)
                .script(script)
                .updateTime(new Date())
                .build();
        int i = nodeRepository.updateNode(build);
        if (i > 0) {
            return "修改成功";
        }
        return "修改失败或无改动";
    }
}
