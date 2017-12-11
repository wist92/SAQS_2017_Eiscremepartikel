package epm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import epm.model.CSVParserTest;
import epm.model.StationTest;

/**
 * TestSuite zum ausführen beliebig vieler TestCase-Klassen zusammen
 * Zur Erkennung der TestCase-Klassen im Wizard muss diese Klasse im  selben package sein
 * Funktioniert auch mit anderen TestSuites wie mit TestCase-Klassen
 *
 * @author Stefan Witzak
 */

@RunWith(Suite.class)
@SuiteClasses({ StationTest.class, CSVParserTest.class, ViewModelTest.class }) // .class Dateien der testcase Klassen, die zusammen ausgeführt werden sollen
public class TestSuite {
	// Dieser Bereich kann frei bleiben
}