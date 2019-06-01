package study.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthSymbolinGrammarTest {
	KthSymbolinGrammar test = new KthSymbolinGrammar();
	
	@Test
	public void kthGrammar() {
		System.out.println(test.kthGrammar(4, 5));
	}
}