package com.qdgaming.controller.biz.node;

import com.qdgaming.application.biz.node.NodeReadService;
import com.qdgaming.application.biz.node.NodeWriteService;
import com.qdgaming.controller.auth.Feature;
import com.qdgaming.controller.auth.FeatureType;
import com.qdgaming.controller.base.BaseController;
import com.qdgaming.controller.base.result.WebResult;
import com.qdgaming.domain.biz.node.model.NodeModel;
import com.qdgaming.repository.dto.user.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/16 20:21
 */
@Api(tags = "NodeController", value = "节点")
@RestController
@RequestMapping("/api/node")
public class NodeController extends BaseController {

    @Resource
    NodeWriteService nodeWriteService;

    @Resource
    NodeReadService nodeReadService;

    @ApiOperation("新增节点")
    @Feature(FeatureType.ADMIN)
    @PostMapping("/add")
    // TODO 新增管理员权限
    public WebResult<NodeModel> add(
            @RequestParam String nodeName,
            @RequestParam String script
    ) {
        NodeModel add = nodeWriteService.add(nodeName, script);
        return success(add);
    }

    @ApiOperation("展示当前全部节点")
    @Feature(FeatureType.PUBLIC)
    @GetMapping("/list/{rows}")
    public WebResult<List<NodeModel>> list(@PathVariable("rows") Integer rows ) {
        List<NodeModel> list = nodeReadService.list(rows);
        return success(list);
    }

    @ApiOperation("修改节点配置")
    @Feature(FeatureType.ADMIN)
    @PostMapping("/update")
    // TODO 新增管理员权限
    public WebResult<String> update(
            @RequestParam Long id,
            @RequestParam String nodeName,
            @RequestParam String script
    ) {
        String result = nodeWriteService.update(id, nodeName, script);
        return success(result);
    }
}
