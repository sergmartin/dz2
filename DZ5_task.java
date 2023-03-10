package dz2_java;


import java.util.LinkedList;
import java.util.Queue;

public class DZ5_task {
  public static void main(String[] args) {
    var map = getStartMap();

    System.out.println(mapToString(map));

    int[] startPos = getP2D(1, 1);

    WaveAlgorithm(map, startPos);

    System.out.println(mapToString(map));

  }

  public static int[] getP2D(int x, int y) {
    return new int[] { x, y };
  }

  public static int[][] getStartMap() {
    return new int[][] {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
        { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
        { -1, 00, -1, -1, -1, -1, -1, 00, -1 },
        { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
        { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };
  }

  public static String mapToString(int[][] map) {
    StringBuilder sb = new StringBuilder();

    for (int r = 0; r < map.length; r++) {
      for (int co = 0; co < map[r].length; co++) {
        sb.append(String.format("%3d", map[r][co]));
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  public static void WaveAlgorithm(int[][] map, int[] startPos) {

    Queue<int[]> queue = new LinkedList<int[]>();
    queue.add(startPos);
    map[startPos[0]][startPos[1]] = 1;

    while (queue.size() != 0) {
      int[] cur_Pos = queue.remove();
      int pX = cur_Pos[0];
      int pY = cur_Pos[1];

      if (map[pX - 1][pY] == 0) {
        int[] temp = new int[] { pX - 1, pY };
        queue.add(temp);
        map[pX - 1][pY] = map[pX][pY] + 1;
      }
      if (map[pX][pY - 1] == 0) {
        int[] temp = new int[] { pX, pY - 1 };
        queue.add(temp);
        map[pX][pY - 1] = map[pX][pY] + 1;
      }
      if (map[pX + 1][pY] == 0) {
        int[] temp = new int[] { pX + 1, pY };
        queue.add(temp);
        map[pX + 1][pY] = map[pX][pY] + 1;
      }
      if (map[pX][pY + 1] == 0) {
        int[] temp = new int[] { pX, pY + 1 };
        queue.add(temp);
        map[pX][pY + 1] = map[pX][pY] + 1;
      }
    }
  }
}