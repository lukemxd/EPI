package stacksAndQueues;

//Problem 9.2
public class RPN {
	
	public static int Evaluate(String RPNExpression){
		Stack<Integer> RPN = new Stack<Integer>();
		String[] RPNArray = RPNExpression.split(",");
		for(String element : RPNArray){
			if(element.length() == 1 && "+-*/".contains(element)){
				int a = RPN.Pop();
				int b = RPN.Pop();
				switch (element) {
				case "+":
					RPN.Push(a + b);
					break;
				case "-":
					RPN.Push(a - b);
					break;
				case "*":
					RPN.Push(a * b);
					break;
				case "/":
					RPN.Push(a / b);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at: " + element);
				}				
			}
			else{
				RPN.Push(Integer.parseInt(element));
			}
		}
		
		return RPN.Pop();
	}
}
