package com.surugi.jm.jm;

import java.util.List;

import com.surugi.jm.domain.JmContactVo;
import com.surugi.jm.domain.JmMemberVo;
import com.surugi.jm.domain.JmPagingDto;
import com.surugi.jm.domain.JmPwEmailDto;

public interface JmMemberService {
	//ログイン
	public boolean selectMemberUserIdPw(String u_id , String u_pw)throws Exception;
	
	//会員加入
	public void insertMember(JmMemberVo vo)throws Exception;
	
	//セッションレベルを取得
	public String selectGrade(String u_grade)throws Exception;
	
	//管理者c_originnum検索 - Q&A掲示板管理者のコメントを書き込む
	public int selectOriginNum(int c_originnum)throws Exception;
	
	//管理者ページの一般会員リスト照会
	public List<JmMemberVo> selectList()throws Exception;
	
	//管理者ページ一般会員個人別照会
	public JmMemberVo selectByid(String u_id)throws Exception;
	
	//管理者ページの一般会員修正
	public void updateUser(JmMemberVo jmMemberVo)throws Exception;
	
	//管理者ページ一般会員削除
	public void deleteUser(String u_id)throws Exception;
	
	//Q&A掲示板管理者のコメント
	public void contactManagerInsert(JmContactVo jmContactVo)throws Exception;
	
	//管理者Q&A掲示板削除機能
	public void deleteContact(int c_info)throws Exception;
	
	//パスワード検索（メール）
	public JmPwEmailDto selectPw(String u_id)throws Exception;
	
	//ID重複チェック
	public String selectId(String u_id)throws Exception;
	
	//ページング
	public List<JmMemberVo>selectUserPaging(JmPagingDto jmPagingDto)throws Exception;
	
	//投稿数の照会
	public int selectUserCount(JmPagingDto jmPagingDto)throws Exception;
	
	//個人情報修正フォーム 
	public JmMemberVo selectUserById(String u_id)throws Exception; 

	//個人情報修正実行
	public void updateUserById(JmMemberVo jmMemberVo)throws Exception;
		
}
