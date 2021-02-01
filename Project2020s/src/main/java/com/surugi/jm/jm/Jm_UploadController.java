package com.surugi.jm.jm;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/jm")
public class Jm_UploadController {

	@Resource
	private String uploadPath;
	
	//エージャックス,アップロード
	@RequestMapping(value = "/jmUploadAjax",method = RequestMethod.POST)
	public String jmUpLoadAjax(MultipartFile file)throws Exception{
		String originalName = file.getOriginalFilename();
		//System.out.println("file:"+file);
		//long size = file.getSize();
		//System.out.println("uploadPath:"+uploadPath);
		//System.out.println("size:"+size);
		//System.out.println("fileBytes:::"+file.getBytes());
		//System.err.println("originalName:"+originalName);
		String dirPath = JmFileUploadUtil.uploadFile(uploadPath, originalName, file.getBytes());
		//System.out.println("dirPath:"+dirPath);
		return dirPath.replace("\\", "/");
	}
	
	//ファイルディスプレー
	@RequestMapping(value = "/displayFile",method = RequestMethod.GET)
	public byte[] displayFile(@RequestParam("fileName")String fileName)throws Exception{
		String filePath = uploadPath+File.separator+fileName;
		//System.out.println("filePath :::uploadController:"+filePath);
		String rFilePath = filePath.replace("\\", "/");
		//System.out.println("rFilePath:::::"+rFilePath);
		FileInputStream fis = new FileInputStream(rFilePath);
		byte[] bytes = IOUtils.toByteArray(fis);
		fis.close();
		return bytes;
	}
	
	//ファイル削除
	@RequestMapping(value = "/jmDeleteFile",method = RequestMethod.GET)
	public String deleteFile(String filename)throws Exception{
		int lastSlash = filename.lastIndexOf("-");
		String front = filename.substring(0,lastSlash+1);
		String rear = filename.substring(lastSlash+1);
		String jmServerPath = uploadPath+File.separator+front+"jm"+rear;
		//System.out.println("jmServerPath:::++"+jmServerPath);
		String serverPath = uploadPath+File.separator+filename;
		File f= new File(serverPath);
		f.delete();
		Boolean result = JmFileUploadUtil.isImage(filename);
		if(result == true) {
			File f2 = new File(jmServerPath);
			f2.delete();
		}
		return "success";
	}
	
	
}
