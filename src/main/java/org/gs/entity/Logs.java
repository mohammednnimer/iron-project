package org.gs.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs_tbl")
public class Logs {

    @Id
    @Column(name = "id", length = 30, nullable = false)
    private String id;

    @Column(name = "ip", length = 50, nullable = true)
    private String ip;

    @Column(name = "api", length = 255, nullable = true)
    private String api;

    @Column(name = "request_body", columnDefinition = "TEXT")
    private String requestBody;

    @Column(name = "response_body", columnDefinition = "TEXT")
    private String responseBody;

    @Column(name = "response_time")
    private LocalDateTime responseTime;

    @Column(name = "status_code", length = 10)
    private String statusCode;

   public Logs() {
    }
    public Logs(String id, String ip, String api, String requestBody, String responseBody, LocalDateTime responseTime, String statusCode) {
        this.id = id;
        this.ip = ip;
        this.api = api;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
        this.responseTime = responseTime;
        this.statusCode = statusCode;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public LocalDateTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(LocalDateTime responseTime) {
        this.responseTime = responseTime;
    }
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", api='" + api + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", responseBody='" + responseBody + '\'' +
                ", responseTime=" + responseTime +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
