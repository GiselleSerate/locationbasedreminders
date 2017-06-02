package com.example.cssummer17.autofillplacetypes.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by cssummer17 on 6/2/17.
 */

public class NetworkUtils {

    final static String GITHUB_BASE_URL =
            "https://maps.googleapis.com/maps/api/place/nearbysearch";

    final static String PARAM_FORMAT = "json";

    final static String PARAM_KEY = "key";
    final static String key = "AIzaSyAja6UlAzBSDYIgLJ1RCCHd6fVf9NN6V7Q";

    final static String PARAM_LOCATION = "location";
    final static String location = "-33.8670522,151.1957362"; // lat/long of the thing.

    final static String PARAM_RADIUS = "radius";
    final static String radius = "500";


    final static String PARAM_TYPE = "type";
    final static String type = "restaurant";


//    of form https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=YOUR_API_KEY

    /**
     * Builds the URL used to query GitHub.
     * @return The URL to use to query the GitHub.
     */
    public static URL buildUrl() {
        Uri builtUri = Uri.parse(GITHUB_BASE_URL).buildUpon()
                .appendPath(PARAM_FORMAT)
                .appendQueryParameter(PARAM_LOCATION, location)
                .appendQueryParameter(PARAM_KEY, key)
                .appendQueryParameter(PARAM_RADIUS, radius)
                .appendQueryParameter(PARAM_TYPE, type)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}
