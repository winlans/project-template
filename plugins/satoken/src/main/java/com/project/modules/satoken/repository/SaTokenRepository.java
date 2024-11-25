package com.project.modules.satoken.repository;

import com.project.common.domain.R;
import com.project.modules.satoken.domain.vo.SaTokenUser;

import java.util.Optional;

public interface SaTokenRepository {

    Optional<SaTokenUser> findByPhoneNumber(String phoneNumber);

    R<SaTokenUser> findByAccount(String account, String password);

}