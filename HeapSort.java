/**
 * 堆排序 最好时间复杂度OnlogN 最坏也是OnlogN
 * 相对于快速排序（平均时间复杂度为O（n*logn），最坏情况下为O（n*n）），这是堆排序的最大优点。
 * 基于比较的排序
 */
package net.zhangwenbo;

/**
 * @author Iver3oN Zhang
 * @date 2016年3月9日
 * @email grepzwb@qq.com HeapSort.java Impossible is nothing
 */
public class HeapSort {

	/**
	 * @param args
	 * 最大堆 从小到大排
	 * 最小堆 从大到小排
	 */
	public static void main(String[] args) {
		int a[] = {2,4,5,1,3,5,2,14,21,413,41,12,7,68,98,21};
		print(a);
		heapSort(a,a.length);
		print(a);
	}

	/**
	 * @param a
	 * @param length
	 */
	private static void heapSort(int[] a, int length) {
		// TODO Auto-generated method stub
		int i;
		//将任意二叉树 数组  调整为最大堆
		for(i=length/2-1;i>=0;i--){
			arrayToMaxHeap(a, i, length-1);
		}
		for(i = length-1;i>0;i--){
			//堆顶元素和堆底元素交换  堆顶元素即为最大元素  每次交换后都调整其再次为最大堆，继续....
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			arrayToMaxHeap(a, 0, i-1);
		}
		
	}

	/**
	 * @param a
	 *            将此数组转换成最大堆 待排序 i 2i+1 2i+2 数组起始位置为0 堆的起始位置也是0
	 */
	private static void arrayToMaxHeap(int[] a, int begin, int end) {
		// TODO Auto-generated method stub
		// 保存需要调整的节点
		int temp = a[begin];
		int i = 2 * begin + 1;
		while (i <= end) {
			if (i + 1 < end && a[i] < a[i + 1]) {
				// 右孩子大于左孩子
				i++;
			}
			// 表示左右孩子都小于父节点 退出
			if (a[i] <= temp) {
				break;
			} else {
				// 移动
				a[begin] = a[i];
				// 继续进行交换
				begin = i;
				//继续进入While 进行比较交换
				i = 2 * begin + 1;
			}
			a[begin] = temp;
		}
	}
	
	private static void print(int[] array) {
		for(int x:array){
			System.out.print(x+" ");
		}
		System.out.println();
	}
}
