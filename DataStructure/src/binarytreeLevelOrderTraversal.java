//level order traversal
//it uses iteration not recursion and uses queue for using FIFO
//this uses BFS design as it goes in breadth 
//BFS in tree is called level traversal
//Time complexity O(n)
import java.util.*;
class binaryTreeLevelOrderTraversal{
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
		
		levelOrder(root);
		

	}
	
	public static void levelOrder(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		//check if root is null
		if(root==null)
			return;
		
		//enter it in queue so we can traverse root 
		queue.add(root);
		queue.add(null);
		
		//run while loop till queue is empty
		while(!queue.isEmpty())
		{
			Node currentNode = queue.remove();
			if(currentNode==null){
				//check if queue is empty now 
				if(!queue.isEmpty()){
					//as queue is not empty so add null back to be used for next level 
					System.out.println(); // new line to show new level 
					queue.add(null);
				}
				else
					break;
				}
			else
			{
				System.out.print(currentNode.data+" ");
				if(currentNode.left!=null){
					queue.add(currentNode.left);
				}
				if(currentNode.right!=null){
					queue.add(currentNode.right);
				}
				
			}
		}
	}
	
}

