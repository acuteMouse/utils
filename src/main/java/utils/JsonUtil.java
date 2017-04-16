package utils;


import Model.Worker;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：采用Jackson 操作json
 * Created by cgl on 2017/4/16 0016.
 */
public class JsonUtil {
    private static ObjectMapper mapper = null;

    /**
     * 单例双锁 线程安全
     *
     * @return
     */
    public static ObjectMapper getMapper() {
        if (mapper == null) {
            synchronized (ObjectMapper.class) {
                if (mapper == null)
                    mapper = new ObjectMapper();
            }
        }
        return mapper;
    }

    /**
     * 对象转成json
     *
     * @param o
     * @return
     * @throws IOException
     */
    public static String toJson(Object o) throws IOException {
        ObjectMapper mapper = getMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
        mapper.writeValue(gen, o);
        gen.flush();
        gen.close();
        return sw.toString();
    }

    /**
     * 单个字符串解析成java对象
     *
     * @param json
     * @param clazz java对象的class对象
     *              * @return
     * @throws IOException
     */
    public static Object toObject(String json, Class clazz) throws IOException {
        return getMapper().readValue(json, clazz);
    }

    /**
     * json解析成list
     *
     * @param json
     * @param typeReference    such as new TypeReference<List<Worker>>() {}
     * @return
     * @throws IOException
     */
    public static <T> List<T> toList(String json, TypeReference<List<T>> typeReference ) throws java.io.IOException {
        return JsonUtil.getMapper().readValue(json, typeReference);
    }


}
