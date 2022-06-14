public class JavaCompilation{

	public static void main(String[] args){
		if(args.length == 1) {
			System.out.println(Math.random());
		} else if(args.length > 1) {
			for (int i = 0; i < Integer.parseInt(args[0]); i++) {
				System.out.println(args[1]);
			}
		} else {
			System.out.println("No arguments passed.");
		}
	}

}