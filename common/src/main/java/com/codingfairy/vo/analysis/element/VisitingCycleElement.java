package com.codingfairy.vo.analysis.element;

import com.codingfairy.vo.Tuple;
import com.codingfairy.vo.analysis.ChartData;
import lombok.Data;

/**
 * Created by darxan on 2017/5/14.
 *
 * 来访周期：进⼊店铺或区域的顾客距离上次来店的间隔
 * 纵坐标表示顾客在店内的来访周期时长（毫秒计算）
 * 横坐标表示对应停来访周期时长的人数
 */
@Data
public class VisitingCycleElement extends ChartData<Tuple<Long, Integer>> {

    protected String wifiProb;
    private Long hour;

}
