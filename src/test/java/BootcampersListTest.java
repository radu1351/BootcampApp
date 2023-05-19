import org.example.Bootcamper;
import org.example.BootcampersList;
import org.example.ProgrammingLanguage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BootcampersListTest {

    Bootcamper bootcamper;
    BootcampersList bootcampersList = new BootcampersList(50);

    @BeforeEach
    public void createBootcamper() {
        ArrayList<String> certificates = new ArrayList<>();
        certificates.add("C1");
        certificates.add("C2");

        this.bootcamper = new Bootcamper("Iancu", "Radu", ProgrammingLanguage.Java,
                certificates, "radu@yahoo.com", "0721444333");
    }

    @Test
    public void testAddBootcamper() {
        ArrayList<Bootcamper> testList = new ArrayList<>();
        testList.add(bootcamper);
        bootcampersList.addBootcamper(bootcamper);
        Assertions.assertEquals(bootcampersList.getAttendanceList(), testList,
                "The bootcampers should be on the attendance list");

        bootcampersList.addBootcamper(bootcamper);
        Assertions.assertEquals(bootcampersList.getAttendanceList(), testList,
                "Duplicate bootcamper should not be added");
    }

    @Test
    public void testRemoveBootcamper() {
        ArrayList<Bootcamper> testList = new ArrayList<>();
        testList.add(bootcamper);
        bootcampersList.removeBootcamper(bootcamper);
        testList.remove(bootcamper);
        Assertions.assertEquals(bootcampersList.getAttendanceList(), testList,
                "bootcamper should be removed from the list");
    }

    @Test
    public void testUpdateBootcamper() {
        ArrayList<String> certificates = new ArrayList<>();
        certificates.add("C1");
        certificates.add("C2");

        bootcampersList.addBootcamper(bootcamper);
        Bootcamper newBootcamper = new Bootcamper("Iancu", "Radu", ProgrammingLanguage.Cpp,
                certificates, "radu2@yahoo.com", "0721222333");
        bootcampersList.updateBootcamper(bootcamper, newBootcamper);
        Assertions.assertEquals(bootcampersList.getAttendanceList().get(0), newBootcamper,
                "The bootcamper details should update");
    }


    @Test
    public void testWaitingList() {
        bootcampersList = new BootcampersList(1);
        bootcampersList.addBootcamper(bootcamper);

        ArrayList<String> certificates = new ArrayList<>();
        certificates.add("C1");
        certificates.add("C2");
        this.bootcamper = new Bootcamper("Tanase", "Alex", ProgrammingLanguage.Cpp,
                certificates, "alex@yahoo.com", "0721345678");

        bootcampersList.addBootcamper(bootcamper);
        Assertions.assertEquals(bootcampersList.getWaitingListNo(), 1);
        Assertions.assertEquals(bootcampersList.getWaitingList().get(0), bootcamper,
                "The new bootcamper should be on the waiting list");
    }

    @Test
    public void testSearchByLangauge() {
        ArrayList<Bootcamper> javaBootcampers = new ArrayList<>();
        javaBootcampers.add(bootcamper);
        bootcampersList.addBootcamper(bootcamper);

        ArrayList<String> certificates = new ArrayList<>();
        certificates.add("C1");
        certificates.add("C2");
        this.bootcamper = new Bootcamper("Tanase", "Alex", ProgrammingLanguage.Java,
                certificates, "alex@yahoo.com", "0721345678");

        javaBootcampers.add(bootcamper);
        bootcampersList.addBootcamper(bootcamper);

        Assertions.assertEquals(bootcampersList.getAttendanceListByLanguage(ProgrammingLanguage.Java), javaBootcampers);
    }

    @Test
    public void testSearchBySubstring(){
        bootcampersList.addBootcamper(bootcamper);
        ArrayList<Bootcamper> searchResult = bootcampersList.searchBySubstring("Iancu");
        Assertions.assertEquals(searchResult.get(0), bootcamper,
                "The bootcamper should be retrieved");
    }

}
