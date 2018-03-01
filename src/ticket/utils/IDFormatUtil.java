package ticket.utils;


/**
 * Created by Jiayiwu on 17/2/10.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class IDFormatUtil {

    public  static String encodeVipId(int id){
        String result = id+"";
        int length = result.length();
        for (int i = 0;i<5-length;i++){
            result = "0"+result;
        }
        return "VP"+result;
    }

    public static String encodeOrderId(int id){
        String result = id +"";
        int length = result.length();
        for (int i = 0;i<7-length;i++){
            result = "0"+result;
        }
        return result;
    }

    public static String encodeHotelId(int id){
        String result = id +"";
        int length = result.length();
        for (int i = 0;i<5-length;i++){
            result = "0"+result;
        }
        return "HT"+result;
    }

    public static int decodeVipId(String id){
        id = id.replace("VP","");
        return Integer.parseInt(id);
    }

    public static int decodeHotelId(String id){
        id = id.replace("HT","");
        return Integer.parseInt(id);
    }

    public static int decodeOrderId (String id){
        return Integer.parseInt(id);
    }
}
