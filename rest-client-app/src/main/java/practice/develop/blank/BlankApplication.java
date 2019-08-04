package practice.develop.blank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import practice.develop.blank.dto.InsertRequestBody;
import practice.develop.blank.dto.InsertResponseBody;
import practice.develop.blank.dto.SelectRequestBody;
import practice.develop.blank.dto.SelectResponseBody;

public class BlankApplication {
	
	@Autowired
	ResourceLoader resourceLoader;

	public static void main(String[] args) {

		if ("insert".equals(args[0])) {
			insert();
		} else if ("select".equals(args[0])) {
			select();
		} else {
			return;
		}
	}
	
	public static void insert() {
		RestTemplate restTemplate = new RestTemplate();
		String filepath = "data/studentsInsert.csv";

        try {
			BufferedReader br = new BufferedReader(
	                new InputStreamReader(ClassLoader.getSystemResourceAsStream(filepath)));
	        
	        String line = "";
	        String[] lineSplit = null;
	        
	        // 1陦後★縺､CSV繝輔ぃ繧､繝ｫ繧定ｪｭ縺ｿ霎ｼ繧�
	        while ((line = br.readLine()) != null) {
	        
	            lineSplit = line.split(",", 0);

			    InsertRequestBody req = new InsertRequestBody();
			    req.setSchoolYear(Integer.parseInt(lineSplit[0]));
			    req.setSchoolClass(Integer.parseInt(lineSplit[1]));
			    req.setAttendanceNumber(Integer.parseInt(lineSplit[2]));
			    req.setName(lineSplit[3]);

			    String postUrl = "http://127.0.0.1:8080/insert";
			    ResponseEntity<InsertResponseBody> res = restTemplate.postForEntity(postUrl, req, InsertResponseBody.class);

			    System.out.println(res.getBody().getResultMessage());
	        }
		} catch (IOException e) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆ catch 繝悶Ο繝�繧ｯ
			System.out.println("繝輔ぃ繧､繝ｫ隱ｭ縺ｿ霎ｼ縺ｿ螟ｱ謨�");
			e.printStackTrace();
		}
	}
	
	public static void select() {
		RestTemplate restTemplate = new RestTemplate();
		String filepath = "data/studentsSelect.csv";

        try {
			BufferedReader br = new BufferedReader(
	                new InputStreamReader(ClassLoader.getSystemResourceAsStream(filepath)));
	        
	        String line = "";
	        String[] lineSplit = null;
	        
	        // 1陦後★縺､CSV繝輔ぃ繧､繝ｫ繧定ｪｭ縺ｿ霎ｼ繧�
	        while ((line = br.readLine()) != null) {
	        
	            lineSplit = line.split(",", 0);

			    SelectRequestBody req = new SelectRequestBody();
			    req.setSchoolYear(Integer.parseInt(lineSplit[0]));
			    req.setSchoolClass(Integer.parseInt(lineSplit[1]));
			    req.setAttendanceNumber(Integer.parseInt(lineSplit[2]));

			    String postUrl = "http://127.0.0.1:8080/select";
			    ResponseEntity<SelectResponseBody> res = restTemplate.postForEntity(postUrl, req, SelectResponseBody.class);

			    System.out.println("学年: " + res.getBody().getSchoolYear());
			    System.out.println("クラス: " + res.getBody().getSchoolClass());
			    System.out.println("出席番号: " + res.getBody().getAttendanceNumber());
			    System.out.println("氏名: " + res.getBody().getName());
			    System.out.println(res.getBody().getResultMessage());
			    System.out.println("\n");
	        }
		} catch (IOException e) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆ catch 繝悶Ο繝�繧ｯ
			System.out.println("繝輔ぃ繧､繝ｫ隱ｭ縺ｿ霎ｼ縺ｿ螟ｱ謨�");
			e.printStackTrace();
		}
	}
}
