package edu.austral.ingsis.clifford.structure;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Component {
  private final String name;
  private final Directory parent;
  private final List<Component> children;

  public Directory(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
    this.children = new ArrayList<>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isComposite() {
    return true;
  }

  public Directory getParent() {
    return parent;
  }

  public void add(Component component) {
    children.add(component);
  }

  public void remove(String componentName) {
    children.removeIf(component -> component.getName().equals(componentName));
  }

  public List<Component> getChildren() {
    return children;
  }
}
