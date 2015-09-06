package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import struct.intervalTree;
import struct.line;
import struct.maxsaver;

public class MaxRS {
	
	private void doMaxRS(){
		ArrayList<Double> X = getX();
		Collections.sort(X);
		intervalTree a = new intervalTree();
		a.setX(X);
		a.build(0, X.size()-1);
		System.out.println("tree build finish");
		
		ArrayList<line> lines = getlines();
		Collections.sort(lines);
		System.out.println("sort lines finish");
		
		maxsaver saver = new maxsaver();
		saver.setMAXSIZE(20);
		saver.setInterval(a.getMiddleTravel());
		
		
		a.insertLine(lines.get(0));//[1,4]1
		saver.update(a.getrootMaxlist(), a.getrootMax(),lines.get(0).getHigh());
		a.insertLine(lines.get(1));//[3,6]1
		saver.update(a.getrootMaxlist(), a.getrootMax(),lines.get(1).getHigh());
		a.insertLine(lines.get(2));//[1,4]-1
		saver.update(a.getrootMaxlist(), a.getrootMax(),lines.get(2).getHigh());
		a.insertLine(lines.get(3));//[3,6]1
		saver.update(a.getrootMaxlist(), a.getrootMax(),lines.get(3).getHigh());
		
		System.out.println("insert lines finish");
	}
	private ArrayList<Double> getX() {
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
		return X;
	}
	private ArrayList<line> getlines() {
		ArrayList<Double> X = getX();
		Collections.sort(X);
		HashMap<Double, Integer> xmap = new HashMap<Double, Integer>();
		for (int i = 0; i < X.size(); i++)
			xmap.put(X.get(i), i);
		ArrayList<line> lines = new ArrayList<>();
		line aLine;
		aLine = new line(xmap.get(2.3),xmap.get(5.6),1); aLine.setFlag(true);
		lines.add(aLine);
		aLine = new line(xmap.get(2.3),xmap.get(5.6),2); aLine.setFlag(true);
		lines.add(aLine);
		aLine = new line(xmap.get(2.3),xmap.get(5.6),4); aLine.setFlag(false);
		lines.add(aLine);
		aLine = new line(xmap.get(4.5),xmap.get(7.8),1); aLine.setFlag(true);
		lines.add(aLine);
		aLine = new line(xmap.get(4.5),xmap.get(7.8),3); aLine.setFlag(false);
		lines.add(aLine);

		return lines;
}
	
	public static void main(String[] args) {
		MaxRS maxrs = new MaxRS();
		maxrs.doMaxRS();
		
	}
}
