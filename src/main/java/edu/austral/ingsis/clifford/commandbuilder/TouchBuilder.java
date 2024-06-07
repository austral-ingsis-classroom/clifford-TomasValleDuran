package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.TouchCommand;

public class TouchBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public TouchBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String name = commandLine.split(" ")[1];
    return new TouchCommand(name, fileSystem.getCurrent());
  }
}
