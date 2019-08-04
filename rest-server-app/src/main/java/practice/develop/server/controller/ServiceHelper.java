package practice.develop.server.controller;

import org.springframework.stereotype.Service;

import practice.develop.server.model.dto.InsertRequestBody;
import practice.develop.server.model.dto.InsertResponseBody;
import practice.develop.server.model.dto.SelectRequestBody;
import practice.develop.server.model.dto.SelectResponseBody;
import practice.develop.server.util.Student;
import practice.develop.server.util.StudentInfo;
import practice.develop.server.util.StudentInfoMapper;
import practice.develop.server.util.StudentMapper;

@Service
public class ServiceHelper {

	private final StudentMapper studentMapper;
	private final StudentInfoMapper studentInfoMapper;
	
	public ServiceHelper(StudentMapper studentMapper, StudentInfoMapper studentInfoMapper) {
        this.studentMapper = studentMapper;
        this.studentInfoMapper = studentInfoMapper;
    }
	
	public InsertResponseBody insert(InsertRequestBody requestBody) {

		Student newStudent = new Student();
        newStudent.setSchoolYear(requestBody.getSchoolYear());
        newStudent.setSchoolClass(requestBody.getSchoolClass());
        newStudent.setAttendanceNumber(requestBody.getAttendanceNumber());
        newStudent.setName(requestBody.getName());

        studentMapper.insert(newStudent);
        
        InsertResponseBody responseBody = new InsertResponseBody();
        responseBody.setResultMessage("Insert OK.");

		return responseBody;
	}
	
	public SelectResponseBody select(SelectRequestBody requestBody) {

		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setSchoolYear(requestBody.getSchoolYear());
		studentInfo.setSchoolClass(requestBody.getSchoolClass());
		studentInfo.setAttendanceNumber(requestBody.getAttendanceNumber());

		SelectResponseBody responseBody = new SelectResponseBody();
		
		responseBody.setSchoolYear(studentInfoMapper.select(studentInfo).getSchoolYear());
		responseBody.setSchoolClass(studentInfoMapper.select(studentInfo).getSchoolClass());
		responseBody.setAttendanceNumber(studentInfoMapper.select(studentInfo).getAttendanceNumber());
		responseBody.setName(studentInfoMapper.select(studentInfo).getName());
		responseBody.setResultMessage("Select OK.");

		return responseBody;
	}
}
