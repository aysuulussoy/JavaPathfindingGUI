public class Main {
    public static void main(String[] args) {
        // Mesafe matrisi ve şehir isimlerini okuyun
        String filePath = "src/resources/Turkish_cities.csv";
        CSVReader reader = new CSVReader(filePath);

        String[] cities = reader.getCities();
        int[][] distances = reader.getDistances();

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while(true){
            System.out.println("Choice 1: Istanbul and Trabzon\nChoice 2: Izmir and Diyarbakir\nChoice 3: Gaziantep and Istanbul\nChoice 4: Antalya and Malatya\nChoice 5: Mersin and Urfa\nChoice 6: Samsun and Denizli\nChoice 7: Trabzon and Izmir\nChoice 8: Batman and Ankara\nEnter your choice: ");
            int choice=scanner.nextInt();
            if(choice==1){
                long startTime1 = System.nanoTime();
                String startCity="Istanbul";
                String endCity="Trabzon";
                int startIndex = reader.getCityIndex(startCity);
                int endIndex = reader.getCityIndex(endCity);
                BFS bfs = new BFS(distances, cities);
                Result bfsResult = bfs.findShortestPath(startIndex, endIndex);
                if (bfsResult.getDistance() != -1) {
                    System.out.println("BFS Shortest Path: " + bfsResult.getPath());
                    System.out.println("BFS Total Distance: " + bfsResult.getDistance());
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime1;
                    System.out.println("BFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using BFS.");
                }
                long startTime2 = System.nanoTime();
                DFS dfs = new DFS(distances, cities);
                Result dfsResult = dfs.findShortestPath(startIndex, endIndex);
                if (dfsResult.getDistance() != -1) {
                    System.out.println("DFS Shortest Path: " + dfsResult.getPath());
                    System.out.println("DFS Total Distance: " + dfsResult.getDistance()+"\n");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime2;
                    System.out.println("DFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using DFS.");
                }
            } else if (choice==2) {
                long startTime1 = System.nanoTime();
                String startCity="Izmir";
                String endCity="Diyarbakir";
                int startIndex = reader.getCityIndex(startCity);
                int endIndex = reader.getCityIndex(endCity);
                BFS bfs = new BFS(distances, cities);
                Result bfsResult = bfs.findShortestPath(startIndex, endIndex);
                if (bfsResult.getDistance() != -1) {
                    System.out.println("BFS Shortest Path: " + bfsResult.getPath());
                    System.out.println("BFS Total Distance: " + bfsResult.getDistance());
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime1;
                    System.out.println("BFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using BFS.");
                }
                long startTime2 = System.nanoTime();
                DFS dfs = new DFS(distances, cities);
                Result dfsResult = dfs.findShortestPath(startIndex, endIndex);
                if (dfsResult.getDistance() != -1) {
                    System.out.println("DFS Shortest Path: " + dfsResult.getPath());
                    System.out.println("DFS Total Distance: " + dfsResult.getDistance()+"\n");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime2;
                    System.out.println("DFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using DFS.");
                }
            }else if(choice==3){
                long startTime1 = System.nanoTime();
                String startCity="Gaziantep";
                String endCity="Istanbul";
                int startIndex = reader.getCityIndex(startCity);
                int endIndex = reader.getCityIndex(endCity);
                BFS bfs = new BFS(distances, cities);
                Result bfsResult = bfs.findShortestPath(startIndex, endIndex);
                if (bfsResult.getDistance() != -1) {
                    System.out.println("BFS Shortest Path: " + bfsResult.getPath());
                    System.out.println("BFS Total Distance: " + bfsResult.getDistance());
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime1;
                    System.out.println("BFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using BFS.");
                }
                long startTime2 = System.nanoTime();
                DFS dfs = new DFS(distances, cities);
                Result dfsResult = dfs.findShortestPath(startIndex, endIndex);
                if (dfsResult.getDistance() != -1) {
                    System.out.println("DFS Shortest Path: " + dfsResult.getPath());
                    System.out.println("DFS Total Distance: " + dfsResult.getDistance()+"\n");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime2;
                    System.out.println("DFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using DFS.");
                }
            }else if(choice==4){
                long startTime1 = System.nanoTime();
                String startCity="Antalya";
                String endCity="Malatya";
                int startIndex = reader.getCityIndex(startCity);
                int endIndex = reader.getCityIndex(endCity);
                BFS bfs = new BFS(distances, cities);
                Result bfsResult = bfs.findShortestPath(startIndex, endIndex);
                if (bfsResult.getDistance() != -1) {
                    System.out.println("BFS Shortest Path: " + bfsResult.getPath());
                    System.out.println("BFS Total Distance: " + bfsResult.getDistance());
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime1;
                    System.out.println("BFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using BFS.");
                }
                long startTime2 = System.nanoTime();
                DFS dfs = new DFS(distances, cities);
                Result dfsResult = dfs.findShortestPath(startIndex, endIndex);
                if (dfsResult.getDistance() != -1) {
                    System.out.println("DFS Shortest Path: " + dfsResult.getPath());
                    System.out.println("DFS Total Distance: " + dfsResult.getDistance()+"\n");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime2;
                    System.out.println("DFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using DFS.");
                }
            }else if(choice==5){
                long startTime1 = System.nanoTime();
                String startCity="Mersin";
                String endCity="Urfa";
                int startIndex = reader.getCityIndex(startCity);
                int endIndex = reader.getCityIndex(endCity);
                BFS bfs = new BFS(distances, cities);
                Result bfsResult = bfs.findShortestPath(startIndex, endIndex);
                if (bfsResult.getDistance() != -1) {
                    System.out.println("BFS Shortest Path: " + bfsResult.getPath());
                    System.out.println("BFS Total Distance: " + bfsResult.getDistance());
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime1;
                    System.out.println("BFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using BFS.");
                }
                long startTime2 = System.nanoTime();
                DFS dfs = new DFS(distances, cities);
                Result dfsResult = dfs.findShortestPath(startIndex, endIndex);
                if (dfsResult.getDistance() != -1) {
                    System.out.println("DFS Shortest Path: " + dfsResult.getPath());
                    System.out.println("DFS Total Distance: " + dfsResult.getDistance()+"\n");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime2;
                    System.out.println("DFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using DFS.");
                }
            }else if(choice==6){
                long startTime1 = System.nanoTime();
                String startCity="Samsun";
                String endCity="Denizli";
                int startIndex = reader.getCityIndex(startCity);
                int endIndex = reader.getCityIndex(endCity);
                BFS bfs = new BFS(distances, cities);
                Result bfsResult = bfs.findShortestPath(startIndex, endIndex);
                if (bfsResult.getDistance() != -1) {
                    System.out.println("BFS Shortest Path: " + bfsResult.getPath());
                    System.out.println("BFS Total Distance: " + bfsResult.getDistance());
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime1;
                    System.out.println("BFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using BFS.");
                }
                long startTime2 = System.nanoTime();
                DFS dfs = new DFS(distances, cities);
                Result dfsResult = dfs.findShortestPath(startIndex, endIndex);
                if (dfsResult.getDistance() != -1) {
                    System.out.println("DFS Shortest Path: " + dfsResult.getPath());
                    System.out.println("DFS Total Distance: " + dfsResult.getDistance()+"\n");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime2;
                    System.out.println("DFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using DFS.");
                }
            }else if(choice==7){
                long startTime1 = System.nanoTime();
                String startCity="Trabzon";
                String endCity="Izmir";
                int startIndex = reader.getCityIndex(startCity);
                int endIndex = reader.getCityIndex(endCity);
                BFS bfs = new BFS(distances, cities);
                Result bfsResult = bfs.findShortestPath(startIndex, endIndex);
                if (bfsResult.getDistance() != -1) {
                    System.out.println("BFS Shortest Path: " + bfsResult.getPath());
                    System.out.println("BFS Total Distance: " + bfsResult.getDistance());
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime1;
                    System.out.println("BFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using BFS.");
                }
                long startTime2 = System.nanoTime();
                DFS dfs = new DFS(distances, cities);
                Result dfsResult = dfs.findShortestPath(startIndex, endIndex);
                if (dfsResult.getDistance() != -1) {
                    System.out.println("DFS Shortest Path: " + dfsResult.getPath());
                    System.out.println("DFS Total Distance: " + dfsResult.getDistance()+"\n");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime2;
                    System.out.println("DFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using DFS.");
                }
            }else if(choice==8){
                long startTime1 = System.nanoTime();
                String startCity="Batman";
                String endCity="Ankara";
                int startIndex = reader.getCityIndex(startCity);
                int endIndex = reader.getCityIndex(endCity);
                BFS bfs = new BFS(distances, cities);
                Result bfsResult = bfs.findShortestPath(startIndex, endIndex);
                if (bfsResult.getDistance() != -1) {
                    System.out.println("BFS Shortest Path: " + bfsResult.getPath());
                    System.out.println("BFS Total Distance: " + bfsResult.getDistance());
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime1;
                    System.out.println("BFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using BFS.");
                }
                long startTime2 = System.nanoTime();
                DFS dfs = new DFS(distances, cities);
                Result dfsResult = dfs.findShortestPath(startIndex, endIndex);
                if (dfsResult.getDistance() != -1) {
                    System.out.println("DFS Shortest Path: " + dfsResult.getPath());
                    System.out.println("DFS Total Distance: " + dfsResult.getDistance()+"\n");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime2;
                    System.out.println("DFS Time: "+duration+" nanoseconds\n");
                } else {
                    System.out.println("No path found using DFS.");
                }
            }else
                System.out.println("invalid choice\n");
        }
    }
}