package com.kgc.DvdSystem;

import java.util.Scanner;

public class DvdView {
    public static Scanner input=new Scanner(System.in);
    public static String dname=null;
    public static void main(String[] args) {
        DvdData.init();
        String result=null;
//系统主界面1
        do{
        System.out.println("——————DVD管理系统——————");
            System.out.println("1.浏览所有DVD");
            System.out.println("2.借出DVD");
            System.out.println("3.归还DVD");
            System.out.println("4.增加一个DVD");
            System.out.println("5.删除一个DVD");
            System.out.println("6.退出系统");
            System.out.println("请输入：");
            int command=input.nextInt();
            switch (command){
                //在屏幕上输出所有DVD信息
                case 1:
                    DvdManager.printall(DvdData.dvd_name);
                    break;
                    //借出DVD
                case 2:
                    System.out.println("请输入要借的DVD名称：");
                     dname=input.next();
                    DvdManager.DVD_RENT(dname);
                    break;
                    //归还DVD
                case 3:
                    System.out.println("请输入要归还的DVD名称：");
                    dname=input.next();
                    DvdManager.DVD_RETURN(dname);
                    break;
                    //增加DVD
                case 4:
                    System.out.println("请输入要增加的DVD名称");
                    dname=input.next();
                    System.out.println("请输入要增加的DVD价格");
                    int price=input.nextInt();
                    DvdManager.DVD_ADD(dname,price);
                    break;
                    //删除DVD
                case 5:
                    System.out.println("请输入要删除的DVD名称");
                    dname=input.next();
                    DvdManager.DVD_REMOVE(dname);
                    break;
                    //退出系统
                case 6:
                    return;

            }
            System.out.println("————————————————");
            System.out.println("输入任意键继续，输入no退出");
            result=input.next();


    }while (!result.equals("no"));
    }
}
