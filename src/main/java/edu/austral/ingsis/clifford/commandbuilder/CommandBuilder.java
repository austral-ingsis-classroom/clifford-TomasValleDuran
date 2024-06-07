package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.commands.Command;

public interface CommandBuilder {
  Command build(String commandLine);
}
