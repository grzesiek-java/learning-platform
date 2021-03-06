package pl.coderslab.webfilter;

import pl.coderslab.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/teacher/*")
public class TeacherFilter implements Filter{
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");

        if (httpSession.getAttribute("user") == null || user.getAdmin() == 0) {
            res.sendRedirect("/user/panel");
        } else {
            chain.doFilter(request, response);
        }
    }
}