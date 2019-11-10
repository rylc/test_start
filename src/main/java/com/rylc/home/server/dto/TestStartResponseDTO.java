package com.rylc.home.server.dto;

public class TestStartResponseDTO {
    public TestStartResponseDTO() {
    }

    public TestStartResponseDTO(Integer return_code, String return_message, Integer test_id) {
        this.return_code = return_code;
        this.return_message = return_message;
        this.test_id = test_id;
    }

    private Integer return_code;
    private String return_message;
    private Integer test_id;

    public Integer getReturn_code() {
        return return_code;
    }

    public void setReturn_code(Integer return_code) {
        this.return_code = return_code;
    }

    public String getReturn_message() {
        return return_message;
    }

    public void setReturn_message(String return_message) {
        this.return_message = return_message;
    }

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }
}
