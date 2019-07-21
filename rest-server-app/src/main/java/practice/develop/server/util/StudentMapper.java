package practice.develop.server.util;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface StudentMapper {

    @Insert("INSERT INTO students (school_year, school_class, attendance_number, name) VALUES (#{schoolYear}, #{schoolClass}, #{attendanceNumber}, #{name})")
    void insert(Student student);
}