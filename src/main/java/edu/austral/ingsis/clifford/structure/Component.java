package edu.austral.ingsis.clifford.structure;

public interface Component {
  String getName();

  Component getParent();

  boolean isComposite();
}
