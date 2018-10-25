package nowcoder.experiment;

import java.io.UnsupportedEncodingException;

public class StringCharset {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] src = null, dst;
		dst = new String(src, "GBK").getBytes("UTF-8");
	}

}
