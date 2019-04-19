package leetcode.challenge;

public class BinaryPlus {

	public static void main(String[] args) {

		Long i = (long) 0x0010;
		Long j = (long) 0x1000;
		Long x = ((1L<<2)<<4) + 2L;
		System.out.println(Long.toBinaryString(i));
		System.out.println(Long.toBinaryString(j));
		System.out.println(x.toString());
		System.out.println(Long.toBinaryString(x+i));
		System.out.println("X: =========="+ Long.toBinaryString(x));
		long a1 = 1L<<1;
		long a2 = 1L<<6;
		long sum = a1+a2;
		System.out.println(Long.toBinaryString(sum));
		
		long z = ((1L<<2)<<4)+(1L<<1);
		long z1 = (1L<<8)+z;
		System.out.println("++++++++ "+ (int)z1);
		System.out.println("++++++++ "+ Long.toBinaryString(z1));
		
		System.out.println("TT: =========="+ Long.toBinaryString(
				((1L<<2)<<4)+(1L<<1)
				
				));
	}

}
