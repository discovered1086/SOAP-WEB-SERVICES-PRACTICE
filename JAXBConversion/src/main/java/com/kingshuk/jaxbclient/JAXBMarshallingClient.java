package com.kingshuk.jaxbclient;

import com.kingshuk.schema.student.Course;
import com.kingshuk.schema.student.Student;
import com.kingshuk.schema.student.Subjects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by kingshuk on 6/17/17.
 */
public class JAXBMarshallingClient {

    public static void main(String [] args){
        try {

            //We are about to get our hands on the JAXB API. This API is used by engines like apache CXF, Axis 2 etc.
            //We as developers will be rarely directly using this API
            JAXBContext jaxbContext=JAXBContext.newInstance(Student.class);

            //Marshaller Object that will perform the actual act of marshalling
            Marshaller marshaller=jaxbContext.createMarshaller();

            //Creating the actual Student object with some kind of details inside
            Subjects subjects=new Subjects();
            subjects.setId("1");
            subjects.setName("Java");
            Student student=new Student();
            student.setId(232649);
            student.setAdmissionYear(2005);
            student.setCourse(Course.IT);
            student.setMajor(subjects);
            student.setName("Kingshuk Mukherjee");
            student.getEmails().add("sly.mania42@gmail.com");

            //Actual work of marshalling the object
            //The StringWriter here is required because marshaller needs
            //some kind of a stream writer/file to write the marshalled output to
            File xmlFile=new File("/Volumes/Work/PROJECTS/WEB-SERVICE-APPS/JAXBConversion/output/student.xml");
            Writer outputStreamWriter=new FileWriter(xmlFile);
            marshaller.marshal(student, outputStreamWriter);

            //Printing the contents of the writer for debugging
            System.out.println(outputStreamWriter);

            //Alright so the marshaller works, now it's the time to un-marshall it
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();

            //Now have to make the unmarshaller read the contents of the XML file and un-marshall it
            Student student1 = (Student) unmarshaller.unmarshal(xmlFile);

            //Job well done. Now let's just print the object in the console
            System.out.println(student1);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
