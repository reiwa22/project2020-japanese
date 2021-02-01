package com.surugi.jm.jm;

import java.util.List;

import com.surugi.jm.domain.JmContactVo;
import com.surugi.jm.domain.JmPagingDto;

public interface JmContactDao {

	//Q&A掲示板リスト照会
	public List<JmContactVo> selectContactList() throws Exception;
	
	//Q&A掲示板info照会
	public JmContactVo selectContactInfo(int c_info)throws Exception;
	
	//Q&A 掲示板の書き込み
	public void insertContact(JmContactVo jmContactVo)throws Exception;
	
	//Q&A掲示板アップデート
	public void upadateContact(JmContactVo jmContactVo)throws Exception;
	
	//フェージング
	public List<JmContactVo> selectPaging(JmPagingDto jmPagingDto)throws Exception;
	
	//投稿数の照会
	public int selectCount(JmPagingDto jmPagingDto)throws Exception;
	
	//アクセス数増加
	public void upadateViewCount(int c_info)throws Exception;
	
}
