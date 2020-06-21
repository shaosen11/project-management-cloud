package com.edu.lingnan.entity;

import lombok.Data;


@Data
public class Myprojects {
    private Integer projectId;
    private String projectName;
    private Integer chargeUserId;
    private String chargeUser;
    private Integer scheduleId;
    private Integer functionPoints;
    private Integer completedFunctionPoints;
    private Integer codeUpdateCount;
    private Integer myUpdateCount;
    private String type;
    private Integer likeCount;
    private Integer storeCount;
    private Integer storeFlag;
    private Integer likeFlag;
    private ProjectSchedule projectSchedule;
    private ProjectType projectType;
}

