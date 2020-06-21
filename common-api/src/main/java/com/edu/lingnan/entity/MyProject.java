package com.edu.lingnan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MyProject {
    private Integer projectId;
    private String projectName;
    private Integer chargeUserId;
    private String chargeUser;
    private Integer scheduleId;
    private String schedule;
    private Integer functionPoints;
    private Integer completedFunctionPoints;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastUpdateTime;
    private Integer typeId;
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date joinTime;
    private Integer likeCount;
    private Integer storeCount;
    private Integer storeFlag;
    private Integer likeFlag;
}
