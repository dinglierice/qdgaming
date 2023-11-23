package com.qdgaming.domain.biz.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author：dinglie
 * @date：2023/11/23 23:20
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
