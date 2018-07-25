package com.sdu.utils;

/**
 * Created by kkkkkk on 2018/7/24.
 */
public class StringProcess {

    public static String deleteBlankSpace(String target){
        target = target.replaceAll(" ","");
        target = target.replaceAll("★", "");
        target = target.replaceAll("◆", "");
        target = target.replaceAll("\n","");
        return target;
  }
}
