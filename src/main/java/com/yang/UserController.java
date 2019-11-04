package com.yang;

import com.yang.Id;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * getSession method is not verifies time.
 * 'public Session getSession(boolean create)'  in DelegatingSubject.
 *
 */
@Controller
@RequestMapping("/test")
public class UserController {

    @RequestMapping("json")
    @ResponseBody
    public Id retID(HttpServletRequest request) {
        try {
            Session session = SecurityUtils.getSubject().getSession();
            session.getAttribute("a");
            // set timeout 1s
            session.setTimeout(1000);
            // get tomcat StandardSession
            HttpSession session1 = request.getSession(false);
            // get HttpServletSession
            session = SecurityUtils.getSubject().getSession();
            // Session already invalidated
            session.getAttribute("a");
            Id id = new Id();
            id.setId("1321");
            return id;
        }catch (Exception e) {
            e.printStackTrace();
            return new Id();
        }

    }

}
