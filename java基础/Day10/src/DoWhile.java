
public class DoWhile implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int x = 0;
		do {
			System.out.println("45");
			x++;
		} while (x < 5);
		
		int j = 800;
		do {
			System.out.println("again"); //先执行，在判断
			j++;
		} while (j < 5);
		*/
		int i = 0;
		while (i < 5) {
			System.out.println(i);
			if (i == 3) {
			//	break;//终止循环
				continue; //结果一直都是3，因为下面的i++不执行了。所以会无限循环
			}
			i++;
		}
	}

}
