package solution._1_10;


import org.junit.jupiter.api.Test;

public class MedianofTwoSortedArrays {
	@Test
	public void test() throws Exception {
		int[] a= {1,2},b= {3,4};
		double k=findMedianSortedArraysI(a, b);
		System.out.println(k);
	}
	public double findMedianSortedArraysI(int[] nums1, int[] nums2) {
		int N1 = nums1.length;
	    int N2 = nums2.length;
	    if (N1 < N2) return findMedianSortedArrays(nums2, nums1);	
	    
	    int lo = 0, hi = N2 * 2;
	    while (lo <= hi) {
	        int mid2 = (lo + hi) / 2;   
	        int mid1 = N1 + N2 - mid2;  
	        
	        double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];	
	        double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
	        double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
	        double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];
	        
	        if (L1 > R2) lo = mid2 + 1;		
	        else if (L2 > R1) hi = mid2 - 1;	
	        else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	
	    }
	    return -1;
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums=nums1.length+nums2.length;
		int mid=nums/2,flag=nums%2==0?1:0;
		int i=0,j=0,count=0;
		int last=0,current=0;
		if(nums1.length==0) {
			return midOfArray(nums2);
		}
		if(nums2.length==0) {
			return midOfArray(nums1);
		}
		while(i<nums1.length||j<nums2.length) {
			int a=i<nums1.length?nums1[i]:Integer.MAX_VALUE;
			int b=j<nums2.length?nums2[j]:Integer.MAX_VALUE;
			if(count==mid) {
				current=a<b?a:b;
			}
			if(count==mid-flag) {
				last=a<b?a:b;
			}
			if(a<b) {
				i++;
			}else {
				j++;
			}
			count++;
		}
		return (current+last)/2.0;
	}
	public double midOfArray(int[] array) {
		if(array.length==1) {
			return array[0];
		}
		int mid=array.length/2;
		int flag=array.length%2==0?1:0;
		return (array[mid]+array[mid-flag])/2.0;
	}
}
