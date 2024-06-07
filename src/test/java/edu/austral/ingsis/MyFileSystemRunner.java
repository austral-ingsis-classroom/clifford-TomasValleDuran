package edu.austral.ingsis;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.ArrayList;
import java.util.List;

public class MyFileSystemRunner implements FileSystemRunner {
  private final FileSystem fileSystem;

  public MyFileSystemRunner(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> results = new ArrayList<>();
    for (String command : commands) {
      String result = fileSystem.executeCommand(command);
      results.add(result);
    }
    return results;
  }
}
