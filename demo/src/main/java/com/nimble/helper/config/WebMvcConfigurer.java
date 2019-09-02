package com.nimble.helper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    String customResourceFolderName = "ui-report";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.noStore());

        try {
            // Jar path
            String jarPath = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent();
            Path uiReportFolderPath = Paths.get(jarPath + File.separator + customResourceFolderName);
            if(Files.notExists(uiReportFolderPath)){
                Files.createDirectories(uiReportFolderPath);
            }
            registry.addResourceHandler("/"+customResourceFolderName+"/**")
                    .addResourceLocations("file:" + uiReportFolderPath.toString() + File.separator)
                    .setCacheControl(CacheControl.noStore());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

}