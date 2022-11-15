package com.zyy.blog.handler;

import com.alibaba.fastjson.JSON;
import com.zyy.blog.enums.StatusCodeEnum;
import com.zyy.blog.vo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zyy.blog.constant.CommonConst.APPLICATION_JSON;

/**
 * 用户未登录处理
 *
 * @author poixao
 * @date 2022/11/01
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setContentType(APPLICATION_JSON);
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.fail(StatusCodeEnum.NO_LOGIN)));
    }

}
