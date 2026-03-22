import java.util.Locale;
import java.util.ResourceBundle;

public class Local {
    public static ResourceBundle getBundle(String lang) {
        return ResourceBundle.getBundle("messages",
                Locale.forLanguageTag(lang),
                new ResourceBundle.Control() {
                    @Override
                    public java.io.Reader newReader(java.io.InputStream stream, String encoding)
                            throws java.io.IOException {
                        return new java.io.InputStreamReader(stream,
                                java.nio.charset.StandardCharsets.UTF_8);
                    }
                });
    }
}