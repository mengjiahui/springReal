package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import spittr.AspectJ.LogProcess;
import spittr.Spitter;

import javax.sql.RowSet;

@Repository
@PropertySource("classpath:app.properties")
public class PeopleMarket implements SpitterRepository {

    private JdbcOperations jdbcOperations;
    @Autowired
    Environment env;

    public PeopleMarket(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public LogProcess logProcess;

    public void markAnything(){
        env.getProperty("singCount",Integer.class);//解析成Integer
        env.getProperty("singCount",Integer.class,30);//解析成Integer,默认值30
        System.out.println("just for test,songer:"+ env.getProperty("songer")+","+env.getProperty("song","我是默认值"));
    }

    @Override
    public Spitter save(Spitter unsaved) {
//        String INSERT_SPITTER="insert into tm_fund_channel (FUND_CHANNEL_CODE, NAME, INST_CODE, PAY_MODE, STATUS) " +
//                "values (?,?,?,?,?)";

        SqlRowSet rs = this.jdbcOperations.queryForRowSet("SELECT FUND_CHANNEL_CODE, NAME, INST_CODE, PAY_MODE, STATUS FROM tm_fund_channel WHERE FUND_CHANNEL_CODE='QNUC20101'");
        if (rs.next()) {
            System.out.println(rs.getString("NAME"));
        }
        //        this.jdbcOperations.update(INSERT_SPITTER,
//                unsaved.getUsername(),
//                unsaved.getEmail(),
//                unsaved.getFirstName(),
//                unsaved.getLastName(),
//                unsaved.getEmail());
        return null;

    }

    @Override
    public void atLeastOnce() {

    }


    @Override
    public Spitter findByUsername(String username) {
        Spitter spitter=null;
        SqlRowSet rs = this.jdbcOperations.queryForRowSet(
                "SELECT FUND_CHANNEL_CODE, NAME, INST_CODE, PAY_MODE, STATUS " +
                        "FROM tm_fund_channel " +
                        "WHERE FUND_CHANNEL_CODE='QNUC20101'");
        if (rs.next()) {
            spitter=new Spitter();
            spitter.setPassword(rs.getString("FUND_CHANNEL_CODE"));
            spitter.setLastName(rs.getString("NAME"));
            spitter.setFirstName(rs.getString("INST_CODE"));
            spitter.setUsername(rs.getString("PAY_MODE"));
            spitter.setEmail(rs.getString("STATUS"));
        }

        return spitter;
    }
}
