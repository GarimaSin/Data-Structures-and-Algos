package Java.Multithreading.PrintSequenceUsingThreeThreads;

public class PrintThreadsSequentiallyMain {
	public static void main(String[] args) {

		PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
		PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2);
		PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0);

		Thread t1=new Thread(runnable1,"T1");
		Thread t2=new Thread(runnable2,"T2");
		Thread t3=new Thread(runnable3,"T3");

		t1.start();
		t2.start();
		t3.start();   
	}


	// Employee.java
	final class Employee {
		private final String empName;
		private final Address address;
		public Employee(String name, Address address) {
			this.empName = name;
			this.address = address;
		}
		public String getEmpName() {
			return empName;
		}
		/* public Address getAddress() {
	      return address;
	      }
		 */
		public Address getAddress() throws CloneNotSupportedException {
			return (Address) address.clone();
		}
	}
	// Address.java
	class Address implements Cloneable {
		public String addressType;
		public String address;
		public String city;
		public Address(String addressType, String address, String city) {
			super();
			this.addressType = addressType;
			this.address = address;
			this.city = city;
		}
		public String getAddressType() {
			return addressType;
		}
		public void setAddressType(String addressType) {
			this.addressType = addressType;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		@Override
		public String toString() {
			return "Address Type - "+addressType+", address - "+address+", city - "+city;
		}
	}

	static class MainClass {

		public static void main(String[] args) throws CloneNotSupportedException  {
			PrintThreadsSequentiallyMain obj = new PrintThreadsSequentiallyMain();
			Employee emp =obj. new Employee("Adithya", obj.new Address("Home", "Madhapur", "Hyderabad"));
			Address address = emp.getAddress();
			System.out.println(address);
			address.setAddress("Hi-tech City");
			address.setAddressType("Office");
			address.setCity("Hyderabad");
			System.out.println(emp.getAddress());
		}
	}
}