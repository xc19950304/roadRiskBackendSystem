package com.xc.roadRisk.common;

public class Conf {

    public static class MpGeneratorConf{
        public static String author = "xiongchang";

        public static String jdbcDriver = "com.mysql.jdbc.Driver";
        public static String host = "127.0.0.1";
        public static String port = "3306";
        public static String dbName = "road_risk";
        public static String jdbcUrl = "jdbc:mysql://"+host+":"+port+"/"+dbName+"?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        public static String username ="root";
        public static String Password ="root";

        public static String serviceName ="%sApi";
        public static String serviceImplName ="%sService";
        public static String daoName ="%sDao";
        public static String daoXmlName ="%sDao";

        public static String BaseEntity ="com.xc.roadRisk.common.base.BaseEntity";
        public static String BaseService ="com.xc.roadRisk.common.base.BaseService";
        public static String tablePrefix ="";

        public static String controllerPackageName ="controller";
        public static String entityPackageName ="entity";
        public static String mapperPackageName ="dao";
        public static String xmlPackageName ="dao";
        public static String servicePackageName ="api";
        public static String serviceImplPackageName ="service";

        public static String controllerTemplate ="/template/controller.java.vm";
        public static String entityTemplate ="/template/entity.java.vm";
        public static String mapperTemplate ="/template/mapper.java.vm";
        public static String xmlTemplate ="/template/mapper.xml.vm";
        public static String serviceTemplate ="/template/service.java.vm";
        public static String serviceImplTemplate ="/template/serviceImpl.java.vm";
    }
}
