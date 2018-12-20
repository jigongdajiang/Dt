package com.gjg.dt.date;

import com.gjg.dt.DtBean;
import com.gjg.dt.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gaojigong
 * @date : 2018/12/11
 * @description:
 */


public class Data20181211 {
    public static final String DATE = "2018-12-11";
    public static List<DtBean> getOrgDatas(){
        List<DtBean> datas = new ArrayList<>();
        datas.add(new DtBean("上证红利", Util.getPer2(14.01)));
        datas.add(new DtBean("50AH优选", Util.getPer2(12.73)));
        datas.add(new DtBean("中证红利", Util.getPer2(13.25)));
        datas.add(new DtBean("基本面50", Util.getPer2(11.8)));
        datas.add(new DtBean("央视50", Util.getPer2(11.39f)));
        datas.add(new DtBean("H股指数", Util.getPer2(11.64)));
        return datas;
    }
}
