package ds.hashtable;

public class HashTable {
	
	String[] hashArray;
	int arraySize;
	int size =0; // counter for number of elements in the hash table
	
	public HashTable(int noOfSlots) {
		
		
		if(isPrime(noOfSlots)) {
			hashArray = new String[noOfSlots];
			arraySize=noOfSlots;
		}
		else {
			int primeCount = getNextPrime(noOfSlots);
			hashArray = new String[primeCount];
			arraySize=primeCount;
			
			System.out.println("Hash table size given " + noOfSlots+" is not a prime");
			System.out.println("Hash table size changed to: "+ primeCount);
		}
	}

	private int getNextPrime(int minNumber) {
		for(int i=minNumber;true;i++) {
			if(isPrime(i)) {
				return i;
			}
		}
	}

	private boolean isPrime(int number) {
		for(int i=2;i*i<=number;i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}

}
