package com.gjg.dt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : gaojigong
 * @date : 2018/12/11
 * @description:
 */


public class Util {
    /**
     * 得到要投资的列表
     * @param datas
     * @return
     */
    public static List<DtBean> getCompleteDatas(List<DtBean> datas){
        datas.add(getYangLao(datas));
        return datas;
    }

    public static List<DtBean> completeDatas(List<DtBean> datas,int budget) {
        double sum = 0.0;
        for (DtBean dtBean : datas) {
            sum += (dtBean.getEp() - 10);
        }
        double avr = getPer2(sum)/datas.size();
        double moneryTotal = getStart(getPer2(avr),budget);
        for (DtBean dtBean : datas) {
            double per = (dtBean.getEp() - 10) / sum;
            dtBean.setPer(getPer2(per));
            dtBean.setAcount((int) (moneryTotal * dtBean.getPer()));
        }
        return datas;
    }

    /**
     * 按照第一次投资时的平均EP-10为基准决定本次参考额度时的实际投资总额
     * @param avr
     * @return
     */
    public static double getStart(double avr,int budget) {
        return  getPer2(budget * avr / DtBean.AVR);
    }

    /**
     * 获取养老的EP，取已知里面最低的作为养老的比例
     * @param datas
     * @return
     */
    public static DtBean getYangLao(List<DtBean> datas) {
        DtBean yanglao = new DtBean("中证养老");
        List<DtBean> temp = new ArrayList<>();
        temp.clear();
        temp.addAll(datas);
        Collections.sort(temp, new Comparator<DtBean>() {
            @Override
            public int compare(DtBean o1, DtBean o2) {
                if (o1.getEp() > o2.getEp()) {
                    return 1;
                } else if (o1.getEp() < o2.getEp()) {
                    return -1;
                }
                return 0;
            }
        });
        yanglao.setEp(temp.get(0).getEp());
        return yanglao;
    }

    /**
     * 四舍五入取两位小数
     * @param f
     * @return
     */
    public static double getPer2(double f) {
        BigDecimal bg = new BigDecimal(f);
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static int print(String date,List<DtBean> orgDatas,int budget){
        System.out.println("******************************************************************");
        System.out.println("                       "+date+"投资记录                         ");
        System.out.println("******************************************************************");
        List<DtBean> datas = Util.completeDatas(Util.getCompleteDatas(orgDatas),budget);
        int sum = 0;
        for (DtBean dtBean : datas) {
            sum += dtBean.getAcount();
            System.out.print(dtBean.toString());
        }
        System.out.println("");
        System.out.println("本期投资金额: "+sum);
        System.out.println("******************************************************************");
        return sum;
    }
}
