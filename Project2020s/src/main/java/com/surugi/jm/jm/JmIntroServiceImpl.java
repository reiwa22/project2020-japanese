package com.surugi.jm.jm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.surugi.jm.domain.JmIntroVo;
import com.surugi.jm.domain.JmPagingDto;

@Service
public class JmIntroServiceImpl implements JmIntroService {

	@Inject
	private JmIntroDao jmIntroDao;
	
	//紹介掲示板目録照会
	@Override
	public List<JmIntroVo> selectIntroList() throws Exception {
		List<JmIntroVo> list = jmIntroDao.selectIntroList();
		return list;
	}

	//紹介掲示板info照会
	@Override
	public JmIntroVo selectIntroInfo(int i_info) throws Exception {
		JmIntroVo jmIntroVo = jmIntroDao.selectIntroInfo(i_info);
		jmIntroDao.updateViewCount(i_info);
		return jmIntroVo;
	}

	//掲示板の書き込み
	@Override
	public void insertIntro(JmIntroVo jmIntroVo) throws Exception {
		int i_info = jmIntroDao.getNextVal();
		jmIntroVo.setI_info(i_info);
		jmIntroDao.insertIntro(jmIntroVo);
		String[] files = jmIntroVo.getI_files();
		for(String file :files) {
			System.out.println("jmIntroVo::::eeee"+jmIntroVo);
			jmIntroDao.insertIntroAttach(file, i_info);
		}
	}

	//紹介掲示板アップデート
	@Override
	public void updateIntro(JmIntroVo jmIntroVo) throws Exception {
		int i_info = jmIntroVo.getI_info();
		jmIntroDao.updateIntro(jmIntroVo);
		String[] files = jmIntroVo.getI_files();
		for(String file: files) {
			jmIntroDao.insertIntroAttach(file, i_info);
		}

	}

	//紹介掲示板削除機能
	@Override
	public void deleteIntro(int i_info) throws Exception {
		jmIntroDao.deleteIntro(i_info);

	}

	//リストページング
	@Override
	public List<JmIntroVo> selectPaging(JmPagingDto jmPagingDto) throws Exception {
		List<JmIntroVo> list = jmIntroDao.selectPaging(jmPagingDto);
		return list;
	}

	//投稿数の照会
	@Override
	public int selectCount(JmPagingDto jmPagingDto) throws Exception {
		return jmIntroDao.selectCount(jmPagingDto);
	}

	//紹介掲示板info -写真を読み込む
	@Override
	public List<String> selectIntroInfoImage(int i_filesinfo) throws Exception {
		return jmIntroDao.selectIntroInfoImage(i_filesinfo);
	}

}
