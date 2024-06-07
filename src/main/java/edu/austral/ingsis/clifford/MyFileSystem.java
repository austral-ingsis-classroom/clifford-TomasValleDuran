package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commandbuilder.*;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.structure.Directory;
import java.util.HashMap;
import java.util.Map;

public class MyFileSystem implements FileSystem {
  private final Directory root;
  private Directory current;
  private final Map<String, CommandBuilder> commands;

  public MyFileSystem() {
    this.root = new Directory("/", null);
    this.current = root;
    this.commands = makeCommands();
  }

  private Map<String, CommandBuilder> makeCommands() {
    Map<String, CommandBuilder> map = new HashMap<>();
    map.put("pwd", new PwdBuilder(this));
    map.put("mkdir", new MkdirBuilder(this));
    map.put("rm", new RmBuilder(this));
    map.put("touch", new TouchBuilder(this));
    map.put("ls", new LsBuilder(this));
    map.put("cd", new CdBuilder(this));
    return map;
  }

  @Override
  public void setCurrent(Directory current) {
    this.current = current;
  }

  @Override
  public Directory getCurrent() {
    return current;
  }

  @Override
  public Directory getRoot() {
    return root;
  }

  @Override
  public String executeCommand(String command) {
    String commandName = command.split(" ")[0];
    Command commandToExecute = commands.get(commandName).build(command);
    return commandToExecute.execute();
  }
}
