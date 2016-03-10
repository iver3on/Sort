/**
 * count sort 计数排序
 * 假设n个输入元素的每一个都是0到k区间内的一个整数，其中k为某个整数。
 * 因此我们后面所写的程序也只是针对0到k之间的元素进行排序，换句话说，排序元素中不能有负数。
    计数排序的基本思想是：对一个输入元素x，先确定所有输入元素中小于x的元素个数，
    那么排序后x所在的位置也就明确了。比如，所有的输入元素中有10个元素小于x，
    那么排好序后x的位置序号就应该是11。当然，如果有相同元素，自然要放到相邻的位置上。
 */
package net.zhangwenbo;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月8日
 * Impossible is nothing
 */
public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {217,125,362,136,733,522}; 
		print(array);
		//select_sort(array);
		// int brr[6]; //用来保存每次计数排序后的结果  
		// int w[6];   //每次循环时，保存该位上的数  
		// int crr[8]; //每次循环时，保存该位上的数出现的次数  
		radixSort(array);
		print(array);
}
/**
	 * @param array
	 */
	
	private static int getMax(int[] a){
		int max = 0;
		for(int x:a){
			if(x>max){
				max = x;
			}
		}
		return max;
	}
	private static void countSort(int[] a,int[] ago) {
		// TODO Auto-generated method stub
		//得到a数组的最大值
		int max = getMax(a);
		//存储 统计a中小于等于i的元素个数
		int[] c = new int[max+1];
		//存储排序后的数组
		int[] b = new int[a.length];
		for(int i=0;i<c.length;i++){
			c[i]=0;
		}
		//统计a中元素分别出现的次数
		for(int i=0;i<a.length;i++){
			c[a[i]]++;
		}
		//求数组a中小于等于i的元素个数  
		for(int i=1;i<c.length;i++){
			c[i] = c[i]+c[i-1];
		}
		for(int i=a.length-1;i>=0;i--){
			//a[i]的实际位置应该是c[a[i]]-1
			int index = c[a[i]]-1;
			b[index] = ago[i];
			//如果有相同的元素，则放在下一个位置上  
			c[a[i]]--;
		}
		for(int i=0;i<a.length;i++){
			ago[i] = b[i];
		}
	}
	private static void countSort2(int[] a) {
		// TODO Auto-generated method stub
		//ago是待排序的数组 
		//a是待排序数组个位或者十位上 百位上的数字 数组
		//得到a数组的最大值
		int max = getMax(a);
		//存储 统计a中小于等于i的元素个数
		int[] c = new int[max+1];
		//存储排序后的数组
		//int[] b = new int[a.length];
		for(int i=0;i<c.length;i++){
			c[i]=0;
		}
		//统计a中元素分别出现的次数
		for(int i=0;i<a.length;i++){
			c[a[i]]++;
		}
	/*	//求数组a中小于等于i的元素个数  存储在c中
		for(int i=1;i<c.length;i++){
			c[i] = c[i]+c[i-1];
		}*/
		int i,j=0;
		for(i=0;i<=max;i++){ 
	        while((c[i]--)>0){  
	            a[j++] = i;  
	        }
		}
	}
	
	//基数排序 使用了计数排序
	public static void radixSort(int[] a){
		int val = 1;
		int[] w = new int[a.length];
		//3位数
		for(int i=0;i<3;i++){
			for(int j=0;j<a.length;j++){
				w[j] = (a[j]/val)%10;
			}
			countSort(w,a);
			print(a);
			val = val*10;
		}
	}
/**
 * @param array
 */
private static void print(int[] array) {
	for(int x:array){
		System.out.print(x+" ");
	}
	System.out.println();
}
}
