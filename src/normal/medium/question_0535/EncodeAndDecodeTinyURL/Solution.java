package normal.medium.question_0535.EncodeAndDecodeTinyURL;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Note: This is a companion problem to the System Design problem: <a href="https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/">Design TinyURL</a>.
 * <p>
 * TinyURL is a URL shortening service where you enter a URL such as <a href="https://leetcode.com/problems/design-tinyurl">https://leetcode.com/problems/design-tinyurl</a> and it returns a short URL such as <a href="http://tinyurl.com/4e9iAk">http://tinyurl.com/4e9iAk</a>. Design a class to encode a URL and decode a tiny URL.
 * <p>
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * <p>
 * Implement the Solution class:
 *
 * <li>Solution() Initializes the object of the system.</li>
 * <li>String encode(String longUrl) Returns a tiny URL for the given longUrl.</li>
 * <li>String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.</li>
 *
 * @author Jungle
 * @since 2022/4/23 16:18
 */

public class Solution {

}

class Codec {

    @Test
    public void test() {
        final Codec codec = new Codec();
        final String url = "https://leetcode.com/problems/design-tinyurl";
        final String encode = codec.encode(url);
        System.out.println(encode);
        System.out.println(url);
    }

    Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashCode = longUrl.hashCode();
        map.put(hashCode, longUrl);
        return String.valueOf(hashCode);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int code = Integer.parseInt(shortUrl);
        return map.get(code);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));