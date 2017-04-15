package utils;

import Exceptions.NotCollectionException;
import org.apache.poi.ss.formula.functions.T;

import java.util.Collection;

/**
 * Created by cgl on 2017/4/15 0015.
 */
public class CollectionsUtil {

    public static  boolean isNotNull  (Collection<T > collection) throws NotCollectionException {
        if (!(collection instanceof Collection)){
            throw  new NotCollectionException("the parameter you inputted  is not a  collection");
        }
        return (collection!=null&&collection.size()>0);
    }
}
