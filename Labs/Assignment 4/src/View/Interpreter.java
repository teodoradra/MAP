package View;

import Controller.Controller;
import HeapStmt.New;
import Model.DataStructures.*;
import Model.Expressions.ArithExp;
import Model.Expressions.ValueExp;
import Model.Expressions.VarExp;
import Model.File.CloseFile;
import Model.File.OpenFile;
import Model.File.ReadFile;
import Model.HeapExp.rH;
import Model.HeapExp.wH;
import Model.MyException;
import Model.ProgramStatement.*;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Type.RefType;
import Model.Type.StringType;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.StringValue;
import Model.Value.Value;
import Repository.RepoI;
import Repository.Repository;
import Controller.*;

import java.io.BufferedReader;

public class Interpreter {
    public static void main(String[] args) {
        String filePath = "out.txt";
        MyIStack<IStmt> stk1 = new MyStack<>();
        MyIList<Value> out1 = new MyList<>();
        MyIDictionary<String, Value> symTbl1 = new MyDictionary<>();
        MyIDictionary<String, BufferedReader> fileTable1 = new MyDictionary<>();
        HeapI<Integer, Value> heap1 = new Heap<>();
        RepoI repo1 = new Repository(filePath);
        Controller controller1 = new Controller(repo1);
        IStmt ex1 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))), new PrintStmt(new
                        VarExp("v"))));
        PrgState prgSate = new PrgState(stk1, symTbl1, out1, fileTable1, heap1, ex1);
        controller1.addProgState(prgSate);


        MyIStack<IStmt> stk2 = new MyStack<>();
        MyIList<Value> out2 = new MyList<>();
        MyIDictionary<String, Value> symTbl2 = new MyDictionary<>();
        MyIDictionary<String, BufferedReader> fileTable2 = new MyDictionary<>();
        HeapI<Integer, Value> heap2 = new Heap<>();

        RepoI repo2 = new Repository(filePath);
        Controller controller2 = new Controller(repo2);
        IStmt ex2 = new CompStmt(new VarDeclStmt("a", new IntType()),
                new CompStmt(new VarDeclStmt("b", new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp(1, new ValueExp(new IntValue(2)), new
                                ArithExp(3, new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b", new ArithExp(1, new VarExp("a"), new
                                        ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));
        PrgState prgSate2 = new PrgState(stk2, symTbl2, out2, fileTable2, heap2, ex2);
        controller2.addProgState(prgSate2);


        MyIStack<IStmt> stk3 = new MyStack<>();
        MyIList<Value> out3 = new MyList<>();
        MyIDictionary<String, Value> symTbl3 = new MyDictionary<>();
        MyIDictionary<String, BufferedReader> fileTable3 = new MyDictionary<>();
        HeapI<Integer, Value> heap3 = new Heap<>();

        RepoI repo3 = new Repository(filePath);
        Controller controller3 = new Controller(repo3);
        IStmt ex3 = new CompStmt(new VarDeclStmt("a", new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"), new AssignStmt("v", new ValueExp(new
                                        IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
                                        VarExp("v"))))));
        PrgState prgSate3 = new PrgState(stk3, symTbl3, out3, fileTable3, heap3, ex3);
        controller3.addProgState(prgSate3);


        IStmt ex4 = new CompStmt(new VarDeclStmt("varf", new StringType()), new CompStmt(new AssignStmt("varf", new ValueExp(new StringValue("test.in"))),
                new CompStmt(new OpenFile(new VarExp("varf")),
                        new CompStmt(new VarDeclStmt("varc", new IntType()), new CompStmt(new ReadFile(new VarExp("varf"), "varc"),
                                new CompStmt(new PrintStmt(new VarExp("varc")), new CompStmt(new ReadFile(new VarExp("varf"), "varc"),
                                        new CompStmt(new PrintStmt(new VarExp("varc")), new CloseFile(new VarExp("varf"))))))))));

        MyIStack<IStmt> stk4 = new MyStack<>();
        MyIList<Value> out4 = new MyList<>();
        MyIDictionary<String, Value> symTbl4 = new MyDictionary<>();
        MyIDictionary<String, BufferedReader> fileTable4 = new MyDictionary<>();
        HeapI<Integer, Value> heap4 = new Heap<>();

        RepoI repo4 = new Repository(filePath);
        Controller controller4 = new Controller(repo4);

        PrgState prgSate4 = new PrgState(stk4, symTbl4, out4, fileTable4, heap4, ex4);
        controller4.addProgState(prgSate4);


        IStmt ex5 = new CompStmt(new VarDeclStmt("v", new RefType(new IntType())),
                new CompStmt(new New("v", new ValueExp(new IntValue(20))),
                        new CompStmt(new VarDeclStmt("a", new RefType(new RefType(new IntType()))),
                                new CompStmt(new New("a", new VarExp("v")),
                                        new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new VarExp("a")))))));

        MyIStack<IStmt> stk5 = new MyStack<>();
        MyIList<Value> out5 = new MyList<>();
        MyIDictionary<String, Value> symTbl5 = new MyDictionary<>();
        MyIDictionary<String, BufferedReader> fileTable5 = new MyDictionary<>();
        HeapI<Integer, Value> heap5 = new Heap<>();

        RepoI repo5 = new Repository(filePath);
        Controller controller5 = new Controller(repo5);

        PrgState prgSate5 = new PrgState(stk5, symTbl5, out5, fileTable5, heap5, ex5);
        controller5.addProgState(prgSate5);


        IStmt ex6 = new CompStmt(new VarDeclStmt("v", new RefType(new IntType())),
                new CompStmt(new New("v", new ValueExp(new IntValue(20))),
                        new CompStmt(new VarDeclStmt("a", new RefType(new RefType(new IntType()))),
                                new CompStmt(new New("a", new VarExp("v")),
                                        new CompStmt(new PrintStmt(new rH(new VarExp("v"))),
                                                new PrintStmt(new ArithExp(1, new rH(new rH(new VarExp("a"))), new ValueExp(new IntValue(5)))))))));

        MyIStack<IStmt> stk6 = new MyStack<>();
        MyIList<Value> out6 = new MyList<>();
        MyIDictionary<String, Value> symTbl6 = new MyDictionary<>();
        MyIDictionary<String, BufferedReader> fileTable6 = new MyDictionary<>();
        HeapI<Integer, Value> heap6 = new Heap<>();

        RepoI repo6 = new Repository(filePath);
        Controller controller6 = new Controller(repo6);

        PrgState prgSate6 = new PrgState(stk6, symTbl6, out6, fileTable6, heap6, ex6);
        controller6.addProgState(prgSate6);


        IStmt ex7 = new CompStmt(new VarDeclStmt("v", new RefType(new IntType())),
                new CompStmt(new New("v", new ValueExp(new IntValue(20))),
                        new CompStmt(new PrintStmt(new rH(new VarExp("v"))),
                                new CompStmt(new wH("v", new ValueExp(new IntValue(30))),
                                        new PrintStmt(new ArithExp(1, new rH(new VarExp("v")), new ValueExp(new IntValue(5))))
                                ))));

        MyIStack<IStmt> stk7 = new MyStack<>();
        MyIList<Value> out7 = new MyList<>();
        MyIDictionary<String, Value> symTbl7 = new MyDictionary<>();
        MyIDictionary<String, BufferedReader> fileTable7 = new MyDictionary<>();
        HeapI<Integer, Value> heap7 = new Heap<>();

        RepoI repo7 = new Repository(filePath);
        Controller controller7 = new Controller(repo7);

        PrgState prgSate7 = new PrgState(stk7, symTbl7, out7, fileTable7, heap7, ex7);
        controller7.addProgState(prgSate7);


        IStmt ex8 = new CompStmt(new VarDeclStmt("v", new RefType(new IntType())),
                new CompStmt(new New("v", new ValueExp(new IntValue(20))),
                        new CompStmt(new VarDeclStmt("a", new RefType(new RefType(new IntType()))),
                                new CompStmt(new New("a", new VarExp("v")),
                                        new CompStmt(new New("v", new ValueExp(new IntValue(30))),
                                                new PrintStmt(new rH(new rH(new VarExp("a")))))))));

        MyIStack<IStmt> stk8 = new MyStack<>();
        MyIList<Value> out8 = new MyList<>();
        MyIDictionary<String, Value> symTbl8 = new MyDictionary<>();
        MyIDictionary<String, BufferedReader> fileTable8 = new MyDictionary<>();
        HeapI<Integer, Value> heap8 = new Heap<>();

        RepoI repo8 = new Repository(filePath);
        Controller controller8 = new Controller(repo8);

        PrgState prgSate8 = new PrgState(stk8, symTbl8, out8, fileTable8, heap8, ex8);
        controller8.addProgState(prgSate8);


        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), controller1));
        menu.addCommand(new RunExample("2", ex2.toString(), controller2));
        menu.addCommand(new RunExample("3", ex3.toString(), controller3));
        menu.addCommand(new RunExample("4", ex4.toString(), controller4));
        menu.addCommand(new RunExample("5", ex5.toString(), controller5));
        menu.addCommand(new RunExample("6", ex6.toString(), controller6));
        menu.addCommand(new RunExample("7", ex7.toString(), controller7));
        menu.addCommand(new RunExample("8", ex8.toString(), controller8));
        menu.show();
    }

}
