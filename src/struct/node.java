package struct;

public class node {
	int lft,rht;
	int w_lft,w_rht;
	boolean flag;
	double value;
	node(){
	}
	void init(int lft,int rht){
		this.lft = lft;
		this.rht = rht;
		this.w_lft = (lft+rht)>>1;
		this.w_rht = w_lft+1;
		if((rht - lft)<=2)
			flag=false;
		else
			flag=true;
		value = 0;
	}
	public int mid() {
		return lft+((rht-lft)>>1);
	}
	void add_value(double v){
		value += v;
	}
	void sub_value(double v){
		value -= v;
		if (value<0) System.err.println("value is err , it cant < 0");
	}
}
