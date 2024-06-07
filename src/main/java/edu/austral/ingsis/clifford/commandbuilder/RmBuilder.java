package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.RmCommand;

public class RmBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public RmBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String[] command = commandLine.split(" ");
    if (command.length == 2) {
      return new RmCommand(fileSystem.getCurrent(), command[1], false);
    } else if (command.length == 3 && command[1].equals("--recursive")) {
      return new RmCommand(fileSystem.getCurrent(), command[2], true);
    }
    return new RmCommand(fileSystem.getCurrent(), "", false);
  }
}
