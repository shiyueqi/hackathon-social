package com.unionpay.uplus.service;

import java.util.List;

import com.unionpay.uplus.api.ActService;
import com.unionpay.uplus.dao.ActDao;
import com.unionpay.uplus.vo.ActivityRegVO;
import com.unionpay.uplus.vo.UserVO;

/**
 * date: 2016/11/26 4:55 
 * author: Aeon
 */
public class ActServiceImpl implements ActService {

	private ActDao actDao = new ActDao();


	public boolean regActivity(int contentId, UserVO user) {
		// TODO Auto-generated method stub
		if(contentId==0||null==user){
			return false;
		}
		return actDao.regActivity(contentId, user);
	}

	public List<ActivityRegVO> queryActivity(int contentId) {
		return actDao.getActivity(contentId);
	}

}
