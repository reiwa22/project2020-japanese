package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.surugi.jm.domain.JmContactVo;
import com.surugi.jm.domain.JmPagingDto;

@Service
public class JmContactServiceImpl implements JmContactService {

	@Inject
	private JmContactDao jmContactDao;
	
	
	//Q&A掲示板リスト照会
	@Override
	public List<JmContactVo> selectContactList() throws Exception {
		List<JmContactVo> list = jmContactDao.selectContactList();
		return list;
	}

	//Q&A掲示板info照会
	@Override
	public JmContactVo selectContactInfo(int c_info) throws Exception {
		JmContactVo jmContactVo = jmContactDao.selectContactInfo(c_info);
		jmContactDao.upadateViewCount(c_info);
		
		return jmContactVo;
	}

	//Q&A 掲示板の書き込み
	@Override
	public void insertContact(JmContactVo jmContactVo) throws Exception {
		jmContactDao.insertContact(jmContactVo);

	}

	//Q&A掲示板アップデート
	@Override
	public void upadateContact(JmContactVo jmContactVo) throws Exception {
		jmContactDao.upadateContact(jmContactVo);

	}

	//フェージング
	@Override
	public List<JmContactVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmContactVo> list = jmContactDao.selectPaging(jmPagingDto);
		return list;
	}

	//投稿数の照会
	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		
		return jmContactDao.selectCount(jmPagingDto);
	}

}
