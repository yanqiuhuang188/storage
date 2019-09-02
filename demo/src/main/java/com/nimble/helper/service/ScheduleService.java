package com.nimble.helper.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ScheduleService {
    static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);

    private final String corn = "* * * * * ?";

    @Scheduled(cron = corn)
    public void triggerUiAutomationTest(){
        LOGGER.debug("Trigger Ui Automation Test Now [" + (new Date()).toString()+ "]");
    }
}
