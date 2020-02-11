package com.example.sqlite.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.Data;
import java.util.List;

@Data
public class ImmediateStatus {
    String jsonbtServersConfig;
    // common configs
    List<String> bootstrapServersConfig;
    Boolean autoCommitConfig;
    String groupIdConfig;
    Object keyDeserializerClassConfig;
    Object valuesDeserializerClassConfig;

    String jsonTopicName;
    // immediate consumer configs
    List<String> immediateTopicName;
    Boolean immediateIsHashListInclude;
    int immediateTimeoutMillis;
    long immediatePollIntervalMillis;


    ObjectMapper om = new ObjectMapper();

    //db에서 가져올 때
    public ImmediateStatus(String jsonbtServersConfig, Boolean autoCommitConfig, String groupIdConfig, String jsonTopicName, Boolean immediateIsHashListInclude, int immediateTimeoutMillis, long immediatePollIntervalMillis) throws JsonProcessingException {
        this.bootstrapServersConfig = om.readValue(jsonbtServersConfig, new TypeReference<List<String>>(){});
        this.autoCommitConfig = autoCommitConfig;
        this.groupIdConfig = groupIdConfig;
        this.keyDeserializerClassConfig = StringDeserializer.class;
        this.valuesDeserializerClassConfig = JsonDeserializer.class;
        this.immediateTopicName = om.readValue(jsonTopicName, new TypeReference<List<String>>(){});
        this.immediateIsHashListInclude = immediateIsHashListInclude;
        this.immediateTimeoutMillis = immediateTimeoutMillis;
        this.immediatePollIntervalMillis = immediatePollIntervalMillis;
    }

    //db로 보낼 때
    public ImmediateStatus(List<String> bootstrapServersConfig, Boolean autoCommitConfig, String groupIdConfig, List<String> immediateTopicName, Boolean immediateIsHashListInclude, int immediateTimeoutMillis, long immediatePollIntervalMillis) throws JsonProcessingException {
        this.jsonbtServersConfig = om.writeValueAsString(bootstrapServersConfig);

        this.bootstrapServersConfig = bootstrapServersConfig;
        this.autoCommitConfig = autoCommitConfig;
        this.groupIdConfig = groupIdConfig;
        this.keyDeserializerClassConfig = StringDeserializer.class;
        this.valuesDeserializerClassConfig = JsonDeserializer.class;
        this.jsonTopicName = om.writeValueAsString(immediateTopicName); //JSON String
        this.immediateIsHashListInclude = immediateIsHashListInclude;
        this.immediateTimeoutMillis = immediateTimeoutMillis;
        this.immediatePollIntervalMillis = immediatePollIntervalMillis;
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

    public List<String> getImmediateTopicName() {
        return immediateTopicName;
    }

    public void setImmediateTopicName(List<String> immediateTopicName) {
        this.immediateTopicName = immediateTopicName;
    }

    public Boolean getImmediateIsHashListInclude() {
        return immediateIsHashListInclude;
    }

    public void setImmediateIsHashListInclude(Boolean immediateIsHashListInclude) {
        this.immediateIsHashListInclude = immediateIsHashListInclude;
    }

    public int getImmediateTimeoutMillis() {
        return immediateTimeoutMillis;
    }

    public void setImmediateTimeoutMillis(int immediateTimeoutMillis) {
        this.immediateTimeoutMillis = immediateTimeoutMillis;
    }

    public long getImmediatePollIntervalMillis() {
        return immediatePollIntervalMillis;
    }

    public void setImmediatePollIntervalMillis(long immediatePollIntervalMillis) {
        this.immediatePollIntervalMillis = immediatePollIntervalMillis;
    }


    @Override
    public String toString() {
        return "ImmediateStatus{" +
                "bootstrapServersConfig=" + bootstrapServersConfig +
                ", autoCommitConfig=" + autoCommitConfig +
                ", groupIdConfig='" + groupIdConfig + '\'' +
                ", keyDeserializerClassConfig=" + keyDeserializerClassConfig +
                ", valuesDeserializerClassConfig=" + valuesDeserializerClassConfig +
                ", immediateTopicName=" + immediateTopicName +
                ", immediateIsHashListInclude=" + immediateIsHashListInclude +
                ", immediateTimeoutMillis=" + immediateTimeoutMillis +
                ", immediatePollIntervalMillis=" + immediatePollIntervalMillis +
                '}';
    }



}
