package com.codingfairy.vo.analysis.element;

import lombok.Data;

/**
 * Created by darxan on 2017/5/14.
 * 顾客活跃度：按顾客距离上次来访间隔,划分为不同活跃度（高活跃度、中活跃度、低活跃度、沉睡活跃度）
 * 横坐标表示顾客举例上次来访的时间间隔,以毫秒为单位
 * 纵坐标表示对应时间间隔的顾客人数
 */
@Data
public class CustomerActivenessElement {

    protected String wifiProb;
    private Long hour;
    private int numOfHighActive;
    private int numOfMedianActive;
    private int numOfLowActive;
    private int numOfSleepActive;

}
