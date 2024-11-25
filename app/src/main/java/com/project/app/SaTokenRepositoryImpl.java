package com.project.app;

import com.project.common.domain.R;
import com.project.common.utils.StringUtils;
import com.project.modules.satoken.domain.vo.SaTokenUser;
import com.project.modules.satoken.repository.SaTokenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaTokenRepositoryImpl implements SaTokenRepository {
    @Override
    public Optional<SaTokenUser> findByPhoneNumber(String phoneNumber) {
        return Optional.empty();
    }

    @Override
    public R<SaTokenUser> findByAccount(String account, String password) {
        if (StringUtils.equals(account, "acc")) {
            SaTokenUser mock = new SaTokenUser();
            mock.setUserId(11111111111L);
            mock.setTenantId("");
            mock.setUserName("userName");

            return R.ok(mock);
        }
        return R.fail("不存在的账号");
    }
}