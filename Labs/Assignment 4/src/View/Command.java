package View;

public abstract class Command {
    private String key, description;

    public Command(String key, String desc){
        this.key = key;
        this.description = desc;
    }

    public abstract void execute();

    public String getKey(){ return key;}

    public String getDescription(){ return description;}
}
