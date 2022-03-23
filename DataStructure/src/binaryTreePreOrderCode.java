//create tree using preorder 
//Time complexity of preorder traversal = O(n)
//pre order as root comes first than left and than right
public class binaryTreePreOrderCode{
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
	
	public static void main(String[] args){
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		//Binarytree binaryTree = new Binarytree();
		Node root=Binarytree.buildTree(nodes);
		System.out.println(root.data);
		preOrderTraversal(root);
	}
	
	//print traversal of above tree
	public static void preOrderTraversal(Node binaryTree){
		if(binaryTree==null){
		System.out.print(-1+" ");	
		return ;
		}
		System.out.print(binaryTree.data+" ");
		preOrderTraversal(binaryTree.left);
		preOrderTraversal(binaryTree.right);
	}
}