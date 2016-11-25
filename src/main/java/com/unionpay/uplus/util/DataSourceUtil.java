package com.unionpay.uplus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * date: 2016/11/25 16:53
 * author: yueqi.shi
 */

public class DataSourceUtil {
    private static final String strUrl = "jdbc:mysql://172.21.101.175:60001/uplus?autoReconnect=true&UseUnicode=true&"
            + "characterEncoding=utf8";
    private static final String strDriver = "com.mysql.jdbc.Driver";
    private static final String strMySQLUsername = "cup_dba";
    private static final String strMySQLPassword = "123456";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(strDriver).newInstance();
            connection = DriverManager.getConnection(strUrl, strMySQLUsername, strMySQLPassword);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
//    private static DataSource dataSource;
//    private static final String DS_NAME = "java:/uplusDS";
//
//    //private static final Logger logger = Logger.getLogger(DatasourceUtil.class);
//
//    public static DataSource getDatasource() {
//        if (dataSource == null) {
//            InitialContext ic;
//            try {
//                ic = new InitialContext();
//                dataSource = (DataSource) ic.lookup(DS_NAME);
//            } catch (NamingException e) {
//                //logger.error("Error lookup datasource!", e);
//            }
//        }
//        return dataSource;
//    }
}
