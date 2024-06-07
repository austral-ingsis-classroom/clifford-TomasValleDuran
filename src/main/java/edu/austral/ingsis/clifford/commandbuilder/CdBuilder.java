package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.CdCommand;
import edu.austral.ingsis.clifford.commands.Command;

public class CdBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public CdBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String path = commandLine.split(" ")[1];
    return new CdCommand(fileSystem, path);
  }
}
