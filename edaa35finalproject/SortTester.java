import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SortTester {
  public static void main(String[] args) throws IOException {
    String dataFileName = "descendingData.txt"; // Byt mot nästa
    String resultFileName = "QsortResult5.txt"; // Byt mot nästa av 1-5 eller nästa sortering algorithm
    writeTitel(resultFileName);

    int[] array = new int[800];
    int[] arrayCopy = new int[800];
    fillArray(dataFileName, array);

    FileWriter fw = new FileWriter(resultFileName, true);

    for (int i = 0; i < 600; i++) {
      System.arraycopy(array, 0, arrayCopy, 0, 800);

      long timeStart = System.nanoTime();
      // Arrays.sort(arrayCopy);
      // Bsort.sort(arrayCopy);
      // Isort.sort(arrayCopy);
      Qsort.sort(arrayCopy, 0, 799);
      long timeEnd = System.nanoTime();
      long time = timeEnd - timeStart;
      fw.write(String.format("%d,%d\n", i + 1, (int) time));
    }
    fw.close();
  }

  private static void writeTitel(String name) {
    try {
      FileWriter fw = new FileWriter(name);
      fw.write("Test,Time\n");
      fw.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  private static void fillArray(String name, int[] array) throws FileNotFoundException {
    Scanner scan = new Scanner(new File(name));
    for (int i = 0; i < 800; i++) {
      array[i] = Integer.parseInt(scan.next());
    }
    scan.close();
  }
}
