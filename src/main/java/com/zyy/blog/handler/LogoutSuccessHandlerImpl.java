package com.zyy.blog.handler;

import com.alibaba.fastjson.JSON;
import com.zyy.blog.vo.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zyy.blog.constant.CommonConst.APPLICATION_JSON;

/**
 * 注销处理
 *
 * @author poixao
 * @date 2022/11/01
 */
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        httpServletResponse.setContentType(APPLICATION_JSON);
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.ok()));
    }

}
