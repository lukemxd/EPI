package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.11
public class RectIntersect {
	
	int x1, x2, y1, y2;
	
	//Default constructor
	public RectIntersect(int a, int b, int c, int d){

		this.x1 = a;
		this.x2 = b;
		this.y1 = c;
		this.y2 = d;
	}
	
	private static boolean isIntersect(RectIntersect r1, RectIntersect r2){
		return r1.x1 <= r2.x2 && r1.x2 >= r2.x1 && r1.y1 <= r2.y2 && r1.y2 >= r2.y1;
	}
	
	private static RectIntersect intersectRectangle(RectIntersect r1, RectIntersect r2){
		if(isIntersect(r1, r2)){
			return new RectIntersect(Math.max(r1.x1, r2.x1), Math.min(r1.x2, r1.x2), Math.max(r1.y1, r2.y1), Math.min(r1.y2, r2.y2));
		}
		else{
			return new RectIntersect(0, 0, 0, 0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		RectIntersect R1, R2;
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		
		System.out.println("Enter the coordibates for rectangle R1 and R2: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				x1 = Integer.valueOf(input.split(" ")[0]);
				x2 = Integer.valueOf(input.split(" ")[1]);
				y1 = Integer.valueOf(input.split(" ")[2]);
				y2 = Integer.valueOf(input.split(" ")[3]);
				R1 = new RectIntersect(x1, x2, y1, y2);
				x1 = Integer.valueOf(input.split(" ")[4]);
				x2 = Integer.valueOf(input.split(" ")[5]);
				y1 = Integer.valueOf(input.split(" ")[6]);
				y2 = Integer.valueOf(input.split(" ")[7]);
				R2 = new RectIntersect(x1, x2, y1, y2);
				
				System.out.println("R1 = (" + R1.x1 + "," + R1.x2 + "," + R1.y1 + "," + R1.y2 + ") "
						         + "R2 = (" + R2.x1 + "," + R2.x2 + "," + R2.y1 + "," + R2.y2 + ")");
				//Calculate the intersection
				RectIntersect R = intersectRectangle(R1, R2);
				System.out.println("The instection rectangle is: (" + R.x1 + "," + R.x2 + "," + R.y1 + "," + R.y2 + ")");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
