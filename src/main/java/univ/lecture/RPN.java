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

	public static void transform(String s){
		ArrayStack stack = new ArrayStack();

		for(int i = 0; i < s.length(); i++){ 
			char c = s.charAt(i);
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
			System.out.println(postfix);
	}

}
