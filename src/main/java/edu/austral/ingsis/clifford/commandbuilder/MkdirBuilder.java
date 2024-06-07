package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.MkdirCommand;

public class MkdirBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public MkdirBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    return new MkdirCommand(fileSystem.getCurrent(), commandLine.split(" ")[1]);
  }
}
