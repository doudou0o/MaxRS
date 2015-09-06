package struct;
import java.util.ArrayList;
import java.util.HashSet;

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
		tree[ind].subMaxList.add(ind);//init maxlist
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
		//forward pass
		if ( line.linex < tree[index].w_lft )
			openNode(index<<1, line);
		if ( line.liney > tree[index].w_rht )
			openNode((index<<1)+1, line);
		if ( line.linex <= tree[index].w_lft && line.liney >= tree[index].w_rht )
			if ( line.isButtom )
				tree[index].add_value(line.value);
			else
				tree[index].sub_value(line.value);

		//backward pass
		// 当前节点的权值，与左孩子右孩子的最大子权值比较
		// 返回一个最大list ，以及一个最大权值
		HashSet<Integer> maxlist = new HashSet<Integer>();
		double maxvalue=getMaxList(index,index<<1,(index<<1)+1,maxlist);
		tree[index].subMaxValue = maxvalue;
		tree[index].subMaxList = maxlist;
	}
	private double getMaxList(int root, int leftchild, int rightchild, HashSet<Integer> maxlist) {
		if ( !tree[root].flag ){
			maxlist.addAll(tree[root].subMaxList);
			return tree[root].value;
		}
		double rootvalue = tree[root].value;
		double leftchildvalue = leftchild<tree.length ? tree[leftchild].subMaxValue : -1;
		double rightchildvalue = rightchild<tree.length ? tree[rightchild].subMaxValue : -1;

		double maxvalue = Math.max( Math.max(leftchildvalue, rightchildvalue) , rootvalue);
		if (rootvalue == maxvalue )
			maxlist.add(root);
		if (leftchildvalue == maxvalue ){
			if (tree[leftchild].subMaxList!=null)
				maxlist.addAll(tree[leftchild].subMaxList);
		}
		if (rightchildvalue == maxvalue ){
			if (tree[rightchild].subMaxList!=null)
				maxlist.addAll(tree[rightchild].subMaxList);
		}
		return maxvalue;
	}
	private boolean isValid(int index) {
		if ( index >= tree.length )
			return false;
		if ( tree[index].lft == 0 && tree[index].rht == 0 )
			return false;
		return true;
	}
}
