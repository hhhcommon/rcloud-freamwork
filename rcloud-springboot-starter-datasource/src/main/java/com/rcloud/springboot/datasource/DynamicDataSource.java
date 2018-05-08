package com.rcloud.springboot.datasource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <Description> 动态数据源路由
 * 
 * @author wanghao
 * @CreateDate 2018年3月13日 上午11:29:28
 * @since V1.0
 * @see com.rcloud.springboot.datasource
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSource.getDataSourceKey();
    }

    /** * Maintain variable for every thread, to avoid effect other thread */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>() {

        /** * 将 default 数据源的 key 作为默认数据源的 key */
        @Override
        protected String initialValue() {
            return "default";
        }
    };

    /** * 数据源的 key 集合，用于切换时判断数据源是否存在 */
    public static List<Object> dataSourceKeys = new ArrayList<>();

    /** * To switch DataSource * * @param key the key */
    public static void setDataSourceKey(String key) {
        contextHolder.set(key);
    }

    /** * Get current DataSource * * @return data source key */
    public static String getDataSourceKey() {
        return contextHolder.get();
    }

    /** * To set DataSource as default */
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

    /** * Check if give DataSource is in current DataSource list * * @param key the key * @return boolean boolean */
    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }
}