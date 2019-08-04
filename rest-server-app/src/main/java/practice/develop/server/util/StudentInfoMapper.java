package practice.develop.server.util;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import practice.develop.server.model.dto.SelectResponseBody;

@Mapper
public interface StudentInfoMapper {

    @Select("SELECT * FROM students WHERE school_year=#{schoolYear} AND school_class=#{schoolClass} AND attendance_number=#{attendanceNumber}")
    SelectResponseBody select(StudentInfo studentInfo);
}