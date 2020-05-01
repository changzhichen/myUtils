package com.czc.designPattern;

/**
 * @author changzhichen
 * @date 2020-05-01 17:21
 */
public class StudentAction extends TemplateDesignPattern {

    @Override
    protected void login() {
        System.out.println("学生进入学校");
    }

    @Override
    protected void getMeasure() {
        System.out.println("学生测温");
    }

    @Override
    protected void go2Class() {
        System.out.println("学生进入班级");
    }

    @Override
    protected void logout() {
        System.out.println("学生离开学校");
    }

}
