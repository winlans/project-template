package com.project.app.entity;

import io.hypersistence.utils.hibernate.type.json.JsonStringType;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.JsonAsStringJdbcType;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
    @Getter
    @Type(JsonType.class)
    private List<String> updateBy;
}