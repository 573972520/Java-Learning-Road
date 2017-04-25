package file文件处理;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("d:\\Code");
		String[] files = f1.list();
		for(int i = 0;i < files.length;i++)
		{
			/*
			File file = new File(files[i]); //遍历拿到的每个数组元素只是一个文件名，没有路径
			if(file.isFile())
			{
				System.out.println(files[i]);//输出时没有结果
			}
			*/
			File file = new File(f1,files[i]);//根据指定的父文件夹对象和子文件或者文件夹创建File对象
			if(file.isFile())
			{
				System.out.println(files[i]); //输出结果为该文件夹下的文件
			}
			
		}
	}

}
