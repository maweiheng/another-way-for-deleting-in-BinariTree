package BinaryTree;
class Node{
	long element;
	Node left;
	Node right;
	public Node(long element){
		this.element=element;
		this.left=null;
		this.right=null;
	}
}
public class BinaryTree {
	private Node root;
	public BinaryTree(){
		root=null;
	}
	public void insert(long num){
		Node a=new Node(num);
		if(root==null)	root=a;
		else{
			Node temp=root;
			Node parent;
			while(true){
				parent=temp;
				if(a.element<temp.element){
					temp=temp.left;
					if(temp==null){
						parent.left=a;
						return;
					}
				}
				else{
					temp=temp.right;
					if(temp==null){
						parent.right=a;
						return;
					}
				}
			}
		}
	}
	public Node find(long e){
		Node temp=root;
		while(temp!=null){
			if(temp.element==e) return temp;
			if(e<temp.element)	temp=temp.left;
			if(e>temp.element)	temp=temp.right;
		}
		return null;
	}
	public Node anofind(long e){
		Node temp=root;
		if(root==null) return null;
		while(temp.element!=e){
			if(e<temp.element)	temp=temp.left;
			if(e>temp.element)	temp=temp.right;
			if(temp==null) return null;
		}
		return temp;
	}
	public void inOrder(Node n){
		if(n!=null){
			inOrder(n.left);
			System.out.println(n.element);
			inOrder(n.right);
		}
	}
	public void beforeOrder(Node n){
		if(n!=null){
			System.out.println(n.element);
			inOrder(n.left);
			inOrder(n.right);
		}
	}
	public void delete(long e){
		Node temp=root;
		if(root==null) throw new RuntimeException("BinaryTree is empty!");
		Node parent=root;
		boolean isleft=true;
		while(temp.element!=e){
			parent=temp;
			if(e<temp.element){
				temp=temp.left;
				isleft=true;
			}
			if(e>temp.element){
				temp=temp.right;
				isleft=false;
			}
			if(temp==null)	throw new RuntimeException("No match elements");
		}
		if(temp.left==null&&temp.right==null){
			if(temp==root) root=null;
			if(isleft){
				parent.left=null;
			}
			else parent.right=null;
		}
		if(temp.left==null){
			if(temp==root)	root=temp.right;
			if(isleft)	parent.left=temp.right;
			else	parent.right=temp.right;
		}
		if(temp.right==null){
			if(temp==root)	root=temp.left;
			if(isleft)	parent.left=temp.left;
			else	parent.right=temp.left;
		}
		else{
			Node parent1=temp;
			if(temp==root){
				temp=temp.right;
				while(temp.left!=null){
					temp=temp.left;
				}
				temp.left=root.left;
			}
			else{
				if(isleft){
					temp=parent1.right;
					while(temp!=null){
						parent1=temp;
						temp=temp.left;
					}
					parent1.left=parent.left.left;
					parent.left=parent.left.right;
				}
			}
		}
	}
	public static void main(String[] args) {
		BinaryTree t=new BinaryTree();// TODO Auto-generated method stub
		t.insert(5);
		t.insert(3);
		t.insert(2);
		t.insert(4);
		t.insert(1);
		t.insert(6);
		t.insert(7);
		t.insert(10);
		t.insert(8);
		t.insert(9);
		System.out.println(" "+t.find(4).left+" "+" "+t.anofind(4).right);
		t.inOrder(t.root);
		t.beforeOrder(t.root);
		t.delete(4);
		System.out.println(t.find(4)+" "+t.find(3).left+" "+t.find(3).right+" "+t.find(2));
	}
}
