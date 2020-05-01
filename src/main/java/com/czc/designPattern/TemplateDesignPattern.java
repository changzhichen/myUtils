package com.czc.designPattern;

/**
 * @author changzhichen
 * @date 2020-05-01 17:13
 */
public abstract class TemplateDesignPattern {

    public final void baseMethod() {
        login();
        getMeasure();
        if (isGo2Class()) {
            go2Class();
        }

        logout();
    }

    protected boolean isGo2Class() {
        return true;
    }

    protected abstract void login();

    protected abstract void getMeasure();

    protected abstract void go2Class();

    protected abstract void logout();
}
