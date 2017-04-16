package utils;

import Model.Worker;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * 功能：
 * Created by cgl on 2017/4/16 0016.
 */
public class JsonUtilTest {
    @Test
    public void toJson() throws Exception {
        List<Worker> workerList=new ArrayList<>();
        for (int i = 0; i < 15000; i++) {
            Worker worker=new Worker("一",i,new Date());
              workerList.add(worker);
        }
        System.out.println(JsonUtil.toJson(workerList));
    }

    @Test
    public void getMapper() throws Exception {
        List<ObjectMapper> mappers=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Runnable runnable= () -> {
                System.out.println(Thread.currentThread());
                mappers.add(JsonUtil.getMapper());
                System.out.println(JsonUtil.getMapper());

            };
            new  Thread(runnable).start();
        }
        Thread.sleep(1000);
        for(ObjectMapper mapper:mappers){
            System.out.println(mapper);
        }


    }

}