package com.project.common.domain;

import lombok.Data;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

@Data
public class AppRequestHolder {
    private static final AppRequestHolder EMPTY = new AppRequestHolder();
    private static final ThreadLocal<AppRequestHolder> contextHolder = new ThreadLocal<>();


    public void clear() {
        contextHolder.remove();
    }

    public void set() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        AppRequestHolder appContextHolder = new AppRequestHolder();
        contextHolder.set(appContextHolder);
    }
    public static String getUid() {
        return getContext().getUid();
    }



    private static AppRequestHolder getContext() {
        return Objects.requireNonNullElse(contextHolder.get(), EMPTY);
    }

}