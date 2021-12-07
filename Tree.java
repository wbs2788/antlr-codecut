import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    private Object data;
    private ArrayList<Tree> childs;

    public Tree(){
        data = null;
        childs = new ArrayList();
        childs.clear();
    }

    public Tree(Object data) {
        this.data = data;
        childs = new ArrayList();
        childs.clear();
    }


    public void addNode(Tree tree) {
        childs.add(tree);
    }
    public void addNodeToHead(Tree tree) {
        childs.add(0,tree);
    }


    public void clearTree() {
        data = null;
        childs.clear();
    }
    public void deleteChilds() {

        childs.clear();
    }


    public int dept() {
        return dept(this);
    }

    private int dept(Tree tree) {
        if(tree.isEmpty()) {
            return 0;
        }else if(tree.isLeaf()) {
            return 1;
        } else {
            int n = childs.size();
            int[] a = new int[n];
            for(int i=0; i<n; i++) {
                if(childs.get(i).isEmpty()) {
                    a[i] = 0+1;
                } else {
                    a[i] = dept(childs.get(i)) + 1;
                }
            }
            Arrays.sort(a);
            return a[n-1];
        }
    }

    public Tree getChild(int i) {
        return childs.get(i);
    }

    public void setChild(int i, Tree child) {
        childs.set(i, child);
    }


    public Tree getFirstChild() {
        return childs.get(0);

    }
    public String getIdString(Tree tree) {
        String ret=new String();
        if(tree.getRootData().equals("unqualifiedid")){
            return tree.getChild(0).getRootData().toString();
        }
        else if(!tree.isEmpty()) {
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    ret=getIdString(child);
                }
            }
        }
        return ret;


    }
    public Tree getWantedChild(Tree tree,String rule) {
        Tree ret=new Tree();
        if(tree.getRootData().equals(rule)){
            return tree.getChild(0);
        }
        else if(!tree.isEmpty()) {
                for(Tree child : tree.getChilds()) {
                    if(child != null) {
                        ret=getWantedChild(child,rule);
                    }
                }
        }
        return ret;
    }





    public Tree getLastChild() {
        return childs.get(childs.size()-1);
    }
    public int getChildCount() {
        return childs.size();
    }
    public List<Tree> getChilds() {
        return childs;
    }


    public Object getRootData() {
        return data;
    }


    public boolean isEmpty() {
        if(childs.isEmpty() && data == null)
            return true;
        return false;
    }


    public boolean isLeaf() {
        if(childs.isEmpty())
            return true;
        return false;
    }


    public Tree root() {
        return this;
    }


    public void setRootData(Object data) {
        this.data = data;
    }


    public int size() {
        return size(this);
    }

    private int size(Tree tree) {
        if(tree.isEmpty()) {
            return 0;
        }else if(tree.isLeaf()) {
            return 1;
        } else {
            int count = 1;
            int n = childs.size();
            for(int i=0; i<n; i++) {
                if(!childs.get(i).isEmpty()) {
                    count += size(childs.get(i));
                }
            }
            return count;
        }
    }

    public static void preOrder(Tree root) {
        if(!root.isEmpty()) {
            visit(root);
            for(Tree child : root.getChilds()) {
                if(child != null) {
                    preOrder(child);
                }
            }
        }
    }

        public static void printCode(Tree root) {
            if(root.getChildCount()==0){System.out.print("\t" + root.getRootData());}
            if(!root.isEmpty()) {
                //visit(root);
                for(Tree child : root.getChilds()) {
                    if(child != null) {
                        printCode(child);
                    }
                }
            }
        }

        public static void postOrder(Tree root) {
            if(!root.isEmpty()) {
                for(Tree child : root.getChilds()) {
                    if(child != null) {
                        postOrder(child);
                    }
                }
                visit(root);
            }
        }

        public static void visit(Tree tree) {
            System.out.print("\t" + tree.getRootData());
        }

    public static void main(String[] args) {
        Tree root = new Tree("A");
        root.addNode(new Tree("B"));
        root.addNode(new Tree("C"));
        root.addNode(new Tree("D"));
        Tree t = null;
        t = root.getChild(0);
        t.addNode(new Tree("L"));
        t.addNode(new Tree("E"));
        t = root.getChild(1);
        t.addNode(new Tree("F"));
        t = root.getChild(2);
        t.addNode(new Tree("I"));
        t.addNode(new Tree("H"));
        t = t.getFirstChild();
        t.addNode(new Tree("L"));

        System.out.println("first node:" + root.getRootData());
        //System.out.println("size:" + root.size());
        //System.out.println("dept:" + root.dept());
        System.out.println("is left:" + root.isLeaf());
        System.out.println("data:" + root.getRootData());



        preOrder(root);

        postOrder(root);

    }

}

