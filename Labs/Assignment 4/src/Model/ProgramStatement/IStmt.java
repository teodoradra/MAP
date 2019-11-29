package Model.ProgramStatement;

import Controller.PrgState;
import Model.MyException;

import java.io.FileNotFoundException;

public interface IStmt {
    PrgState execute(PrgState state) throws MyException, FileNotFoundException;
    //which is the execution method for a statement.
}
