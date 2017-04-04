package univ.lecture;
import java.lang.*;
import java.util.*;

	private static boolean isAnOperator(char s) {
		return (s == '+' || s == '-' || s == '*' || s == '/');
	}

	private static int evaluate(int x, int y, char op) {
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

	public static int calculateExpression(String exp){
		return calculatePostFix(infixToPostfix(exp));
	}

	private static int calculatePostFix(String postfix){

		Stack<Object> stack = new Stack<Object>();
		for (int i = 0; i < postfix.length(); i++) {
			char input = postfix.charAt(i);
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
		return 0;
	}
		
	private static String infixToPostfix(String infix){
		String postfix = "";
		Stack<Object> stack = new Stack<Object>();

		for(int i = 0; i < infix.length(); i++){ 
			char c = infix.charAt(i);
			if(c >= '0' && c <= '9'){ 
				postfix += c;
			}
			else if (c == '+' || c == '-') { 
				while(!stack.isEmpty()) { 
					
					char prev = (char)stack.pop();
					if ( prev == '*' || prev == '/' || prev == '+' || prev == '-') {
						postfix += prev; 	  
					}						
					else {
						stack.push(prev);	
						break;
					}
				}
				stack.push(c);             
			}
			else if (c == '*' || c == '/') { 
				while(!stack.isEmpty()) { 
					
					char prev = (char)stack.pop();
					if(prev == '*' || prev == '/'){ 
						postfix += prev;			
					}
					else
					{								
						stack.push(prev);			
						break;
					}
				}
				stack.push(c);	
			}
			else if ( c == '(') { 
				stack.push(c);
			}
			else if ( c == ')') { 
				while(true){      
					char prev = (char)stack.pop();
					if( prev == '(')
						break;
					postfix += prev;
				}
			}
		}
		while( !stack.isEmpty() ){ 
			postfix += stack.pop();
		}
		return "";
	}

}
