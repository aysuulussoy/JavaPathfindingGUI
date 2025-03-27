class BFS {
        // Şehirler arasındaki mesafeleri ve şehir isimlerini tutar
        private int[][] distances; // Ağı temsil eden mesafe matrisi
        private String[] cities;   // Şehirlerin isimlerini tutan dizi

        /**
         * BFS yapıcısı, mesafe matrisi ve şehir isimleri ile başlatılır.
         * @param distances Şehirler arasındaki mesafe matrisi
         * @param cities Şehirlerin isimleri
         */
        public BFS(int[][] distances, String[] cities) {
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
                CustomQueue<Integer> queue = new CustomQueue<>();  // BFS için kuyruk
                int[] distanceFromStart = new int[distances.length]; // Başlangıçtan her şehre olan mesafeler
                int[] parents = new int[distances.length]; // Her şehrin bir önceki şehrini tutar

                // Mesafeleri ve ebeveynleri başlangıç değerlerine ayarla
                for (int i = 0; i < distances.length; i++) {
                        distanceFromStart[i] = Integer.MAX_VALUE; // Başlangıçta tüm mesafeler sonsuz
                        parents[i] = -1; // Başlangıçta tüm şehirlerin ebeveyni yok
                }
                distanceFromStart[startIndex] = 0; // Başlangıç şehrinin kendisine olan mesafesi 0

                queue.enqueue(startIndex); // Kuyruğa başlangıç şehrini ekle
                visited[startIndex] = true; // Başlangıç şehri ziyaret edildi

                // BFS algoritması
                while (!queue.isEmpty()) {
                        int current = queue.dequeue(); // Kuyruktan bir şehir al

                        // Komşuları kontrol et
                        for (int i = 0; i < distances.length; i++) {
                                if (distances[current][i] != 99999 && !visited[i]) { // Eğer komşu mevcutsa ve ziyaret edilmediyse
                                        int newDistance = distanceFromStart[current] + distances[current][i]; // Yeni mesafeyi hesapla
                                        if (newDistance < distanceFromStart[i]) { // Daha kısa bir yol bulduysak
                                                distanceFromStart[i] = newDistance; // Mesafeyi güncelle
                                                parents[i] = current; // Ebeveyni güncelle
                                        }
                                        queue.enqueue(i); // Komşuyu kuyruğa ekle
                                        visited[i] = true; // Ziyaret edildi olarak işaretle
                                }
                        }
                }

                return buildResult(startIndex, endIndex, parents, distanceFromStart); // Sonuç nesnesini oluştur
        }

        /**
         * BFS sonuçlarını oluşturur.
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

                String[] path = new String[cities.length]; // Şehir isimlerinden oluşan yolu tutmak için dizi
                int pathIndex = 0;
                int current = endIndex;

                // Şehirleri ebeveyn dizisinden geriye doğru takip ederek yolu oluştur
                while (current != -1) {
                        path[pathIndex++] = cities[current];
                        current = parents[current];
                }

                // Yolu ters sırada oluştur ve uygun formata getir
                StringBuilder resultPath = new StringBuilder();
                for (int i = pathIndex - 1; i >= 0; i--) {
                        resultPath.append(path[i]);
                        if (i != 0) {
                                resultPath.append(" -> ");
                        }
                }

                return new Result(resultPath.toString(), distances[endIndex]); // Yol ve mesafeyi içeren sonucu döndür
        }
}