package com.qdgaming.application.base.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/25 20:22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterRequest {
    private String userName = null;
    private String password = null;
}
