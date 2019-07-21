package practice.develop.server.controller;

import org.springframework.stereotype.Service;

import practice.develop.server.model.dto.SampleRequestBody;
import practice.develop.server.model.dto.SampleResponseBody;
import practice.develop.server.util.Student;
import practice.develop.server.util.StudentMapper;

@Service
public class ServiceHelper {

	private final StudentMapper studentMapper;
	
	public ServiceHelper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper; // Mapperをインジェクションする
    }
	
	public SampleResponseBody insert(SampleRequestBody requestBody) {

		Student newStudent = new Student();
        newStudent.setSchoolYear(requestBody.getSchoolYear());
        newStudent.setSchoolClass(requestBody.getSchoolClass());
        newStudent.setAttendanceNumber(requestBody.getAttendanceNumber());
        newStudent.setName(requestBody.getName());

        studentMapper.insert(newStudent);
        
        SampleResponseBody responseBody = new SampleResponseBody();
        responseBody.setResultMessage("Insert OK.");

		return responseBody;
	}
}
