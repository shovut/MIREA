import Lexer.Lexer;
import Lexer.Token;
import Optimizer.Optimisation;
import Parser.Parser;
import Machine.Executor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input =
                "Thread t1;\n" +
                "Thread t2;\n" +
                "function func1(int arg){\n" +
                     "while(arg < 100){\n"+
                        "print 'thread11111111';\n" +
                        "arg = arg + 1;\n"+
                     "}\n"+
                    "return;\n" +
                "}\n"  +
                "function func2(int arg){\n" +
                      "while(arg < 200){\n"+
                            "print 'thread22222222';\n" +
                            "arg = arg + 1;\n"+
                       "}\n"+
                   "return;\n" +
                 "}\n"  +
                "int a = 2 + 1;\n" +
                "int b = a + 50;\n" +
                "t1.run(func1(a));\n" +
                "t2.run(func2(b));\n" +
                "t1.join();\n" +
                "t2.join();\n" +
//                "hello(a);\n"+
//                "world(b);\n"+
                "print 'DATS ALL';";
        System.out.println("\nCode: \n" + input);

        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.getTokens();

        Parser parser = new Parser(tokens);

        if (parser.lang()) {
            System.out.println(parser.reversePolishNotation);
            System.out.println(parser.tableOfVariables);
            Optimisation optimisation = new Optimisation(parser.tableOfVariables, parser.reversePolishNotation);
            optimisation.execute();
            System.out.println(parser.reversePolishNotation);

            Executor executor = new Executor();
            System.out.println("Results:");
            executor.start(parser);
        }
    }
}
