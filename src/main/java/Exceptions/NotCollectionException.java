package Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cgl on 2017/4/15 0015.
 */
public class NotCollectionException extends Exception{
   private Logger logger= LoggerFactory.getLogger(NotCollectionException.class);

    public NotCollectionException(String message) {
        super(message);
    }
}
