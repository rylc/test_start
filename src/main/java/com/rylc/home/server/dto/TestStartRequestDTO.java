package com.rylc.home.server.dto;

import javax.validation.constraints.NotBlank;

public class TestStartRequestDTO {
    @NotBlank
    private String model;

    @NotBlank
    private String rocket;

    @NotBlank
    private String site;

    @NotBlank
    private String time;

    @NotBlank
    private String status;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
