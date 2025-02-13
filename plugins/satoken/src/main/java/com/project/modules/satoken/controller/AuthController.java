package com.project.modules.satoken.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.project.common.domain.R;
import com.project.common.utils.ValidatorUtils;
import com.project.modules.satoken.domain.model.LoginBody;
import com.project.modules.satoken.domain.vo.LoginVo;
import com.project.modules.satoken.repository.SaTokenRepository;
import com.project.modules.satoken.service.AuthStrategy;
import lombok.RequiredArgsConstructor;
import org.dromara.common.json.utils.JsonUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SaIgnore
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final SaTokenRepository saTokenRepository;

    /**
     * 登录方法
     *
     * @param body 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public R<LoginVo> login(@RequestBody String body) {
        LoginBody loginBody = JsonUtils.parseObject(body, LoginBody.class);
        ValidatorUtils.validate(loginBody);
        // 授权类型和客户端id
        String clientType = loginBody.getClientType();
        String grantType = loginBody.getGrantType();

        LoginVo loginVo = AuthStrategy.login(body, clientType, grantType);
        return R.ok(loginVo);
    }

}