package main;

import entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBExample {

//    public static void main(String[] args) {
//
//        try {
//            File file = new File("user.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            User user = new User();
//            user.setId(1);
//            user.setName("HanhHT4");
//            user.setEmail("hanh@gmail.com");
//            user.setRoles(new String[] {"Admin", "Mentor", "Member"});
//            user.setAdmin(true);
//
//            marshaller.marshal(user, file);
//            System.out.println("OK");
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//    }

    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File("user.xml");
            User user = (User) unmarshaller.unmarshal(file);
            System.out.println(user);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
