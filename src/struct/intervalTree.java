package struct;
import java.util.ArrayList;

public class intervalTree {
	private final int N = 50;
	private final int IND = 1;
	private node[] tree;
	private ArrayList<Double> X;
	public intervalTree(){
		tree = new node[N];
		for (int i = 0; i < N; i++)
			tree[i] = new node();
	}
	public void setX(ArrayList<Double> list) {
		X=list;
	}
	public void build(int lft,int rht) {
		build(lft,rht,IND);
	}
	private void build(int lft,int rht,int ind) {
		if (X==null){
			System.err.println("X is not init first");
			return;
		}
		tree[ind].init(lft,rht);
		if (lft+1!=rht && lft!=rht) {
			int mid = tree[ind].mid();
			build(lft, mid, ind<<1);
			build(mid+1, rht, ind<<1|1);
		}
	}
}
