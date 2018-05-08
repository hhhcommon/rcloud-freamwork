package com.rcloud.springboot.datasource;

import lombok.Data;

/**
 * <Description> Druid数据源配置项
 * 
 * @author wanghao
 * @CreateDate 2018年3月15日 上午8:50:10
 * @since V1.0
 * @see com.rcloud.springboot.datasource
 */
@Data
public class DruidDbProperties {

    private String id;

    private String url;

    private String driverClassName = "com.mysql.jdbc.Driver";

    /**
     * 初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
     */
    private int initialSize = 1;

    /**
     * 最小连接池数量
     */
    private int minIdle = 10;

    /**
     * 最大连接池数量
     */
    private int maxActive = 100;

    /**
     * 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
     */
    private int maxWait = 60000;

    /**
     * 有两个含义： 1) Destroy线程会检测连接的间隔时间，如果连接空闲时间大于等于minEvictableIdleTimeMillis则关闭物理连接。 2)
     * testWhileIdle的判断依据，详细看testWhileIdle属性的说明
     */
    private int timeBetweenEvictionRunsMillis = 60000;

    /**
     * 连接保持空闲而不被驱逐的最长时间
     */
    private int minEvictableIdleTimeMillis = 3600000;

    /**
     * 用来检测连接是否有效的sql，要求是一个查询语句，常用select 'x'。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
     */
    private String validationQuery = "SELECT 'X'";

    /**
     * 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
     */
    private boolean testWhileIdle = true;

    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
     */
    private boolean testOnBorrow = false;

    /**
     * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
     */
    private boolean testOnReturn = false;

    /**
     * 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有： 监控统计用的filter:stat 日志用的filter:log4j 防御sql注入的filter:wall
     */
    private String filters = "mergeStat,config,wall";

    private String connectionProperties;

    /**
     * 白名单
     */
    private String allow;

    /**
     * 黑名单
     */
    private String deny;

    /**
     * 用户名
     */
    private String username = "";

    /**
     * 密码
     */
    private String password = "";
}