import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.util.ArrayList;

public class TreeProcessor {
    public ArrayList<String> treeType;
    public TreeProcessor(){treeType = new ArrayList<>();}
    public  float levenshtein(String str1,String str2) {

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dif = new int[len1 + 1][len2 + 1];

        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }

        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }

                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,
                        dif[i - 1][j] + 1);
            }
        }
        //System.out.println("块\""+str1+"\"与\""+str2+"\"的比较");
        System.out.println();
        System.out.println("dist："+dif[len1][len2]);

        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
        System.out.println("similiar："+similarity);
        return similarity;
    }

    //得到最小值
    private  int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
    public  void getParamName(CPP14Parser.TranslationunitContext tree,CPP14Parser parser){
        System.out.println(tree.declarationseq().declaration().functiondefinition().declarator().ptrdeclarator().noptrdeclarator().parametersandqualifiers().parameterdeclarationclause().parameterdeclarationlist().parameterdeclaration().declarator().ptrdeclarator().noptrdeclarator().declaratorid().idexpression().unqualifiedid().toStringTree(parser));

    }
    public  String getRuleName(ParseTree tree, CPP14Parser parser){
        //System.out.println("text:"+tree.getText());
      //  System.out.println("rule:"+tree.toStringTree(parser).split(" ")[0].replace("(",""));
        return  tree.toStringTree(parser).split(" ")[0].replace("(","");
    }
    public  void visitorTree(ParseTree tree,CPP14Parser parser){
        if(tree.getChildCount()>0){
            System.out.println(getRuleName(tree,parser));
            for(int i=0;i<tree.getChildCount();i++) {
                visitorTree(tree.getChild(i),parser);
            }
        }
        else{

            System.out.println(tree.getText());
        }
    }
    public  Tree convertTree(ParseTree tree,CPP14Parser parser,Tree myTree){
        if(tree.getChildCount()>0){
            for(int i=0;i<tree.getChildCount();i++) {
                String rule=getRuleName(tree.getChild(i),parser);
                if (rule.equals(""))  {
                    //System.out.println("rule = null");
                    rule="(";
                }
                //System.out.println(getRuleName(tree.getChild(i),parser));
                myTree.addNode(new Tree(rule));
                Tree t=myTree.getChild(i);
                convertTree(tree.getChild(i),parser,t);
            }
        }
        return  myTree;
    }
    public  String getReturn(Tree Call) {
        String ret =new String();
        if(!Call.isEmpty()) {
            if(Call.getRootData().equals("jumpstatement")&&Call.getChildCount()==3){//find call function,make it return value
                Tree t=new Tree();
                ret=t.getIdString(Call.getChild(1));
                //System.out.println("get return : "+ret);

                return ret;

            };
            for(Tree child : Call.getChilds()) {
                if(child != null) {
                    getReturn(child);
                }
            }
        }
        return ret;
    }
    public  Tree getChildWithRule(Tree Call,String rule,int ChildCount) {
        Tree ret=new Tree();
        //preOrder(Call);
        //System.out.println();
        if(Call.getRootData().equals(rule)&&Call.getChildCount()==ChildCount){//find call function,make it return value
            //System.out.println(rule);
            return Call;
        }
        else if(!Call.isEmpty()) {
            for(Tree child : Call.getChilds()) {
                if(child != null) {
                    Tree t=getChildWithRule(child,rule,ChildCount);
                    if(t.getRootData()!=null) ret=t;
                }
            }
        }
        // System.out.println(ret.getRootData());
        return ret;
    }

    public void replaceParam(Tree tree,ArrayList<String> ParamList,ArrayList<String> calledParamlist){
        if(!tree.isEmpty()) {
            for(int i=0;i<ParamList.size();i++){
                if(tree.getRootData().equals(ParamList.get(i))){
                    tree.setRootData(calledParamlist.get(i));

                }

            }
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    replaceParam(child,ParamList, calledParamlist);
                }
            }
        }
    }

    public void printTreeText(Tree tree){
        StringBuffer ss=new StringBuffer();
        getLeafText(tree,ss);
        System.out.println(ss);
    }

    public  int mergeFunc(Tree Call,ArrayList<String> funcNameList,ArrayList<Tree> returnTreeList,ArrayList<ArrayList<String>> ParamList,ArrayList<ArrayList<String>> calledParamList,
                           ArrayList<Tree> funcBodyList) {
        int flag=-1;
        if(!Call.isEmpty()) {
            //find call function,make it return value
            if(Call.getRootData().equals("postfixexpression")&&Call.getChildCount()==4&&Call.getChild(1).getRootData().equals("(")){

                Tree l=Call.getWantedChild(Call.getChild(0),"unqualifiedid");
                for(int i=0;i<funcNameList.size();i++){
                    String name=funcNameList.get(i);
                    String callname=l.getRootData().toString();
                    if(callname.equals(name)){
                        ArrayList<String> tempParam=getCalledParams(Call);

                        replaceParam(funcBodyList.get(i),ParamList.get(i),tempParam);
                        replaceParam(returnTreeList.get(i),ParamList.get(i),tempParam);

                        //System.out.println("replacing return in statement...");
                        Call.deleteChilds();
                        Call.addNode(returnTreeList.get(i).getChild(0));
                        StringBuffer sb=new StringBuffer();
                        this.getLeafText(Call,sb);
                        //System.out.println(sb.toString());

                        if(funcBodyList.get(i).getRootData()!=null) {
                            flag=i;
                            return flag;
                        }
                    }
                }

            };
            for(Tree child : Call.getChilds()) {
                if(child != null) {
                    if(child.getRootData().equals("statementseq")&&child.getChildCount()>0) {//find a statementseq
                        for(Tree t:child.getChilds()) {//find a call function statement in its childs
                            if(t.getRootData().equals("statement")) {//check every statement
                                StringBuffer sb = new StringBuffer();
                                this.getLeafText(t, sb);
                                //System.out.println(sb.toString());
                                int ind = mergeFunc(t, funcNameList, returnTreeList, ParamList, calledParamList, funcBodyList);
                                if (ind >= 0) {
                                    Tree save=t.getChild(t.getChildCount()-1);
                                    t.getChilds().remove(t.getChildCount()-1);
                                    //System.out.println("call func " + ind);
                                    Tree newseq=new Tree("statementseq");
                                    newseq.addNode(funcBodyList.get(ind));
                                    newseq.addNode(save);
                                    t.addNode(newseq);
                                    StringBuffer sbb = new StringBuffer();
                                    this.getLeafText(t, sbb);
                                    System.out.println("after merge:"+sbb.toString());
                                    ind=-1;
                                }
                            }
                        }
                    }

                    int t=mergeFunc(child, funcNameList, returnTreeList, ParamList, calledParamList, funcBodyList);
                    if(t>=0) flag=t;

                }
            }
        }
        return flag;
    }

    public  void mergeIfBlock(Tree Call) {
        if(!Call.isEmpty()) {
            for(Tree child : Call.getChilds()) {
                if(child != null) {
                    if(child.getRootData().equals("statementseq")&&child.getChildCount()>0) {//find a statementseq
                        for(Tree t:child.getChilds()) {//find a call function statement in its childs
                            if(t.getRootData().equals("statement")) {//check every statement
                                for(Tree tc:t.getChilds()) {
                                    if(tc.getRootData().equals("selectionstatement")) {
                                        StringBuffer sb = new StringBuffer();
                                        this.getLeafText(t, sb);
                                        //System.out.println(sb.toString());
                                        mergeIfBlock(tc);
                                        Tree save=t.getChild(t.getChildCount() - 1);
                                        t.getChilds().remove(t.getChildCount() - 1);
                                        //System.out.println("call func " + ind);
                                        Tree newseq=new Tree("statementseq");
                                        newseq.addNode(save);
                                        //this.printCode(newseq);
                                        t.addNode(newseq);
                                        StringBuffer sbb = new StringBuffer();
                                        this.getLeafText(t, sbb);
                                        System.out.println("after merge:" + sbb.toString() + "\n");
                                    }
                                }
                            }
                        }   
                    }
                }
                mergeIfBlock(child);
            }
        }
    }

    public  void mergeForBlock(Tree Call) {
        if(!Call.isEmpty()) {
            for(Tree child : Call.getChilds()) {
                if(child != null) {
                    if(child.getRootData().equals("statementseq")&&child.getChildCount()>0) {//find a statementseq
                        for(Tree t:child.getChilds()) {//find a call function statement in its childs
                            if(t.getRootData().equals("statement")) {//check every statement
                                for(Tree tc:t.getChilds()) {
                                    if(tc.getRootData().equals("iterationstatement")) {
                                        StringBuffer sb = new StringBuffer();
                                        this.getLeafText(t, sb);
                                        //System.out.println(sb.toString());
                                        mergeForBlock(tc);
                                        Tree save=t.getChild(t.getChildCount()-1);
                                        t.getChilds().remove(t.getChildCount()-1);
                                        //System.out.println("call func " + ind);
                                        Tree newseq=new Tree("statementseq");
                                        newseq.addNode(save);
                                        //this.printCode(newseq);
                                        t.addNode(newseq);
                                        StringBuffer sbb = new StringBuffer();
                                        this.getLeafText(t, sbb);
                                        System.out.println("after merge:" + sbb.toString() + "\n");
                                    }
                                }
                            }
                        }   
                    }
                }
                mergeForBlock(child);
            }
        }
    }
    
    public  void setType(Tree root) {
        if(!root.isEmpty()) {
            treeType.add(root.getRootData().toString());
            for(Tree child : root.getChilds()) {
                if(child != null) {
                    setType(child);
                }
            }
        }
    }


    public  void preOrder(Tree root) {
        if(!root.isEmpty()) {
            visit(root);
            for(Tree child : root.getChilds()) {
                if(child != null) {
                    preOrder(child);
                }
            }
        }
    }

    public  void postOrder(Tree root) {
        if(!root.isEmpty()) {
            for(Tree child : root.getChilds()) {
                if(child != null) {
                    postOrder(child);
                }
            }
            visit(root);
        }
    }

    public  void visit(Tree tree) {
        System.out.print("\t" + tree.getRootData());
    }
    public  void printCode(Tree root) {

        if(root.getChildCount()==0){System.out.print("\t" + root.getRootData());}
        if(root.getRootData().equals(";")||root.getRootData().equals("{")) System.out.println();
        if(!root.isEmpty()) {
            //visit(root);
            for(Tree child : root.getChilds()) {
                if(child != null) {
                    printCode(child);
                }
            }
        }

    }
    public  StringBuffer lessEncode(Tree tree,StringBuffer s) {

        if(!tree.isEmpty()) {
            //visit(root);
            for(int i=0;i<tree.getChildCount();i++) {
                Tree child=tree.getChild(i);
                if(child != null) {
                    s.append(i);

                    lessEncode(child,s);
                }
            }
            //System.out.println(s);
        }

        return s;
    }
    public StringBuffer getLeafText(Tree tree,StringBuffer sb){

        if(!tree.isEmpty()){
            if(tree.isLeaf()){
                if(tree.getRootData().equals("parameterdeclarationclause")) sb.append("");
                else sb.append(tree.getRootData()+" ");
            }
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    getLeafText(child,sb);
                }
            }
        }
        return sb;
    }
    public ArrayList<Tree> getCallFunc(Tree tree,ArrayList<Tree> funclist){

        Tree ret=new Tree();
        if(!tree.isEmpty()) {
            if(tree.getRootData().equals("postfixexpression")&&tree.getChildCount()==4){//find call function,make it return value
                StringBuffer sb=new StringBuffer();
                funclist.add(tree);
                getLeafText(tree,sb);
                System.out.println("call function statement:"+sb.toString());


            }
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    getCallFunc(child,funclist);


                }
            }
        }
        return funclist;
    }

    public ArrayList<String> getCalledParams(Tree tree){
        ArrayList<String> ret=new ArrayList<>();
        String[]  paramList;
        tree=tree.getChild(2);
        tree=tree.getChild(0);
        if(tree.getRootData().equals("initializerlist")&&tree.getChildCount()>0){//find call function,make it return value
            StringBuffer sb=new StringBuffer();
            getLeafText(tree,sb);
            System.out.println("call function param:"+sb.toString());
            paramList=sb.toString().split(",");
            for(String param:paramList){
                ret.add(param);
            }
        }
        //System.out.println(tree.getRootData());
        return ret;
    }
    public ArrayList<String> getCalledParamsFromStatement(Tree tree){
        ArrayList<String> ret=new ArrayList<>();
        String[]  paramList=new String[100];
        tree=tree.getChild(2);
        tree=tree.getChild(0);
        if(tree.getRootData().equals("initializerlist")&&tree.getChildCount()>0){//find call function,make it return value
            StringBuffer sb=new StringBuffer();
            getLeafText(tree,sb);
            System.out.println("call function param:"+sb.toString());
            paramList=sb.toString().split(",");
            for(String param:paramList){
                ret.add(param);
            }
        }
        //System.out.println(tree.getRootData());
        return ret;
    }

    public ArrayList<String> getFuncParams(Tree tree,ArrayList<String> ret){
        if(!tree.isEmpty()) {
            if (tree.getRootData().equals("parametersandqualifiers") && tree.getChildCount() ==3) {//find call function,make it return value
                StringBuffer sb = new StringBuffer();
                getLeafText(tree.getChild(1), sb);
                //System.out.println(sb.toString());
                String[] paramList = sb.toString().split(",");
                if(paramList.length>0)
                {
                    int c = 0;
                    for (String param : paramList)
                    {
                        String[] sp = param.split(" ");
                        if (c == 0) ret.add(sp[sp.length - 1]);
                        else ret.add(sp[sp.length - 1]);
                        c++;
                    }
                }

            }
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    getFuncParams(child,ret);
                }
            }
        }
        //System.out.println(tree.getRootData());
        return ret;
    }


    public ArrayList<Tree> getFunctionDefinition(Tree tree, ArrayList<Tree> tl){
        if(!tree.isEmpty()) {
            if(tree.getRootData().equals("functiondefinition")&&tree.getChildCount()==3){//find call function,make it return value
                tl.add(tree);
                System.out.println("add function");
                return tl;
            }
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    tl=getFunctionDefinition(child,tl);
                }
            }
        }
        return tl;
    }
    public  Tree getFuncStatementseq(Tree tree) {
        Tree ret=new Tree();
        if(tree.getRootData().equals("statementseq")&&tree.getChildCount()>=2){//find call function,make it return value
            StringBuffer sb=new StringBuffer();
            this.getLeafText(tree.getChild(0),sb);
            System.out.println("function body without return:"+sb.toString());
            return  tree.getChild(0);

        }
        else if(!tree.isEmpty()) {
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    Tree t=getFuncStatementseq(child);
                    if(t.getRootData()!=null) ret=t;
                }
            }
        }
        // System.out.println(ret.getRootData());
        return ret;
    }

    public void getFunctionName(Tree tree,StringBuffer sb){
        if(!tree.isEmpty()) {
            if(tree.getRootData().equals("noptrdeclarator")&&tree.getChildCount()==2){
                this.getLeafText(tree.getChild(0),sb);

            }
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    getFunctionName(child,sb);


                }
            }
        }
    }

    public Tree getReturnStatementTree(Tree tree){
        Tree ret=new Tree();
        if(!tree.isEmpty()) {
            if(tree.getRootData().equals("jumpstatement")&&tree.getChildCount()==3){
                ret.setRootData("postfixexpression");
                Tree temp=tree;
                ret.addNode(temp);
                ret.getChild(0).setRootData("primaryexpression");
                ret.getChild(0).getChild(0).setRootData("(");
                ret.getChild(0).getChild(2).setRootData(")");
                StringBuffer sb=new StringBuffer();
                this.getLeafText(ret,sb);
                System.out.println("return statement:"+sb.toString());
                return ret;

            }
            for(Tree child : tree.getChilds()) {
                if(child != null) {
                    Tree t=getReturnStatementTree(child);
                    if(t.getRootData()!=null) ret=t;

                }
            }
        }
        return ret;
    }

    public ArrayList<String> getFunctionEncode(ArrayList<Tree> tl){
        ArrayList<String> str_list=new ArrayList<>();

        for(int i=0;i<tl.size();i++) {
            System.out.println("encoding\tfunction "+i);
            StringBuffer sb = new StringBuffer();
            StringBuffer p = this.getLeafText(tl.get(i), sb);
            ANTLRInputStream input = new ANTLRInputStream(p.toString());
            CPP14Lexer lexer = new CPP14Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CPP14Parser parser = new CPP14Parser(tokens);
            CPP14Parser.TranslationunitContext tree = parser.translationunit();

            CPP14BaseVisitorBinary loader = new CPP14BaseVisitorBinary();
            loader.visit(tree);
            str_list.add(loader.encode_str);

        }
        return str_list;
    }

    public   String readFromTextFile(String pathname) throws IOException {
        String code="";
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        while(line != null) {
            code+=line+"\n";
            line = br.readLine();
        }
        return code;
    }

    public  Tree getTreeFromCpp(String loadPath) throws IOException {
        System.out.println("convert\t"+loadPath+"\tto tree...");
        String code=this.readFromTextFile(loadPath);

        ANTLRInputStream input = new ANTLRInputStream(code);
        CPP14Lexer lexer = new CPP14Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CPP14Parser parser = new CPP14Parser(tokens);
        CPP14Parser.TranslationunitContext tree = parser.translationunit();
        TreeProcessor tp=new TreeProcessor();
        tree.removeLastChild();
        //visitorTree(tree4,parser4);
        Tree myTree=new Tree(tp.getRuleName(tree,parser));
        Tree ret=tp.convertTree(tree,parser,myTree);
        return ret;
    }

    public ArrayList<String> getFuncEncodeList(String loadPath) throws IOException {
        Tree cppTree=new Tree();
        ArrayList<Tree> funcList=new ArrayList<>();
        cppTree=this.getTreeFromCpp(loadPath);
        this.preOrder(cppTree);
        this.getFunctionDefinition(cppTree,funcList);
        //tp.preOrder(funcList.get(0));
        for (Tree tree : funcList) {
            StringBuffer sb = new StringBuffer();
            StringBuffer p = this.getLeafText(tree, sb);
            System.out.println(p.toString());
        }

        ArrayList<String> encode_list=this.getFunctionEncode(funcList);


        return encode_list;
    }


    public ArrayList<ArrayList<String>> compareFuncList(String path1,ArrayList<String> list1,String path2,ArrayList<String> list2,double threshold) throws IOException {
        ArrayList<ArrayList<String>> result=new ArrayList<>();
        Tree cppTree1=new Tree();
        ArrayList<Tree> funcList1=new ArrayList<>();
        cppTree1=this.getTreeFromCpp(path1);
        this.getFunctionDefinition(cppTree1,funcList1);

        Tree cppTree2=new Tree();
        ArrayList<Tree> funcList2=new ArrayList<>();
        cppTree2=this.getTreeFromCpp(path2);
        this.getFunctionDefinition(cppTree2,funcList2);

        for(int i=0;i<list1.size();i++){
            StringBuffer sb1=new StringBuffer();
            String code1=this.getLeafText(funcList1.get(i),sb1).toString();
            ArrayList<String> row=new ArrayList<>();
            row.add(code1);

            for(int j=0;j<list2.size();j++){
                if(levenshtein(list1.get(i),list2.get(j))>threshold){
                    StringBuffer sb2=new StringBuffer();
                    String code2=this.getLeafText(funcList2.get(j),sb2).toString();
                    System.out.println("code similiar over threshode.");
                    System.out.println(code1);
                    System.out.println(code2);
                    System.out.println();
                    row.add(code2);

                }
            }
            result.add(row);
        }
        return result;
    }
}
