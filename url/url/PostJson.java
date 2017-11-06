package url;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.activiti.engine.impl.util.json.JSONObject;

public class PostJson {
	public static void postJson() {
		try {
			JSONObject obj = new JSONObject();
			obj.append("busLicense", "111111111111111");
			obj.append("city", "");
			obj.append("country", "512");
			obj.append("entCategory", "0");
			obj.append("entId", "Q00000166");
			obj.append("entName", "多项城10");
			obj.append("modifier", "系统管理员");
			obj.append("orgCode", "11111111");
			obj.append("province", "521");
			obj.append("status", "2");
			obj.append("taxId", "111111111111111");
			obj.append("tenantId", "Q00000166");
			
			HashMap<String, Object> hashMap=new HashMap<>();
			hashMap.put("busLicense", "111111111111111");
			hashMap.put("city", "");
			hashMap.put("country", "512");
			hashMap.put("entCategory", "0");
			hashMap.put("entId", "Q00000166");
			hashMap.put("entName", "多项城10");
			hashMap.put("modifier", "系统管理员");
			hashMap.put("orgCode", "11111111");
			hashMap.put("province", "521");
			hashMap.put("status", "2");
			hashMap.put("taxId", "111111111111111");
			hashMap.put("tenantId", "Q00000166");
			
			JSONObject newjsonObejct=new JSONObject(hashMap);

			System.out.println(obj);
			System.out.println(newjsonObejct);
			System.out.println(hashMap);
			URL url = new URL("http://localhost:8080/oic/services/manage/company/single");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Charset", "UTF-8");
			byte[] data = (newjsonObejct.toString()).getBytes();
			conn.setRequestProperty("Content-Length", String.valueOf(data.length));
			conn.setRequestProperty("Content-Type", "application/json");
			conn.connect();
			OutputStream out = conn.getOutputStream();

			out.write((newjsonObejct.toString()).getBytes());
			out.flush();
			out.close();

			System.out.println(conn.getResponseCode());
			// 请求返回的状态
			if (conn.getResponseCode() == 200) {
				System.out.println("连接成功");
				// 请求返回的数据
				InputStream in = conn.getInputStream();
				String a = null;
				try {
					byte[] data1 = new byte[in.available()];
					in.read(data1);
					// 转成字符串
					a = new String(data1);
					System.out.println(a);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				System.out.println("no++");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public static void main(String args[]){
		 postJson();
	 }
}
