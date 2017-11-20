package com.micro.service.core.datasource;

/**
 * @author Fermi(fermi@youleyu.com)
 * @date Aug 18, 2014
 * @desc
 */
public class DataSourceHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setDataSourceName(String name) {
        holder.set(name);
    }

    public static String getDataSourceName() {

        return holder.get();
    }

    public static void clearDataSourceName() {

        holder.remove();
    }
}
