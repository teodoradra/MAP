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
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OpenFile implements IStmt {
    private Exp fileName;

    public OpenFile(Exp fileNameInput){
        fileName = fileNameInput;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, FileNotFoundException {
        BufferedReader b = null;
        MyIDictionary<String,BufferedReader> fileTable = state.getFileTable();
        MyIDictionary<String,Value> symTbl = state.getSymbolTable();
        HeapI<Integer,Value> heap = state.getHeap();

        Value file = fileName.eval(symTbl,heap);
        if(!file.getType().equals(new StringType()))
            throw new MyException("Var not a string");

        StringValue fileN = (StringValue) file;
        BufferedReader unique = fileTable.get(fileN.getVal());

        if (unique != null)
            throw new MyException("This key already exists");
        try{
            b = new BufferedReader(new FileReader(fileN.getVal()));

        } catch (FileNotFoundException e) {
            throw  new MyException("error while trying to open the file\\n");
        }
        fileTable.add(fileN.getVal(),b);
        return null;
    }

    @Override
    public String toString(){
        return "openFile(" + fileName +  ")";
    }

}
