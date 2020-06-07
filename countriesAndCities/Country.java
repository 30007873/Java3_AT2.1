
package countriesAndCities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 30007873
 * Activity 1 (AT2.1)
 */
class DoublyLinkedList {
    // Represent the head and tail of the doubly linked list
    Node head, tail = null;

    class Node {
        Country country;
        Node previous;
        Node next;

        public Node(Country country) {
            this.country = country;
        }
    }

    // addNode() will add a node to the list
    public void addNode(Country country) {
        // Create a new node
        Node newNode = new Node(country);

        // If list is empty
        if (head == null) {
            // Both head and tail will point to newNode
            head = tail = newNode;
            // head's previous will point to null
            head.previous = null;
            // tail's next will point to null, as it is the last node of the list
            tail.next = null;
        } else {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode's previous will point to tail
            newNode.previous = tail;
            // newNode will become new tail
            tail = newNode;
            // As it is last node, tail's next will point to null
            tail.next = null;
        }
    }

    // display() will print out the nodes of the list
    public void display() {
        // Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            // Prints each node by incrementing the pointer.

            System.out.println(current.country + " ");
            current = current.next;
        }
    }
}

public class Country {

    private String countryName;
    List<City> cities = new ArrayList<City>();
    //Nested Class : City
    class City {
        private String cityName;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        @Override
        public String toString() {
            return "City [cityName=" + cityName + "]";
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DoublyLinkedList list = new DoublyLinkedList();

        // created the doublylinkedlist
        // create an object of the class country
        Country country1 = new Country();
        country1.setCountryName("England");

        City city1 = country1.new City();
        city1.setCityName("London");
        City city2 = country1.new City();
        city2.setCityName("Leeds");
        City city3 = country1.new City();
        city3.setCityName("Bristol");
        City city4 = country1.new City();
        city4.setCityName("Manchester");

        country1.cities.add(city1);
        country1.cities.add(city2);
        country1.cities.add(city3);
        country1.cities.add(city4);

        list.addNode(country1);

        Country country2 = new Country();
        country2.setCountryName("US");

        City city5 = country2.new City();
        city5.setCityName("New York");
        City city6 = country2.new City();
        city6.setCityName("Miami");
        City city7 = country2.new City();
        city7.setCityName("Los Angeles");
        City city8 = country2.new City();
        city8.setCityName("San Antonio");

        country2.cities.add(city5);
        country2.cities.add(city6);
        country2.cities.add(city7);
        country2.cities.add(city8);

        list.addNode(country2);

        Country country3 = new Country();
        country3.setCountryName("Australia");

        City city9 = country3.new City();
        city9.setCityName("Perth");
        City city10 = country3.new City();
        city10.setCityName("Sydney");
        City city11 = country3.new City();
        city11.setCityName("Brisbane");
        City city12 = country3.new City();
        city12.setCityName("Melbourne");

        country3.cities.add(city9);
        country3.cities.add(city10);
        country3.cities.add(city11);
        country3.cities.add(city12);

        list.addNode(country3);

        Country country4 = new Country();
        country4.setCountryName("Russia");

        City city13 = country4.new City();
        city13.setCityName("Moscow");
        City city14 = country4.new City();
        city14.setCityName("St.Petersburg");
        City city15 = country4.new City();
        city15.setCityName("Vladivostok");
        City city16 = country4.new City();
        city16.setCityName("Krasnoyarsk");

        country4.cities.add(city13);
        country4.cities.add(city14);
        country4.cities.add(city15);
        country4.cities.add(city16);

        list.addNode(country4);

        list.display();
        // populate the cities list in the object country using setters of the object
        // city by creating one
        // add the object country to the doublylinkedlist

    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country [countryName=" + countryName + ", cities=" + cities + "]";
    }
}

