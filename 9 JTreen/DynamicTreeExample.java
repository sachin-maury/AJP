import javax.swing.*; 
import javax.swing.tree.DefaultMutableTreeNode; 
  
public class DynamicTreeExample { 
    public static void main(String[] args) 
    { 
       
        JFrame frame = new JFrame( 
            "GeeksforGeeks - Java JTree Example"); 
  
         
        DefaultMutableTreeNode root 
            = new DefaultMutableTreeNode("Root"); 
  
        
        DefaultMutableTreeNode parent1 
            = new DefaultMutableTreeNode("Parent 1"); 
        DefaultMutableTreeNode child1_1 
            = new DefaultMutableTreeNode("Child 1.1"); 
        DefaultMutableTreeNode child1_2 
            = new DefaultMutableTreeNode("Child 1.2"); 
  
        
        parent1.add(child1_1); 
        parent1.add(child1_2); 
  
        
        DefaultMutableTreeNode parent2 
            = new DefaultMutableTreeNode("Parent 2"); 
        DefaultMutableTreeNode child2_1 
            = new DefaultMutableTreeNode("Child 2.1"); 
        DefaultMutableTreeNode child2_2 
            = new DefaultMutableTreeNode("Child 2.2"); 
  
        
        parent2.add(child2_1); 
        parent2.add(child2_2); 
  
      
        root.add(parent1); 
        root.add(parent2); 
  
        
        JTree tree = new JTree(root); 
  
        
        frame.add(new JScrollPane(tree)); 
  
         
        frame.setSize(400, 400); 
        frame.setDefaultCloseOperation( 
            JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true); 
    } 
}
