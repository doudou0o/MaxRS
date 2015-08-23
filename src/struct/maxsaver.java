package struct;

import java.util.ArrayList;

public class maxsaver {
	private ArrayList<slide> slides;
	private double value=-1;
	private double top;
	public void init(){
		if (slides != null)
			slides.clear();
		slides = new ArrayList<slide>();
	}
	public void update(ArrayList<node> maxnodes, double value, double h) {
		//TODO
	}
	public void getAns(){
		//TODO
	}

	class slide{
		private byte[] windowRecode;
		private double high;
		public void setWindowRecode(byte[] windowRecode) {
			//TODO
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
