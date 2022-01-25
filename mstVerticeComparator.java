import java.util.Comparator;

public class mstVerticeComparator implements Comparator<Vertice>{

	public int compare(Vertice o1, Vertice o2) {
		if(o1.getEdgeDistance() > o2.getEdgeDistance()){
			return 1;
		}
		if(o1.getEdgeDistance() < o2.getEdgeDistance()) {
			return -1;
		}
		return 0;
	}

}
