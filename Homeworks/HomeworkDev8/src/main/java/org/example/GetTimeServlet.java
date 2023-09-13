package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time")
public class GetTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String timeZone = parseUTC(req);

        String time = ZonedDateTime.now(ZoneId.of(timeZone)).format(DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss"))
                + " " + timeZone;

        resp.getWriter().write(time);

        resp.getWriter().close();
    }

    private String parseUTC(HttpServletRequest request) {
        if (request.getParameterMap().containsKey("timezone")) {
            return request.getParameter("timezone").replace(" ", "+");
        }
        return "UTC";
    }
}



