package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.structure.Directory;

public class MkdirCommand implements Command {
  private final Directory current;
  private final String name;

  public MkdirCommand(Directory current, String name) {
    this.name = name;
    this.current = current;
  }

  @Override
  public String execute() {
    if (name.contains("/") || name.contains(" ")) {
      return "mkdir: invalid file name";
    }
    current
        .getChildren()
        .forEach(
            component -> {
              if (component.getName().equals(name)) {
                current.remove(component.getName());
              }
            });
    current.add(new Directory(name, current));
    return "'" + name + "' directory created";
  }
}
