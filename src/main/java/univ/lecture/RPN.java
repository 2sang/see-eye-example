package univ.lecture;
import java.lang.*;
import java.util.*;

public class RPN{

	private static boolean isAnOperator(String s) {
		return (s.length() == 1 && "+-*/".indexOf(s) >= 0);
	}

	private static double evaluate(double x, double y, String op) {
		double z = 0;

		if (op.equals("+"))
			z = x + y;
		else if (op.equals("-"))
			z = x - y;
		else if (op.equals("*"))
			z = x * y;
		else
			z = x / y;
		
		return z;
	}

	public static double calculateExpression(String exp){
		return calculatePostFix(infixToPostfix(exp));
	}

	private static double calculatePostFix(String[] args){
		Stack<Object> stack = new Stack<Object>();
		
		for (int i = 0; i < args.length; i++) {
			String input = args[i];

			if (isAnOperator(input)) {
				double y = Double.parseDouble((String) stack.pop());
				double x = Double.parseDouble((String) stack.pop());
				double z = evaluate(x, y, input);
				stack.push("" + z);
			} else
				stack.push(input);
		}
		
		return Double.parseDouble(stack.pop().toString());
	}
	
	private static String[] infixToPostfix(String infix){
		Stack<Object> stack = new Stack<Object>();
		
		String tempPostfix = new String();
		int count = 0;
		String[] changedArgs = infix.split("(?<=[\\(\\)\\+\\-*\\/\\^A-Za-z])|(?=[\\(\\)\\+\\-*\\/\\^A-Za-z])");
		
		for (int i = 0; i < changedArgs.length; i++) {
			if (precedence(changedArgs[i]) == 3) {
				stack.push(changedArgs[i]);
			} else if (precedence(changedArgs[i]) == 9) {
				while (!stack.peek().equals("(")) {
					tempPostfix += (String) stack.pop() + " ";
					count++;
				}
				stack.pop();
			} else if (precedence(changedArgs[i]) == 0) {
				tempPostfix += changedArgs[i] + " ";
				count++;
			} else if (!stack.isEmpty() && (precedence(changedArgs[i]) <= precedence((String) stack.peek()))) {
				while (!stack.isEmpty() && (precedence(changedArgs[i]) <= precedence((String) stack.peek()))) {
					tempPostfix += (String) stack.pop() + " ";
					count++;
				}
				stack.push(changedArgs[i]);
			} else
				stack.push(changedArgs[i]);
		}

		while (!stack.isEmpty()) {
			tempPostfix += (String) stack.pop() + " ";
			count++;
		}

		StringTokenizer parser = new StringTokenizer(tempPostfix, " ");
		String[] postfix = new String[count];
		int j = 0;

		while (parser.hasMoreTokens()) {
			postfix[j] = parser.nextToken();
			j++;
		}

		return postfix;
	}
	
	private static int precedence(String token) {
		if (token.equals("+")) {
			return 5;
		} else if ("-".equals(token)) {
			return 5;
		} else if ("/".equals(token)) {
			return 7;
		} else if ("*".equals(token)) {
			return 7;
		} else if ("(".equals(token)) {
			return 3;
		} else if (")".equals(token)) {
			return 9;
		} else
			return 0;
	}
}
