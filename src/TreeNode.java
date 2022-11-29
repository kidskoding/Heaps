import java.util.*;
public class TreeNode<T> {
    private T data;
    private TreeNode<T> parent;
    private Set<TreeNode<T>> children;
    public TreeNode(T data) {
        this.data = data;
        this.parent = null;
        this.children = new LinkedHashSet<TreeNode<T>>();
    }
    public TreeNode(T data, TreeNode<T> parent) {
        this.data = data;
        this.parent = parent;
        this.children = new LinkedHashSet<TreeNode<T>>();
        parent.addChild(this);
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public TreeNode<T> getParent() { return parent; }
    public void setParent(TreeNode<T> parent) { this.parent = parent; }
    public Set<TreeNode<T>> getChildren() { return children; }

    public void addChild(TreeNode<T> child) {
        children.add(child);
        child.setParent(this);
    }
    public void removeChild(TreeNode<T> child) {
        children.remove(child);
        child.setParent(null);
    }

    public static <T> Set<TreeNode<T>> breadthFirstSearch(TreeNode<T> start) {
        Set<TreeNode<T>> visited = new LinkedHashSet<TreeNode<T>>();
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()) {
            TreeNode<T> node = queue.remove();
            for(TreeNode<T> n : node.getChildren()) {
                visited.add(n);
                queue.add(n);
            }
        }
        return visited;
    }

    public static <T> Set<TreeNode<T>> preOrder(TreeNode<T> start) {
        Set<TreeNode<T>> visited = new LinkedHashSet<TreeNode<T>>();
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        stack.push(start);
        while(!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            visited.add(node);
            List<TreeNode<T>> list = new ArrayList<TreeNode<T>>(node.getChildren());
            for(int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return visited;
    }

    public static <T> void inOrder(TreeNode<T> start) {
        List<TreeNode<T>> list = new ArrayList<TreeNode<T>>(start.getChildren());
        if(list.size() >= 1) {
            inOrder(list.get(0));
        }
        System.out.print(start.getData() + " ");
        if(start.getChildren().size() == 2) {
            inOrder(list.get(1));
        }
    }
    public static <T> void inOrderHelper(TreeNode<T> node, Set<TreeNode<T>> visited) {
        List<TreeNode<T>> list = new ArrayList<TreeNode<T>>(node.getChildren());
        if(list.size() >= 1) {
            inOrder(list.get(0));
        }
        if(list.size() == 2) {
            inOrder(list.get(1));
        }
    }
    public static <T> Set<TreeNode<T>> postOrder(TreeNode<T> start) {
        Set<TreeNode<T>> visited = new LinkedHashSet<TreeNode<T>>();
        Stack<TreeNode<T>> dq = new Stack<TreeNode<T>>();
        dq.add(start);
        while(!dq.isEmpty()) {
            TreeNode<T> node = dq.pop();
            if(node.isLeafNode()) {
                TreeNode<T> n = dq.pop();
                visited.add(n);
            }
            else {

            }
        }
        return visited;
    }
    public static <T> void postOrderHelper(TreeNode<T> node, Set<TreeNode<T>> visited) {
        List<TreeNode<T>> list = new ArrayList<TreeNode<T>>(node.getChildren());
        for(TreeNode<T> n : list) {
            postOrderHelper(n, visited);
        }
        visited.add(node);
    }

    public boolean isRootNode() { return parent == null; }
    public boolean isLeafNode() { return children.size() == 0; }
    public String toString() { return data.toString() + children; }
}
