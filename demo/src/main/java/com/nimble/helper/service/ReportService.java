package com.nimble.helper.service;

import com.nimble.helper.config.PropertiesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class ReportService {
    static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

    @Autowired
    private PropertiesManager propertiesManager;

    public static void main(String[] args) {
        String uiProjectPath = "E:\\WorkSpace\\Idea\\nimble\\ui-helper\\automation\\";
        String uiProjectOwnRootDrive = uiProjectPath.split(":")[0] + ":";
        StringBuffer commandStr = new StringBuffer();
        commandStr
                .append(" cmd /c ")
                .append(uiProjectOwnRootDrive)
                .append(" && ")
                .append(" cd ")
                .append(uiProjectPath)
                .append(" && ")
                .append(" mvn clean ")
                .append(" && ")
                .append(" mvn install ");
        exeCmd(commandStr.toString());
    }

    public static void exeCmd(String commandStr) {
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            String result = new BufferedReader(new InputStreamReader(p.getInputStream()))
                    .lines().collect(Collectors.joining("\n"));
            LOGGER.debug(result);
        } catch (Exception e) {
            LOGGER.error("Execute command failed !", e);
        }
    }
}
