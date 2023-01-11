package practice;

import java.util.Arrays;

public class AddAndSplit {
	public static void main(String[] args) {
		int[] a= {1,5,9,11,1236,19};
		int[] b= {4,4,2,1,8};
		int length=0;
		if(a.length>=b.length) {
			length=a.length;
		}
		else {
			length=b.length;
		}
		int[] temp=new int[length];
		for(int i=0;i<length;i++) {
			try {
			temp[i]=a[i]+b[i];
			}
			catch(ArrayIndexOutOfBoundsException e) {
				if(a.length>b.length) {
					temp[i]=a[i];
				}
				else {
					temp[i]=b[i];
				}	
			}
		}
		String s="";
		for(int it:temp) {
			s=s+it;
		}
		System.out.println(s);
		
		System.out.println(Arrays.toString(temp));
		int rlength=0;
		for(int i=0;i<temp.length;i++) {
			if(temp[i]<=9) {
				rlength++;
			}else {
				while(temp[i]>0) {
					rlength++;
					temp[i]=temp[i]/10;
				}
			}
		}
		int[] res=new int[rlength];	 
		for(int i=0;i<s.length();i++) {
			res[i]=s.charAt(i)-48;
		}
		System.out.println(Arrays.toString(res));
		
	}


}
