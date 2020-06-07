package countriesAndCities;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import countriesAndCities.Country.City;
import countriesAndCities.DoublyLinkedList.Node;
public class CountryTest {
	private static final Logger log = Logger.getLogger(CountryTest.class.getName());

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setup() {
		log.info("Setting up...");
	}

	@After
	public void tearDown() {
		log.info("Tearing down...");
	}

	@BeforeClass
	public static void before() {
		log.info("Running JUnit test cases from class: " + CountryTest.class);
	}

	@AfterClass
	public static void after() {
		log.info("Testing class " + CountryTest.class + " has completed.");
	}

	public void reset() {
		tearDown();
		setup();
	}

	@Test
	public void addNodeTest() {
		// TODO Auto-generated method stub
		DoublyLinkedList list = new DoublyLinkedList();

		// created the doublylinkedlist
		// create an object of the class country
		Country country1 = new Country();
		country1.setCountryName("England");

		City city1 = country1.new City();
		city1.setCityName("London");
		
		country1.cities.add(city1);
		
		list.addNode(country1);
		
		Node head = list.head;
		Node tail = list.tail;
		
		assertEquals("England", head.country.getCountryName());
		assertEquals("London", head.country.cities.get(0).getCityName());
		assertNull(head.next);
		assertNull(head.previous);
		assertEquals("England", tail.country.getCountryName());
		assertEquals("London", tail.country.cities.get(0).getCityName());
		assertNull(tail.next);
		assertNull(tail.previous);
		
		Country country2 = new Country();
		country2.setCountryName("US");

		City city2 = country2.new City();
		city2.setCityName("Los Angeles");
		
		country2.cities.add(city2);
		
		list.addNode(country2);
		head = list.head;
		tail = list.tail;
		
		assertEquals("England", head.country.getCountryName());
		assertEquals("London", head.country.cities.get(0).getCityName());
		assertEquals(tail, head.next);
		assertNull(head.previous);
		assertEquals("US", tail.country.getCountryName());
		assertEquals("Los Angeles", tail.country.cities.get(0).getCityName());
		assertNull(tail.next);
		assertEquals(head, tail.previous);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CountryTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}
}
