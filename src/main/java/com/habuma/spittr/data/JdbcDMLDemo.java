package com.habuma.spittr.data;

import spittr.Spitter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDMLDemo {

    // insert into cmf.tm_fund_channel (FUND_CHANNEL_CODE, NAME, DESCRIPTION, INST_CODE, BIZ_TYPE, PAY_MODE, SIGNED_CROP, STATUS, VALID_FROM, VALID_TO, MAX_AMOUNT, MIN_AMOUNT, EXPECT_ARRIVE_TIME, GMT_CREATE, GMT_MODIFIED, MEMO, CHANNEL_MODE, PRIORITY)
    //values (&channel_code, &channel_name, &channel_desc, &inst_code, &biz_type, &pay_mode, 'S', 'VALID', sysdate, sysdate, &channel_max_lmt, &channel_min_lmt, 'T+15M', sysdate, sysdate, '', &channel_mode, &channel_priority);
    //'CEB00998','光大快捷','CEB','QPAY','INVALID'
    private static final String SQL_INSERT_SPITTER="insert into tm_fund_channel (FUND_CHANNEL_CODE, NAME, INST_CODE, PAY_MODE, STATUS) values (?,?,?,?,?)";
    private DataSource dataSource;

    public void addSpitter(Spitter spitter){
        Connection conn=null;
        PreparedStatement stmt=null;
        try {
            conn=dataSource.getConnection();
            stmt=conn.prepareStatement(SQL_INSERT_SPITTER);
            stmt.setString(1,spitter.getUsername());
            stmt.setString(2,spitter.getEmail());
            stmt.setString(3,spitter.getFirstName());
            stmt.setString(4,spitter.getLastName());
            stmt.setString(5,spitter.getPassword());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
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


    }
}
