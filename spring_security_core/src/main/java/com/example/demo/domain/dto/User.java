package com.example.demo.domain.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

/**
 * description
 *
 * @author zb 2019/04/22 20:48
 */

@Setter
@Getter
public class User {

    /**
     * 简单视图
     */
    public interface UserSampleView {
    }

    /**
     * 详细视图
     */
    public interface UserDetailView extends UserSampleView {
    }

    @JsonView(UserSampleView.class)
    private String name;
    @JsonView(UserDetailView.class)
    private String password;
    @JsonView(UserSampleView.class)
    private Long id;
    @JsonView(UserSampleView.class)
    private Integer age;
}

