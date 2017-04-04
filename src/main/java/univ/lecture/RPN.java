import java.lang.*;

public class RPN{
	public RPN(String args) {
		ArrayStack stack = new ArrayStack(args.length());
		
		for (int i = 0; i < args.length(); i++) {
			char input = args.charAt(i);
			int input_int = 0;
				
			if (isAnOperator(input)) {
				int y = (int)stack.pop();
				int x = (int)stack.pop();
				int z = evaluate(x, y, input);
				stack.push(z);
				}
			else{
				input_int = Character.getNumericValue(input); 
				stack.push(input_int);
				}
			}
	}
		
	private boolean isAnOperator(char s) {
		return (s == '+' || s == '-' || s == '*' || s == '/');
	}

	private int evaluate(int x, int y, char op) {
		int z = 0;

		if (op == '+')
			z = x + y;
		else if (op == '-')
			z = x - y;
		else if (op == '*')
			z = x * y;
		else
			z = x / y;

		return z;
	}
}
