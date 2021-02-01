package com.surugi.jm.jm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.surugi.jm.domain.JmContactVo;
import com.surugi.jm.domain.JmMemberVo;
import com.surugi.jm.domain.JmPagingDto;
import com.surugi.jm.domain.JmPwEmailDto;

@Repository
public class JmMemberDaoImpl implements JmMemberDao {

	public static final String NAMESPACE = "mappers.member-mapper.";
	
	@Inject
	private SqlSession SqlSession;
	
	//ログイン
	@Override
	public JmMemberVo selectMemberUserIdPw(String u_id, String u_pw) throws Exception {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("u_id", u_id);
		paramMap.put("u_pw",u_pw);	
		JmMemberVo vos = SqlSession.selectOne(NAMESPACE+"selectMemberUserIdPw",paramMap);
		return vos;
	}
	//会員加入
	@Override
	public void insertMember(JmMemberVo vo) throws Exception {
		SqlSession.insert(NAMESPACE+"insertMember",vo);

	}
	//セッションレベルを取得
	@Override
	public String selectGrade(String u_grade) throws Exception {
	
		return SqlSession.selectOne(NAMESPACE+"selectGrade",u_grade);
	}
	
	//管理者c_originnum検索 - Q&A掲示板管理者のコメントを書き込む
	@Override
	public int selectOriginNum(int c_originnum) throws Exception {
		
		return SqlSession.selectOne(NAMESPACE+"selectOriginalNum",c_originnum);
	}

	//管理者ページの一般会員リスト照会
	@Override
	public List<JmMemberVo> selectList() throws Exception {
		
		return SqlSession.selectList(NAMESPACE+"selectList");
	}
	
	//管理者ページ一般会員個人別照会
	@Override
	public JmMemberVo selectByid(String u_id) throws Exception {
		
		return SqlSession.selectOne(NAMESPACE+"selectById",u_id);
	}

	//管理者ページの一般会員修正
	@Override
	public void updateUser(JmMemberVo jmMemberVo) throws Exception {
		SqlSession.update(NAMESPACE+"updateUser",jmMemberVo);
	}

	//管理者ページ一般会員削除
	@Override
	public void deleteUser(String u_id) throws Exception {
		SqlSession.delete(NAMESPACE+"deleteUser",u_id);

	}

	//Q&A掲示板管理者のコメント
	@Override
	public void contactManagerInsert(JmContactVo jmContactVo) throws Exception {
		SqlSession.insert(NAMESPACE+"contactManagerInsert",jmContactVo);

	}
	//管理者ページ一般会員削除
	@Override
	public void deleteContact(int c_info) throws Exception {
		SqlSession.delete(NAMESPACE+"deleteContact",c_info);

	}
	//パスワード検索（メール）
	@Override
	public JmPwEmailDto selectPw(String u_id) throws Exception {
		
		return SqlSession.selectOne(NAMESPACE+"selectPw",u_id);
	}

	//ID重複チェック
	@Override
	public String selectId(String u_id) throws Exception {
		
		return SqlSession.selectOne(NAMESPACE+"selectId",u_id);
	}
	//ページング
	@Override
	public List<JmMemberVo> selectUserPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmMemberVo> list = SqlSession.selectList(NAMESPACE+"selectUserPaging",jmPagingDto);
		return list;
	}

	//投稿数の照会
	@Override
	public int selectUserCount(JmPagingDto jmPagingDto) throws Exception {
		
		return SqlSession.selectOne(NAMESPACE+"selectUserCount",jmPagingDto);
	}
	
	//個人情報修正フォーム 
	@Override
	public JmMemberVo selectUserById(String u_id) throws Exception {
		
		return SqlSession.selectOne(NAMESPACE+"selectUserById",u_id);
	}
	
	//個人情報修正実行
	@Override
	public void updateUserById(JmMemberVo jmMemberVo) throws Exception {
		SqlSession.update(NAMESPACE+"updateUserById",jmMemberVo);
	}
	
}
