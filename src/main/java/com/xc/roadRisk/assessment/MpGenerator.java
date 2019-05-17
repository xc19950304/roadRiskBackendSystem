package com.xc.roadRisk.assessment;

import com.xc.roadRisk.common.utils.MpGeneratorUtils;

/**
 * 代码生成
 */
public class MpGenerator {

    public static void main(String[] args) {
        String sourcePath = MpGenerator.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String basePackage = "com.xc.roadRisk.assessment";
        String tableNames[] = {"location","task_type","water_level","road_basic","rain_fall"
                    ,"people","reservoir","geo_enviroment","road_risk_task"};
        if (sourcePath.endsWith("target/classes/")) {
            sourcePath = sourcePath.substring(0, sourcePath.lastIndexOf("target/classes/"));
        }
        sourcePath = sourcePath + "src/main/java/";
        System.out.println("代码生成路径：" + sourcePath);
        MpGeneratorUtils.generate(sourcePath, basePackage, tableNames);
    }

}
