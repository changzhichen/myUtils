package com.czc.designPattern;

/**
 * @author changzhichen
 * @date 2020-05-01 17:25
 */
public class TeacherAction extends TemplateDesignPattern {
    @Override
    protected void login() {
        System.out.println("校长进入");
    }

    @Override
    protected void getMeasure() {
        System.out.println("校长测温");
    }

    @Override
    protected void go2Class() {
        System.out.println("校长不进入班级");
    }

    @Override
    protected void logout() {
        System.out.println("校长离开学校");
    }

    @Override
    protected boolean isGo2Class() {
        return false;
    }
}
