package com.unionpay.uplus.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * date: 2016/11/25 23:12
 * author: yueqi.shi
 */
public class TypeSub {

    /**
     * 默认动态子类型
     */
    public static final Integer contentDefaultType = 10;


    /**
     * 活动-默认类型
     */
    public static final Integer activityDefaultType = 20;

    /**
     * 活动-骑行类型
     */
    public static final int activityBikeType = 21;
    public static final String activityBikeTypeStr = "骑行";

    /**
     * 活动-桌游类型
     */
    public static final int activityPlayType = 22;
    public static final String activityPlayTypeStr = "桌游";

    /**
     * 活动-游泳类型
     */
    public static final int activitySwimType = 23;
    public static final String activitySwimTypeStr = "游泳";

    /**
     * 活动-足球类型
     */
    public static final int activityFootballType = 24;
    public static final String activityFootballTypeStr = "足球";

    /**
     * 活动-dota类型
     */
    public static final int activityDotaType = 25;
    public static final String activityDotaTypeStr = "dota";

    public static final Set<Integer> activityTypes = new HashSet<Integer>();
    static {
        activityTypes.add(activityBikeType);
        activityTypes.add(activityPlayType);
        activityTypes.add(activitySwimType);
        activityTypes.add(activityFootballType);
        activityTypes.add(activityDotaType);
    }

    /**
     * 问答-默认类型
     */
    public static final Integer qaDefaultType = 30;

    /**
     * 问答-技术类型
     */
    public static final Integer qaTechType = 31;
    public static final String qaTechTypeStr = "技术";

    /**
     * 问答-生活类型
     */
    public static final Integer qaLifeType = 32;
    public static final String qaLifeTypeStr = "生活";

    /**
     * 问答-工作类型
     */
    public static final Integer qaWorkType = 33;
    public static final String qaWorkTypeStr = "工作";

    /**
     * 问答-情感类型
     */
    public static final Integer qaEmotionType = 34;
    public static final String qaEmotionTypeStr = "情感";

    /**
     * 问答-杂谈类型
     */
    public static final Integer qaAllType = 35;
    public static final String qaAllTypeStr = "杂谈";

    public static final Set<Integer> qaTypes = new HashSet<Integer>();
    static {
        qaTypes.add(qaTechType);
        qaTypes.add(qaLifeType);
        qaTypes.add(qaWorkType);
        qaTypes.add(qaEmotionType);
        qaTypes.add(qaAllType);
    }


    /**
     * 博客-默认类型
     */
    public static final Integer blogDefaultType = 40;
}
