package com.example.sqlite.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.Data;
import java.util.List;

@Data
public class BufferStatus {

    String jsonbtServersConfig;
    List<String> bootstrapServersConfig;
    Boolean autoCommitConfig;
    String groupIdConfig;
    Object keyDeserializerClassConfig;
    Object valuesDeserializerClassConfig;
    // buffer consumer configs
    String jsonTopicName;
    List<String> buffTopicName;
    int buffMinBatchSize;
    Boolean buffIsHashListInclude;
    int buffTimeoutMillis;
    long buffPollIntervalMillis;


    ObjectMapper om = new ObjectMapper();


    //db에서 가져올 때
    public BufferStatus(String jsonbtServersConfig, Boolean autoCommitConfig, String groupIdConfig, String jsonTopicName, int buffMinBatchSize, Boolean buffIsHashListInclude, int buffTimeoutMillis, long buffPollIntervalMillis) throws JsonProcessingException {
        this.bootstrapServersConfig = om.readValue(jsonbtServersConfig, new TypeReference<List<String>>(){});
        this.autoCommitConfig = autoCommitConfig;
        this.groupIdConfig = groupIdConfig;
        this.buffTopicName = om.readValue(jsonTopicName, new TypeReference<List<String>>(){});
        this.buffMinBatchSize = buffMinBatchSize;
        this.buffIsHashListInclude = buffIsHashListInclude;
        this.buffTimeoutMillis = buffTimeoutMillis;
        this.buffPollIntervalMillis = buffPollIntervalMillis;
        this.keyDeserializerClassConfig = StringDeserializer.class;
        this.valuesDeserializerClassConfig = JsonDeserializer.class;

    }
    //db로 보낼 때
    public BufferStatus(List<String> bootstrapServersConfig, Boolean autoCommitConfig, String groupIdConfig,
                        List<String> buffTopicName, int buffMinBatchSize,
                        Boolean buffIsHashListInclude, int buffTimeoutMillis, long buffPollIntervalMillis) throws JsonProcessingException {
        this.jsonbtServersConfig = om.writeValueAsString(bootstrapServersConfig);

        this.bootstrapServersConfig = bootstrapServersConfig;
        this.autoCommitConfig = autoCommitConfig;
        this.groupIdConfig = groupIdConfig;
        this.keyDeserializerClassConfig = StringDeserializer.class;
        this.valuesDeserializerClassConfig = JsonDeserializer.class;
        this.jsonTopicName = om.writeValueAsString(buffTopicName); //jsonString
        this.buffMinBatchSize = buffMinBatchSize;
        this.buffIsHashListInclude = buffIsHashListInclude;
        this.buffTimeoutMillis = buffTimeoutMillis;
        this.buffPollIntervalMillis = buffPollIntervalMillis;
    }


    public List<String> getBootstrapServersConfig() {
        return bootstrapServersConfig;
    }

    public void setBootstrapServersConfig(List<String> bootstrapServersConfig) {
        this.bootstrapServersConfig = bootstrapServersConfig;
    }

    public Boolean getAutoCommitConfig() {
        return autoCommitConfig;
    }

    public void setAutoCommitConfig(Boolean autoCommitConfig) {
        this.autoCommitConfig = autoCommitConfig;
    }

    public String getGroupIdConfig() {
        return groupIdConfig;
    }

    public void setGroupIdConfig(String groupIdConfig) {
        this.groupIdConfig = groupIdConfig;
    }

    public List<String> getBuffTopicName() {
        return buffTopicName;
    }

    public void setBuffTopicName(List<String> buffTopicName) {
        this.buffTopicName = buffTopicName;
    }

    public int getBuffMinBatchSize() {
        return buffMinBatchSize;
    }

    public void setBuffMinBatchSize(int buffMinBatchSize) {
        this.buffMinBatchSize = buffMinBatchSize;
    }

    public Boolean getBuffIsHashListInclude() {
        return buffIsHashListInclude;
    }

    public void setBuffIsHashListInclude(Boolean buffIsHashListInclude) {
        this.buffIsHashListInclude = buffIsHashListInclude;
    }

    public int getBuffTimeoutMillis() {
        return buffTimeoutMillis;
    }

    public void setBuffTimeoutMillis(int buffTimeoutMillis) {
        this.buffTimeoutMillis = buffTimeoutMillis;
    }

    public long getBuffPollIntervalMillis() {
        return buffPollIntervalMillis;
    }

    public void setBuffPollIntervalMillis(long buffPollIntervalMillis) {
        this.buffPollIntervalMillis = buffPollIntervalMillis;
    }


    @Override
    public String toString() {
        return "BufferStatus{" +
                "bootstrapServersConfig=" + bootstrapServersConfig +
                ", autoCommitConfig=" + autoCommitConfig +
                ", groupIdConfig='" + groupIdConfig + '\'' +
                ", keyDeserializerClassConfig=" + keyDeserializerClassConfig +
                ", valuesDeserializerClassConfig=" + valuesDeserializerClassConfig +
                ", buffTopicName=" + buffTopicName +
                ", buffMinBatchSize=" + buffMinBatchSize +
                ", buffIsHashListInclude=" + buffIsHashListInclude +
                ", buffTimeoutMillis=" + buffTimeoutMillis +
                ", buffPollIntervalMillis=" + buffPollIntervalMillis +
                '}';
    }

}
