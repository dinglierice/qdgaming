package com.qdgaming.repository.orm;

import lombok.*;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/23 23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    private String userName = null;
    private String password = null;
}
