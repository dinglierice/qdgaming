package com.qdgaming.controller.biz.scene;

import com.qdgaming.application.biz.scene.SceneReadService;
import com.qdgaming.controller.auth.Feature;
import com.qdgaming.controller.auth.FeatureType;
import com.qdgaming.controller.base.BaseController;
import com.qdgaming.controller.base.result.WebResult;
import com.qdgaming.domain.biz.scene.model.SceneModel;
import com.qdgaming.repository.dto.user.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/16 20:23
 */
@Api(tags = "SceneController", description = "场景")
@RestController
@RequestMapping("/api/scene")
public class SceneController extends BaseController {
    @Resource
    SceneReadService sceneReadService;

    @ApiOperation("场景展示")
    @Feature(FeatureType.PUBLIC)
    @GetMapping("/list")
    public WebResult<List<SceneModel>> list(int rows) {
        List<SceneModel> list = sceneReadService.list(rows);
        return success(list);
    }

    @ApiOperation("场景注册")
    @Feature(FeatureType.USER_LOGIN)
    @PostMapping("/register")
    public WebResult<String> register(
            @RequestParam String name,
            @RequestParam String nodes
    ) {
        String add = sceneReadService.add(name, nodes);
        return success(add);
    }

    @ApiOperation("根据场景生成相关明细sql")
    @Feature(FeatureType.USER_LOGIN)
    @GetMapping("/{id}")
    public WebResult<?> genDirectoryTable(
            @PathVariable("id") Long id
    ) {
        return null;
    }
}
