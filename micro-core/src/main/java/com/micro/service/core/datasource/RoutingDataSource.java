package com.micro.service.core.datasource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * @author Fermi(fermi@youleyu.com)
 * @date Aug 18, 2014
 * @desc
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        Object obj = DataSourceHolder.getDataSourceName();
        return obj;
    }

}
