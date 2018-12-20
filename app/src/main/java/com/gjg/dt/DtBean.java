package com.gjg.dt;


/**
 * @author : gaojigong
 * @date : 2018/12/11
 * @description:
 */


public class DtBean{
    public static final double AVR = 2.32;
    private String name;
    private double ep;
    private double per;
    private int acount;

    public DtBean(String name) {
        this.name = name;
    }

    public DtBean(String name, double ep) {
        this.name = name;
        this.ep = ep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEp() {
        return ep;
    }

    public void setEp(double ep) {
        this.ep = ep;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public int getAcount() {
        return acount;
    }

    public void setAcount(int acount) {
        this.acount = acount;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "    盈利收益率=" + ep +
                "    投资占比=" + per * 100 + "%" +
                "    投资金额=" + acount +
                '\n';
    }
}
