import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
    private static final Pattern REGEX_ITENS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATTRIBUTES_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public static List<Map<String, String>> parse(String json) {
        Matcher matcher = REGEX_ITENS.matcher(json);
        if (!matcher.find())
            throw new IllegalArgumentException("No items found");

        var regex = "\\},\\{";
        String itens[] = matcher.group(1).split(regex);

        List<Map<String, String>> data = new ArrayList<>();

        for (String item : itens) {
            Map<String, String> itemAttributes = new HashMap<>();

            Matcher matcherAttributesJson = REGEX_ATTRIBUTES_JSON.matcher(item);
            while (matcherAttributesJson.find()) {
                String key = matcherAttributesJson.group(1);
                String value = matcherAttributesJson.group(2);
                itemAttributes.put(key, value);
            }

            data.add(itemAttributes);
        }

        return data;
    }

    public static PokeTest simpleParse(String json) {
        var mapper = new ObjectMapper();
        PokeTest pokeTest = null;
        try {
            pokeTest = mapper.readValue(json, PokeTest.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokeTest;
    }
}
