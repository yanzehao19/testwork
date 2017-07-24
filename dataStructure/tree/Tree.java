package tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	private int id;

	private String name;

	private int parentId;

	private List<Tree> childrens;

	public Tree(int id, String name, int parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<Tree> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Tree> childrens) {
		this.childrens = childrens;
	}

	public static void main(String[] args) {
		Tree tree1 = new Tree(1, "顶层节点1", 0);
		Tree tree2 = new Tree(2, "顶层节点2", 0);
		Tree tree3 = new Tree(3, "顶层节点3", 0);

		Tree tree4 = new Tree(4, "二级节点4", 1);
		Tree tree5 = new Tree(5, "二级节点5", 2);
		Tree tree6 = new Tree(6, "二级节点6", 3);

		Tree tree7 = new Tree(7, "三级节点7", 4);
		Tree tree8 = new Tree(8, "三级节点8", 4);
		Tree tree9 = new Tree(9, "三级节点9", 5);

		List<Tree> trees = new ArrayList<Tree>();
		trees.add(tree1);
		trees.add(tree2);
		trees.add(tree3);
		trees.add(tree4);
		trees.add(tree5);
		trees.add(tree6);
		trees.add(tree7);
		trees.add(tree8);
		trees.add(tree9);

		List<Tree> rootTrees = new ArrayList<Tree>();
		for (Tree tree : trees) {
			if (tree.getParentId() == 0) {
				rootTrees.add(tree);
			}
			for (Tree t : trees) {
				if (t.getParentId() == tree.getId()) {
					if (tree.getChildrens() == null) {
						List<Tree> myChildrens = new ArrayList<Tree>();
						myChildrens.add(t);
						tree.setChildrens(myChildrens);
					} else {
						tree.getChildrens().add(t);
					}
				}
			}
		}

		for (Tree tree : rootTrees) {
			System.out.println(tree.toString());
		}

	}

}
