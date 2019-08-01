package topic.trie;

public class LongestWordinDictionary {
	public static class Node {
		Node[] nodes;
		boolean used;
		
		public Node(boolean used) {
			this.used = used;
		}
	}
	
	public String longestWord(String[] words) {
		Node head = new Node(true);
		for (String word : words) {
			Node node = head;
			for (int i = 0; i < word.toCharArray().length; i++) {
				if (node.nodes == null) {
					node.nodes = new Node[26];
				}
				int ch = word.charAt(i) - 97;
				if (node.nodes[ch] == null) {
					node.nodes[ch] = new Node(i == word.toCharArray().length - 1);
				} else {
					node.nodes[ch].used |= i == word.toCharArray().length - 1;
				}
				node = node.nodes[ch];
			}
		}
		StringBuilder sb = new StringBuilder();
//		StringBuilder res = new StringBuilder();
//		recursive(head, sb, res);
//		return res.toString();
		return recursive(head, sb);
	}
	
	public String recursive(Node head, StringBuilder sb) {
		if (!head.used) {
			return sb.substring(0, sb.length() - 1).toString();
		}
		if (head.nodes == null) {
			return sb.toString();
		}
		String res = "";
		for (int i = 0; i < head.nodes.length; i++) {
			if (head.nodes[i] == null) continue;
			sb.append((char) (i + 97));
			String recursive = recursive(head.nodes[i], sb);
			if (recursive.length() > res.length()) res = recursive;
			sb.delete(sb.length() - 1, sb.length());
		}
		return res;
	}
	public void recursive(Node head, StringBuilder sb, StringBuilder res) {
		if (!head.used) return;
		if (res.length() < sb.length()) {
			res.replace(0, res.length(), sb.toString());
		}
		if (head.nodes == null) return;
		for (int i = 0; i < head.nodes.length; i++) {
			if (head.nodes[i] == null) continue;
			sb.append((char) (i + 97));
			recursive(head.nodes[i], sb, res);
			sb.delete(sb.length() - 1, sb.length());
		}
	}
}
