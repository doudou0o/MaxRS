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
		if (lft==rht) return;
		tree[ind].init(lft,rht);
		if (lft+1!=rht && lft!=rht) {
			int mid = tree[ind].mid();
			build(lft, mid, ind<<1);
			build(mid+1, rht, ind<<1|1);
		}
	}
	
	public void insertLine(line line) {
		openNode(IND,line);
	}
	private void openNode(int index, line line) {
		if ( !isValid(index) )
			return;
		if ( line.linex < tree[index].w_lft )
			openNode(index<<1, line);
		if ( line.liney > tree[index].w_rht )
			openNode((index<<1)+1, line);
		if ( line.linex <= tree[index].w_lft && line.liney >= tree[index].w_rht )
			if ( line.isButtom )
				tree[index].add_value(line.value);
			else
				tree[index].sub_value(line.value);
	}
	private boolean isValid(int index) {
		if ( index >= tree.length )
			return false;
		if ( tree[index].lft == 0 && tree[index].rht == 0 )
			return false;
		return true;
	}
}
