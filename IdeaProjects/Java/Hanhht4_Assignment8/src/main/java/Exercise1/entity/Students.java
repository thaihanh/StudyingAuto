package Exercise1.entity;


import Exercise1.entity.Student;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement

public class Students {

    private String noteName;
    private List<Student> students;

    public Students() {
    }

    public String getNoteName() {
        return noteName;
    }

    @XmlElement
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public Students(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public void setStudents(List<Student> students) {
        this.students = students;
    }



    @Override
    public String toString() {
        return "{" + noteName +
                "students=" + students +
                '}';
    }
}
