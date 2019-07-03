package other;

import java.util.HashMap;
import java.util.Map;

public class TinyURL {

    Map<String, String> charToStringMap = new HashMap<>();
    Map<String, String> stringToCharMap = new HashMap<>();
    Integer seed1 = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortenedUrl = "http://tinyurl.com/";
        String value = stringToCharMap.get(longUrl);
        if (value == null) {
            String seed = Integer.toString(seed1);
            shortenedUrl += seed;
            charToStringMap.put(seed, longUrl);
            stringToCharMap.put(longUrl, seed);
            seed1++;
        } else {
            shortenedUrl += value;
        }
        return shortenedUrl;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] splitUrl = shortUrl.split("/");
        String encodedValue = splitUrl[splitUrl.length - 1];
        return charToStringMap.get(encodedValue);
    }
}
