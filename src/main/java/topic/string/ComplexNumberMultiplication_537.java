package topic.string;

public class ComplexNumberMultiplication_537 {
	public String complexNumberMultiply(String a, String b) {
		return add(new ComplexNumber(a), new ComplexNumber(b)).toString();
	}
	public static class ComplexNumber {
		int a;
		int b;
		public ComplexNumber(String str) {
			String[] arr = str.split("\\+");
			a = Integer.valueOf(arr[0]);
			b = Integer.valueOf(arr[1].replace("i", ""));
		}

		public ComplexNumber(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return a+"+"+b+"i";
		}
		

	}
	public ComplexNumber add(ComplexNumber number1,
			ComplexNumber number2) {
		return new ComplexNumber(
				number1.a * number2.a - number1.b * number2.b,
				number1.a * number2.b + number1.b * number2.a);
	}
}
