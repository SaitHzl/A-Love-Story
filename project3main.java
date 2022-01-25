import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class project3main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		double timeLimit = in.nextDouble();
		int numberOfCities = in.nextInt();
		String emptyLine = in.nextLine();
		String mecnunLeylaLines = in.nextLine();
		String lineArray[] = mecnunLeylaLines.split(" ");
		String mecnunsCity = lineArray[0];
		Vertice mecnun = new Vertice(mecnunsCity);
		String leylasCity = lineArray[1];
		Vertice leyla = new Vertice(leylasCity);
		Map<String, Vertice> cities = new HashMap<String, Vertice>();
		cities.put(mecnunsCity, mecnun);
		cities.put(leylasCity, leyla);
		Country country = new Country();
		while(in.hasNextLine()) {
			String lines = in.nextLine();
			lines = lines.strip();
			if(!lines.isEmpty()) {
				String lineArray1[] = lines.split(" ");
				Vertice newCity = null;
				if(!cities.containsKey(lineArray1[0])) {
					newCity = new Vertice(lineArray1[0]);
					cities.put(lineArray1[0], newCity);
				}
				else {
					newCity = cities.get(lineArray1[0]);
				}	
				for(int a = 1; a < lineArray1.length;a++) {
					if(a%2 == 1) {
						Vertice aCity = null;
						if(!cities.containsKey(lineArray1[a])) {
							aCity = new Vertice(lineArray1[a]);
							cities.put(lineArray1[a], aCity);
						}
						else {
							String cityName = lineArray1[a];
							aCity = cities.get(cityName);
							
						}
						
						if(newCity.getAdjacentVertices().containsKey(aCity)) {
							if(Integer.valueOf(lineArray1[a+1]) < newCity.getAdjacentVertices().get(aCity)) {
								newCity.addConnection(aCity, Integer.valueOf(lineArray1[a+1]));
							}
						}
						else {
							newCity.addConnection(aCity, Integer.valueOf(lineArray1[a+1]));
						}
						if(aCity.getName().charAt(0) == 'd') { 
							if(aCity.getAdjacentVertices().containsKey(newCity)) {
								if(Integer.valueOf(lineArray1[a+1]) < aCity.getAdjacentVertices().get(newCity)) {
									aCity.addConnection(newCity, Integer.valueOf(lineArray1[a+1]));
								}
							}
							else {
								aCity.addConnection(newCity, Integer.valueOf(lineArray1[a+1]));
							}
						}
					}
				
			}
				}
		}
		country.shortestPathsFromMecnun(leyla,mecnun);
		List<Vertice> shortestPath = new LinkedList<Vertice>();
		if(country.checkIfPath == 1) {
			Vertice currentVertice = cities.get(leylasCity);
			while(currentVertice != cities.get(mecnunsCity)) {
				currentVertice = currentVertice.getParent();
				shortestPath.add(currentVertice);
			}
			for(int a = shortestPath.size()-1; a > -1; a--) {
				out.print(shortestPath.get(a).getName() + " ");
				
			}
			out.print(cities.get(leylasCity).getName());
			out.println();
			if(leyla.getDistance() > timeLimit) {
				out.print(-1);
				out.close();
			}
			
		}
		else {
			out.print(-1);
			out.println();
			out.print(-1);
			out.close();
		}
		Iterator<Vertice> iter = cities.get(leylasCity).getAdjacentVertices().keySet().iterator();
		while(iter.hasNext()) {
			if(iter.next().getName().charAt(0) == 'c') {
				iter.remove();
			}
		}
		country.MST(leyla);
		int totalCost = 0;
		int a = 0;
		for(String city : cities.keySet()){
			if(city.charAt(0) == 'd') {
				if(cities.get(city).getEdgeDistance() == Integer.MAX_VALUE) {
					a = 1;
					break;
				}
				totalCost += cities.get(city).getEdgeDistance();
			}
			
		}
		if(a == 0) {
			out.print(totalCost*2);
		}
		if(a == 1) {
			out.print(-2);
		}
		
		
	}

	
		
}
	

		
		

