/**
 * 
 */
package net.zhangwenbo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author iver3on
 * @email grepzwb@qq.com
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		
		/*
		 * Collections.sort(names, new Comparator<String>() {
    		@Override
    		public int compare(String a, String b) {
        	return b.compareTo(a);
    	}
	});
		 */
		
		//JAVA8Lambda±í´ïÊ½¡£
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		
		//Collections.sort(names, (String a, String b) -> b.compareTo(a));
		//Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names);
	}

}
