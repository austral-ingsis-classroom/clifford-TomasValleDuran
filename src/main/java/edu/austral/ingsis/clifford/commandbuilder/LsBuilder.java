package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.LsCommand;

public class LsBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public LsBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String[] parts = commandLine.split(" ");
    if (parts.length == 2) {
      return new LsCommand(fileSystem.getCurrent(), parts[1].split("=")[1]);
    } else {
      return new LsCommand(fileSystem.getCurrent());
    }
  }
}
