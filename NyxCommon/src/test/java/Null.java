public class Null {

    public static String getStringByP56Time(byte P56Time2a[]) {
        int year = (int)P56Time2a[6]& 0x7f;
        year=2000 + year;
        int month= (int)P56Time2a[5]& 0x0f;
        int day=(int)P56Time2a[4] & 0x1f;
        int hour=(int)P56Time2a[3]& 0x1f;
        int minute=(int)P56Time2a[2]& 0x3f;

        int MillSec = P56Time2a[0] & 0xff;
        MillSec |= (P56Time2a[1] & 0xff) << 8;

        long second= MillSec/1000 ;

        try {
            String in=String.format("%d-%02d-%02d %02d:%02d:%02d", year, month, day, hour,minute,second);
            return in;

        } catch (Exception e) {
            //logger.error("getP56Time2aTime exception,e.getStackTrace:{}",e.getMessage());

            return "";
        }

    }

    public static String bcd2StrDividFF(byte[] bytes){
        if(bytes==null || bytes.length<1){
            return "";
        }
        short valid_len=0;
        for(int i=0;i< bytes.length;i++) {
            if( (bytes[i]&0x0FF)==255) {
                break;
            }
            valid_len += 1;
        }
        if(valid_len<=0) {
            return "";
        }
        StringBuffer temp = new StringBuffer(valid_len * 2);
        for (int i = 0; i <valid_len; i++) {
            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
            byte b= (byte) (bytes[i] & 0x0f);
            if(b!=0x0f) {
                temp.append(b);
            }
        }
        return temp.toString();
    }

    public static String bcd2Str(byte[] bytes){
        if(bytes==null || bytes.length<1){
            return "";
        }
        int len= bytes.length;
        StringBuffer temp = new StringBuffer(len * 2);
        for (int i = 0; i <len; i++) {
            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
            temp.append((byte) (bytes[i] & 0x0f));
        }
        return temp.toString();
    }

    public static String cleanFirstZero(String value){

        String subString= value.substring(0,1);
        if(subString.equalsIgnoreCase("0")){
            return value.substring(1);
        }
        return value;
    }

    public static void main(String[] args) {
        String os_name = System.getProperty("os.name");
        System.out.println(os_name);

        System.out.println("nai");
        byte[] a = {0x00,0x2e,0x12,0x0d,0x02,0x03,0x13};
        String ss = getStringByP56Time(a);
        System.out.println(ss);

        //018916602617FFFF

        byte[] b = {0x01,(byte)0x89,0x16,0x60,0x26,0x17,(byte)0xff,(byte)0xff};
        String sss = bcd2StrDividFF(b);
        System.out.println(cleanFirstZero(sss));
    }
}
