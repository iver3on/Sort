/**
 * ������ ���ʱ�临�Ӷ�OnlogN �Ҳ��OnlogN
 * ����ڿ�������ƽ��ʱ�临�Ӷ�ΪO��n*logn����������ΪO��n*n���������Ƕ����������ŵ㡣
 * ���ڱȽϵ�����
 */
package net.zhangwenbo;

/**
 * @author Iver3oN Zhang
 * @date 2016��3��9��
 * @email grepzwb@qq.com HeapSort.java Impossible is nothing
 */
public class HeapSort {

	/**
	 * @param args
	 * ���� ��С������
	 * ��С�� �Ӵ�С��
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
		//����������� ����  ����Ϊ����
		for(i=length/2-1;i>=0;i--){
			arrayToMaxHeap(a, i, length-1);
		}
		for(i = length-1;i>0;i--){
			//�Ѷ�Ԫ�غͶѵ�Ԫ�ؽ���  �Ѷ�Ԫ�ؼ�Ϊ���Ԫ��  ÿ�ν����󶼵������ٴ�Ϊ���ѣ�����....
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			arrayToMaxHeap(a, 0, i-1);
		}
		
	}

	/**
	 * @param a
	 *            ��������ת�������� ������ i 2i+1 2i+2 ������ʼλ��Ϊ0 �ѵ���ʼλ��Ҳ��0
	 */
	private static void arrayToMaxHeap(int[] a, int begin, int end) {
		// TODO Auto-generated method stub
		// ������Ҫ�����Ľڵ�
		int temp = a[begin];
		int i = 2 * begin + 1;
		while (i <= end) {
			if (i + 1 < end && a[i] < a[i + 1]) {
				// �Һ��Ӵ�������
				i++;
			}
			// ��ʾ���Һ��Ӷ�С�ڸ��ڵ� �˳�
			if (a[i] <= temp) {
				break;
			} else {
				// �ƶ�
				a[begin] = a[i];
				// �������н���
				begin = i;
				//��������While ���бȽϽ���
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
