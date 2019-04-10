package com.kgc.DvdSystem;
//声明数据存储空间（50），并初始化
public class DvdData {
    public static  String[]dvd_name=new String[50];
    public static  int[] dvd_status=new int[50];
    public static  int[] dvd_price=new int[50];
    public static  int[] dvd_history=new int[50];
    public static  int[] dvd_days=new int[50];
    public static void init(){
       dvd_name[0]="流浪地球";
       dvd_price[0]=15;
        dvd_name[1]="疯狂的石头";
        dvd_price[1]=5;
        dvd_name[2]="魔兽世界";
        dvd_price[2]=10;
        dvd_name[3]="普罗米修斯";
        dvd_price[3]=4;
        dvd_name[4]="虹猫蓝兔七侠传";
        dvd_price[4]=10;
        dvd_name[5]="太极";
        dvd_price[5]=5;
        dvd_name[6]="SNIS-531";
        dvd_price[6]=15;
        dvd_name[7]="变形金刚";
        dvd_price[7]=10;
        dvd_name[8]="乔布斯传";
        dvd_price[8]=7;
        dvd_name[9]="阿甘正传";
        dvd_price[9]=6;
    }
}
