//Main.java

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

import java.util.ArrayList;

public class Demo2 {
    public static double similarity(ArrayList va, ArrayList vb) {
        if (va.size() > vb.size()) {
            int temp = va.size() - vb.size();
            for (int i = 0; i < temp; i++) {
                vb.add(0);
            }
        } else if (va.size() < vb.size()) {
            int temp = vb.size() - va.size();
            for (int i = 0; i < temp; i++) {
                va.add(0);
            }
        }

        int size = va.size();
        double simVal = 0;


        double num = 0;
        double den = 1;
        double powa_sum = 0;
        double powb_sum = 0;
        for (int i = 0; i < size; i++) {
            double a = Double.parseDouble(va.get(i).toString());
            double b = Double.parseDouble(vb.get(i).toString());

            num = num + a * b;
            powa_sum = powa_sum + (double) Math.pow(a, 2);
            powb_sum = powb_sum + (double) Math.pow(b, 2);
        }
        double sqrta = (double) Math.sqrt(powa_sum);
        double sqrtb = (double) Math.sqrt(powb_sum);
        den = sqrta * sqrtb;

        simVal = num / den;

        return simVal;
    }


    /*public static void levenshtein(String str1,String str2) {

        int len1 = str1.length();
        int len2 = str2.length();
        System.out.println(len1);
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

        System.out.println("dist："+dif[len1][len2]);

        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
        System.out.println("similiar："+similarity+"\n");
    }
 */
    public static void levenshtein(String str1,String str2) {

        int len1 = str1.length();
        int len2 = str2.length();
        //System.out.println(len1);
        int[] dif = new int[len2 + 1];

        for (int a = 0; a <= len2; a++) {
            dif[a] = a;
        }

        int temp1, temp2;
        for (int i = 1; i <= len1; i++) {
            temp1 = dif[0] ++ ;
            for (int j = 1; j <= len2; j++) {
                temp2 = dif[j];
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dif[j] = temp1;
                } else {
                    dif[j] = min(temp1, min(dif[j - 1], dif[j])) + 1;
                }
                temp1 = temp2;
            }
        }
        //System.out.println("块\""+str1+"\"与\""+str2+"\"的比较");

        System.out.println("dist："+dif[len2]);

        float similarity =1 - (float) dif[len2] / Math.max(str1.length(), str2.length());
        System.out.println("similiar："+similarity+"\n");
    }


    //得到最小值
    private static int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public static  String readFromTextFile(String pathname) throws IOException{
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

    public static void saveAsFileWriter(String content , String filePath) {
        FileWriter fwriter = null;
        try {
            // true is append,false is cover
            fwriter = new FileWriter(filePath, false);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void convertCppToAst(String loadPath,String savePath) throws IOException {
        System.out.println("convert\t"+loadPath+"\tto\t"+savePath);
        String code=readFromTextFile(loadPath);

        ANTLRInputStream input = new ANTLRInputStream(code);
        CPP14Lexer lexer = new CPP14Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CPP14Parser parser = new CPP14Parser(tokens);
        CPP14Parser.TranslationunitContext tree = parser.translationunit();

        CPP14BaseVisitorBinary loader = new CPP14BaseVisitorBinary();
        //CPP14BaseVisitor loader = new CPP14BaseVisitor();
        loader.visit(tree);
        System.out.println("encode_string:"+loader.encode_str);
        saveAsFileWriter(loader.encode_str,savePath);
    }



    public  static String getCppName(String path)
    {
        String[] sp ;
        sp=path.split("\\\\");
        String cpp=sp[sp.length-1];
        return cpp.split("\\.")[0];
    }

    public static void makeGitAst(String path) throws IOException {
        File file = new File(path);
        File[] fs = file.listFiles();
        for(File f:fs)
        {
            System.out.println("——"+f);
            if(f.isDirectory())
            {

                File src=new File(f.toString()+"\\src");
                File[] srcs = src.listFiles();
                for(File s:srcs)
                {
                    System.out.println("—— ——"+s);
                    System.out.println("Convert Cpp to Ast");

                    convertCppToAst(s.toString(),f.toString()+"\\src\\"+getCppName(s.toString())+"_ast.txt");
                }
            }
        }
    }
    public static void makeAst(String path) throws IOException {
        File file = new File(path);
        File[] fs = file.listFiles();
        for(File f:fs)
        {
            System.out.println("——"+f);
            System.out.println("Convert Cpp to Ast");
            convertCppToAst(f.toString(),path+"\\"+getCppName(f.toString())+"_ast.txt");

        }
    }

    public static Tree MergeCppFuncs(String loadPath) throws IOException {
        TreeProcessor tp=new TreeProcessor();
        String code=readFromTextFile(loadPath);

        ANTLRInputStream input = new ANTLRInputStream(code);
        CPP14Lexer lexer = new CPP14Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CPP14Parser parser = new CPP14Parser(tokens);
        CPP14Parser.TranslationunitContext tree = parser.translationunit();

        tree.removeLastChild();
        System.out.println(tree.getText());
        //visitorTree(tree4,parser4);
        Tree myTree=new Tree(tp.getRuleName(tree,parser));
        tp.convertTree(tree,parser,myTree);

        ArrayList<Tree> funclist=new ArrayList<>();
        tp.getFunctionDefinition(myTree,funclist);


        ArrayList<String> funcNameList=new ArrayList<>();
        for(Tree Func:funclist){
            StringBuffer sb=new StringBuffer();
            tp.getFunctionName(Func,sb);
            System.out.println("function name:"+sb.toString().strip());
            funcNameList.add(sb.toString().strip());
        }
        /*get param from every  function,make it a matrix*/
        ArrayList<ArrayList<String>> ParamList=new ArrayList<>();
        for(Tree Func:funclist){
            System.out.print("function params:");
            ArrayList<String> param=new ArrayList<>();
            tp.getFuncParams(Func,param);
            for(String p:param) System.out.print(p+"  ");
            System.out.println();
            ParamList.add(param);
        }

        /*get function statementseq Tree*/
        ArrayList<Tree> funcBodyList=new ArrayList<>();
        for(Tree Func:funclist){
            funcBodyList.add(tp.getFuncStatementseq(Func));
        }
        for(Tree Func:funcBodyList){
            System.out.println(Func.getRootData());
        }

        /*get return statement ,change return to (***) <tree>*/
        ArrayList<Tree> returnTreeList=new ArrayList<>();
        for(Tree Func:funclist){
            Tree ret=tp.getReturnStatementTree(Func);
            returnTreeList.add(ret);
        }




        /*get call function statement in a code*/
        ArrayList<Tree> CallFuncList=new ArrayList<>();
        tp.getCallFunc(myTree,CallFuncList);

        /*get param from every called function,make it a matrix*/
        ArrayList<ArrayList<String>> calledParamList=new ArrayList<>();
        for(Tree callFunc:CallFuncList){
            ArrayList<String> param=tp.getCalledParams(callFunc);
            calledParamList.add(param);
        }

        tp.mergeFunc(myTree,funcNameList,returnTreeList,ParamList,calledParamList,funcBodyList);

        //System.out.println("printing code...");
        //tp.printCode(myTree);
        //System.out.println("\nprinting code over.");

        return myTree;

    }

    public static  void compare() throws IOException {
        TreeProcessor tp=new TreeProcessor();
        String path1="S:\\mymymy\\crowl_test\\fetch_code\\1.cpp";
        String path2="S:\\mymymy\\crowl_test\\fetch_code\\2.cpp";

        //
        Tree tree1;
        tree1=MergeCppFuncs(path1);
        Tree tree2;
        tree2=MergeCppFuncs(path2);

        StringBuffer s1=new StringBuffer();
        StringBuffer lessEncode1=tp.lessEncode(tree1,s1);
        StringBuffer s2=new StringBuffer();
        StringBuffer lessEncode2=tp.lessEncode(tree2,s2);


        System.out.println("compare file:\t"+path1+"\tand\t"+path2);
        System.out.println(lessEncode1.toString());
        levenshtein(lessEncode1.toString(),lessEncode2.toString());
    }

    public static void modifyInterface(Tree myTree,ArrayList<String> rep)
    {
        TreeProcessor tp=new TreeProcessor();
        //get all declared function
        ArrayList<Tree> funclist=new ArrayList<>();
        tp.getFunctionDefinition(myTree,funclist);

        //get function names
        ArrayList<String> funcNameList=new ArrayList<>();
        for(Tree Func:funclist){
            StringBuffer sb=new StringBuffer();
            tp.getFunctionName(Func,sb);
            funcNameList.add(sb.toString().strip());
        }
        //get param from every  function,make it a matrix
        ArrayList<ArrayList<String>> ParamList=new ArrayList<>();
        for(Tree Func:funclist){
            System.out.print("function params:");
            ArrayList<String> param=new ArrayList<>();
            tp.getFuncParams(Func,param);
            for(String p:param) System.out.print(p+"  ");
            System.out.println();
            ParamList.add(param);
        }

        //get function statementseq Tree
        ArrayList<Tree> funcBodyList=new ArrayList<>();
        for(Tree Func:funclist){
            funcBodyList.add(tp.getFuncStatementseq(Func));
        }
        for(Tree Func:funcBodyList){
            System.out.println(Func.getRootData());
        }

        System.out.println();
        System.out.println("origin");
        tp.printCode(funclist.get(0));
        tp.replaceParam(funclist.get(0),ParamList.get(0),rep);
        System.out.println();
        System.out.println("after modify");
        tp.printCode(funclist.get(0));
    }

    public static Tree Copy(Tree tree){
        if(tree.isEmpty()) return  null;
        Tree ans = new Tree(tree.getRootData());
        for(int i =0; i< tree.getChildCount(); ++i){
            Tree child = Copy(tree.getChild(i));
            ans.addNode(child);
        }
        return ans;
    }

    public static Tree crossover(Tree tree1, Tree tree2, double probswap, int top){
        Tree ans;
        if(Math.random() < probswap){
            ans = Copy(tree2);
        }else{
           // System.out.println(tree1.getRootData());
            ans = Copy(tree1);
            for(int i =0; i< tree1.getChildCount(); ++i){
                if(tree2.getChildCount() <= i )break;
                Tree child = crossover(tree1.getChild(i), tree2.getChild(i), probswap, 0);
                ans.setChild(i,child);
            }
        }
        return ans;
    }

    public static Tree mutate(Tree tree, double pc, double probchange, ArrayList<String>treeType){
        Tree ans = Copy(tree);
        if(Math.random() < probchange){
            int idx = (int)(Math.random() * treeType.size()) ;
            ans.setRootData(treeType.get(idx));
        }else{
            // System.out.println(tree1.getRootData());

            for(int i =0; i< tree.getChildCount(); ++i){
                Tree child = mutate(tree.getChild(i), pc, probchange,treeType);
                ans.setChild(i,child);
            }
        }
        return ans;
    }

   /* public static Tree makeRandomTree(int pc, int maxDepth, double fpr, double ppr){

    }*/

    public static void main(String[] args) throws Exception {
        TreeProcessor tp=new TreeProcessor();

        // create a CharStream thatreads from standard input
        String sql3="int a = 4;" +
                "int getCellRowID(int a,int b)//get the row ID from cell index\n" +
                "  {\n" +
                "     int c=a/w+b;\n" +
                "     string s;     " +
                "     int ret=a/c+b;\n" +
                "     return ret;\n" +
                "  }";
        String sql4="int getCellRowID(int index,int p)//get the row ID from cell index\n" +
                "  {\n" +
                "     c1=index/width+p;\n" +
                "     ret=index/c1+p;\n" +
                "     return ret;\n" +
                "  }";
        String sq = sql3;
        String sql5="int getCellColID(int ind)//get colunm ID from cell index\n" +
                "  {\n" +
                "    return ind%width;\n" +
                "  }";

        String sql6="void RAstarPlannerROS::convertToCoordinate(int index, float& x, float& y)\n" +
                "{\n" +
                "\n" +
                "  x = getCellColID(index) * resolution;\n" +
                "\n" +
                "  y = getCellRowID(index,q) * resolution;\n" +
                "\n" +
                "  x = x + originX;\n" +
                "  y = y + originY;\n" +
                "\n" + 
                "}";
//        ANTLRInputStream input3 = new ANTLRInputStream(sq); //将输入转成antlr的input流
//        CPP14Lexer lexer3 = new CPP14Lexer(input3);  //词法分析
//        CommonTokenStream tokens3 = new CommonTokenStream(lexer3); //转成token流
//        CPP14Parser parser3 = new CPP14Parser(tokens3); // 语法分析
//        CPP14Parser.TranslationunitContext tree3 = parser3.translationunit();
//
//        String re = tree3.declarationseq().getText();
//        System.out.println(re);
//        System.out.println(tree3.toStringTree(parser3) + "\n\n");


        ANTLRInputStream input3 = new ANTLRInputStream(sql3); //将输入转成antlr的input流
        CPP14Lexer lexer3 = new CPP14Lexer(input3);  //词法分析
        CommonTokenStream tokens3 = new CommonTokenStream(lexer3); //转成token流
        CPP14Parser parser3 = new CPP14Parser(tokens3); // 语法分析
        CPP14Parser.TranslationunitContext tree3 = parser3.translationunit();


        ANTLRInputStream input4 = new ANTLRInputStream(sql4); //将输入转成antlr的input流
        CPP14Lexer lexer4 = new CPP14Lexer(input4);  //词法分析
        CommonTokenStream tokens4 = new CommonTokenStream(lexer4); //转成token流
        CPP14Parser parser4 = new CPP14Parser(tokens4); // 语法分析
        CPP14Parser.TranslationunitContext tree4 = parser4.translationunit();

       /* ANTLRInputStream input5 = new ANTLRInputStream(sql5);
        CPP14Lexer lexer5 = new CPP14Lexer(input5);
        CommonTokenStream tokens5 = new CommonTokenStream(lexer5);
        CPP14Parser parser5 = new CPP14Parser(tokens5);
        CPP14Parser.TranslationunitContext tree5 = parser5.translationunit(); //ParseTree

        ANTLRInputStream input6 = new ANTLRInputStream(sql6);
        CPP14Lexer lexer6 = new CPP14Lexer(input6);
        CommonTokenStream tokens6 = new CommonTokenStream(lexer6);
        CPP14Parser parser6 = new CPP14Parser(tokens6);
        CPP14Parser.TranslationunitContext tree6 = parser6.translationunit();  //生成语法树遍历监听器*/


        /*tree4.removeLastChild();
        System.out.println("tree4:\n" + tree4.getText() + "\n\n");
        System.out.println(tree4.toStringTree(parser4) + "\n\n");*/

        Tree myTree4=new Tree(tp.getRuleName(tree4,parser4));
        tp.convertTree(tree4,parser4,myTree4);
        Tree myTree3=new Tree(tp.getRuleName(tree3,parser3));
        tp.convertTree(tree3,parser3,myTree3);

        System.out.println("\nprinting code3...");
        tp.printCode(myTree3);

        System.out.println("\nprinting code4...");
        tp.printCode(myTree4);

        tp.setType(myTree3);
        ArrayList<String>treeType = tp.treeType;
        Tree mutateTree = mutate(myTree3,4,0.1, treeType);
        System.out.println("\nprinting pre postOrder...");
        tp.postOrder(myTree3);
        System.out.println("\nprinting code mutate...");
        tp.postOrder(mutateTree);

        Tree mytree = crossover(myTree3,myTree4,0.1,1);
        System.out.println("\nprinting code cross...");
        tp.printCode(mytree);

        System.out.println("\nprinting code copy...");
        Tree cp = Copy(myTree3);
        tp.printCode(cp);

       /* String path1="S:\\mymymy\\crowl_test\\fetch_code\\1.cpp";
        Tree myTree=MergeCppFuncs(path1);
        System.out.println("printing code...");
        tp.printCode(myTree);
        System.out.println("\nprinting code over.");*/

//        CPP14BaseVisitorBinary loader = new CPP14BaseVisitorBinary();
//        loader.visit(tree3);
        //System.out.println("encode_string:"+loader.encode_str);


        //modify Interface
//        ArrayList<String> rep=new ArrayList<>();
//        rep.add("x");
//        rep.add("y");
//        modifyInterface(myTree4,rep);



        //compare code
        //compare();



    }

}