package struct;

public class line implements Comparable<line>{
		double high;
		double linex;
		double liney;
		boolean isButtom;
		public line() {
		}
		public line(double x, double y,double h) {
			linex = x;
			liney = y;
			high = h;
		}
		public void setFlag(boolean f) {
			isButtom = f;
		}
		
		@Override
		public int compareTo(line o) {
			if (o.high < this.high) 
				return 1;
			else if (o.high > this.high) 
				return -1;
			else 
				return 0;
		}
}