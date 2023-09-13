package org.example;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.TimeZone;

@WebFilter(value = "/time?timezone")
public class TimezoneValidateFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse resp,
                            FilterChain chain) throws IOException, ServletException {

        String timezone = req.getParameter("timezone");
        if (!timezoneValid(timezone).equals("GMT")) {
            chain.doFilter(req, resp);
        } else {
            resp.setStatus(404);
            resp.setContentType("application/json");
            resp.getWriter().write("Invalid timezone");
            resp.getWriter().close();
        }
    }
    public TimeZone timezoneValid (String timezone) {
        if(timezone.isEmpty()){
            TimeZone.getTimeZone("GMT");
        }
        return TimeZone.getTimeZone(timezone);
    }
}
