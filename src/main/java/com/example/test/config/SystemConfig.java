package com.example.test.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义配置文件实体类
 */
@Component
@ConfigurationProperties(prefix = "app")
public class SystemConfig {


    private String info;

    private String author;

    private String email;

    private String swaggerTitle;



    private String swaggerContactName;

    private String swaggerContactWebUrl;

    private String swaggerContactEmail;
    private String swaggerVersion;

    private String swaggerDescription;
    private String swaggerTermsOfServiceUrl;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSwaggerTitle() {
        return swaggerTitle;
    }

    public void setSwaggerTitle(String swaggerTitle) {
        this.swaggerTitle = swaggerTitle;
    }

    public String getSwaggerContactName() {
        return swaggerContactName;
    }

    public void setSwaggerContactName(String swaggerContactName) {
        this.swaggerContactName = swaggerContactName;
    }

    public String getSwaggerContactWebUrl() {
        return swaggerContactWebUrl;
    }

    public void setSwaggerContactWebUrl(String swaggerContactWebUrl) {
        this.swaggerContactWebUrl = swaggerContactWebUrl;
    }

    public String getSwaggerContactEmail() {
        return swaggerContactEmail;
    }

    public void setSwaggerContactEmail(String swaggerContactEmail) {
        this.swaggerContactEmail = swaggerContactEmail;
    }

    public String getSwaggerVersion() {
        return swaggerVersion;
    }

    public void setSwaggerVersion(String swaggerVersion) {
        this.swaggerVersion = swaggerVersion;
    }

    public String getSwaggerDescription() {
        return swaggerDescription;
    }

    public void setSwaggerDescription(String swaggerDescription) {
        this.swaggerDescription = swaggerDescription;
    }

    public String getSwaggerTermsOfServiceUrl() {
        return swaggerTermsOfServiceUrl;
    }

    public void setSwaggerTermsOfServiceUrl(String swaggerTermsOfServiceUrl) {
        this.swaggerTermsOfServiceUrl = swaggerTermsOfServiceUrl;
    }
}
