package ds.graph;


public class App {

	public static void main(String[] args) {

//		Graph myGraph = new Graph(5);
//		myGraph.addEdge(0,1);
//		myGraph.addEdge(0,2);
//		myGraph.addEdge(0,3);
//		myGraph.addEdge(1,2);
//		myGraph.addEdge(1,4);
//		myGraph.addEdge(2,3);
//		myGraph.addEdge(3,1);
//		myGraph.addEdge(4,0);
//		myGraph.addEdge(4,3);
//		
//		Object[] values = myGraph.adj(4);
//		for(Object val : values) {
//			System.out.println(val);
//		}
		
		BetterGraph myGraph = new BetterGraph(5, "directed");
		myGraph.addVertex("State");
		myGraph.addVertex("Avenel");
		myGraph.addVertex("Elm");
		myGraph.addVertex("Pocono");
		myGraph.addVertex("William");
		
		myGraph.addEdge("State", "Avenel");
		myGraph.addEdge("State", "Elm");
		myGraph.addEdge("Elm", "Avenel");
		myGraph.addEdge("Elm", "William");
		myGraph.addEdge("William", "State");
		myGraph.addEdge("William", "Pocono");
		myGraph.addEdge("Avenel", "Pocono");
		myGraph.addEdge("Pocono", "Elm");
		
		myGraph.print();
		
	}

}
