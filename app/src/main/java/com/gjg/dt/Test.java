package com.gjg.dt;

import com.gjg.dt.date.Data20181211;
import com.gjg.dt.date.Data20181220;

/**
 * @author : gaojigong
 * @date : 2018/12/11
 * @description:
 */


public class Test {
    public static void main(String[] args) {
        int sum = 10000;
        System.out.println("+++++++++++++++++++++上证50AH初始持有:"+sum+"元++++++++++++++++++++++");
        sum += Util.print(Data20181211.DATE,Data20181211.getOrgDatas(),10000);
        sum += Util.print(Data20181220.DATE,Data20181220.getOrgDatas(),3000);


        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~当前总投资金额:"+sum+"元~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
