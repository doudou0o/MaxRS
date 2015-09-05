# MaxRS 实现

数据结构
intervalTree.java
  ![image](https://github.com/doudou0o/MaxRS/blob/master/info/Tree.png)
  实现 build 用来构造树，树的结构如上图
  实现 insertline 用来将 线段加入 使树对这根线段 做出反应
      其中包括每个节点权值的更新
      其中包括每个节点最大子节点列表更新

node.java
  如上图，主要有左右窗口，和最大子节点列表
  value指当前节点权值
  flag指是否是叶子节点（暂时没有用到）
  
maxsaver.java
  主要保存 最大权值的各个时段的切片， ArrayList<slide> slides
  slide类 中保存一个切片和其高度，由一串二进制表示一个段（例如，0011100）
  ArrayList<Integer> intervals 主要是用来指示每个nodeid 对应的切片的位置
  value指此时最大权值
  top为 max 状态的终止 上线
  实现 update 用来对每次 insert 过后产生的根节点的 max序列进行处理*
  （稍后作图）



  
