package com.student.studentinfoservice;



import com.studentinfoservice.student.*;

import javax.jws.WebService;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by kingshuk on 6/18/17.
 */

@WebService
public class StudentInfoServiceImpl implements StudentInfoService {
    private Student student = null;
    private Map<BigInteger,Student> studentsList = new TreeMap<BigInteger, Student>();

    public StudentInfoServiceImpl() {
        student = new Student();
        student.setId(1);
        student.setAdmissionYear(2005);
        student.setName("Kingshuk Mukherjee");
        student.setCourse(Course.CSE);
        student.setRoleNumber(200529);
        studentsList.put(BigInteger.valueOf(student.getId()),student);
    }


    @Override
    public StudentResponse getStudentDetails(StudentRequest parameters) {
        StudentResponse studentResponse=new StudentResponse();

        //The student is a custom user-defined java object that's why JAXB provides a setter method on
        //the response object for Student. JAXB provides the setter for all kinds of objects except the java.util.List objects
        //There's a workaround for that as well.
        if(parameters.getStudentId().intValue()!=1){
            throw new RuntimeException("Student wasn't found in the database");
        }
        studentResponse.setStudent(studentsList.get(parameters.getStudentId()));
        return studentResponse;
    }
}
