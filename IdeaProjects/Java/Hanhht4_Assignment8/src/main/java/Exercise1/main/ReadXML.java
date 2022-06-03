package Exercise1.main;

import Exercise1.entity.Student;
import Exercise1.entity.Students;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXML {

    public static void main(String[] args) {
        File file = new File("student.xml");


        try {

            Student student1 = new Student();
            student1.setName("Rick Grimes");
            student1.setAge(35);
            student1.setSubject("Maths");
            student1.setGender(true);

            Student student2 = new Student();
            student2.setName("Daryl Dixon");
            student2.setAge(33);
            student2.setSubject("Science");
            student2.setGender(true);

            Student student3 = new Student();
            student3.setName("Maggie");
            student3.setAge(36);
            student3.setSubject("Arts");
            student3.setGender(false);

            List<Student> list = new ArrayList<>();
            list.add(student1);
            list.add(student2);
            list.add(student3);


            Students students = new Students();
            students.setStudents(list);
            students.setNoteName("student.xml file :");

            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(students, file);
            System.out.println("OK");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        extractNode();

    }

    public static void extractNode(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Students students = (Students) unmarshaller.unmarshal(new File("student.xml"));
            System.out.println(students);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
