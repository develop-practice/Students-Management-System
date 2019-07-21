package practice.develop.blank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import practice.develop.blank.dto.SampleRequestBody;
import practice.develop.blank.dto.SampleResponseBody;

public class BlankApplication {
	
	@Autowired
	ResourceLoader resourceLoader;

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		String filepath = "data/students.csv";

        try {
			BufferedReader br = new BufferedReader(
	                new InputStreamReader(ClassLoader.getSystemResourceAsStream(filepath)));
	        
	        String line = "";
	        String[] lineSplit = null;
	        
	        // 1行ずつCSVファイルを読み込む
	        while ((line = br.readLine()) != null) {
	        
	            lineSplit = line.split(",", 0);

			    SampleRequestBody req = new SampleRequestBody();
			    req.setSchoolYear(Integer.parseInt(lineSplit[0]));
			    req.setSchoolClass(Integer.parseInt(lineSplit[1]));
			    req.setAttendanceNumber(Integer.parseInt(lineSplit[2]));
			    req.setName(lineSplit[3]);

			    String postUrl = "http://127.0.0.1:8080/post-server";
			    ResponseEntity<SampleResponseBody> res = restTemplate.postForEntity(postUrl, req, SampleResponseBody.class);

			    System.out.println(res.getBody().getResultMessage());
	        }
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("ファイル読み込み失敗");
			e.printStackTrace();
		}
	}
}
