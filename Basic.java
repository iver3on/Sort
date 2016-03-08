/**
 * 
 */
package net.zhangwenbo;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月7日
 * Impossible is nothing
 */
public class Basic {

	//基本排序，每次排序对后面的排序没有帮助，冒泡排序就是基于这个改进的
	public static void BasicSort(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					swap(array, i, j);
				}
			}
		}
	}
	
	//冒泡排序
	public static void BubbleSort(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=array.length-1;j>i;j--){
				if(array[j-1]>array[j]){
					swap(array, j-1, j);
				}
			}
		}
	}
	//改进后的冒泡排序算法：通过一个boolean isChanged，如果一次循环中没有交换过元素，则说明已经排好序
	// 最好：n-1次比较，不移动,因此时间复杂度为O(n)，不占用辅助空间
	// 最坏：n(n-1)/2次比较和移动，因此O(n^2)，占用交换的临时空间，大小为1；
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
	
	//简单选择排序
	/*//最差：n(n-1)/2次比较，n-1次交换，因此时间复杂度为O(n^2)  
//最好：n(n-1)/2次比较，不交换，因此时间复杂度为O(n^2)  
//好于冒泡排序 ：
	 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。*/
	public static void select_sort(int[] array){
		for(int i =0;i<array.length -1;i++){
			int min = i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[min]){
					//记录一轮的最小值
					min = j;
				}
			}
			if(min!=i){
				swap(array, min, i);
			}
		}
	}
	
	//直接插入排序
	//每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置
	//（从后向前找到合适位置后），直到全部插入排序完为止。	
	public static void insertion_sort(int[] a){
		for(int i=1;i<a.length;i++){
			int temp  = a[i];
			int j;
			for(j=i-1;j>=0;j--){
				if(a[j]>temp){
					//将大于temp的向后移动一位
					a[j+1] = a[j];
				}else
					break;
			}
			a[j+1] = temp;
		}
	}
	
	//算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，
	//每组中记录的下标相差d.对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，
//当增量减到1时，进行直接插入排序后，排序完成。
	public static void shellSort(int[] a){
		double d1 = a.length;
		int temp=0;
		while(true){
			d1 = Math.ceil(d1/2);
			int d = (int)d1;
			for(int x=0;x<d;x++){
				for(int i=x+d;i<a.length;i=i+d){
					temp = a[i];
					int j = i-d;
					for(;j>=0&&temp<a[j];j=j-d){
						a[j+d] = a[j];
					}
					a[j+d] = temp;
				}
			}
			if(d==1){
				break;
			}
		}
	}
	
	//希尔排序实现方式2 比较容易理解
	public static void shellSort2(int[] a){
		int d = a.length;
		while(true){
            for(int i=0;i<d;i++){
                for(int j=i;j+d<a.length;j+=d){
                int temp;
                if(a[j]>a[j+d]){
                    temp=a[j];
                    a[j]=a[j+d];
                    a[j+d]=temp;
                    }
                }
            } 
            if(d==1){break;}
            d--;
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
