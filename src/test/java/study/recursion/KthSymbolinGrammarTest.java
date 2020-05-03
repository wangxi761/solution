package study.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KthSymbolinGrammarTest {
	KthSymbolinGrammar test = new KthSymbolinGrammar();
	
	@Test
	public void kthGrammar() {
		System.out.println(test.kthGrammar(4, 5));
	}
}