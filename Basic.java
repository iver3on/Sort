/**
 * 
 */
package net.zhangwenbo;

/**
 * @author Iver3oN Zhang
 * @date 2016��3��7��
 * Impossible is nothing
 */
public class Basic {

	//��������ÿ������Ժ��������û�а�����ð��������ǻ�������Ľ���
	public static void BasicSort(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					swap(array, i, j);
				}
			}
		}
	}
	
	//ð������
	public static void BubbleSort(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=array.length-1;j>i;j--){
				if(array[j-1]>array[j]){
					swap(array, j-1, j);
				}
			}
		}
	}
	//�Ľ����ð�������㷨��ͨ��һ��boolean isChanged�����һ��ѭ����û�н�����Ԫ�أ���˵���Ѿ��ź���
	// ��ã�n-1�αȽϣ����ƶ�,���ʱ�临�Ӷ�ΪO(n)����ռ�ø����ռ�
	// ���n(n-1)/2�αȽϺ��ƶ������O(n^2)��ռ�ý�������ʱ�ռ䣬��СΪ1��
	public static int[] bubble_sort3(int[] arr) {
		boolean isChanged = true;
		for (int i = 0; i < arr.length && isChanged; i++) {
			isChanged = false;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
					isChanged = true;
				}
			}
		}
		return arr;
	}
	
	//��ѡ������
	/*//��n(n-1)/2�αȽϣ�n-1�ν��������ʱ�临�Ӷ�ΪO(n^2)  
//��ã�n(n-1)/2�αȽϣ������������ʱ�临�Ӷ�ΪO(n^2)  
//����ð������ ��
	 * ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������
	 * Ȼ����ʣ�µ�������������С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��*/
	public static void select_sort(int[] array){
		for(int i =0;i<array.length -1;i++){
			int min = i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[min]){
					//��¼һ�ֵ���Сֵ
					min = j;
				}
			}
			if(min!=i){
				swap(array, min, i);
			}
		}
	}
	
	//ֱ�Ӳ�������
	//ÿ����һ��������ļ�¼������˳�����С���뵽ǰ���Ѿ�����������еĺ���λ��
	//���Ӻ���ǰ�ҵ�����λ�ú󣩣�ֱ��ȫ������������Ϊֹ��	
	public static void insertion_sort(int[] a){
		for(int i=1;i<a.length;i++){
			int temp  = a[i];
			int j;
			for(j=i-1;j>=0;j--){
				if(a[j]>temp){
					//������temp������ƶ�һλ
					a[j+1] = a[j];
				}else
					break;
			}
			a[j+1] = temp;
		}
	}
	
	

	public static void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void print(int[] array){
		for(int x:array){
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,4,6,1,3};
		print(array);
		//select_sort(array);
		insertion_sort(array);
		print(array);
	}
}
