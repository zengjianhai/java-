package com.homework.three;

public class ShapeTest {

	shapeVa shapeVa = new shapeVa();

	public static void main(String[] args) {
		ShapeTest st = new ShapeTest();
		st.outTriangle();
		st.leftTriangle();
		st.leftOutTriangle();
		st.rightOutTriangle();
		st.rightTriangle();
		st.nullInTriangle();
		st.Triangle();
		st.nullOutTriangle();
		st.nullTriangle();
	}
	// triangle三角形
	public void leftTriangle() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j <= i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	// triangle三角形,倒左三角
	public void leftOutTriangle() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j >= i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public void rightTriangle() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (4 > i + j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public void rightOutTriangle() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j >= i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public void Triangle() {
		shapeVa.shpaeV(5, 9, new ShapeInter() {

			@Override
			public void shape(int x, int y, int i, int j) {
				if (x-1 > i + j || j - x >= i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
		});
	}

	public void outTriangle() {
		shapeVa.shpaeV(5, 9, new ShapeInter() {

			@Override
			public void shape(int x, int y, int i, int j) {
				if (y <= i + j || i > j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
		});
	}

	public void nullTriangle() {
		shapeVa.shpaeV(5, 9, new ShapeInter() {

			@Override
			public void shape(int x, int y, int i, int j) {
				if (x-1 == i + j || j - (x-1) == i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
		});
	}

	public void nullInTriangle() {
		shapeVa.shpaeV(5, 9, new ShapeInter() {

			@Override
			public void shape(int x, int y, int i, int j) {
				if (x-1 == i + j || j - (x-1) == i || i == x-1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
		});
	}

	public void nullOutTriangle() {
		shapeVa.shpaeV(5, 9, new ShapeInter() {

			@Override
			public void shape(int x, int y, int i, int j) {
				if (y - 1 == i + j || i == j || i == 0) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
		});
	}

}

class shapeVa {
	public void shpaeV(int x, int y, ShapeInter sInter) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				sInter.shape(x, y, i, j);
			}
			System.out.println();
		}
	}
}
