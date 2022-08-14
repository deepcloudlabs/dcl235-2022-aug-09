package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Exercise02 {
	private static final List<Customer> customers = new ArrayList<>();
	public static void main(String[] args) {
		  System.out.println(getCustomersByBirthYearRange(20, 30).getClass()); 
		  getCustomerByEmail("a@b.c").ifPresent(System.out::println); // HoF
		  getCustomerByEmail("a@b.c").get();
		  var customer = getCustomerByEmail("a@b.c").orElseThrow(() -> new IllegalArgumentException("Cannot find the customer")); // HoF
	      Set <Integer> set  = new TreeSet  <Integer>();
	      List<Integer> list = new ArrayList<Integer>();
	      for (int i = -3; i < 3; i++) { 
	          set.add(i); list.add(i); // -3 -2 -1 0 1 2
	      } 
	      for (int i = 0; i < 3; i++) { // 0 1 2 
	          set.remove(i); 
	          list.remove(Integer.valueOf(i)); // [-3 -2 -1 0 1 2].remove(0) -> [-2 -1 0 1 2].remove(1)
	                          // [-2 0 1 2].remove(2) -> [-2 0 2]
	      }
	      System.out.println(list); // -2 0 2
	      System.out.println(set); // -3 -2 -1
	}
	
	public static List<Customer> getCustomersByBirthYearRange(int fromYear,final int toYear){
		Predicate<Customer> lessThanToYear = customer -> customer.getBirthYear() < toYear;
		Predicate<Customer> greaterThanFromYear = customer -> customer.getBirthYear() >= fromYear;
		return customers.stream()
		         .filter(lessThanToYear.and(greaterThanFromYear))
		         .toList();
		// return Collections.emptyList();
	}
	
	public static Optional<Customer> getCustomerByEmail(String email){
		return customers.stream()
				        .filter(cust -> email.equals(cust.getEmail()))
				        .findFirst() ;
	}

}


class Customer{
	private int birthYear;
	private String email;

	public Customer(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public String getEmail() {
		return email;
	}
	
}