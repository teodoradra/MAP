package Repository;

import Controller.PrgState;

import java.io.IOException;


public interface RepoI {
    PrgState getCrtPrg();
    void addToRepo(PrgState p);
    void logPrgStateExec() throws IOException;
}
