package org.interview;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatMap {
    private static List<Customer> getAllCustomer(){
        return Stream.of(
                new Customer("one","one@gmail.com", Arrays.asList("123","134")),
                new Customer("two","two@gmail.com", Arrays.asList("223","234")),
                new Customer("three","three@gmail.com", Arrays.asList("323","334"))
        ).toList();
    }

    public static void main(String[] args) {
        var allCustomers=getAllCustomer();
       // allCustomers.forEach();
        var map=new HashMap<>();

       Customer customer= new Customer("one","one@gmail.com", Arrays.asList("123","134"));
        Customer customer1= new Customer("two","two@gmail.com", Arrays.asList("223","234"));

        map.put(customer,1);
        map.put(customer1,2);


        System.out.println(map);
        String string="a";
        String string1="a";




        System.out.println(string==string1);
        System.out.println(string.equals(string1));
        System.out.println(string.compareTo(string1));

        System.out.println(map);

        var collect = allCustomers.stream().map(Customer::getPhone).toList();
        System.out.println(collect);
        var nums=allCustomers
                .stream()
                .flatMap(e->e.getPhone().stream()).toList();

        System.out.println(nums);
        Predicate<Customer> predicate=(e)->e.getName().equalsIgnoreCase("one");
        Predicate<Customer> predicate1=(e)->e.getName().equalsIgnoreCase("two");

        System.out.println(allCustomers.stream().filter(predicate.or(predicate1)).map(Customer::getName).toList());
    }
}
