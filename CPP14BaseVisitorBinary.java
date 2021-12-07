import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.*;



public class CPP14BaseVisitorBinary extends CPP14BaseVisitor<Void> {




        List<Integer> encode=new ArrayList<Integer>();

        String encode_str="";

        String tree_str="";

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTranslationunit(CPP14Parser.TranslationunitContext ctx) {encode.add(22);encode_str+="10110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPrimaryexpression(CPP14Parser.PrimaryexpressionContext ctx) {encode.add(29);encode_str+="11101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitIdexpression(CPP14Parser.IdexpressionContext ctx) {encode.add(36);encode_str+="100100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitUnqualifiedid(CPP14Parser.UnqualifiedidContext ctx) {encode.add(43);encode_str+="101011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitQualifiedid(CPP14Parser.QualifiedidContext ctx) {encode.add(50);encode_str+="110010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNestednamespecifier(CPP14Parser.NestednamespecifierContext ctx) {encode.add(57);encode_str+="111001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLambdaexpression(CPP14Parser.LambdaexpressionContext ctx) {encode.add(64);encode_str+="1000000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLambdaintroducer(CPP14Parser.LambdaintroducerContext ctx) {encode.add(71);encode_str+="1000111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLambdacapture(CPP14Parser.LambdacaptureContext ctx) {encode.add(78);encode_str+="1001110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCapturedefault(CPP14Parser.CapturedefaultContext ctx) {encode.add(85);encode_str+="1010101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCapturelist(CPP14Parser.CapturelistContext ctx) {encode.add(92);encode_str+="1011100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCapture(CPP14Parser.CaptureContext ctx) {encode.add(99);encode_str+="1100011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitSimplecapture(CPP14Parser.SimplecaptureContext ctx) {encode.add(106);encode_str+="1101010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitInitcapture(CPP14Parser.InitcaptureContext ctx) {encode.add(113);encode_str+="1110001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLambdadeclarator(CPP14Parser.LambdadeclaratorContext ctx) {encode.add(120);encode_str+="1111000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPostfixexpression(CPP14Parser.PostfixexpressionContext ctx) {encode.add(127);encode_str+="1111111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTypeidofexpr(CPP14Parser.TypeidofexprContext ctx) {encode.add(134);encode_str+="10000110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTypeidofthetypeid(CPP14Parser.TypeidofthetypeidContext ctx) {encode.add(141);encode_str+="10001101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExpressionlist(CPP14Parser.ExpressionlistContext ctx) {encode.add(148);encode_str+="10010100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPseudodestructorname(CPP14Parser.PseudodestructornameContext ctx) {encode.add(155);encode_str+="10011011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitUnaryexpression(CPP14Parser.UnaryexpressionContext ctx) {encode.add(162);encode_str+="10100010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitUnaryoperator(CPP14Parser.UnaryoperatorContext ctx) {encode.add(169);encode_str+="10101001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNewexpression(CPP14Parser.NewexpressionContext ctx) {encode.add(176);encode_str+="10110000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNewplacement(CPP14Parser.NewplacementContext ctx) {encode.add(183);encode_str+="10110111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNewtypeid(CPP14Parser.NewtypeidContext ctx) {encode.add(190);encode_str+="10111110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNewdeclarator(CPP14Parser.NewdeclaratorContext ctx) {encode.add(197);encode_str+="11000101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNoptrnewdeclarator(CPP14Parser.NoptrnewdeclaratorContext ctx) {encode.add(204);encode_str+="11001100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNewinitializer(CPP14Parser.NewinitializerContext ctx) {encode.add(211);encode_str+="11010011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDeleteexpression(CPP14Parser.DeleteexpressionContext ctx) {encode.add(218);encode_str+="11011010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNoexceptexpression(CPP14Parser.NoexceptexpressionContext ctx) {encode.add(225);encode_str+="11100001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCastexpression(CPP14Parser.CastexpressionContext ctx) {encode.add(232);encode_str+="11101000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPmexpression(CPP14Parser.PmexpressionContext ctx) {encode.add(239);encode_str+="11101111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitMultiplicativeexpression(CPP14Parser.MultiplicativeexpressionContext ctx) {encode.add(246);encode_str+="11110110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAdditiveexpression(CPP14Parser.AdditiveexpressionContext ctx) {encode.add(253);encode_str+="11111101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitShiftexpression(CPP14Parser.ShiftexpressionContext ctx) {encode.add(260);encode_str+="100000100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitShiftoperator(CPP14Parser.ShiftoperatorContext ctx) {encode.add(267);encode_str+="100001011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitRelationalexpression(CPP14Parser.RelationalexpressionContext ctx) {encode.add(274);encode_str+="100010010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEqualityexpression(CPP14Parser.EqualityexpressionContext ctx) {encode.add(281);encode_str+="100011001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAndexpression(CPP14Parser.AndexpressionContext ctx) {encode.add(288);encode_str+="100100000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExclusiveorexpression(CPP14Parser.ExclusiveorexpressionContext ctx) {encode.add(295);encode_str+="100100111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitInclusiveorexpression(CPP14Parser.InclusiveorexpressionContext ctx) {encode.add(302);encode_str+="100101110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLogicalandexpression(CPP14Parser.LogicalandexpressionContext ctx) {encode.add(309);encode_str+="100110101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLogicalorexpression(CPP14Parser.LogicalorexpressionContext ctx) {encode.add(316);encode_str+="100111100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitConditionalexpression(CPP14Parser.ConditionalexpressionContext ctx) {encode.add(323);encode_str+="101000011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAssignmentexpression(CPP14Parser.AssignmentexpressionContext ctx) {encode.add(330);encode_str+="101001010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAssignmentoperator(CPP14Parser.AssignmentoperatorContext ctx) {encode.add(337);encode_str+="101010001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExpression(CPP14Parser.ExpressionContext ctx) {encode.add(344);encode_str+="101011000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitConstantexpression(CPP14Parser.ConstantexpressionContext ctx) {encode.add(351);encode_str+="101011111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitStatement(CPP14Parser.StatementContext ctx) {encode.add(358);encode_str+="101100110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLabeledstatement(CPP14Parser.LabeledstatementContext ctx) {encode.add(365);encode_str+="101101101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExpressionstatement(CPP14Parser.ExpressionstatementContext ctx) {encode.add(372);encode_str+="101110100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCompoundstatement(CPP14Parser.CompoundstatementContext ctx) {encode.add(379);encode_str+="101111011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitStatementseq(CPP14Parser.StatementseqContext ctx) {encode.add(386);encode_str+="110000010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitSelectionstatement(CPP14Parser.SelectionstatementContext ctx) {encode.add(393);encode_str+="110001001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCondition(CPP14Parser.ConditionContext ctx) {encode.add(400);encode_str+="110010000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitIterationstatement(CPP14Parser.IterationstatementContext ctx) {encode.add(407);encode_str+="110010111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitForinitstatement(CPP14Parser.ForinitstatementContext ctx) {encode.add(414);encode_str+="110011110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitForrangedeclaration(CPP14Parser.ForrangedeclarationContext ctx) {encode.add(421);encode_str+="110100101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitForrangeinitializer(CPP14Parser.ForrangeinitializerContext ctx) {encode.add(428);encode_str+="110101100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitJumpstatement(CPP14Parser.JumpstatementContext ctx) {encode.add(435);encode_str+="110110011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDeclarationstatement(CPP14Parser.DeclarationstatementContext ctx) {encode.add(442);encode_str+="110111010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDeclarationseq(CPP14Parser.DeclarationseqContext ctx) {encode.add(449);encode_str+="111000001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDeclaration(CPP14Parser.DeclarationContext ctx) {encode.add(456);encode_str+="111001000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBlockdeclaration(CPP14Parser.BlockdeclarationContext ctx) {encode.add(463);encode_str+="111001111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAliasdeclaration(CPP14Parser.AliasdeclarationContext ctx) {encode.add(470);encode_str+="111010110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitSimpledeclaration(CPP14Parser.SimpledeclarationContext ctx) {encode.add(477);encode_str+="111011101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitStatic_assertdeclaration(CPP14Parser.Static_assertdeclarationContext ctx) {encode.add(484);encode_str+="111100100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEmptydeclaration(CPP14Parser.EmptydeclarationContext ctx) {encode.add(491);encode_str+="111101011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttributedeclaration(CPP14Parser.AttributedeclarationContext ctx) {encode.add(498);encode_str+="111110010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDeclspecifier(CPP14Parser.DeclspecifierContext ctx) {encode.add(505);encode_str+="111111001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDeclspecifierseq(CPP14Parser.DeclspecifierseqContext ctx) {encode.add(512);encode_str+="1000000000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitStorageclassspecifier(CPP14Parser.StorageclassspecifierContext ctx) {encode.add(519);encode_str+="1000000111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitFunctionspecifier(CPP14Parser.FunctionspecifierContext ctx) {encode.add(526);encode_str+="1000001110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTypedefname(CPP14Parser.TypedefnameContext ctx) {encode.add(533);encode_str+="1000010101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTypespecifier(CPP14Parser.TypespecifierContext ctx) {encode.add(540);encode_str+="1000011100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTrailingtypespecifier(CPP14Parser.TrailingtypespecifierContext ctx) {encode.add(547);encode_str+="1000100011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTypespecifierseq(CPP14Parser.TypespecifierseqContext ctx) {encode.add(554);encode_str+="1000101010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTrailingtypespecifierseq(CPP14Parser.TrailingtypespecifierseqContext ctx) {encode.add(561);encode_str+="1000110001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitSimpletypespecifier(CPP14Parser.SimpletypespecifierContext ctx) {encode.add(568);encode_str+="1000111000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitThetypename(CPP14Parser.ThetypenameContext ctx) {encode.add(575);encode_str+="1000111111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDecltypespecifier(CPP14Parser.DecltypespecifierContext ctx) {encode.add(582);encode_str+="1001000110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitElaboratedtypespecifier(CPP14Parser.ElaboratedtypespecifierContext ctx) {encode.add(589);encode_str+="1001001101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEnumname(CPP14Parser.EnumnameContext ctx) {encode.add(596);encode_str+="1001010100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEnumspecifier(CPP14Parser.EnumspecifierContext ctx) {encode.add(603);encode_str+="1001011011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEnumhead(CPP14Parser.EnumheadContext ctx) {encode.add(610);encode_str+="1001100010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitOpaqueenumdeclaration(CPP14Parser.OpaqueenumdeclarationContext ctx) {encode.add(617);encode_str+="1001101001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEnumkey(CPP14Parser.EnumkeyContext ctx) {encode.add(624);encode_str+="1001110000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEnumbase(CPP14Parser.EnumbaseContext ctx) {encode.add(631);encode_str+="1001110111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEnumeratorlist(CPP14Parser.EnumeratorlistContext ctx) {encode.add(638);encode_str+="1001111110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEnumeratordefinition(CPP14Parser.EnumeratordefinitionContext ctx) {encode.add(645);encode_str+="1010000101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitEnumerator(CPP14Parser.EnumeratorContext ctx) {encode.add(652);encode_str+="1010001100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNamespacename(CPP14Parser.NamespacenameContext ctx) {encode.add(659);encode_str+="1010010011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitOriginalnamespacename(CPP14Parser.OriginalnamespacenameContext ctx) {encode.add(666);encode_str+="1010011010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNamespacedefinition(CPP14Parser.NamespacedefinitionContext ctx) {encode.add(673);encode_str+="1010100001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNamednamespacedefinition(CPP14Parser.NamednamespacedefinitionContext ctx) {encode.add(680);encode_str+="1010101000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitOriginalnamespacedefinition(CPP14Parser.OriginalnamespacedefinitionContext ctx) {encode.add(687);encode_str+="1010101111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExtensionnamespacedefinition(CPP14Parser.ExtensionnamespacedefinitionContext ctx) {encode.add(694);encode_str+="1010110110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitUnnamednamespacedefinition(CPP14Parser.UnnamednamespacedefinitionContext ctx) {encode.add(701);encode_str+="1010111101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNamespacebody(CPP14Parser.NamespacebodyContext ctx) {encode.add(708);encode_str+="1011000100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNamespacealias(CPP14Parser.NamespacealiasContext ctx) {encode.add(715);encode_str+="1011001011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNamespacealiasdefinition(CPP14Parser.NamespacealiasdefinitionContext ctx) {encode.add(722);encode_str+="1011010010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitQualifiednamespacespecifier(CPP14Parser.QualifiednamespacespecifierContext ctx) {encode.add(729);encode_str+="1011011001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitUsingdeclaration(CPP14Parser.UsingdeclarationContext ctx) {encode.add(736);encode_str+="1011100000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitUsingdirective(CPP14Parser.UsingdirectiveContext ctx) {encode.add(743);encode_str+="1011100111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAsmdefinition(CPP14Parser.AsmdefinitionContext ctx) {encode.add(750);encode_str+="1011101110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLinkagespecification(CPP14Parser.LinkagespecificationContext ctx) {encode.add(757);encode_str+="1011110101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttributespecifierseq(CPP14Parser.AttributespecifierseqContext ctx) {encode.add(764);encode_str+="1011111100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttributespecifier(CPP14Parser.AttributespecifierContext ctx) {encode.add(771);encode_str+="1100000011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAlignmentspecifier(CPP14Parser.AlignmentspecifierContext ctx) {encode.add(778);encode_str+="1100001010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttributelist(CPP14Parser.AttributelistContext ctx) {encode.add(785);encode_str+="1100010001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttribute(CPP14Parser.AttributeContext ctx) {encode.add(792);encode_str+="1100011000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttributetoken(CPP14Parser.AttributetokenContext ctx) {encode.add(799);encode_str+="1100011111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttributescopedtoken(CPP14Parser.AttributescopedtokenContext ctx) {encode.add(806);encode_str+="1100100110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttributenamespace(CPP14Parser.AttributenamespaceContext ctx) {encode.add(813);encode_str+="1100101101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAttributeargumentclause(CPP14Parser.AttributeargumentclauseContext ctx) {encode.add(820);encode_str+="1100110100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBalancedtokenseq(CPP14Parser.BalancedtokenseqContext ctx) {encode.add(827);encode_str+="1100111011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBalancedtoken(CPP14Parser.BalancedtokenContext ctx) {encode.add(834);encode_str+="1101000010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitInitdeclaratorlist(CPP14Parser.InitdeclaratorlistContext ctx) {encode.add(841);encode_str+="1101001001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitInitdeclarator(CPP14Parser.InitdeclaratorContext ctx) {encode.add(848);encode_str+="1101010000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDeclarator(CPP14Parser.DeclaratorContext ctx) {encode.add(855);encode_str+="1101010111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPtrdeclarator(CPP14Parser.PtrdeclaratorContext ctx) {encode.add(862);encode_str+="1101011110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNoptrdeclarator(CPP14Parser.NoptrdeclaratorContext ctx) {encode.add(869);encode_str+="1101100101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitParametersandqualifiers(CPP14Parser.ParametersandqualifiersContext ctx) {encode.add(876);encode_str+="1101101100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTrailingreturntype(CPP14Parser.TrailingreturntypeContext ctx) {encode.add(883);encode_str+="1101110011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPtroperator(CPP14Parser.PtroperatorContext ctx) {encode.add(890);encode_str+="1101111010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCvqualifierseq(CPP14Parser.CvqualifierseqContext ctx) {encode.add(897);encode_str+="1110000001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCvqualifier(CPP14Parser.CvqualifierContext ctx) {encode.add(904);encode_str+="1110001000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitRefqualifier(CPP14Parser.RefqualifierContext ctx) {encode.add(911);encode_str+="1110001111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDeclaratorid(CPP14Parser.DeclaratoridContext ctx) {encode.add(918);encode_str+="1110010110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitThetypeid(CPP14Parser.ThetypeidContext ctx) {encode.add(925);encode_str+="1110011101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAbstractdeclarator(CPP14Parser.AbstractdeclaratorContext ctx) {encode.add(932);encode_str+="1110100100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPtrabstractdeclarator(CPP14Parser.PtrabstractdeclaratorContext ctx) {encode.add(939);encode_str+="1110101011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNoptrabstractdeclarator(CPP14Parser.NoptrabstractdeclaratorContext ctx) {encode.add(946);encode_str+="1110110010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAbstractpackdeclarator(CPP14Parser.AbstractpackdeclaratorContext ctx) {encode.add(953);encode_str+="1110111001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNoptrabstractpackdeclarator(CPP14Parser.NoptrabstractpackdeclaratorContext ctx) {encode.add(960);encode_str+="1111000000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitParameterdeclarationclause(CPP14Parser.ParameterdeclarationclauseContext ctx) {encode.add(967);encode_str+="1111000111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitParameterdeclarationlist(CPP14Parser.ParameterdeclarationlistContext ctx) {encode.add(974);encode_str+="1111001110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitParameterdeclaration(CPP14Parser.ParameterdeclarationContext ctx) {encode.add(981);encode_str+="1111010101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitFunctiondefinition(CPP14Parser.FunctiondefinitionContext ctx) {encode.add(988);encode_str+="1111011100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitFunctionbody(CPP14Parser.FunctionbodyContext ctx) {encode.add(995);encode_str+="1111100011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitInitializer(CPP14Parser.InitializerContext ctx) {encode.add(1002);encode_str+="1111101010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBraceorequalinitializer(CPP14Parser.BraceorequalinitializerContext ctx) {encode.add(1009);encode_str+="1111110001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitInitializerclause(CPP14Parser.InitializerclauseContext ctx) {encode.add(1016);encode_str+="1111111000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitInitializerlist(CPP14Parser.InitializerlistContext ctx) {encode.add(1023);encode_str+="1111111111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBracedinitlist(CPP14Parser.BracedinitlistContext ctx) {encode.add(1030);encode_str+="10000000110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitClassname(CPP14Parser.ClassnameContext ctx) {encode.add(1037);encode_str+="10000001101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitClassspecifier(CPP14Parser.ClassspecifierContext ctx) {encode.add(1044);encode_str+="10000010100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitClasshead(CPP14Parser.ClassheadContext ctx) {encode.add(1051);encode_str+="10000011011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitClassheadname(CPP14Parser.ClassheadnameContext ctx) {encode.add(1058);encode_str+="10000100010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitClassvirtspecifier(CPP14Parser.ClassvirtspecifierContext ctx) {encode.add(1065);encode_str+="10000101001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitClasskey(CPP14Parser.ClasskeyContext ctx) {encode.add(1072);encode_str+="10000110000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitMemberspecification(CPP14Parser.MemberspecificationContext ctx) {encode.add(1079);encode_str+="10000110111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitMemberdeclaration(CPP14Parser.MemberdeclarationContext ctx) {encode.add(1086);encode_str+="10000111110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitMemberdeclaratorlist(CPP14Parser.MemberdeclaratorlistContext ctx) {encode.add(1093);encode_str+="10001000101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitMemberdeclarator(CPP14Parser.MemberdeclaratorContext ctx) {encode.add(1100);encode_str+="10001001100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitVirtspecifierseq(CPP14Parser.VirtspecifierseqContext ctx) {encode.add(1107);encode_str+="10001010011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitVirtspecifier(CPP14Parser.VirtspecifierContext ctx) {encode.add(1114);encode_str+="10001011010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPurespecifier(CPP14Parser.PurespecifierContext ctx) {encode.add(1121);encode_str+="10001100001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBaseclause(CPP14Parser.BaseclauseContext ctx) {encode.add(1128);encode_str+="10001101000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBasespecifierlist(CPP14Parser.BasespecifierlistContext ctx) {encode.add(1135);encode_str+="10001101111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBasespecifier(CPP14Parser.BasespecifierContext ctx) {encode.add(1142);encode_str+="10001110110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitClassordecltype(CPP14Parser.ClassordecltypeContext ctx) {encode.add(1149);encode_str+="10001111101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBasetypespecifier(CPP14Parser.BasetypespecifierContext ctx) {encode.add(1156);encode_str+="10010000100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitAccessspecifier(CPP14Parser.AccessspecifierContext ctx) {encode.add(1163);encode_str+="10010001011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitConversionfunctionid(CPP14Parser.ConversionfunctionidContext ctx) {encode.add(1170);encode_str+="10010010010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitConversiontypeid(CPP14Parser.ConversiontypeidContext ctx) {encode.add(1177);encode_str+="10010011001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitConversiondeclarator(CPP14Parser.ConversiondeclaratorContext ctx) {encode.add(1184);encode_str+="10010100000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitCtorinitializer(CPP14Parser.CtorinitializerContext ctx) {encode.add(1191);encode_str+="10010100111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitMeminitializerlist(CPP14Parser.MeminitializerlistContext ctx) {encode.add(1198);encode_str+="10010101110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitMeminitializer(CPP14Parser.MeminitializerContext ctx) {encode.add(1205);encode_str+="10010110101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitMeminitializerid(CPP14Parser.MeminitializeridContext ctx) {encode.add(1212);encode_str+="10010111100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitOperatorfunctionid(CPP14Parser.OperatorfunctionidContext ctx) {encode.add(1219);encode_str+="10011000011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLiteraloperatorid(CPP14Parser.LiteraloperatoridContext ctx) {encode.add(1226);encode_str+="10011001010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTemplatedeclaration(CPP14Parser.TemplatedeclarationContext ctx) {encode.add(1233);encode_str+="10011010001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTemplateparameterlist(CPP14Parser.TemplateparameterlistContext ctx) {encode.add(1240);encode_str+="10011011000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTemplateparameter(CPP14Parser.TemplateparameterContext ctx) {encode.add(1247);encode_str+="10011011111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTypeparameter(CPP14Parser.TypeparameterContext ctx) {encode.add(1254);encode_str+="10011100110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitSimpletemplateid(CPP14Parser.SimpletemplateidContext ctx) {encode.add(1261);encode_str+="10011101101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTemplateid(CPP14Parser.TemplateidContext ctx) {encode.add(1268);encode_str+="10011110100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTemplatename(CPP14Parser.TemplatenameContext ctx) {encode.add(1275);encode_str+="10011111011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTemplateargumentlist(CPP14Parser.TemplateargumentlistContext ctx) {encode.add(1282);encode_str+="10100000010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTemplateargument(CPP14Parser.TemplateargumentContext ctx) {encode.add(1289);encode_str+="10100001001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTypenamespecifier(CPP14Parser.TypenamespecifierContext ctx) {encode.add(1296);encode_str+="10100010000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExplicitinstantiation(CPP14Parser.ExplicitinstantiationContext ctx) {encode.add(1303);encode_str+="10100010111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExplicitspecialization(CPP14Parser.ExplicitspecializationContext ctx) {encode.add(1310);encode_str+="10100011110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTryblock(CPP14Parser.TryblockContext ctx) {encode.add(1317);encode_str+="10100100101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitFunctiontryblock(CPP14Parser.FunctiontryblockContext ctx) {encode.add(1324);encode_str+="10100101100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitHandlerseq(CPP14Parser.HandlerseqContext ctx) {encode.add(1331);encode_str+="10100110011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitHandler(CPP14Parser.HandlerContext ctx) {encode.add(1338);encode_str+="10100111010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExceptiondeclaration(CPP14Parser.ExceptiondeclarationContext ctx) {encode.add(1345);encode_str+="10101000001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitThrowexpression(CPP14Parser.ThrowexpressionContext ctx) {encode.add(1352);encode_str+="10101001000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitExceptionspecification(CPP14Parser.ExceptionspecificationContext ctx) {encode.add(1359);encode_str+="10101001111";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitDynamicexceptionspecification(CPP14Parser.DynamicexceptionspecificationContext ctx) {encode.add(1366);encode_str+="10101010110";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTypeidlist(CPP14Parser.TypeidlistContext ctx) {encode.add(1373);encode_str+="10101011101";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitNoexceptspecification(CPP14Parser.NoexceptspecificationContext ctx) {encode.add(1380);encode_str+="10101100100";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitTheoperator(CPP14Parser.TheoperatorContext ctx) {encode.add(1387);encode_str+="10101101011";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitLiteral(CPP14Parser.LiteralContext ctx) {encode.add(1394);encode_str+="10101110010";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitBooleanliteral(CPP14Parser.BooleanliteralContext ctx) {encode.add(1401);encode_str+="10101111001";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitPointerliteral(CPP14Parser.PointerliteralContext ctx) {encode.add(1408);encode_str+="10110000000";tree_str+=ctx.getText();return visitChildren(ctx);}

        /**

         * {@inheritDoc}

         *

         * <p>The default implementation returns the result of calling

         * {@link #visitChildren} on {@code ctx}.</p>

         */

        @Override public Void visitUserdefinedliteral(CPP14Parser.UserdefinedliteralContext ctx) {encode.add(1415);encode_str+="10110000111";tree_str+=ctx.getText();return visitChildren(ctx);}

    }


