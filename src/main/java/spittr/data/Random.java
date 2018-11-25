package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Random implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList=new ArrayList<>();
        Spittle s=new Spittle("happy", new Date(), 2.20, 3.171);
        spittleList.add(s);
        return spittleList;
    }

    @Override
    public Object findOne(long spittleId) {
        return null;
    }
}
