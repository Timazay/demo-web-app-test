package com.example.demowebapp;

import com.example.demowebapp.quartz.QuartzScheduler;
import com.example.demowebapp.services.CurrenciesSenderService;
import com.example.demowebapp.utils.ServletUtils;
import com.example.demowebapp.dao.UserDAOImpl;
import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CurrenciesSenderServlet", value = "/send-currencies")
public class CurrenciesSenderServlet extends HttpServlet {
    private UserDAOImpl dao = new UserDAOImpl();
    private Logger log = Logger.getLogger(CurrenciesSenderService.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null){
            request.setAttribute("msg", "You should login to perform such operation");
            ServletUtils.forwardJSP("login", request, response);
            return;
        }
        String job = request.getParameter("job");
        String action = request.getParameter("action");
        String interval = request.getParameter("interval");


        if (job.equals("1")){

            if (action.equals("start")){
            log.info("job #1 has been started via Servlet");
            try {
                if (interval != null){
                    int i = Integer.parseInt(interval);
                    if (i > 0 && i < 3000){
                        QuartzScheduler.TIME_INTERVAL = i;
                    } else {
                        log.warn("Invalid time interval " + i);
                    }
                }
                QuartzScheduler.jobOne();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } } else {
                log.info("Trying to stop job #1");
                try {
                    QuartzScheduler.stopJob();
                } catch (SchedulerException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            log.info("Common sender Servlet");
            CurrenciesSenderService.sendCurrencies(dao.findAll());
            request.setAttribute("msg", "Currencies has been send");
            ServletUtils.forwardJSP("blog", request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
