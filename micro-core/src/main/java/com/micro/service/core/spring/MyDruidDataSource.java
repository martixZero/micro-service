package com.micro.service.core.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * USER:    suncg
 * TIME:    2015-08-21 14:22
 * COMMENT:
 */
public class MyDruidDataSource extends DruidDataSource {

    private static Logger logger = LoggerFactory.getLogger(MyDruidDataSource.class);

    @Override
    public void close() {
        super.close();

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while(drivers.hasMoreElements()) {
            try {
                Driver driver = drivers.nextElement();

                logger.info("destroy current driver : "+driver.getClass());

                DriverManager.deregisterDriver(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
