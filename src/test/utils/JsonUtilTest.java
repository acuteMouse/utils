package utils;

import Model.Worker;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * 功能：json工具类的单元测试
 * Created by cgl on 2017/4/16 0016.
 */
public class JsonUtilTest {

    @Test
    public void toList() throws Exception {
        List<Worker> workerList = new ArrayList<>();
        for (int i = 0; i < 15000; i++) {
            Worker worker = new Worker("一", i, new Date());
            workerList.add(worker);
        }
        String workerStr = JsonUtil.toJson(workerList);
        List<Worker> workers = JsonUtil.toList(workerStr, new TypeReference<List<Worker>>() {
        });
        workers.stream().forEach(worker -> System.out.println(worker));

    }

    @Test
    public void toObject() throws Exception {
        Worker worker = (Worker) JsonUtil.toObject(JsonUtil.toJson(new Worker("yi", 1, new Date())), Worker.class);
        System.out.println(worker.getName());
    }

    @Test
    public void toJson() throws Exception {
        List<Worker> workerList = new ArrayList<>();
        for (int i = 0; i < 15000; i++) {
            Worker worker = new Worker("一", i, new Date());
            workerList.add(worker);
        }
        System.out.println(JsonUtil.toJson(workerList));
    }

    @Test
    public void getMapper() throws Exception {
        List<ObjectMapper> mappers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread());
                mappers.add(JsonUtil.getMapper());
                System.out.println(JsonUtil.getMapper());

            };
            new Thread(runnable).start();
        }
        Thread.sleep(1000);
        mappers.stream().forEach(mapper -> System.out.println(mapper));
    }

}