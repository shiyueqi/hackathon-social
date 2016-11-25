package com.unionpay.uplus.util;

import com.unionpay.uplus.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * date: 2016/11/26 00:42
 * author: yueqi.shi
 */
public class PicsUtil {
    public static List<String> getPics(String pics) {
        List<String> picList = new ArrayList<String>();

        if (pics == null || pics.trim().equals("")) {
            return picList;
        }

        String[] picsArray = pics.split(Constants.PICS_SPLIT);

        for (String pic : picsArray) {
            picList.add(pic);
        }

        return picList;
    }
}
