package Repository;

import Controller.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repository implements RepoI {
    private List<PrgState> repo;
    private String logFilePath;

    public Repository(String lfp){
        repo = new ArrayList<>();
        logFilePath = lfp;
    }

    @Override
    public PrgState getCrtPrg() {
        return repo.get(repo.size()-1);
    }

    @Override
    public void addToRepo(PrgState p){
        repo.add(p);
    }

    @Override
    public void logPrgStateExec() throws IOException {
        PrintWriter logFile;
        logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath,true)));
        for (PrgState prgState : repo) {
            logFile.append(prgState.toString());
        }
        logFile.close();
    }
}
