package com.example.pc.booklistingapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class BookLoader extends AsyncTaskLoader<ArrayList<Book>> {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static final String BOOK_REQUEST_URL =
            "https://www.googleapis.com/books/v1/volumes?q=";

    public BookLoader(Context context) {
        super(context);
    }

    @Override
    public ArrayList<Book> loadInBackground() {
        String searchInput = MainActivity.searchData;

        if (searchInput.length() == 0) {
            return null;
        }

        searchInput = searchInput.replace(" ", "+");

        URL url = createUrl(BOOK_REQUEST_URL + searchInput);

        String jsonResponse = "";
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "IOException", e);
        }

        return extractBookInfoFromJson(jsonResponse);
    }

    private URL createUrl(String stringUrl) {
        URL url;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException exception) {
            Log.e(LOG_TAG, "Error with creating URL", exception);
            return null;
        }
        return url;
    }

    private String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.connect();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                    Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
                }
            } catch (IOException e) {
                Log.e(LOG_TAG, "Problem retrieving the book JSON results.", e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private ArrayList<Book> extractBookInfoFromJson(String bookJSON) {
        if (TextUtils.isEmpty(bookJSON)) {
            return null;
        }

        ArrayList<Book> books = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(bookJSON);
            if (baseJsonResponse.getInt("totalItems") == 0) {
                return null;
            }

            JSONArray itemArray = baseJsonResponse.getJSONArray("items");

            for (int i = 0; i < itemArray.length(); i++) {
                JSONObject cuurentItem = itemArray.getJSONObject(i);
                JSONObject bookInfo = cuurentItem.getJSONObject("volumeInfo");

                String title = bookInfo.getString("title");

                String[] authors = new String[]{};
                JSONArray authorJsonArray = bookInfo.optJSONArray("authors");
                if (authorJsonArray != null) {
                    ArrayList<String> authorList = new ArrayList<>();
                    for (int j = 0; j < authorJsonArray.length(); j++) {
                        authorList.add(authorJsonArray.get(j).toString());
                    }
                    authors = authorList.toArray(new String[authorList.size()]);
                }


                String description = "";
                if (bookInfo.optString("description") != null)
                    description = bookInfo.optString("description");

                String infoLink = "";
                if (bookInfo.optString("infoLink") != null)
                    infoLink = bookInfo.optString("infoLink");
                books.add(new Book(title, authors, description, infoLink));
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the book JSON results", e);
        }
        return books;
    }
}

