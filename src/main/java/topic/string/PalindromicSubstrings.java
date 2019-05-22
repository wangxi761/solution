package topic.string;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int len=s.length();
		int count=0;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j <= len; j++) {
				if(isPalindromic(s.substring(i,j)))
					count++;
			}
		}
		return count;
		
	}
	public boolean isPalindromic(String s) {
		int len = s.length();
		if(len==1)
			return true;
		int i=len/2-1,j=len/2;
		while(i>=0&&j<len) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i--;j++;
		}
		return true;
	}
}
