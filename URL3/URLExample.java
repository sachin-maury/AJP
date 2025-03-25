package URL3;

import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {
    public static void main(String[] args) {
        try {
            // Example URL
            URL url = new URL("https://www.example.com:8080/path/to/resource?query=example#reference");

            // Display the components of the URL
            System.out.println("URL: " + url.toString());
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + (url.getPort() != -1 ? url.getPort() : "default port"));
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Reference: " + url.getRef());
        } catch (MalformedURLException e) {
            System.out.println("The URL is malformed: " + e.getMessage());
        }
    }
}

