import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ABCDE {
  public static void main(String[] args) throws IOException {
    String dataFileName = "sortedData.txt"; // Byt mot nästa
    String resultFileName = "descendingData.txt"; // Byt mot nästa av 1-5 eller nästa sortering algorithm

    int[] array = new int[800];

    fillArray(dataFileName, array);

    FileWriter fw = new FileWriter(resultFileName, true);
    for (int i = 799; i >= 0; i--) {
      fw.write(String.format("%d\n", array[i]));
    }
    fw.close();
  }

  private static void fillArray(String name, int[] array) throws FileNotFoundException {
    Scanner scan = new Scanner(new File(name));
    for (int i = 0; i < 800; i++) {
      array[i] = Integer.parseInt(scan.next());
    }
    scan.close();
  }
}
