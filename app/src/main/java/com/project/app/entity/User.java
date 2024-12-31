package com.project.app.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.eclipse.collections.api.list.ImmutableList;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "sys_user")
@EqualsAndHashCode
public class User {
    @Id
    @Getter
    private Long userId;
    @Getter
    private String userName;
    @Getter
    private Long deptId;
    @Getter
    private String email;
    @Embedded
    @Getter
    private ImmutableList<String> updateBy;


}