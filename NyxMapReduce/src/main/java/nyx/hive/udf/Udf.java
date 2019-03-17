package nyx.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class Udf extends UDF {

    public Text evalute(Text text){
        return evaluate(text,"lower");
    }
    /**
     * 对参数t进行大小写转换
     * @param t
     * @param lowerOrUpper
     * @return
     */
    public Text evaluate(Text t,String lowerOrUpper){
        if(t == null){
            return t;
        }
        if("lower".equals(lowerOrUpper)){
            return new Text(t.toString().toLowerCase());
        }
        else if("upper".equals(lowerOrUpper)){
            return new Text(t.toString().toUpperCase());
        }
        return t;
    }
}
