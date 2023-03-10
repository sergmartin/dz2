package dz2_java;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Itog_task {
    public static void main(String[] args) {
        Map myMap = new Map();
        myMap.generateStartMap();
        System.out.println(new MapPrinter().mapToString(myMap.getMap()));

        var Algorithm = new Algorithm(myMap.getMap());
        var startPoint = new Po2D(1, 1);
        Algorithm.fillMap(startPoint);

        var finishPoint = new Po2D(6, 4);
        var road = Algorithm.getRoad(finishPoint, startPoint, myMap.getMap());
        for (Po2D coordinate : road) {
            System.out.println(coordinate);
        }
        System.out.println("");
        System.out.println(new MapPrinter().mapToString(myMap.getMap()));
       
        
       
    }
}

class Po2D {
    int x, y;

    public Po2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}

class Map {
    int[][] map;

    public void generateStartMap() {
        int[][] map = {
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

        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

    public void StartPos(Po2D pos) {
        map[pos.x][pos.y] = -2;
    }

    public void ExitPos(Po2D pos) {
        map[pos.x][pos.y] = -3;
    }

}

class MapPrinter {
    public String mapToString(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                sb.append(String.format("%3d", map[r][c]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

class Algorithm {
    int[][] map;

    public Algorithm(int[][] map) {
        this.map = map;
    }
    public ArrayList<Po2D> getRoad(Po2D exit, Po2D start, int[][] map) {
        ArrayList<Po2D> road = new ArrayList<>();
        if (map[exit.x][exit.y] != 0 && map[exit.x][exit.y]!=-1) {
            Po2D current_position = exit;
            road.add(new Po2D(current_position.x, current_position.y));

            System.out.println("Путь:");

            while (map[current_position.x][current_position.y] != map[start.x][start.y]) {

                if (map[current_position.x - 1][current_position.y] == map[current_position.x][current_position.y] - 1) {
                    current_position.x = current_position.x - 1;
                    road.add(new Po2D(current_position.x, current_position.y));
                }

                else if (map[current_position.x][current_position.y - 1] == map[current_position.x][current_position.y] - 1) {
                    current_position.y = current_position.y - 1;
                    road.add(new Po2D(current_position.x, current_position.y));
                }

                else if (map[current_position.x + 1][current_position.y] == map[current_position.x][current_position.y] - 1) {
                    current_position.x = current_position.x + 1;
                    road.add(new Po2D(current_position.x, current_position.y));
                }

                else if (map[current_position.x][current_position.y + 1] == map[current_position.x][current_position.y] - 1) {
                    current_position.y = current_position.y + 1;
                    road.add(new Po2D(current_position.x, current_position.y));
                }
            }

        } else {
            System.out.println("Путь не найден!");
        }
        return road;
    }
    public void fillMap(Po2D startPoint) {
        Queue<Po2D> queue = new LinkedList<Po2D>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;

        while (queue.size() != 0) {
            Po2D p = queue.remove();

            if (map[p.x - 1][p.y] == 0) {
                queue.add(new Po2D(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0) {
                queue.add(new Po2D(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0) {
                queue.add(new Po2D(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0) {
                queue.add(new Po2D(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
        }
    }

    
}