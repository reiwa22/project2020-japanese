package com.surugi.jm.jm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class JmFileUploadUtil {

	//ファイルアップロード
	public static String uploadFile(String uploadPath , String originalName, byte[] fileData)throws Exception{
		UUID uuid =UUID.randomUUID();
		System.out.println("uuid:"+uuid);
		String datePath = calcPath(uploadPath);
		String dirPath = datePath+File.separator+uuid+"-"+originalName;	
		String filePath = uploadPath+File.separator+dirPath;
		File target = new File(filePath);
		System.out.println("target:::::"+target);
		System.out.println("fileData::"+fileData);
		FileCopyUtils.copy(fileData, target);
		
		boolean result = isImage(originalName);
		if(result ==true) {
			makeThumNail(filePath);
		}
		System.out.println("dirPath:::::::upload"+dirPath);
		return dirPath;
	}
	
	//ファイル拡張子チェック
	public static boolean isImage(String filename)throws Exception{
		String extName = filename.substring(filename.lastIndexOf(".")+1).toUpperCase();
		if(extName.equals("JPG")||extName.equals("GIF")||extName.equals("PNG")) {
			return true;
		}
		return false;
	}
	///Users/jimin/workspace/aaa.jpg 
	//ファイルサムネイル
	public static String makeThumNail(String filePath)throws Exception{
		int lastSlashIndex = filePath.lastIndexOf("-");
		String front = filePath.substring(0,lastSlashIndex+1);
		String rear = filePath.substring(lastSlashIndex+1);
		String thumNail = front +"jm"+rear;
		System.out.println("thumNail"+thumNail);
		BufferedImage srcImage = ImageIO.read(new File(filePath));
		BufferedImage destImage = Scalr.resize(srcImage, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,200);
		File thumFile = new File(thumNail);
		ImageIO.write(destImage, getFormatName(thumNail), thumFile);
		
		return thumNail;	
	}
	
	//ファイル名抽出
	public static String getFormatName(String filename) {
		int dotindex = filename.lastIndexOf(".");
		String extName = filename.substring(dotindex+1);

		return extName.toUpperCase();
	}
	
	//ファイル日付
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		
		String dateString = year+File.separator+month+File.separator+date;
		System.out.println("dateString::::"+dateString);
		String datePath = uploadPath +dateString;
		System.out.println("datePath::upload::"+datePath);
		File f = new File(datePath);
		if(!f.exists()) {
			f.mkdirs();		
		}
		return dateString;
	}
}
