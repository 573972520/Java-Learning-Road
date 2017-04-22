import com.rupeng.game.GameCore;

public class Arr implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		//来回显示数组里面的内容
		String[] str = {"rupeng","百度","阿里","tentent"};
		int i = 0;
		boolean isLeftToRight = true;
		while (true) {
			String name = str[i];
			GameCore.alert(name);
			if (isLeftToRight&&i==str.length-1) {
				isLeftToRight = false;
			}
			else if (!isLeftToRight&&i==0) {
				isLeftToRight =true;
			}
			
			if (isLeftToRight) {
				i++;
			}
			else {
				i--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Arr());
		/*
		int[] arr = new int[5]; //int数组元素的默认值都是0
		arr[0] = 8;//赋值
		int i1 = arr[0];
		int i2 = arr[1];
		System.out.println(arr[0]);
		System.out.println(i1);
		System.out.println(i2);
		
		int[] arr2 = {1,2,3}; //声明个数为3的int数组
		int i3 = arr2[0];
		System.out.println(i3);
		arr2[2] = 999;
		System.out.println(arr2[2]);
		*/
		/*
		String[] arr2 = {"ali","JD","JD","taobao",""} ;
		int arrLength = arr2.length;
		System.out.println(arrLength); //获取数组长度
		for ( i = 0; i < arr2.length; i++) {
			String s = arr2[i];
			System.out.println(s);
		}
		String[] arr = new String[2]; //String类型的数组初始化为null
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			System.out.println(s);
		}
		*/
		/*
		int[] arr = new int[5]; //数字长度声明之后不能再改变
		arr[6] = 0;            //尝试增加数组长度（但是却报错误java.lang.ArrayIndexOutOfBoundsException: 6）
		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			System.out.println(j);
		}
		*/
		
		/*
		//将string类型的数组转换成int类型的数组(与老师的对照)
		String[] strs = {"123","21","45","466"};
		int[] arr = new int[4]; //注意：更好的写法可以改为int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {  
			String s1 = strs[i];
			int intValue = Integer.parseInt(s1); //这里的变量名要有意义（一般不要用i,j,k,l,m,n,a,b等这些没有意义的名字）
			arr[i] = intValue;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		//System.out.println(arr[2]); //可以改为上述的代码（遍历int类型数组）
		*/
		
	
		/*
		//逗号分隔的字符串
		String[] strs = {"如鹏","阿里","腾讯","天"};
		String s1 = "";
		for (int i = 0; i < strs.length-1; i++) {
			s1 += strs[i]+",";
		}
		for (int i = strs.length-1; i < strs.length; i++) {
			s1 += strs[i];
		}
		//s1 = s1+strs[strs.length-1]; //最后一个不需要添加逗号（和上面的第二关for循环一样的效果）
		System.out.println(s1);
		*/
		
		
		/*
		//数组对应输出
		String[] name = {"大力","小明","三丰"};
		boolean[] scores = {true,false,true};
		String[] results = new String[scores.length];
		for (int i = 0; i < name.length; i++) {
			boolean score = scores[i]; //位置是一一对应的，所以来取当前的名字对于成绩
			results[i] = name[i]+(score?"合格":"不合格");
		}
		
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
		*/
		
		
		/*
		//两个数组组成一个新数组
		int[] num1 = {3,5,8};
		int[] num2 = {88,9,25,66,77};
		int[] newNum = new int[num1.length+num2.length];
		for (int i = 0; i < num1.length; i++) {
			int numValue = num1[i];
			newNum[i] = numValue;
		}
		for (int i = 0; i < num2.length; i++) {
			int numValue = num2[i];
			newNum[i+num1.length] = numValue; //注意这里需要增加前面数组的增值
		}
		for (int i = 0; i < newNum.length; i++) {
			System.out.println(newNum[i]);
		}
		*/
		
		/*
		//循环数组里面的内容
		String[] str = {"rupeng","百度","阿里","tentent"};
		for(;;){
			for (int i = 0; i < str.length; i++) {
				String strValue = str[i];
				System.out.println(strValue);
			}
		}
		*/
		
	
		
	}

}
