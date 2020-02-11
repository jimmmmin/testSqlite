package com.example.sqlite.model;

import lombok.Data;

@Data
public class Status {

    private String subscription;
    private int timeout;
    private int minBatchSize;

    public Status() {
    }

    public Status(String subscription, int timeout, int minBatchSize) {
        this.subscription = subscription;
        this.timeout = timeout;
        this.minBatchSize = minBatchSize;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMinBatchSize() {
        return minBatchSize;
    }

    public void setMinBatchSize(int minBatchSize) {
        this.minBatchSize = minBatchSize;
    }



    @Override
    public String toString() {
        return "Status{" +
                "subscription='" + subscription + '\'' +
                ", timeout=" + timeout +
                ", minBatchSize=" + minBatchSize +
                '}';
    }


}
