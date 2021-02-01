package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.surugi.jm.domain.JmContactVo;
import com.surugi.jm.domain.JmPagingDto;

@Repository
public class JmContactDaoImpl implements JmContactDao {

	public static final String NAMESPACE = "mappers.contact-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	
	//Q&A掲示板リスト照会
	@Override
	public List<JmContactVo> selectContactList() throws Exception {

		return sqlSession.selectList(NAMESPACE+"selectContactList");
	}

	//Q&A掲示板info照会
	@Override
	public JmContactVo selectContactInfo(int c_info) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"selectContactInfo",c_info);
	}

	//Q&A 掲示板の書き込み
	@Override
	public void insertContact(JmContactVo jmContactVo) throws Exception {
		sqlSession.insert(NAMESPACE+"insertContact",jmContactVo);
	}

	//Q&A掲示板アップデート
	@Override
	public void upadateContact(JmContactVo jmContactVo) throws Exception {
		sqlSession.update(NAMESPACE+"updateContact",jmContactVo);
	}

	//フェージング
	@Override
	public List<JmContactVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmContactVo> list = sqlSession.selectList(NAMESPACE+"selectPaging",jmPagingDto);
		return list;
	}

	//投稿数の照会
	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"selectCount",jmPagingDto);
	}

	//アクセス数増加
	@Override
	public void upadateViewCount(int c_info) throws Exception {
		sqlSession.selectOne(NAMESPACE+"updateViewCount",c_info);
	}
}
