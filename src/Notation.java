
public class Notation {
	public Notation() {
		
	}
	public static int priority(char ch) {
		if (ch == '+' || ch == '-') {
			return 1;
		}
		else if (ch == '*' || ch == '/') {
			return 2;
		}
		return 0;
	}
	public static double evaluatePostfixExpression(String PostfixExpr) throws InvalidNotationFormatException{
		double sol = 0;
		NotationStack<Integer> stack = new NotationStack<>();
		for (int i=0; i< PostfixExpr.length(); i++) {
			char symbol = PostfixExpr.charAt(i);
			
			if(Character.isDigit(symbol)) {
				try {
					stack.push(symbol -'0');
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				int val1 =0;
				try {
					val1 = stack.pop();
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int val2 =0;;
				try {
					val2 = stack.pop();
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch(symbol) {
				case '+':
					try {
						stack.push(val1+val2);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case '-':
					try {
						stack.push(val2-val1);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case '*':
					try {
						stack.push(val2*val1);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case '/':
					try {
						stack.push(val2/val1);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
		try {
			return stack.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sol;
	}
	public static String convertPostfixToInfix(String Postfix) throws InvalidNotationFormatException{
		String infix = "";
		NotationStack<String> s = new NotationStack<String>();
		char symbol;
		for (int i= 0; i < Postfix.length(); i++) {
			symbol = Postfix.charAt(i);
			if(Character.isDigit(symbol)) {
				try {
					s.push(symbol +"");
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					String op1 = s.top();
					s.pop();
					String op2 = s.top();
					s.pop();
					s.push("("  + op2 + symbol + op1 + ")");
					infix += s.pop();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return infix;
	}
	
	public static String convertInfixToPostfix (String Infix) throws InvalidNotationFormatException{
		String postfix = "";
		NotationStack<Character> stack = new NotationStack<>();
		char symbol;
		for (int i = 0; i < Infix.length(); i++) {
			symbol = Infix.charAt(i);
			if (Character.isLetterOrDigit(symbol)) {
				postfix += Infix.charAt(i);
			}
			else if (symbol == '(') {
				try {
					stack.push(symbol);
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (symbol == ')') {
				try {
					while(stack.top() != '(')
					{
						postfix += stack.pop();
					}
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					stack.pop();
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				try {
					if (stack.isEmpty()) {
						throw new InvalidNotationFormatException();
					}
					else if (stack.top() == '(')
					{
						stack.push(symbol);
					}
					else {
						while(!stack.isEmpty() && !(stack.top() == '(') && priority(symbol) <= priority(stack.top()))
						{
							postfix += stack.pop();
							stack.push(symbol);
						}
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				}
			}
		
		while(!stack.isEmpty()) {
			try {
				postfix	+= stack.pop();
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return postfix;
			
	}

}
