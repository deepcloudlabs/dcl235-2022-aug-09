package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

public class MemoryLeak {

	public static void main(String[] args) {
		var customers = new HashSet<LeakyCustomer>(4*1_000/3);
		System.out.println(customers.size());
		customers.add(new LeakyCustomer("1", "jack"));
		System.out.println(customers.size());
		customers.add(new LeakyCustomer("2", "kate"));
		System.out.println(customers.size());
		System.out.println(customers.remove(new LeakyCustomer("1", "jack")));
		System.out.println(customers.size());
		System.out.println(customers.remove(new LeakyCustomer("2", "kate")));
		System.out.println(customers.size());
		
		var list = new ArrayList<LeakyCustomer>();
		list.add(new LeakyCustomer("1", "jack"));
		list.add(new LeakyCustomer("2", "kate"));
		System.out.println(list);
		// equals() ==> true --> compare/compareTo ==> 0 
		Comparator<LeakyCustomer> orderByFullNameAsc = (c1,c2)->c1.getFullname().compareTo(c2.getFullname());
		var orderByFullNameDesc = orderByFullNameAsc.reversed();
		Collections.sort(list,orderByFullNameDesc);

		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.contains(new LeakyCustomer("1", "jack")));
		System.out.println(list.remove(new LeakyCustomer("1", "jack")));
		System.out.println(list.size());
		// Object: equals(), hashCode()
	}

}
// jack -> add(jack("1")) -> jack.hashCode() -> int % 100  | | | | | jack | | | | | | | | | | | | | 
//         remove("1")  ->            
class LeakyCustomer extends Object implements Comparable<LeakyCustomer>{
	private String identity;
	private String fullname;

	public LeakyCustomer(String identity, String fullname) {
		this.identity = identity;
		this.fullname = fullname;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeakyCustomer other = (LeakyCustomer) obj;
		return Objects.equals(identity, other.identity);
	}

	@Override
	public String toString() {
		return "LeakyCustomer [" + (identity != null ? "identity=" + identity + ", " : "")
				+ (fullname != null ? "fullname=" + fullname : "") + "]";
	}

	@Override
	public int compareTo(LeakyCustomer other) {
		//  0:  this = other
		// -1:  this < other
		// +1: other < this
		return this.fullname.compareTo(other.fullname);
	}



}
