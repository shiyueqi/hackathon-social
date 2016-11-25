package com.unionpay.uplus.api;

import java.util.List;

import com.unionpay.uplus.vo.ActivityRegVO;
import com.unionpay.uplus.vo.UserVO;

/**
 * date: 2016/11/26 4:53
 * author: Aeon
 */
public interface ActService {
    public boolean regActivity(int contentId, UserVO user);
    
    public List<ActivityRegVO> queryActivity(int contentId);
    
}