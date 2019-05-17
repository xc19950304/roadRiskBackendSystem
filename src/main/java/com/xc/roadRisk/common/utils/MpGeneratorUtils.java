package com.xc.roadRisk.common.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.xc.roadRisk.common.Conf;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MpGeneratorUtils {

    /**
     * @param sourcePath
     * @param basePackage
     * @param tableNames
     */
    public static void generate(String sourcePath, String basePackage, String[] tableNames) {
        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setAuthor(Conf.MpGeneratorConf.author)
                .setOutputDir(sourcePath)
                .setServiceName(Conf.MpGeneratorConf.serviceName)
                .setServiceImplName(Conf.MpGeneratorConf.serviceImplName)
                .setMapperName(Conf.MpGeneratorConf.daoName)
                .setXmlName(Conf.MpGeneratorConf.daoXmlName)
                .setOpen(false)
                .setEnableCache(false)
                //是否覆盖已经生成的文件
                .setFileOverride(false);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(Conf.MpGeneratorConf.jdbcDriver)
                .setUrl(Conf.MpGeneratorConf.jdbcUrl)
                .setUsername(Conf.MpGeneratorConf.username)
                .setPassword(Conf.MpGeneratorConf.Password);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
//                .setCapitalMode(false)
//                .setDbColumnUnderline(true)
//                .setTablePrefix("ec_")
                .entityTableFieldAnnotationEnable(true)
                .setRestControllerStyle(true)
                .setEntityLombokModel(false)
                .setSuperEntityClass(Conf.MpGeneratorConf.BaseEntity)
                .setSuperEntityColumns("id", "uid", "create_user_id", "create_date", "last_update_user_id", "last_update_date")
//                .setSuperServiceClass("")
                .setSuperServiceImplClass(Conf.MpGeneratorConf.BaseService)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(basePackage)
                .setController(Conf.MpGeneratorConf.controllerPackageName)
                .setService(Conf.MpGeneratorConf.servicePackageName)
                .setServiceImpl(Conf.MpGeneratorConf.serviceImplPackageName)
                .setMapper(Conf.MpGeneratorConf.mapperPackageName)
                .setXml(Conf.MpGeneratorConf.xmlPackageName)
                .setEntity(Conf.MpGeneratorConf.entityPackageName);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(Conf.MpGeneratorConf.controllerTemplate)
                .setEntity(Conf.MpGeneratorConf.entityTemplate)
                .setMapper(Conf.MpGeneratorConf.mapperTemplate)
                .setXml(Conf.MpGeneratorConf.xmlTemplate)
                .setService(Conf.MpGeneratorConf.serviceTemplate)
                .setServiceImpl(Conf.MpGeneratorConf.serviceImplTemplate);

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplate(templateConfig)
                .execute();
    }

}
