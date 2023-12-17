package com.qdgaming.application.biz.node;

import com.qdgaming.domain.biz.node.model.NodeModel;
import com.qdgaming.domain.biz.node.service.NodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/17 10:31
 */
@Service
public class NodeWriteService {
    @Resource
    NodeService nodeService;

    /*
     * 新增Node服务
     */
    public NodeModel add(String nodeName, String script) {
        return nodeService.save(nodeName, script);
    }

    /**
     * 修改Node服务
     */
    public String update(Long id, String nodeName, String script) {
        return nodeService.update(id, nodeName, script);
    }
}
