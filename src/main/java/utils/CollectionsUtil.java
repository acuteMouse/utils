package utils;

import Exceptions.NotCollectionException;
import org.apache.poi.ss.formula.functions.T;

import java.util.Collection;
import java.util.Map;

/**
 * Created by cgl on 2017/4/15 0015.
 */

public class CollectionsUtil {

    /**
     *  判断集合不为空
     * @param collection
     * @return
     * @throws NotCollectionException
     */
    public static  boolean isNotNull  (Collection<?> collection) throws NotCollectionException {
        if (!(collection instanceof Collection)){
            throw  new NotCollectionException("the parameter you inputted  is not a  collection");
        }
        return (collection!=null&&collection.size()>0);
    }

    public static boolean mapIsNotNull(Map map){
         return (map!=null&&map.size()>0);
    }
}
