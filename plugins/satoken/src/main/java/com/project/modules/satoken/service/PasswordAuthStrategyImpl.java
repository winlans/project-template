package com.project.modules.satoken.service;

import com.project.common.domain.R;
import com.project.common.exception.user.UserException;
import com.project.modules.satoken.domain.model.PasswordLoginBody;
import com.project.modules.satoken.domain.vo.SaTokenUser;
import com.project.modules.satoken.repository.SaTokenRepository;
import lombok.RequiredArgsConstructor;
import org.dromara.common.json.utils.JsonUtils;
import org.springframework.stereotype.Component;

@Component("password" + IAuthStrategy.BASE_NAME)
@RequiredArgsConstructor
public class PasswordAuthStrategyImpl implements IAuthStrategy {
    private final SaTokenRepository saTokenRepository;

    @Override
    public R<SaTokenUser> login(String body) {
        PasswordLoginBody passwordLoginBody = JsonUtils.parseObject(body, PasswordLoginBody.class);
        String password = passwordLoginBody.getPassword();
        String username = passwordLoginBody.getUsername();
        var result = saTokenRepository.findByAccount(username, password);
        if (!result.isSuccess()) {
            throw new UserException(result.getMsg());
        }

        SaTokenUser saTokenUser = result.getData();

        return R.ok(saTokenUser);
    }
}