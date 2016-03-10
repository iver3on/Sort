/**
 * count sort ��������
 * ����n������Ԫ�ص�ÿһ������0��k�����ڵ�һ������������kΪĳ��������
 * ������Ǻ�����д�ĳ���Ҳֻ�����0��k֮���Ԫ�ؽ������򣬻��仰˵������Ԫ���в����и�����
    ��������Ļ���˼���ǣ���һ������Ԫ��x����ȷ����������Ԫ����С��x��Ԫ�ظ�����
    ��ô�����x���ڵ�λ��Ҳ����ȷ�ˡ����磬���е�����Ԫ������10��Ԫ��С��x��
    ��ô�ź����x��λ����ž�Ӧ����11����Ȼ���������ͬԪ�أ���ȻҪ�ŵ����ڵ�λ���ϡ�
 */
package net.zhangwenbo;

/**
 * @author Iver3oN Zhang
 * @date 2016��3��8��
 * Impossible is nothing
 */
public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {217,125,362,136,733,522}; 
		print(array);
		//select_sort(array);
		// int brr[6]; //��������ÿ�μ��������Ľ��  
		// int w[6];   //ÿ��ѭ��ʱ�������λ�ϵ���  
		// int crr[8]; //ÿ��ѭ��ʱ�������λ�ϵ������ֵĴ���  
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
		//�õ�a��������ֵ
		int max = getMax(a);
		//�洢 ͳ��a��С�ڵ���i��Ԫ�ظ���
		int[] c = new int[max+1];
		//�洢����������
		int[] b = new int[a.length];
		for(int i=0;i<c.length;i++){
			c[i]=0;
		}
		//ͳ��a��Ԫ�طֱ���ֵĴ���
		for(int i=0;i<a.length;i++){
			c[a[i]]++;
		}
		//������a��С�ڵ���i��Ԫ�ظ���  
		for(int i=1;i<c.length;i++){
			c[i] = c[i]+c[i-1];
		}
		for(int i=a.length-1;i>=0;i--){
			//a[i]��ʵ��λ��Ӧ����c[a[i]]-1
			int index = c[a[i]]-1;
			b[index] = ago[i];
			//�������ͬ��Ԫ�أ��������һ��λ����  
			c[a[i]]--;
		}
		for(int i=0;i<a.length;i++){
			ago[i] = b[i];
		}
	}
	private static void countSort2(int[] a) {
		// TODO Auto-generated method stub
		//ago�Ǵ���������� 
		//a�Ǵ����������λ����ʮλ�� ��λ�ϵ����� ����
		//�õ�a��������ֵ
		int max = getMax(a);
		//�洢 ͳ��a��С�ڵ���i��Ԫ�ظ���
		int[] c = new int[max+1];
		//�洢����������
		//int[] b = new int[a.length];
		for(int i=0;i<c.length;i++){
			c[i]=0;
		}
		//ͳ��a��Ԫ�طֱ���ֵĴ���
		for(int i=0;i<a.length;i++){
			c[a[i]]++;
		}
	/*	//������a��С�ڵ���i��Ԫ�ظ���  �洢��c��
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
	
	//�������� ʹ���˼�������
	public static void radixSort(int[] a){
		int val = 1;
		int[] w = new int[a.length];
		//3λ��
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
