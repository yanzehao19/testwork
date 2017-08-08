package yzh.freeMarker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

public class ExportWordwithPic {

	public static void main(String[] args) {
		ExportWordwithPic exportWordwithPic = new ExportWordwithPic();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		exportWordwithPic.getData(dataMap);
		WordUtil.createWord(dataMap, "导出带图片的word.ftl", "/template", "D:\\", "导出带图片的word.doc");
	}

	private void getData(Map<String, Object> dataMap) {
		dataMap.put("name", "wo");
		dataMap.put("birthday", "1999");
		dataMap.put("ls", "11");
		dataMap.put("image", getImageStr());

	}

	private String getImageStr() {
		String imgFile = "C:\\Users\\lenovo\\Desktop\\下载 (2).jpg";
		InputStream inputStream = null;
		byte[] data = null;
		try {
			inputStream = new FileInputStream(imgFile);
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String imageCodeBase64 = Base64.encodeBase64String(data);
		return imageCodeBase64;
	}

}
