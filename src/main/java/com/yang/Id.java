package com.yang;

import org.springframework.stereotype.Component;

/**
 * @author ygl
 * @description
 * @date 2019/10/31
 */
@Component
public class Id {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
