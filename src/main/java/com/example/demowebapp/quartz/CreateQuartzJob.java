package com.example.demowebapp.quartz;
import com.example.demowebapp.services.CurrenciesSenderService;
import com.example.demowebapp.dao.UserDAOImpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CreateQuartzJob implements   Job{
    private UserDAOImpl dao = new UserDAOImpl();
    private Logger log = Logger.getLogger(CreateQuartzJob.class);


    //execute Job by using execute() method of the Job interface
    public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {//handle JobExecutionException
        log.debug("CreateQuartzJob is running......");
        CurrenciesSenderService.sendCurrencies(dao.findAll());
        //debug message
        log.debug("CreateQuartzJob is finishing......");
    }
}
