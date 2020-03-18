package com.codingfairy.vo.analysis;

import com.codingfairy.vo.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darxan on 2017/5/14.
 */
public class ChartData<V> {
    /*** sum in yData*/
    protected V sum ;
    /*** mean in yData*/
    protected V mean ;
    /*** maximal value in yData */
    protected V max;
    /*** minimal value in yData*/
    protected V min;
    /**
     * 如果是瞬时的图表，那么xData表示时间点，长度等于yData的长度
     * 如果是时间段统计的图表，那么每两个xData表示一个时间段，长度等于yData.length+(1/0)
     */
    protected List<V> statistic;

    public List<V> getStatistic() {
        if (statistic==null)
            statistic = new ArrayList<V>();
        return statistic;
    }

    public void setStatistic(List<V> statistic) {
        this.statistic = statistic;
    }

    public void add(V v) {
        if (statistic==null)
            statistic = new ArrayList<V>();
        statistic.add(v);
    }
}
