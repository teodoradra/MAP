package Model.File;

import Controller.PrgState;
import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.Expressions.Exp;
import Model.MyException;
import Model.ProgramStatement.IStmt;
import Model.Type.StringType;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseFile implements IStmt {
    private Exp file;

    public CloseFile(Exp cf){file = cf;}

    @Override
    public PrgState execute(PrgState prgState) throws MyException{
        MyIDictionary<String,Value> symTbl = prgState.getSymbolTable();
        MyIDictionary<String, BufferedReader> fileTable = prgState.getFileTable();
        HeapI<Integer,Value> heap = prgState.getHeap();

        Value uniq = file.eval(symTbl,heap);
        if(!uniq.getType().equals(new StringType()))
            throw new MyException("Var not a string");

        StringValue file = (StringValue) uniq;
        BufferedReader b = fileTable.get(file.getVal());

        try{
            b.close();
        } catch (IOException e) {
            throw new MyException("Cannot close file!\n");
        }
        fileTable.remove(file.getVal());
        return prgState;
    }

    @Override
    public String toString() {
        return " closeFile(" + file.toString() + ")";
    }
}
