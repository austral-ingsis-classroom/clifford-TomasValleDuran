package edu.austral.ingsis.clifford.structure;

public class File implements Component {
  private final String name;
  private final Directory parent;

  public File(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isComposite() {
    return false;
  }

  public Directory getParent() {
    return parent;
  }
}
