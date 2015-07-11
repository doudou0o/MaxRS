package solution;

import java.util.ArrayList;
import java.util.Collections;

import struct.intervalTree;

public class MaxRS {

	public static void main(String[] args) {
		ArrayList<Double> X= new ArrayList<Double>();
		X.add(1.2);
		X.add(2.3);
		X.add(3.4);
		X.add(4.5);
		X.add(5.6);
		X.add(6.7);
		X.add(7.8);
		X.add(8.2);
		X.add(9.4);
		X.add(9.9);
		Collections.sort(X);
		intervalTree a = new intervalTree();
		a.setX(X);
		a.build(0, X.size()-1);
		System.out.println("aa");
	}

}
