//Diameter in a TREE
//Number of nodes in the Longest between two nodes

//Case 1: Via Root 
//Case 2 : not Via root

//calculate height at each node and take sum 

class binarytreeDiameter{
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	static class Binarytree{
		static int idx=-1;
		public static Node buildTree(int nodes[]){
			idx++;
			
			if(nodes[idx]==-1)
				return null;

			Node nodeNew = new Node(nodes[idx]);
			nodeNew.left=buildTree(nodes);
			nodeNew.right=buildTree(nodes);
			return nodeNew;
		}
	}
	
	public static int height(Node root){
		if(root==null)
		{
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return Math.max(leftHeight,rightHeight) +1;
	}
	
	public static void main(String[] args){
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		//Binarytree binaryTree = new Binarytree();
		Node root=Binarytree.buildTree(nodes);
		System.out.println(root.data);
		
		//postOrder(root);
		System.out.println();
		//calculate height of tree 
		System.out.println(height(root));
		System.out.println(diameter(root));
		
		System.out.println(diameter2(root).diameter);
		
	}
	//o(n^2)
	public static int diameter(Node root){
		if(root == null)
			return 0;
		
		int diameter1= diameter(root.left);
		int diameter2= diameter(root.right);
		int diameter3= height(root.left) + height(root.right) +1;
		
		return Math.max(diameter3,Math.max(diameter1,diameter2));
	}
	
	//o(n) calculate diameter and height together to avoid two traversals
	static class TreeInfo{
		int ht;
		int diameter;
		
		TreeInfo(int ht, int diameter){
			this.ht=ht;
			this.diameter=diameter;
		}
	}
	
	public static TreeInfo diameter2(Node node){
		
		if(node==null)
			return new TreeInfo(0,0);
		
		TreeInfo left = diameter2(node.left);
		TreeInfo right = diameter2(node.right);
		
		int myHeight = Math.max(left.ht, right.ht) +1;
		
		
		int diam = left.diameter;
		int diam2 = right.diameter;
		int diam3= left.ht + right.ht +1;
		
		int myDiam = Math.max(Math.max(diam,diam2),diam3);
		
		TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
		return myInfo;
		
	}
}