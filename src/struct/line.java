package struct;

public class line implements Comparable<line>{
		double high;
		int linex;
		int liney;
		boolean isButtom;
		public line() {
		}
		public line(int x, int y,double h) {
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