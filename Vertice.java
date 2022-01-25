import java.util.HashMap;
import java.util.Map;

public class Vertice implements Comparable<Vertice> {
	private Vertice parentForShortest; //parents for shortest path.
	private String name;
	private Integer distance; //total distance from the source.
	private Map<Vertice, Integer> adjacentVertices;
	private Integer edgeDistance; //edge distance between two nodes.
	private boolean ifVisitedForMst;
	private boolean ifVisitedForShortest;
	public Vertice(String name) {
		this.name = name;
		this.distance = Integer.MAX_VALUE;
		this.edgeDistance = Integer.MAX_VALUE;
		this.adjacentVertices = new HashMap<Vertice, Integer>();
		this.ifVisitedForMst = false;
		this.ifVisitedForShortest = false;
	}
	
	public void addConnection(Vertice vertice, int distance) {
		this.adjacentVertices.put(vertice, distance);
		
	}
	
	public boolean getifVisitedForShortest() {
		return ifVisitedForShortest;
	}
	
	public void setifVisitedForShortest(boolean ifVisitedForShortest) {
		this.ifVisitedForShortest = ifVisitedForShortest;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Map<Vertice, Integer> getAdjacentVertices() {
		return adjacentVertices;
	}
	public void setAdjacentVertices(Map<Vertice, Integer> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}
	public void setParent(Vertice parent) {
		this.parentForShortest = parent;
	}
	public Vertice getParent() {
		return parentForShortest;
	}
	
	public Integer getEdgeDistance() {
		return edgeDistance;
	}
	public void setEdgeDistance(Integer edgeDistance) {
		this.edgeDistance = edgeDistance;
	}
	public boolean getifVisitedForMst() {
		return ifVisitedForMst;
	}
	
	public void setifVisitedForMst(boolean ifVisitedForMst) {
		this.ifVisitedForMst = ifVisitedForMst;
	}
	
	public int compareTo(Vertice o) {
		if(this.distance > o.getDistance()) {
			return 1;
		}
		if(this.distance < o.getDistance()) {
			return -1;
		}
		return 0;
	}

	
	
}
