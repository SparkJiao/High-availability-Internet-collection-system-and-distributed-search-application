package com.sdu.utils;

/**
 * Created by kkkkkk on 2018/7/2.
 */
public class Message<T> {

    private boolean flag;
    private String msg;
    private T obj;

    public Message(boolean flag){
        this.flag = flag;
        this.msg = "";
        this.obj = null;
    }

    public Message(boolean flag, String msg){
        this.flag = flag;
        this.msg = msg;
        this.obj = null;
    }

    public Message(boolean flag, String msg, T obj){
        this.flag = flag;
        this.msg = msg;
        this.obj = obj;
    }

    public Message(){

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
