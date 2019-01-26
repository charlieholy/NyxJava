package utils;

public class Logger {

    private static AnyWayLog anyWayLog = new AnyWayLog("Nyx");

    public static void info(String content){
        anyWayLog.INFO(content);
    }
    public static void error(String identify,String content,Throwable e){
        anyWayLog.ERROR(content,e);
    }
}
