package com.project.app.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.project.app.config.Create;
import com.project.app.config.Update;
import com.project.app.entity.User;
import com.project.app.entity.Users;
import com.project.common.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final Users users;

    @PostMapping("/user/create")
    @SaCheckLogin
    public R<Void> create(@Validated(Create.class) @RequestBody UserBo bo) {
        return R.ok();
    }

    @PostMapping("/user/update")
    public R<Void> update(@Validated(Update.class) @RequestBody UserBo bo) {
        return R.ok();
    }


    @GetMapping("list")
    public R<List<User>> list() {
        return R.ok(users.findAll());
    }
}