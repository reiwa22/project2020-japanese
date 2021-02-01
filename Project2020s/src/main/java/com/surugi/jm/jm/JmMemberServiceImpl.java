package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.surugi.jm.domain.JmContactVo;
import com.surugi.jm.domain.JmMemberVo;
import com.surugi.jm.domain.JmPagingDto;
import com.surugi.jm.domain.JmPwEmailDto;

@Service
public class JmMemberServiceImpl implements JmMemberService {

	@Inject
	private JmMemberDao jmMemberDao;
	
	//ログイン
	@Override
	public boolean selectMemberUserIdPw(String u_id, String u_pw) throws Exception {
		JmMemberVo vo = jmMemberDao.selectMemberUserIdPw(u_id, u_pw);
		if(vo!=null) {
			return true;
		}
		return false;
	}

	//会員加入
	@Override
	public void insertMember(JmMemberVo vo) throws Exception {
		System.out.println(vo);
		jmMemberDao.insertMember(vo);

	}
	
	//セッションレベルを取得
	@Override
	public String selectGrade(String u_grade) throws Exception {
		
		return jmMemberDao.selectGrade(u_grade);
	}
	
	//管理者c_originnum検索 - Q&A掲示板管理者のコメントを書き込む
	@Override
	public int selectOriginNum(int c_originnum) throws Exception {
	
		return jmMemberDao.selectOriginNum(c_originnum);
	}
	
	//管理者ページの一般会員リスト照会
	@Override
	public List<JmMemberVo> selectList() throws Exception {
		List<JmMemberVo> list = jmMemberDao.selectList();
		return list;
	}
	
	//管理者ページ一般会員個人別照会
	@Override
	public JmMemberVo selectByid(String u_id) throws Exception {
		JmMemberVo jmMemberVo = jmMemberDao.selectByid(u_id);
		return jmMemberVo;
	}
	
	//管理者ページの一般会員修正
	@Override
	public void updateUser(JmMemberVo jmMemberVo) throws Exception {
		jmMemberDao.updateUser(jmMemberVo);

	}
	//管理者ページ一般会員削除
	@Override
	public void deleteUser(String u_id) throws Exception {
		jmMemberDao.deleteUser(u_id);

	}
	//Q&A掲示板管理者のコメント
	@Override
	public void contactManagerInsert(JmContactVo jmContactVo) throws Exception {
		jmMemberDao.contactManagerInsert(jmContactVo);

	}
	//管理者Q&A掲示板削除機能
	@Override
	public void deleteContact(int c_info) throws Exception {
		jmMemberDao.deleteContact(c_info);

	}
	//パスワード検索（メール）
	@Override
	public JmPwEmailDto selectPw(String u_id) throws Exception {
		
		return jmMemberDao.selectPw(u_id);
	}

	//ID重複チェック
	@Override
	public String selectId(String u_id) throws Exception {
		
		return jmMemberDao.selectId(u_id);
	}
	
	//ページング
	@Override
	public List<JmMemberVo> selectUserPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmMemberVo> list = jmMemberDao.selectUserPaging(jmPagingDto);
		return list;
	}

	//投稿数の照会
	@Override
	public int selectUserCount(JmPagingDto jmPagingDto) throws Exception {
			
		return jmMemberDao.selectUserCount(jmPagingDto);
	}

	//個人情報修正フォーム
	@Override
	public JmMemberVo selectUserById(String u_id) throws Exception {
		JmMemberVo jmMemberVo = jmMemberDao.selectUserById(u_id);
		return jmMemberVo;
	}

	//個人情報修正実行
	@Override
	public void updateUserById(JmMemberVo jmMemberVo) throws Exception {
		jmMemberDao.updateUserById(jmMemberVo);
		
	}

}
