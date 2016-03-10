/**
 *Ͱ����
 */
package net.zhangwenbo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Iver3oN Zhang
 * @date 2016��3��9��
 * @email grepzwb@qq.com
 * BucketSort.java
 * Impossible is nothing
 */
public class BucketSort {
    
	//ѧ�������� Ҳ����Ͱ������ĳ���
	public static final int STU_SIZE = 500;
	//Ͱ�Ĵ�С��Ҳ����0-9����
	public static final int BUCKET_SIZE=11; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = init();
		print(a);
		int[] b = bucketSort(a);
		print(b);
	}

	/**
	 * @param a ��������
	 */
	private static int[] bucketSort(int[] a) {
		// TODO Auto-generated method stub
		int[] b = new int[STU_SIZE];
		List<List<Integer>>	 bucket = new ArrayList<>();
		for(int i=0;i<BUCKET_SIZE;i++){
			bucket.add(new ArrayList<Integer>());
		}
		for(int i =0;i<STU_SIZE;i++){
			int k = a[i]/10;
			bucket.get(k).add(a[i]);
		}
		for(List<Integer> list:bucket)  
             Collections.sort(list);
		int i =0;
		for(List<Integer> list:bucket){
			for(Integer score:list){
				b[i] = score;
				i++;
			}
		}
		return b;
	}

	/**
	 * @return ��ʼ����������
	 * @throws IOException 
	 */
	private static int[] init(){
		// TODO Auto-generated method stub
		int[] score = new int[STU_SIZE];
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/score.txt"));
			String sscore="";
			int i =0;
			try {
				while((sscore=br.readLine())!=null){
					score[i] = Integer.valueOf(sscore.trim());
					i++;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
	}

	public static void print(int[] array){
		for(int x:array){
			System.out.print(x+" ");
		}
		System.out.println();
	}
}
