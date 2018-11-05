package nowcoder.experiment;

public class ForLoopPrint {

	public static void main(String[] args) {
		int i = 0;
        for(out('A');out('B') && (i<2);out('C')){
            i++;
            out('D');
        }
	}
	
	static boolean out(char c){
        System.out.println(c);
        return true;
    }

}
