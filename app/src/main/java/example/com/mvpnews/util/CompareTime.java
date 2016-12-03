package example.com.mvpnews.util;

/**
 * Created by ASUS-NB on 2016/12/3.
 */

public class CompareTime {
    public static boolean parseData(String data,String lastData){
        String[] dataFragment=data.split("-");
        String[] dataFragment1=dataFragment[2].split(" ");
        String[] dataFragment2=dataFragment1[1].split(":");
        String[] data1Fragment=lastData.split("-");
        String[] data1Fragment1=data1Fragment[2].split(" ");
        String[] data1Fragment2=data1Fragment1[1].split(":");
        if(Integer.parseInt(dataFragment[0])<Integer.parseInt(data1Fragment[0])){
            return false;
        }else if(Integer.parseInt(dataFragment[1])<Integer.parseInt(data1Fragment[1])){
            return false;
        }else if(Integer.parseInt(dataFragment1[0])<Integer.parseInt(data1Fragment1[0])){
            return false;
        }else if(Integer.parseInt(dataFragment2[0])<Integer.parseInt(data1Fragment2[0])){
            return false;
        }else if(Integer.parseInt(dataFragment2[1])<Integer.parseInt(data1Fragment2[1])){
            return false;
        }
        return true;
    }
}
