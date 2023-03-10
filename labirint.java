import java.util.*;
import java.util.Queue;

public class labirint {
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};
    private static final char WALL = '#';
    private static final char FREE = '.';
    private static final char VISITED = 'V';
    
    private static class Node {
        int x, y, dist;
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public static int shortestPath(char[][] maze, int startX, int startY, int endX, int endY) {
        int rows = maze.length;
        int columns = maze[0].length;
        Queue<Node>queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, 0));
        maze[startX][startY] = VISITED;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == endX && node.y == endY) {
                return node.dist;
            }
            for (int i = 0; i < 4; i++) {
                int newX = node.x + row[i];
                int newY = node.y + col[i];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < columns && maze[newX][newY] == FREE) {
                    queue.offer(new Node(newX, newY, node.dist + 1));
                    maze[newX][newY] = VISITED;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        char[][] maze = {{'#', '.', '#', '#', '.', '#'},
                        {'.', '.', '.', '#', '.', '#'},
                        {'#', '#', '#', '#', '#', '#'},
                        {'#', '.', '.', '.', '.', '#'},
                        {'#', '#', '#', '#', '.', '#'},
                        {'.', '.', '.', '#', '.', '#'}};
        int startX = 3, startY = 1, endX = 3, endY = 4;
        int shortestPathLength = shortestPath(maze, startX, startY, endX, endY);
        if (shortestPathLength != -1) {
            System.out.println("The shortest path length is: " + shortestPathLength);
        } else {
            System.out.println("No path found from start to end.");
        }
    }
}
