package com.yh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TianQiResponseEntity {
    String time;
    CityInfo cityInfo;
    String date;
    String message;
    int status;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TianQiResponseEntity{" +
                "time='" + time + '\'' +
                ", cityInfo=" + cityInfo +
                ", date='" + date + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
