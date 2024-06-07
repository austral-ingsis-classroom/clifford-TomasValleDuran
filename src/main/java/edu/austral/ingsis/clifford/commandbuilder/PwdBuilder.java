package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.PwdCommand;

public class PwdBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public PwdBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    return new PwdCommand(fileSystem.getCurrent());
  }
}
