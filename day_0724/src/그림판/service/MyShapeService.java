package 그림판.service;

//import 그림판.MyCircle;
//import 그림판.MyLine;
import 그림판.MyShape;

/** MyShape 파생(자식) 객체를 저장 */

public class MyShapeService {
	private MyShape[] shapes = new MyShape[100];
	private int count = 0;
	
	public int getCount() {
		return count;
	}
	
//	 오버로딩(타입 다름)
//	public void add(MyLine myLine) {
//		shapes[count++] = myLine;
//	}
//	
//	public void add(MyCircle myCircle) {
//		shapes[count++] = myCircle;
//	}
	
	public void add(MyShape myShape) {
		shapes[count++] = myShape;
	}

	public MyShape findMyPosition(int startX, int startY) {
		for(int i=0; i<count; i++) {
			if(startX == shapes[i].getX() && startY == shapes[i].getY()) {
				return shapes[i];
			}
		}
		
		return null;
	}

	public boolean remove(MyShape findShape) {
		for(int i=0; i<count; i++) {
			if(shapes[i].equals(findShape)) {
				remove(i);
				return true;
			}
		}
		
		return false;
	}

	/** i번째 객체 삭제 */
	private void remove(int idx) {
		for(int i=idx; i<count; i++) {
			shapes[i] = shapes[i+1];
		}
		
		count--;
	}
	
	public void printAll() {
		for(int i=0; i<count; i++) {
			System.out.println(shapes[i]);
		}
	}
}
