package topic.string;

public class ReverseWordsinaStringIII {
	public String reverseWords(String s) {
		char[] cs = s.toCharArray();		
		for (int i = 0,j=0; i < cs.length; i++) {
			if(cs[i]==' '||i==cs.length-1) {
				int a=cs[i]==' '?i-1:i,b=j;
				while(b<a) {
					char temp=cs[a];
					cs[a]=cs[b];
					cs[b]=temp;
					a--;b++;
				}
				j=i+1;
			}
		}
		return new String(cs);
	}
}
