package com.rz.iot.think.shiro;

import com.google.gson.Gson;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author by xuxiake, Date on 2018/12/5.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public class ShiroLoginFilter extends UserFilter {


    @Override
    protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) {

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return true;
        }else {
            response.setContentType("application/json;charset=UTF-8");
            try(PrintWriter writer = response.getWriter()) {
                Gson gson = new Gson();
                Result result = new Result();
                result.setCode(RzIotErrMessage.SESSION_TIME_OUT);
                result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.SESSION_TIME_OUT));
                writer.println(gson.toJson(result));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return super.onAccessDenied(request, response);
    }

}
