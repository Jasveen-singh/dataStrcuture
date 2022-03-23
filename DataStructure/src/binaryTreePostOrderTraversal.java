//PostOrder trversal
//left sub tree, right subtree and root is called post order 
//DFS design as it goes in depth on left before going to right 
class binarytreePostOrderTraversal{
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
		
		postOrder(root);
		System.out.println();
		//calculate height of tree 
		System.out.print(height(root));
		
	}
	
	public static void postOrder(Node root){
		if(root==null){
			System.out.print(-1+" ");
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
}