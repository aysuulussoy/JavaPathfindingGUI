class CSVReader {
    private String[] cities; // Array to store city names
    private int[][] distances; // 2D array to store distances between cities
    private int cityCount; // Number of cities




    /**
     * Constructor to initialize the CSVReader by reading a CSV file.
     * @param filePath Path to the CSV file
     */
    public CSVReader(String filePath) {
        try {


            // Create a BufferedReader to read the file
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filePath));
            String line = reader.readLine(); // Read the first line (header with city names)





            // Extract city names from the header row
            String[] headers = line.split(","); // Split the header row by commas
            cityCount = headers.length - 1; // Exclude the first column header
            cities = new String[cityCount]; // Initialize the city array
            distances = new int[cityCount][cityCount]; // Initialize the distance matrix

            // Populate the city names array
            for (int i = 1; i <= cityCount; i++) {
                cities[i - 1] = headers[i].trim(); // Trim whitespace and assign city names
            }





            // Read distances row by row
            int row = 0;
            while ((line = reader.readLine()) != null) { // Read each line of the CSV file
                String[] parts = line.split(","); // Split the line by commas
                for (int col = 1; col <= cityCount; col++) {
                    distances[row][col - 1] = Integer.parseInt(parts[col].trim()); // Parse distances as integers
                }
                row++; // Move to the next row
            }

            reader.close(); // Close the file after reading
        } catch (Exception e) {
            // Handle exceptions during file reading
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }




    /**
     * Get the index of a city by its name.
     * @param city The name of the city
     * @return The index of the city, or -1 if not found
     */
    public int getCityIndex(String city) {
        for (int i = 0; i < cityCount; i++) { // Loop through all cities
            if (cities[i].equals(city)) { // Check if the city name matches
                return i; // Return the index of the city
            }
        }
        return -1; // Return -1 if the city is not found
    }

    /**
     * Get the array of city names.
     * @return Array of city names
     */
    public String[] getCities() {
        return cities; // Return the city names array
    }

    /**
     * Get the distance matrix.
     * @return 2D array of distances between cities
     */
    public int[][] getDistances() {
        return distances; // Return the distance matrix
    }
}
