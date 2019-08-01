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
				node.nodes[ch] = new Node(i == word.toCharArray().length - 1);
				node = node.nodes[ch];
			}
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();
		recursive(head, sb, res);
		return res.toString();
	}
	
	public void recursive(Node head, StringBuilder sb, StringBuilder res) {
		if (head == null || !head.used) return;
		if (head.nodes == null) {
			if (res.length() < sb.length()) {
				res.replace(0, res.length(), sb.toString());
			}
			return;
		}
		for (int i = 0; i < head.nodes.length; i++) {
			sb.append((char) (i + 97));
			recursive(head.nodes[i], sb, res);
			sb.delete(sb.length() - 1, sb.length());
		}
	}
}
