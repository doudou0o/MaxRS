package struct;

import java.util.ArrayList;

public class maxsaver {
	private ArrayList<slide> slides;
	private ArrayList<Integer> intervals; //each node-id <----> its position
	private double value=-1;
	private double top=-1;
	
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
	public void update(ArrayList<Integer> maxnodes, double value, double h) {
		if (value < this.value) {
			if (top == -1)
				setTop(h);
		} else if (value > this.value) {
			init(value);
		} else {
			byte[] slite = nodes2bytes(maxnodes);
			insertSlides(slite,h);
		}
	}
	
	private void insertSlides(byte[] slite, double h) {
		slide s = new slide();
		s.setWindowRecode(slite);
		s.setHigh(h);
		slides.add(s);
	}
	private byte[] nodes2bytes(ArrayList<Integer> maxnodes) {
		byte[] ans = new byte[maxnodes.size()];
		for (Integer nodeid : maxnodes) {
			ans[intervals.get(nodeid)]=1;
		}
		return ans;
	}
	public void setInterval(ArrayList<Integer> i){
		this.intervals = i;
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
