package com.rootcodelabs.gdp.responses;

/**
 * @author - Nipuna Kumaranathunga
 * @description - ApiResponse class in used to standardized all API calls
 */
public class ApiResponse {
	private String status;
	private String data;

    public ApiResponse(String status, String data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
