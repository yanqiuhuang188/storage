package com.nimble.helper.controller;

import com.nimble.helper.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    @RequestMapping("/ui-report")
    public String home() {
        return "/ui-report/index.html";
    }
}
