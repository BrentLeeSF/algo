import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/** Graph with BFS, DFS and Topological Sort 
 * 
 * BFS - https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * DFS - https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 *  
 * */

public class Graph {
	
	private int numberOfVerticies;
	private LinkedList<Integer> adjacencyList[];
	
	
	/** Create Adjaceny List for graph */
	public Graph(int numberOfVerticies) {
		
		this.numberOfVerticies = numberOfVerticies;
		adjacencyList = new LinkedList[numberOfVerticies];
		
		for(int i = 0; i < numberOfVerticies; ++i) {
			adjacencyList[i] = new LinkedList();
		}
	}
	
	
	/** Add edge at specified vertex */
	public void addEdge(int vertex, int neighbor) {
		adjacencyList[vertex].add(neighbor);
		System.out.println("NewVertex "+vertex+", Neighbor "+neighbor);
	}
	
	
	/** Prints Graph from a given start point
	 * BFS - Start closest to root. Uses a Queue (FIFO).
	 * This is slower and requires more memory. 
	 * This algorithm works in single stage.
	 * The visited verticies are removed from the queue, then displayed */
	public void BFS(int start) {
		
		
		/** Mark all the vertices as not visited(By default set as false) */
		boolean[] visited = new boolean[numberOfVerticies];
		
		/** Create a queue for BFS */
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		/** Mark the current node as visited and enqueue (add) it */
		visited[start] = true;
		queue.add(start);
		
		
		while(queue.size() != 0) {
			
			/** Dequeue a vertex from queue and print it 
			 * poll() Retrieves and removes the head (first element) of list. */
			start = queue.poll();
			System.out.print(start+", ");
			
			
			/** Get all adjacent verticies of the dequeued vertex 
			 * if adjacent vertex has not been visited, then mark it visited and enqueue it */
			Iterator<Integer> adjacentVertex = adjacencyList[start].listIterator();
			
			while(adjacentVertex.hasNext()) {
				int nextAdjacentVertext = adjacentVertex.next();
				
				if(!visited[nextAdjacentVertext]) {
					visited[nextAdjacentVertext] = true;
					queue.add(nextAdjacentVertext);
				}
			}
		}
	}
	
	
	
	public void DFSUtil(int start, boolean visited[]) {
		
		/** Mark current Vertex as visited and print */
		visited[start] = true;
		System.out.print(start+", ");
		
		/** Recursion for all vertices adjacent to this vertex */
		Iterator<Integer> vertexIterator = adjacencyList[start].listIterator();
		
		while(vertexIterator.hasNext()) {
			int vertex = vertexIterator.next();
			if(!visited[vertex]) {
				DFSUtil(vertex, visited);
			}
		}
	}
	
	
	/** DFS Traversal */
	public void DFS(int start) {
		
		boolean[] visited = new boolean[numberOfVerticies];
		DFSUtil(start, visited);
	}
	
	

	public void topologicalSortUtil(int start, boolean[] visited, Stack stack) {
		
		/** Mark current vertex as visited*/
		visited[start] = true;
		int vertex;
		
		/** Recursion for all the vertices adjacent to this vertex */
		Iterator<Integer> iterator = adjacencyList[start].iterator();
		
		while(iterator.hasNext()) {
			vertex = iterator.next();
			if(!visited[vertex]) {
				topologicalSortUtil(vertex, visited, stack);
			}
		}
		
		stack.push(start);
	}
	
	
	/** Topological Sort 
	 * Recursively calls topologicalSortUtil() */
	public void topologicalSort() {
		
		Stack stack = new Stack();
		
		boolean[] visited = new boolean[numberOfVerticies];
		for(int i = 0; i < numberOfVerticies; i++) {
			visited[i] = false;
		}
		
		/** Call the recursive helper function to store.
		 * Topological Sort starting from all vertices one by one */
		for(int i = 0; i < numberOfVerticies; i++) {
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		
		/** Print contents of stack */
		while(!stack.empty()) {
			System.out.print(stack.pop()+", ");
		}
	}
	

	public static void main(String[] args) {
		
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		/** 
		 *  -0----->1  
		 *  | ^	   ^
		 *  | |   /
		 *  | |  /
		 *  v | /     	
		 *S->2----->3<->  */
 
		System.out.println("\nFollowing is Breadth First Traversal (BFS) "+ "(starting from vertex 2)");
		graph.BFS(2);
		/** Prints 2, 0, 3, 1 */
        
		System.out.println("\n\nFollowing is Depth First Traversal (DFS) "+ "(starting from vertex 2)");
		graph.DFS(2);
		/** Prints 2, 0, 1, 3 */
        
		System.out.println("\n\nFollowing is a Topological sort of the given graph"); 
		graph.topologicalSort();
		System.out.println("\n");
        
		Graph g = new Graph(6); 
		g.addEdge(5, 2); 
		g.addEdge(2, 3); 
		g.addEdge(3, 1); 
		g.addEdge(4, 0); 
		g.addEdge(5, 0); 
		g.addEdge(4, 1);

		System.out.println("\nFollowing is a Topological sort of the given graph"); 
		g.topologicalSort();

		System.out.println("\n\nFollowing is Breadth First Traversal (BFS) "+ "(starting from vertex 2)");
		g.BFS(2);
		
		System.out.println("\n\nFollowing is Depth First Traversal (DFS) "+ "(starting from vertex 2)");
		g.DFS(2);

	}

}
