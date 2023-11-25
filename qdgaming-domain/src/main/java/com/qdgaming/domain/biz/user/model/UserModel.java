package com.qdgaming.domain.biz.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author：dinglie
 * 描述业务语义的模型
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserModel {
    private Long id = null;

    private Date createTime = null;

    private Date updateTime = null;

    private String userName = null;

    private String password = null;

    private String realName = null;
}
