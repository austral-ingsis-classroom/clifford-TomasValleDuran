package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.structure.Component;
import edu.austral.ingsis.clifford.structure.Directory;

public class RmCommand implements Command {
  private final Directory current;
  private final String name;
  private final boolean recursive;

  public RmCommand(Directory current, String name, boolean recursive) {
    this.current = current;
    this.recursive = recursive;
    if (name.isEmpty()) {
      this.name = current.getChildren().get(0).getName();
    } else {
      this.name = name;
    }
  }

  @Override
  public String execute() {
    for (Component component : current.getChildren()) {
      if (component.getName().equals(name)) {
        if (component.isComposite() && recursive) {
          current.remove(name);
          return "'" + name + "' removed";
        } else if (!component.isComposite()) {
          current.remove(name);
          return "'" + name + "' removed";
        } else {
          return "cannot remove '" + component.getName() + "', is a directory";
        }
      }
    }
    return "cannot remove '" + name + "', no such file or directory";
  }
}
