package com.czc.designPattern;

/**
 * @author changzhichen
 * @date 2020-05-01 17:27
 */
public class Test {
    public static void main(String[] args) {
        StudentAction studentAction = new StudentAction();
        studentAction.baseMethod();

        TeacherAction teacherAction = new TeacherAction();
        teacherAction.baseMethod();

    }
}
