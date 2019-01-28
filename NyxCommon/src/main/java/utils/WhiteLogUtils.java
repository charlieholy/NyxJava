package utils;

import java.util.HashMap;

/**
 * Created by chenpeiwen on 2019/1/28
 */
public class WhiteLogUtils {
    private static HashMap<String,AnyWayLog> maps = new HashMap<>();

    private static synchronized AnyWayLog getOne(String identify){
        AnyWayLog anyWayLog = maps.get(identify);
        if(anyWayLog == null){
            anyWayLog = new AnyWayLog(identify);
        }
        return anyWayLog;
    }

    public static void append(String identify,String msg){
        getOne(identify).INFO(msg);
    }
}
