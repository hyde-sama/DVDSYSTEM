package com.kgc.DvdSystem;

import java.util.Scanner;

//
public class DvdManager {
    public static Scanner input = new Scanner(System.in);

    //显示所有DVD信息
    public static void printall(String[] a) {
        System.out.println("名称" + "\t\t\t" + "价格" + "\t\t" + "状态" + "\t\t" + "借出次数");
        for (int i = 0; i < DVD_EXIST_NUM(DvdData.dvd_name); i++) {
            System.out.println(DvdData.dvd_name[i] + "\t\t\t" + DvdData.dvd_price[i] + "\t\t" + ((DvdData.dvd_status[i] == 0) ? "未借出" : "已借出") + "\t\t" + DvdData.dvd_history[i]);
        }
    }

    //判断目前共有多少DVD
    public static int DVD_EXIST_NUM(String[] a) {
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                index++ ;
            }
        }
        return index;
    }

    //根据客户输入判断是否存在该DVD,并返还DVD的索引号
    public static int DVD_EXIST(String name) {
        int index = -1;
        for (int i = 0; i < DVD_EXIST_NUM(DvdData.dvd_name); i++) {
            if (name.equals(DvdData.dvd_name[i])) {
                index = i;
            }
        }
        return index;
    }

    //借出DVD,
    public static void DVD_RENT(String name) {
        if (DVD_EXIST(name) == -1) {
            System.out.println("对不起，您要借的DVD不存在");
        } else {
            if (DvdData.dvd_status[DVD_EXIST(name)] == 1) {
                System.out.println("对不起你要借的DVD已借出");
            } else {
                System.out.println("恭喜，你已借出" + name + ",祝你使用愉快");
                System.out.println("请输入你将要使用的时间（天）：");
                DvdData.dvd_days[DVD_EXIST(name)] = input.nextInt();
                DvdData.dvd_status[DVD_EXIST(name)] = 1;
            }
        }
    }

    //归还DVD，判断输入是否有效
    public static void DVD_RETURN(String name) {
        if (DVD_EXIST(name) == -1) {
            System.out.println("对不起，你要归还的DVD不存在");
        } else {
            if (DvdData.dvd_status[DVD_EXIST(name)] == 0) {
                System.out.println("对不起，你要归还的DVD未借出，请检查DVD名称是否正确");
            } else {
                System.out.println("你已成功归还" + name);
                DvdData.dvd_days[DVD_EXIST(name)] = 0;
                DvdData.dvd_status[DVD_EXIST(name)] = 0;
            }
        }
    }

    //增加DVD
    public static void DVD_ADD(String name, int price) {
        if (DVD_EXIST_NUM(DvdData.dvd_name) < 50) {
            if (DVD_EXIST(name) == -1) {
                DvdData.dvd_price[DVD_EXIST_NUM(DvdData.dvd_name)] = price;
                DvdData.dvd_name[DVD_EXIST_NUM(DvdData.dvd_name)] = name;
            } else {
                System.out.println("你要增加的DVD已存在");
            }
        } else {
            System.out.println("没有空位了，不能增加");
        }

    }

    //删除DVD
    public static void DVD_REMOVE(String name) {
            if (DVD_EXIST(name) != -1){
                if (DvdData.dvd_status[DVD_EXIST(name)] == 0){
                    int index=DVD_EXIST(name);
                    DvdData.dvd_name[index]=null;
                    DvdData.dvd_price[index]=0;
                    //将已删除DVD的相关所有数列进行替换补位
                    for (int i = index; i <DvdData.dvd_name.length-1; i++) {
                        DvdData.dvd_name[i]=DvdData.dvd_name[i+1];
                        DvdData.dvd_price[i]=DvdData.dvd_price[i+1];
                        DvdData.dvd_status[i]=DvdData.dvd_status[i+1];
                        DvdData.dvd_history[i]=DvdData.dvd_history[i+1];
                        DvdData.dvd_days[i]=DvdData.dvd_days[i+1];
                    }
                }else
                    {
                    System.out.println("你要删除的DVD已借出");
                }
            }else {
                System.out.println("你要删除的DVD不存在，请检查输入是否正确");
            }
        }
    }

