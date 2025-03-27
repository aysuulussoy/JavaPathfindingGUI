class DFS {
    // Şehirler arasındaki mesafeleri ve şehir isimlerini tutar
    private int[][] distances; // Ağı temsil eden mesafe matrisi
    private String[] cities;   // Şehirlerin isimlerini tutan dizi

    /**
     * DFS yapıcısı, mesafe matrisi ve şehir isimleri ile başlatılır.
     * @param distances Şehirler arasındaki mesafe matrisi
     * @param cities Şehirlerin isimleri
     */
    public DFS(int[][] distances, String[] cities) {
        this.distances = distances;
        this.cities = cities;
    }

    /**
     * Başlangıç ve hedef şehir indeksleri arasında en kısa yolu bulur.
     * @param startIndex Başlangıç şehrinin indeksi
     * @param endIndex Hedef şehrin indeksi
     * @return En kısa yolun mesafesi ve yolu içeren bir Result nesnesi
     * Zaman Karmaşıklığı: O(V + E) (V: Şehir sayısı, E: Yol sayısı)
     */
    public Result findShortestPath(int startIndex, int endIndex) {
        boolean[] visited = new boolean[distances.length]; // Ziyaret edilen şehirleri takip eder
        CustomStack<Integer> stack = new CustomStack<>();  // DFS için yığın
        int[] distanceFromStart = new int[distances.length]; // Başlangıçtan her şehre olan mesafeler
        int[] parents = new int[distances.length]; // Her şehrin bir önceki şehrini tutar

        // Mesafeleri ve ebeveynleri başlangıç değerlerine ayarla
        for (int i = 0; i < distances.length; i++) {
            distanceFromStart[i] = Integer.MAX_VALUE; // Başlangıçta tüm mesafeler sonsuz
            parents[i] = -1; // Başlangıçta tüm şehirlerin ebeveyni yok
        }
        distanceFromStart[startIndex] = 0; // Başlangıç şehrinin kendisine olan mesafesi 0

        stack.push(startIndex); // Yığına başlangıç şehrini ekle

        // DFS algoritması
        while (!stack.isEmpty()) {
            int current = stack.pop(); // Yığından bir şehir al

            // Zaten ziyaret edildiyse işlemi atla
            if (visited[current]) continue;
            visited[current] = true; // Şehri ziyaret edildi olarak işaretle

            // Komşuları kontrol et
            for (int i = 0; i < distances.length; i++) {
                if (distances[current][i] != 99999 && !visited[i]) { // Eğer komşu mevcutsa ve ziyaret edilmediyse
                    int newDistance = distanceFromStart[current] + distances[current][i]; // Yeni mesafeyi hesapla
                    if (newDistance < distanceFromStart[i]) { // Daha kısa bir yol bulduysak
                        distanceFromStart[i] = newDistance; // Mesafeyi güncelle
                        parents[i] = current; // Ebeveyni güncelle
                    }
                    stack.push(i); // Komşuyu yığına ekle
                }
            }
        }

        return buildResult(startIndex, endIndex, parents, distanceFromStart); // Sonuç nesnesini oluştur
    }

    /**
     * DFS sonuçlarını oluşturur.
     * @param startIndex Başlangıç şehrinin indeksi
     * @param endIndex Hedef şehrin indeksi
     * @param parents Hedef şehre ulaşan yolun ebeveyn dizisi
     * @param distances Şehirler arasındaki en kısa mesafeler
     * @return Result nesnesi (yol ve mesafe)
     */
    private Result buildResult(int startIndex, int endIndex, int[] parents, int[] distances) {
        if (distances[endIndex] == Integer.MAX_VALUE) {
            return new Result(null, -1); // Eğer mesafe sonsuz ise, yol bulunamadı
        }

        java.util.LinkedList<String> path = new java.util.LinkedList<>();
        int current = endIndex;

        // Şehirleri ebeveyn dizisinden geriye doğru takip ederek yolu oluştur
        while (current != -1) {
            path.addFirst(cities[current]);
            current = parents[current];
        }

        return new Result(String.join(" -> ", path), distances[endIndex]); // Yol ve mesafeyi içeren sonucu döndür
    }
}

/**
 * Yol ve mesafe sonuçlarını temsil eder.
 */
class Result {
    private String path;  // En kısa yol
    private int distance; // En kısa mesafe

    public Result(String path, int distance) {
        this.path = path;
        this.distance = distance;
    }

    public String getPath() {
        return path; // Yol bilgisi döndürülür
    }

    public int getDistance() {
        return distance; // Mesafe bilgisi döndürülür
    }
}