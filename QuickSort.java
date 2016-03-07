package net.zhangwenbo;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月7日
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
		 if(low<high){ //如果不加这个判断递归会无法退出导致堆栈溢出异常
	            int middle = getMiddle(a,low,high);
	            quickSort(a, 0, middle-1);
	            quickSort(a, middle+1, high);
	        }
	}

	/**
	 * @param array
	 * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小
一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 */
	private static int getMiddle(int[] a,int low,int high) {
		int temp = a[low];//选择，此处可以优化
		while(low<high){
			while(low<high&&a[high]>=temp){
				high--;
			}
		   a[low]  =a[high];//交换 此处可以优化
		   while(low<high&&a[low]<=temp){
			   low++;
		   }
		   a[high] = a[low];
		}
		a[low]  =temp;
		return low;
	}

}
