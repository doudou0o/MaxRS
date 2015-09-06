package struct;

import java.util.ArrayList;
import java.util.HashSet;

public class maxsaver {
	private ArrayList<slide> slides;
	private ArrayList<Integer> intervals; //each its position <----> node-id
	private Integer[] intervals_reverse; //each node-id <----> its position
	private double value=-1;
	private double top=-1;
	private int MAXSIZE;
	
	public void init(){
		init(-1);
	}
	public void init(double v){
		if (slides != null)
			slides.clear();
		slides = new ArrayList<slide>();
		top=-1;
		setValue(v);
	}
	public void update(HashSet<Integer> maxlist, double value, double h) {
		if (value < this.value) {
			if (top == -1)
				setTop(h);
		} else if (value > this.value) {
			init(value);
			update(maxlist, value, h);
		} else {
			byte[] slite = nodes2bytes(maxlist);
			insertSlides(slite,h);
		}
	}
	
	private void insertSlides(byte[] slite, double h) {
		slide s = new slide();
		s.setWindowRecode(slite);
		s.setHigh(h);
		slides.add(s);
	}
	private byte[] nodes2bytes(HashSet<Integer> maxlist) {
		byte[] ans = new byte[MAXSIZE];
		for (Integer nodeid : maxlist) {
			ans[intervals_reverse[nodeid]]=1;
		}
		return ans;
	}
	public void setInterval(ArrayList<Integer> i){
		this.intervals = i;
		intervals_reverse = new Integer[MAXSIZE];
		for (int j = 0; j < intervals.size(); j++) {
			intervals_reverse[ intervals.get(j) ] = j;
		}
	}
	private void setTop(double top){
		this.top = top;
	}
	public double getTop(){
		return top;
	}
	private void setValue(double value) {
		this.value = value;
	}
	public double getValue() {
		return value;
	}
	
	public void setMAXSIZE(int m) {
		MAXSIZE = m;
	}

	class slide{
		private byte[] windowRecode;
		private double high;
		
		public void setWindowRecode(byte[] windowRecode) {
			this.windowRecode = windowRecode;
		}
		public byte[] getWindowRecode() {
			return windowRecode;
		}
		public void setHigh(double high) {
			this.high = high;
		}
		public double getHigh() {
			return high;
		}
		
	}
}
