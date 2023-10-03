package 그림판.service;

import java.util.ArrayList;

import 그림판.MyShape;

public class MyShapeListService {
	private ArrayList<MyShape> shapes = new ArrayList<MyShape>();

	public void add(MyShape myShape) {
		shapes.add(myShape);
	}

	public int getCount() {
		return shapes.size();
	}

	public MyShape findMyPosition(int startX, int startY) {
		for(MyShape myShape : shapes) {
			if(myShape.getX() == startX && myShape.getY() == startY) {
				return myShape;
			}
		}
		return null;
	}

	public boolean remove(MyShape findShape) {
		return shapes.remove(findShape);
	}

	public void printAll() {
		for(MyShape myShape : shapes) {
			System.out.println(myShape);
		}
	}
}
