/*
 * @Author: wbs2788
 * @Date: 2021-11-24 10:53:12
 * @LastEditTime: 2021-12-01 10:37:16
 * @LastEditors: wbs2788
 * @Description: cut code to small pieces(for\if block) 
 */

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import java.io.*;

import java.util.ArrayList;

public class codecut {

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
    public static void main(String[] args) throws Exception {
        TreeProcessor tp = new TreeProcessor();
        String path1 = "example.cc";
        String code = readFromTextFile(path1);
        ANTLRInputStream input = new ANTLRInputStream(code);
        CPP14Lexer lexer = new CPP14Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CPP14Parser parser = new CPP14Parser(tokens);
        CPP14Parser.TranslationunitContext tree = parser.translationunit();
        tree.removeLastChild();
        // System.out.println(tree.getText());
        Tree myTree=new Tree(tp.getRuleName(tree,parser));
        tp.convertTree(tree,parser,myTree);
        // System.out.println("printing code...");
        // tp.printCode(myTree);
        System.out.println("\nprinting if block.");
        tp.mergeIfBlock(myTree);
        System.out.println("\nprinting for block.");
        tp.mergeForBlock(myTree);
    }
}