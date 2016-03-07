package net.zhangwenbo;

/**
 * @author Iver3oN Zhang
 * @date 2016��3��7��
 * Impossible is nothing
 */
public class QuickSort {
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
		int[] array = {2,4,6,1,3,0};
		print(array);
		//select_sort(array);
		quick(array);
		print(array);
	}

	/**
	 * @param array
	 */
	private static void quick(int[] array) {
		// TODO Auto-generated method stub
		if(array.length>0){
			quickSort(array,0,array.length-1);
		}
	}

	/**
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void quickSort(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		 if(low<high){ //�����������жϵݹ���޷��˳����¶�ջ����쳣
	            int middle = getMiddle(a,low,high);
	            quickSort(a, 0, middle-1);
	            quickSort(a, middle+1, high);
	        }
	}

	/**
	 * @param array
	 * ѡ��һ����׼Ԫ��,ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ��,ͨ��һ��ɨ�裬���������зֳ�������,һ���ֱȻ�׼Ԫ��С
һ���ִ��ڵ��ڻ�׼Ԫ��,��ʱ��׼Ԫ�������ź�������ȷλ��,Ȼ������ͬ���ķ����ݹ�����򻮷ֵ������֡�
	 */
	private static int getMiddle(int[] a,int low,int high) {
		int temp = a[low];//ѡ�񣬴˴������Ż�
		while(low<high){
			while(low<high&&a[high]>=temp){
				high--;
			}
		   a[low]  =a[high];//���� �˴������Ż�
		   while(low<high&&a[low]<=temp){
			   low++;
		   }
		   a[high] = a[low];
		}
		a[low]  =temp;
		return low;
	}

}
