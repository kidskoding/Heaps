public class TreeMain {
    public static void main(String[] args) {
        TreeNode<String> cdrive = new TreeNode<String>("C Drive");

        TreeNode<String> programs = new TreeNode<String>("Programs", cdrive);
        TreeNode<String> users = new TreeNode<String>("C Drive", cdrive);
        TreeNode<String> windows = new TreeNode<String>("C Drive", cdrive);

        TreeNode<String> bluej = new TreeNode<String>("Programs", programs);
        TreeNode<String> greenfoot = new TreeNode<String>("C Drive", programs);
        TreeNode<String> monroe = new TreeNode<String>("C Drive", users);
        TreeNode<String> fonts = new TreeNode<String>("Fonts", windows);
        TreeNode<String> system32 = new TreeNode<String>("System32", windows);

        System.out.println("Breadth First Search Tree " + TreeNode.breadthFirstSearch(cdrive));
        System.out.println("Pre Order: " + TreeNode.preOrder(cdrive));
        System.out.print("In Order: ");
        TreeNode.inOrder(cdrive);
        System.out.println();

        //System.out.println("Post Order: " + TreeNode.postOrder(cdrive));
        //System.out.println("In Order: " + TreeNode.inOrder(cdrive));
    }
}
