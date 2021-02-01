package com.surugi.jm.domain;

import java.sql.Timestamp;
import java.util.Arrays;

public class JmIntroVo {

	private int i_info;
	private String i_id;
	private String i_subject;
	private String i_contents;
	private Timestamp i_time; 
	private int i_viewcnt;
	private String i_contry;
	private String i_file;
	private int i_filesinfo;
	private String [] i_files;
	
	public JmIntroVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getI_info() {
		return i_info;
	}

	public void setI_info(int i_info) {
		this.i_info = i_info;
	}

	public String getI_id() {
		return i_id;
	}

	public void setI_id(String i_id) {
		this.i_id = i_id;
	}

	public String getI_subject() {
		return i_subject;
	}

	public void setI_subject(String i_subject) {
		this.i_subject = i_subject;
	}

	public String getI_contents() {
		return i_contents;
	}

	public void setI_contents(String i_contents) {
		this.i_contents = i_contents;
	}

	public Timestamp getI_time() {
		return i_time;
	}

	public void setI_time(Timestamp i_time) {
		this.i_time = i_time;
	}

	public int getI_viewcnt() {
		return i_viewcnt;
	}

	public void setI_viewcnt(int i_viewcnt) {
		this.i_viewcnt = i_viewcnt;
	}

	public String getI_contry() {
		return i_contry;
	}

	public void setI_contry(String i_contry) {
		this.i_contry = i_contry;
	}

	public String getI_file() {
		return i_file;
	}

	public void setI_file(String i_file) {
		this.i_file = i_file;
	}

	public int getI_filesinfo() {
		return i_filesinfo;
	}

	public void setI_filesinfo(int i_filesinfo) {
		this.i_filesinfo = i_filesinfo;
	}

	public String[] getI_files() {
		return i_files;
	}

	public void setI_files(String[] i_files) {
		this.i_files = i_files;
	}

	@Override
	public String toString() {
		return "JmIntroVo [i_info=" + i_info + ", i_id=" + i_id + ", i_subject=" + i_subject + ", i_contents="
				+ i_contents + ", i_time=" + i_time + ", i_viewcnt=" + i_viewcnt + ", i_contry=" + i_contry
				+ ", i_file=" + i_file + ", i_filesinfo=" + i_filesinfo + ", i_files=" + Arrays.toString(i_files) + "]";
	}

	
	
	
	
	
	
	
	
	
}
