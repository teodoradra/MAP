package Controller;

import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIList;
import Model.DataStructures.MyIStack;
import Model.ProgramStatement.IStmt;
import Model.Value.Value;
import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Value> symTable;
    private MyIList<Value> out;
    private MyIDictionary<String,BufferedReader> fileTable;
    private HeapI<Integer, Value> heap;

    //IStmt originalProgram;

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Value> symtbl, MyIList<Value> ot,
                    MyIDictionary<String,BufferedReader> fileT,HeapI<Integer,Value> heap, IStmt prg){
        exeStack =stk;
        symTable = symtbl;
        out = ot;
        fileTable = fileT;
        this.heap = heap;
        //originalProgram = deepCopy(prg);   !!! good to implement this
        stk.push(prg);
    }


    public void setExecutionStack(MyIStack<IStmt> executionStack) {
        this.exeStack = executionStack;
    }

    public void setSymbolTable(MyIDictionary<String, Value> symbolTable) {
        this.symTable = symbolTable;
    }

    public void setOutputList(MyIList<Value> outputList) {
        this.out = outputList;
    }

    public void setHeap(HeapI<Integer,Value> newHeap){heap = newHeap;}


    public MyIStack<IStmt> getExecutionStack() {
        return exeStack;
    }

    public MyIList<Value> getOutputList() {
        return out;
    }

    public MyIDictionary<String, Value> getSymbolTable() {
        return symTable;
    }

    public MyIDictionary<String, BufferedReader> getFileTable() {
        return fileTable;
    }

    public HeapI<Integer, Value> getHeap() {
        return heap;
    }



    @Override
    public String toString(){
        return  "Execution Stack : \n" + exeStack.toString() + "\n" +
                "Symbol Table: \n" + symTable.toString() + "\n" +
                "Output List: \n" + out.toString() + "\n"+
                "File Table: \n" + fileTable.toString() + "\n"+
                "Heap: \n" + heap.toString() + "\n";
    }
}
