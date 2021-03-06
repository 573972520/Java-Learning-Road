package arrays常用方法;

import java.util.Arrays;

import object方法复习.Person;

public class java_collection_Test15_Arrays
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		/*int[] nums = { 23, 23, 34, 14, 78, 465 };
		String s = Arrays.toString(nums);
		System.out.println(s);
		System.out.println(Arrays.toString(nums)); //toString():返回每个数组元素组成的字符串。对于Object[]，他是调用每个元素的toString()方法然后用","进行拼接
		*/
		Person p1 = new Person();
		p1.setName("cc");
		p1.setAge(18);
		p1.setPhoneNum("120");

		Person p2 = new Person();
		p2.setName("cc");
		p2.setAge(18);
		p2.setPhoneNum("120");

		Person p3 = new Person();
		p3.setName("cc");
		p3.setAge(18);
		p3.setPhoneNum("120");
		Person[] persons = { p1, p2, p3 };
		System.out.println(Arrays.toString(persons));

		int[] nums1 = { 23, 23, 34, 14, 78, 465 };
		int[] nums2 = { 23, 23, 34, 14, 78, 465 };
		Arrays.sort(nums1); //sort：给数组的元素进行排序
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.binarySearch(nums1, 23));//binarySearch:二分查找法查找元素，返回位置

		System.out.println(nums1 == nums2); //false
		System.out.println(nums1.equals(nums2));//false
		Arrays.fill(nums1, 555); //fill：填充数组为同一个值
		System.out.println(Arrays.toString(nums1));

		int[] num1 = { 23, 23, 34, 14, 78, 465 };
		int[] num2 = { 23, 23, 34, 14, 78, 465 };
		System.out.println(Arrays.equals(num1, num2));//true 
		//equals:判断两个数组的元素是否相等

	}

}
