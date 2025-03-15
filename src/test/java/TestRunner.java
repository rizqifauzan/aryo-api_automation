import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        // Inisialisasi TestNG
        TestNG testNG = new TestNG();
        TestListenerAdapter adapter = new TestListenerAdapter();

        // Definisikan test suite
        XmlSuite suite = new XmlSuite();
        suite.setName("API Test Suite");

        // Tambahkan file testng.xml
        List<String> files = new ArrayList<>();
        files.add("src/test/resources/testng.xml"); // Path ke file konfigurasi TestNG
        suite.setSuiteFiles(files);

        // Tambahkan suite dan listener ke TestNG
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        testNG.setXmlSuites(suites);
        testNG.addListener(adapter);

        // Jalankan test
        testNG.run();
    }
}