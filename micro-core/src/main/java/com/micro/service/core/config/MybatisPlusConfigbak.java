package com.micro.service.core.config;//package com.spring.boot.springboot.config;
//
//import com.baomidou.mybatisplus.MybatisConfiguration;
//import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
//import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
//import com.baomidou.mybatisplus.plugins.parser.ISqlParser;
//import com.baomidou.mybatisplus.plugins.parser.ISqlParserFilter;
//import com.baomidou.mybatisplus.plugins.parser.tenant.TenantHandler;
//import com.baomidou.mybatisplus.plugins.parser.tenant.TenantSqlParser;
//import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
//import com.baomidou.mybatisplus.spring.boot.starter.SpringBootVFS;
//import com.baomidou.mybatisplus.toolkit.PluginUtils;
//import net.sf.jsqlparser.expression.Expression;
//import net.sf.jsqlparser.expression.LongValue;
//import org.apache.ibatis.mapping.DatabaseIdProvider;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.reflection.MetaObject;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.util.ObjectUtils;
//import org.springframework.util.StringUtils;
//
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@MapperScan("com.spring.boot.springboot.dao*")
//public class MybatisPlusConfigbak {
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private MybatisProperties properties;
//
//    @Autowired
//    private ResourceLoader resourceLoader = new DefaultResourceLoader();
//
//    @Autowired(required = false)
//    private Interceptor[] interceptors;
//
//    @Autowired(required = false)
//    private DatabaseIdProvider databaseIdProvider;
//
//    /**
//     *   mybatis-plus分页插件
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setDialectType("mysql");
//        return page;
//    }
//    /**
//     * 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定
//     * 配置文件和mybatis-boot的配置文件同步
//     * @return
//     */
//    @Bean
//    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
//        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
//        mybatisPlus.setDataSource(dataSource);
//        mybatisPlus.setVfs(SpringBootVFS.class);
//        if (StringUtils.hasText(this.properties.getConfigLocation())) {
//            mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
//        }
//        mybatisPlus.setConfiguration(properties.getConfiguration());
//        if (!ObjectUtils.isEmpty(this.interceptors)) {
//            mybatisPlus.setPlugins(this.interceptors);
//        }
//        MybatisConfiguration mc = new MybatisConfiguration();
//        mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        mybatisPlus.setConfiguration(mc);
//        if (this.databaseIdProvider != null) {
//            mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
//        }
//        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
//            mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
//        }
//        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
//            mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//        }
//        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
//            mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
//        }
//        return mybatisPlus;
//    }
//
//
//}
