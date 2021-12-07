//Main.java

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

import java.util.ArrayList;

public class Demo {
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


    public static void levenshtein(String str1,String str2) {

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

        System.out.println("dist："+dif[len1][len2]);

        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
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

        System.out.println("printing code...");
        tp.printCode(myTree);
        System.out.println("\nprinting code over.");

        return myTree;

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
    public static  void compare(String path) throws IOException {
        TreeProcessor tp=new TreeProcessor();
        //makeGitAst(path);
        //makeAst("H:\\fetch_code");
        Tree tree1;
        tree1=MergeCppFuncs("H:\\fetch_code\\1.cpp");
        Tree tree2;
        tree2=MergeCppFuncs("H:\\fetch_code\\2.cpp");

        StringBuffer s1=new StringBuffer();
        StringBuffer lessEncode1=tp.lessEncode(tree1,s1);
        StringBuffer s2=new StringBuffer();
        StringBuffer lessEncode2=tp.lessEncode(tree2,s2);

        levenshtein(lessEncode1.toString(),lessEncode2.toString());
    }



    public static void main(String[] args) throws Exception {
        TreeProcessor tp=new TreeProcessor();

        // create a CharStream thatreads from standard input

        String sql= "" +
                "\n" +
                "        for (size_t i = 0; i < grid_plan.size(); i++) {\n" +
                "            geometry_msgs::PoseStamped pose;\n" +
                "            pose.header.stamp = ros::Time::now();\n" +
                "            pose.header.frame_id = global_frame_id_; /// Check in which frame to publish\n" +
                "            pose.pose.position.x = grid_plan[i].pose.position.x;\n" +
                "            pose.pose.position.y = grid_plan[i].pose.position.y;\n" +
                "            pose.pose.position.z = 0;\n" +
                "            pose.pose.orientation = tf::createQuaternionMsgFromRollPitchYaw(0,0,grid_plan[i].pose.position.z);\n" +
                "            plan.push_back(pose);\n" +
                "\n" +
                "        }";

        String sql2="for (int i = 0; i < bestPath.size(); i++)\n" +
                "      {\n" +
                "\n" +
                "        float x = 0.0;\n" +
                "        float y = 0.0;\n" +
                "\n" +
                "        int index = bestPath[i];\n" +
                "\n" +
                "        convertToCoordinate(index, x, y);\n" +
                "\n" +
                "        geometry_msgs::PoseStamped pose = goal;\n" +
                "\n" +
                "        pose.pose.position.x = x;\n" +
                "        pose.pose.position.y = y;\n" +
                "        pose.pose.position.z = 0.0;\n" +
                "\n" +
                "        pose.pose.orientation.x = 0.0;\n" +
                "        pose.pose.orientation.y = 0.0;\n" +
                "        pose.pose.orientation.z = 0.0;\n" +
                "        pose.pose.orientation.w = 1.0;\n" +
                "\n" +
                "        plan.push_back(pose);\n" +
                "      }";

        String sql3="for (; it!=plan.end(); ++it) {\n" +
                "\t   path_length += hypot(  (*it).pose.position.x - last_pose.pose.position.x, \n" +
                "\t\t                 (*it).pose.position.y - last_pose.pose.position.y );\n" +
                "\t   last_pose = *it;\n" +
                "\t}";


        String sql4="int getCellRowID(int index,int p)//get the row ID from cell index\n" +
                "  {\n" +
                "     ret=index/width+p;\n" +
                "     return ret;\n" +
                "  }";
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



        ANTLRInputStream input = new ANTLRInputStream(sql);
        CPP14Lexer lexer = new CPP14Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CPP14Parser parser = new CPP14Parser(tokens);
        CPP14Parser.TranslationunitContext tree = parser.translationunit();


        ANTLRInputStream input2 = new ANTLRInputStream(sql2);
        CPP14Lexer lexer2 = new CPP14Lexer(input2);
        CommonTokenStream tokens2 = new CommonTokenStream(lexer2);
        CPP14Parser parser2 = new CPP14Parser(tokens2);
        CPP14Parser.TranslationunitContext tree2 = parser2.translationunit();


        ANTLRInputStream input3 = new ANTLRInputStream(sql3);
        CPP14Lexer lexer3 = new CPP14Lexer(input3);
        CommonTokenStream tokens3 = new CommonTokenStream(lexer3);
        CPP14Parser parser3 = new CPP14Parser(tokens3);
        CPP14Parser.TranslationunitContext tree3 = parser3.translationunit();

        ANTLRInputStream input4 = new ANTLRInputStream(sql4);
        CPP14Lexer lexer4 = new CPP14Lexer(input4);
        CommonTokenStream tokens4 = new CommonTokenStream(lexer4);
        CPP14Parser parser4 = new CPP14Parser(tokens4);
        CPP14Parser.TranslationunitContext tree4 = parser4.translationunit();

        ANTLRInputStream input5 = new ANTLRInputStream(sql5);
        CPP14Lexer lexer5 = new CPP14Lexer(input5);
        CommonTokenStream tokens5 = new CommonTokenStream(lexer5);
        CPP14Parser parser5 = new CPP14Parser(tokens5);
        CPP14Parser.TranslationunitContext tree5 = parser5.translationunit();

        ANTLRInputStream input6 = new ANTLRInputStream(sql6);
        CPP14Lexer lexer6 = new CPP14Lexer(input6);
        CommonTokenStream tokens6 = new CommonTokenStream(lexer6);
        CPP14Parser parser6 = new CPP14Parser(tokens6);
        CPP14Parser.TranslationunitContext tree6 = parser6.translationunit();

        System.out.println(tree.toStringTree(parser));
        System.out.println(tree2.toStringTree(parser2));
        System.out.println(tree3.toStringTree(parser3));
        System.out.println(tree4.toStringTree(parser3));

        Tree myTree=new Tree(tp.getRuleName(tree,parser));
        tp.convertTree(tree,parser,myTree);
        Tree myTree2=new Tree(tp.getRuleName(tree2,parser2));
        tp.convertTree(tree2,parser2,myTree2);
        Tree myTree3=new Tree(tp.getRuleName(tree3,parser3));
        tp.convertTree(tree3,parser3,myTree3);

        tp.preOrder(myTree);
        System.out.println();
        /*getParamName(tree4,parser4);
        getParamName(tree5,parser5);*/
        tree4.removeLastChild();
        System.out.println(tree4.getText());
        //visitorTree(tree4,parser4);
        Tree myTree4=new Tree(tp.getRuleName(tree4,parser4));
        tp.convertTree(tree4,parser4,myTree4);

        //preOrder(myTree4);


        System.out.println();
        //getParamName(tree4,parser4);
        //getParamName(tree5,parser5);
        tree5.removeLastChild();
        System.out.println(tree5.getText());
        //visitorTree(tree4,parser4);
        Tree myTree5=new Tree(tp.getRuleName(tree5,parser5));
        tp.convertTree(tree5,parser5,myTree5);
        //preOrder(myTree4);


        System.out.println();

        tree6.removeLastChild();
        Tree myTree6=new Tree(tp.getRuleName(tree6,parser6));
        tp.convertTree(tree6,parser6,myTree6);
        tp.preOrder(myTree6);
        System.out.println();


        System.out.println("printing code...");
        tp.printCode(myTree6);
        System.out.println("\nprinting code over.");



        //get all declared function
        ArrayList<Tree> funclist=new ArrayList<>();
        tp.getFunctionDefinition(myTree4,funclist);
        tp.getFunctionDefinition(myTree5,funclist);

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
        ArrayList<String> rep=new ArrayList<>();
        rep.add("x");
        rep.add("y");
        tp.replaceParam(funclist.get(0),ParamList.get(0),rep);
        System.out.println();
        System.out.println("after modify");
        tp.printCode(funclist.get(0));

        //get return statement ,change return to (***) <tree>
        /*ArrayList<Tree> returnTreeList=new ArrayList<>();
        for(Tree Func:funclist){
            Tree ret=tp.getReturnStatementTree(Func);
            returnTreeList.add(ret);
        }



        //get call function statement in a code
        ArrayList<Tree> CallFuncList=new ArrayList<>();
        tp.getCallFunc(myTree6,CallFuncList);

        //get param from every called function,make it a matrix
        ArrayList<ArrayList<String>> calledParamList=new ArrayList<>();
        for(Tree callFunc:CallFuncList){
            ArrayList<String> param=tp.getCalledParams(callFunc);
            calledParamList.add(param);
        }

        System.out.println();




        tp.mergeFunc(myTree6,funcNameList,returnTreeList,ParamList,calledParamList,funcBodyList);

        System.out.println("printing code...");
        tp.printCode(myTree6);
        System.out.println("\nprinting code over.");

        StringBuffer s6=new StringBuffer();
        StringBuffer lessEncode6=tp.lessEncode(myTree6,s6);


        //System.out.println(lessEncode6);
        //getParamName(tree6,parser6);
        /*
         *
         *
         * */
        //levenshtein(sql,sql2);
        //levenshtein(sql,sql3);
        //levenshtein(sql2,sql3);

        //levenshtein(tree.toStringTree(parser),tree2.toStringTree(parser2));
        //levenshtein(tree.toStringTree(parser),tree3.toStringTree(parser3));
        //levenshtein(tree2.toStringTree(parser2),tree3.toStringTree(parser3));

        /*
         *
         *
         * */

        /*ParseTreeWalker walker=new ParseTreeWalker();
        CPP14BaseListener extor=new CPP14BaseListener(parser);
        walker.walk(extor,tree);

        System.out.println();

        ParseTreeWalker walker2=new ParseTreeWalker();
        CPP14BaseListener extor2=new CPP14BaseListener(parser2);
        walker2.walk(extor2,tree2);

        System.out.println();

        ParseTreeWalker walker3=new ParseTreeWalker();
        CPP14BaseListener extor3=new CPP14BaseListener(parser3);
        walker3.walk(extor3,tree3);

        System.out.println();

        ParseTreeWalker walker4=new ParseTreeWalker();
        CPP14BaseListener extor4=new CPP14BaseListener(parser4);
        walker4.walk(extor4,tree4);

        System.out.println();

        ParseTreeWalker walker5=new ParseTreeWalker();
        CPP14BaseListener extor5=new CPP14BaseListener(parser5);
        walker5.walk(extor5,tree5);

        System.out.println();

        ParseTreeWalker walker6=new ParseTreeWalker();
        CPP14BaseListener extor6=new CPP14BaseListener(parser6);
        walker6.walk(extor6,tree6);*/





        //compare("H:\\GIT");



    }

}