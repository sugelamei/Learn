package xiongchang.jdk8.bean;

import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalThreadDate {

   private static final ThreadLocal<DateFormat> df  = new ThreadLocal<DateFormat>(){
       @Override
       protected DateFormat initialValue(){

           return new SimpleDateFormat("yyyyMMdd");
       }
   };




    public static Date covert(String  str) throws ParseException {
        return df.get().parse(str);
    }


}
