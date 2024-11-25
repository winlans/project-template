package com.project.modules.satoken.service;

import com.project.common.domain.R;
import com.project.common.exception.user.UserException;
import com.project.common.utils.SpringUtils;
import com.project.modules.satoken.domain.events.LoginSuccessEvent;
import com.project.modules.satoken.domain.vo.LoginVo;
import com.project.modules.satoken.domain.vo.SaTokenUser;
import org.springframework.context.ApplicationEventPublisher;

public interface IAuthStrategy {
    String BASE_NAME = "AuthStrategy";

    static LoginVo login(String body, String clientType, String grantType) {
        IAuthStrategy strategy = SpringUtils.getBean(grantType + BASE_NAME, IAuthStrategy.class);
        ApplicationEventPublisher events = SpringUtils.getBean(ApplicationEventPublisher.class);
        R<SaTokenUser> result = strategy.login(body);
        if (result.isSuccess()) {
            SaTokenUser data = result.getData();
            events.publishEvent(LoginSuccessEvent.builder().userId(String.valueOf(data.getUserId())).build());
            LoginVo loginVo = new LoginVo();
            loginVo.setOpenid(String.valueOf(data.getUserId()));
            return loginVo;
        }
        throw new UserException(result.getMsg());

    }

    R<SaTokenUser> login(String body);
}