import org.example.Bootcamper;
import org.example.ProgrammingLanguage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class BootcamperTest {

    @Test
    public void testConstructor(){
        ArrayList<String> certificates = new ArrayList<>();
        certificates.add("C1");
        certificates.add("C2");

        Bootcamper bootcamper = new Bootcamper("Iancu", "Radu", ProgrammingLanguage.Java,
                certificates,"radu@yahoo.com","0721444333");
        Assertions.assertEquals(bootcamper.getFirstName(), "Iancu");
        Assertions.assertEquals(bootcamper.getLastName(),"Radu");
        Assertions.assertEquals(bootcamper.getEmail(),"radu@yahoo.com");
        Assertions.assertEquals(bootcamper.getPhoneNumber(),"0721444333");
    }

    @Test
    public void testGetterSetter(){
        ArrayList<String> certificates = new ArrayList<>();
        certificates.add("C1");
        certificates.add("C2");

        Bootcamper bootcamper = new Bootcamper("Iancu", "Radu", ProgrammingLanguage.Java,
                certificates,"radu@yahoo.com","0721444333");

        bootcamper.setEmail("radu2@yahoo.com");
        Assertions.assertEquals(bootcamper.getEmail(), "radu2@yahoo.com");

        bootcamper.setPhoneNumber("0721222333");
        Assertions.assertEquals(bootcamper.getPhoneNumber(), "0721222333");

        ArrayList<String> newCertificates = new ArrayList<>();
        newCertificates.add("C3");
        newCertificates.add("C4");
        bootcamper.setCertificates(newCertificates);
        Assertions.assertEquals(bootcamper.getCertificates(), newCertificates);
    }
}
