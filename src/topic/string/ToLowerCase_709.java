package topic.string;

public class ToLowerCase_709 {

	public String toLowerCase(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]<='Z'&&ch[i]>='A') {
				ch[i]+=32;
			}
		}
		return new String(ch);
	}
}
