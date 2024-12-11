package me.ajax.boorus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

class NetUtils {

    static String read(final String urlPlain) throws URISyntaxException, IOException {
        final URL url = new URI(urlPlain).toURL();
        final URLConnection connection = url.openConnection();

        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.3");

        connection.connect();

        final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        final StringBuilder outputBuilder = new StringBuilder();

        String curLine;
        while ((curLine = reader.readLine()) != null)
            outputBuilder.append(curLine).append("\n");

        return outputBuilder.toString();
    }

}
