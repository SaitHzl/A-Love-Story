
import java.util.Map;
import java.util.PriorityQueue;

public class Country {
	int checkIfPath = 0;// this number is 0 if there is no path between leyla and mecnun. Otherwise this number is 1.
	
	//part1
	public void shortestPathsFromMecnun(Vertice Leyla,Vertice Mecnun) {
		Mecnun.setDistance(0);
		PriorityQueue<Vertice> unvisitedVertices = new PriorityQueue<Vertice>(); 
	    unvisitedVertices.add(Mecnun);
	    while(unvisitedVertices.size() != 0) {
	    	Vertice minAdjacent = unvisitedVertices.peek();
	    	if(minAdjacent == Leyla) {
	    		this.checkIfPath = 1;
	    		return;
	    	}
	    	unvisitedVertices.poll();
	    	Map<Vertice, Integer> adjacents = minAdjacent.getAdjacentVertices();
	    	for(Vertice vertices : adjacents.keySet()) {
	    		if(!vertices.getifVisitedForShortest()) {
	    			int connectionWeight = adjacents.get(vertices);
	    			if(minAdjacent.getDistance() + connectionWeight < vertices.getDistance()) {
	    				vertices.setDistance(minAdjacent.getDistance() + connectionWeight);
	    				vertices.setParent(minAdjacent);
	    			}
	    			if(unvisitedVertices.contains(vertices)) {
	    				unvisitedVertices.remove(vertices);
	    			}
	    			unvisitedVertices.add(vertices);
	    		}
	    		
	    	}
	    	minAdjacent.setifVisitedForShortest(true);
	    	
	    }
		
		
	}
	
	
	//part2
	public void MST(Vertice source) {
		source.setEdgeDistance(0);
		PriorityQueue<Vertice> unvisitedVertices = new PriorityQueue<Vertice>(new mstVerticeComparator()); 
		unvisitedVertices.add(source);
		while(unvisitedVertices.size() != 0) {
			Vertice minAdjacent = unvisitedVertices.peek();
			unvisitedVertices.poll();
			minAdjacent.setifVisitedForMst(true);
			Map<Vertice, Integer> adjacents = minAdjacent.getAdjacentVertices();
			for(Vertice vertices : adjacents.keySet()) {
	    		if(!vertices.getifVisitedForMst()) {
	    			if(adjacents.get(vertices) < vertices.getEdgeDistance()) {
	    				vertices.setEdgeDistance(adjacents.get(vertices));
	    			}
	    			if(unvisitedVertices.contains(vertices)) {
	    				unvisitedVertices.remove(vertices);
	    			}
	    			unvisitedVertices.add(vertices);
	    		
	    	}
			
		}
		}
		
		
	}
}
