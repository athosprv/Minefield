
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{

    private static int startX = 0;
    private static int startY = 0;
    private static String[][] landscape;// = new String[dims][dims];
    private static int[][] distance;
    private static String[][] color;
    private static String[][] parent;
    private static Queue<indexObj> Q = new LinkedList();// = new Queue();
    private static int dims = 0;

    public static void run(BufferedReader in, PrintWriter out)
            throws IOException
    {
        action(in, out);
    }

    public static void action(BufferedReader in, PrintWriter out) throws IOException
    {
        buildTable(in);
        BFS();
        findPath(out);
        printTable();
    }

    public static void buildTable(BufferedReader in) throws IOException
    {
        dims = Integer.parseInt(in.readLine());
        int mines = Integer.parseInt(in.readLine());

        landscape = new String[dims][dims];
        distance = new int[dims][dims];
        color = new String[dims][dims];
        parent = new String[dims][dims];

        String n = in.readLine();

        Scanner sc = new Scanner(n).useDelimiter(" ");
        for (int i = 0; i < mines; i++)
        {
            int x = sc.nextInt();
            while (sc.hasNext())
            {
                int y = sc.nextInt();
                //   System.out.println(x + " " + y);
                landscape[x][y] = "*";
                color[x][y] = "B";
                distance[x][y] = 0;
                parent[x][y] = "NIL";
            }
            n = in.readLine();
            sc = new Scanner(n).useDelimiter(" ");
        }

        startX = sc.nextInt();
        startY = sc.nextInt();
        landscape[startX][startY] = "S";

        n = in.readLine();
        sc = new Scanner(n).useDelimiter(" ");

        int endX = sc.nextInt();
        int endY = sc.nextInt();        
        landscape[endX][endY] = "E";
        color[endX][endY] = "G";
        distance[endX][endY] = 0;
        parent[endX][endY] = "NIL";

        System.out.println("Table Values Initialized!");
    }

    private static void BFS()
    {
        for (int i = 0; i < landscape.length; i++)
        {
            for (int j = 0; j < landscape.length; j++)
            {
                if (landscape[i][j] == null)
                {
                    color[i][j] = "W";
                    distance[i][j] = 0;
                    parent[i][j] = "NIL";
                    landscape[i][j] = "O";
                }
            }
        }

        color[startX][startY] = "G";
        distance[startX][startY] = 0;
        parent[startX][startY] = "NIL";

        indexObj obj = new indexObj(startX, startY);
        Q.add(obj);

        while (Q.size() != 0)
        {
            obj = new indexObj(Q.peek().x, Q.peek().y);
            Q.poll();

            int i = 0, j = 0;
            String path = "";
            while (true)
            {
                if (i == 0 && j == 0)
                {
                    j = 1;
                  //  path = "L";
                } else if (i == 0 && j == 1)
                {
                    j = -1;
                  //  path = "R";
                } else if (i == 0 && j == -1)
                {
                    i = 1;
                    j = 0;
                  //  path = "D";
                } else if (i == 1 && j == 0)
                {
                    i = -1;
                  //  path = "U";
                } else
                {
                    i = 0;
                    j = 0;
                    path = "";
                    break;
                }
                path = "0";
                int var1 = obj.x + i;
                int var2 = obj.y + j;

                if (var1 < dims && var2 < dims && var1 > -1 && var2 > -1)
                {
                    if (color[var1][var2].equals("W") && landscape[var1][var2].equals("O"))
                    {
                        landscape[var1][var2] = path;
                        color[var1][var2] = "G";
                        distance[var1][var2] = distance[obj.x][obj.y] + 1;
                        parent[var1][var2] = obj.x + "," + obj.y;
                        indexObj obj1 = new indexObj(var1, var2);
                        Q.add(obj1);
                    }
                }
            }
            color[obj.x][obj.y] = "B";
        }
        System.out.println("Breadth First Algorithm Applied!");
    }
    private static void findPath(PrintWriter out)
    {
        System.out.println("Optimal Path not yet found!");
    }

    public static void printTable()
    {
        for (int i = 0; i< color.length; i++)
        {
            for (int j = 0; j< color.length; j++)
            {
                System.out.print(parent[i][j] + "|");
            }
            System.out.println();
        }
    }


    private static class indexObj
    {
        public int x = 0;
        public int y = 0;

        public indexObj(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
