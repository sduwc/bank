package com.bank;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;


public class QuickStart {
    static Scanner scanner = new Scanner(System.in);// 获得控制台输入流
    static User loginUser;

    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎进入网上银行系统!");
            while (!login()){
            }
            System.out.println("登录成功！欢迎" + loginUser.getUserName() + "同学");
            while (!doBusiness()) {
            }
            System.out.println("已退出登录");
        }

    }

    public static boolean login() {
        System.out.println("请输入银行卡号：");
        String cardId = scanner.nextLine();// 获得用户输入
        System.out.println("请输入密码：");
        String password = scanner.nextLine();// 获得用户输入
        User user = DBUtil.getUserByCardId(cardId);
        if (user != null && user.getCardPwd().equals(password)) {
            //success
            loginUser = user;
            return true;
        }
        //failed
        System.out.println("银行卡和密码输入有误！请重新输入");
        return false;

    }

    public static boolean doBusiness() {
        System.out.println("请输入您要进行的操作类型，按回车结束");
        System.out.println("存款：1 取款：2 余额：3 退出：0");

        String bus = scanner.nextLine();// 获得用户输入
        switch (bus) {
            case "1":
                System.out.println("存款：请输入存款金额：");
                String saveMoneyStr = scanner.nextLine();// 获得用户输入
                double saveMoney = 0;
                try {
                    saveMoney = Double.parseDouble(saveMoneyStr);
                } catch (Exception e) {
                    System.out.println("输入有误");
                }
                Bank.saveMoney(loginUser, saveMoney);
                System.out.println("存款成功！现有余额为：" + new BigDecimal(loginUser.getAccount()).toString());
                break;
            case "2":
                System.out.println("取款：请输入取款金额：");
                String takeMoneyStr = scanner.nextLine();// 获得用户输入
                double takeMoney = 0;
                try {
                    takeMoney = Double.parseDouble(takeMoneyStr);
                } catch (Exception e) {
                    System.out.println("输入有误");
                }
                if (!Bank.takeMoney(loginUser, takeMoney)) {
                    System.out.println("取款失败，余额不足！");
                }
                System.out.println("取款成功！现有余额为：" + new BigDecimal(loginUser.getAccount()).toString());
                break;
            case "3":
                double account = loginUser.getAccount();
                System.out.println("现有余额为:" + new BigDecimal(account).toString());
                break;
            case "0":
                return true;
        }
        return false;

    }
}
