public class DrawingBook {
// from - https://www.hackerrank.com/challenges/drawing-book/problem
    int n = 5;
    int p = 3;
    public static void main(String[] args) {
        DrawingBook db = new DrawingBook();
        System.out.println(db.drawBook(5,4));
    }

    public int drawBook(int n, int p) {
        int shortestDistance = Math.min(n-p, p-0);
        int count = 0;

        while(shortestDistance >= 0) {
            System.out.println("Shortest = "+shortestDistance+", count = "+count);
            shortestDistance -= 2;
            if(shortestDistance >= 0)
                count++;
        }
        return count;
    }
}
