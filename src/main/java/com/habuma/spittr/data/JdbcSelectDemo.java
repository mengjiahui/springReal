package com.habuma.spittr.data;

import spittr.Spitter;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcSelectDemo {

    // insert into cmf.tm_fund_channel (FUND_CHANNEL_CODE, NAME, DESCRIPTION, INST_CODE, BIZ_TYPE, PAY_MODE, SIGNED_CROP, STATUS, VALID_FROM, VALID_TO, MAX_AMOUNT, MIN_AMOUNT, EXPECT_ARRIVE_TIME, GMT_CREATE, GMT_MODIFIED, MEMO, CHANNEL_MODE, PRIORITY)
    //values (&channel_code, &channel_name, &channel_desc, &inst_code, &biz_type, &pay_mode, 'S', 'VALID', sysdate, sysdate, &channel_max_lmt, &channel_min_lmt, 'T+15M', sysdate, sysdate, '', &channel_mode, &channel_priority);
    //'CEB00998','光大快捷','CEB','QPAY','INVALID'
    private static final String SQL_INSERT_SPITTER="SELECT FUND_CHANNEL_CODE, NAME, INST_CODE, PAY_MODE, STATUS FROM tm_fund_channel WHERE FUND_CHANNEL_CODE=?";
    private DataSource dataSource;

    public Spitter findSpitter(String fundChannelCode){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            if(this.dataSource!=null){
                conn=dataSource.getConnection();
            }else {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    conn=DriverManager.getConnection("jdbc:oracle:thin:@10.1.210.179:1521:dev","cmfuser","cmfuser");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            stmt=conn.prepareStatement(SQL_INSERT_SPITTER);
            stmt.setString(1,fundChannelCode);
            rs=stmt.executeQuery();
            Spitter spitter=new Spitter();
            if (rs.next()){
                spitter.setUsername(rs.getString("FUND_CHANNEL_CODE"));
                spitter.setEmail(rs.getString("NAME"));
                spitter.setFirstName(rs.getString("INST_CODE"));
                spitter.setLastName(rs.getString("PAY_MODE"));
                spitter.setPassword(rs.getString("STATUS"));
            }
            System.out.println(spitter);
            return spitter;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if(stmt!=null){
                    stmt.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        JdbcSelectDemo demo=new JdbcSelectDemo();
        demo.findSpitter("QNUC20101");//CEB00998

    }
}
