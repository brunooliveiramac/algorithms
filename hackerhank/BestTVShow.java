import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;



class BestTVShow {

    /*
     * Complete the 'bestInGenre' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING genre as parameter.
     *
     * Base URL: https://jsonmock.hackerrank.com/api/tvseries?page=
     */

    public static String bestInGenre(String genre) {
        try {
            String response;
            int page = 1;
            double highestRating = 0.0;
            String bestSeriesName = "";
            int totalPages = 1; // Default value to enter the loop
            int currentPage = 1;

            while (currentPage <= totalPages) {
                URL url = new URL("https://jsonmock.hackerrank.com/api/tvseries?page=" + currentPage);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                response = in.readLine();
                JSONObject jsonObject = (JSONObject) new JSONParser().parse(response);
                totalPages = ((Long) jsonObject.get("total_pages")).intValue(); // Get the total number of pages from the first page

                JSONArray data = (JSONArray) jsonObject.get("data");
                for (Object obj : data) {
                    JSONObject series = (JSONObject) obj;
                    String[] seriesGenres = ((String) series.get("genre")).split(",\\s*");
                    if (Arrays.asList(seriesGenres).contains(genre)) {
                        double rating = Double.parseDouble(series.get("imdb_rating").toString());
                        String name = (String) series.get("name");
                        if (rating > highestRating || (rating == highestRating && name.compareToIgnoreCase(bestSeriesName) < 0)) {
                            highestRating = rating;
                            bestSeriesName = name;
                        }
                    }
                }
                in.close();
                currentPage++;
            }

            return bestSeriesName;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/brunom/brunooliveiramac/algorithms/hackerhank/result.txt"));

        String genre = bufferedReader.readLine();

        String result = BestTVShow.bestInGenre(genre);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}

