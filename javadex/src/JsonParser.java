import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    private static final Pattern REGEX_ITENS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATTRIBUTES_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public static List<Map<String, String>> parse(String json) {
        Matcher matcher = REGEX_ITENS.matcher(json);
        if (!matcher.find()) throw new IllegalArgumentException("No items found");

        var regex = "\\},\\{";
        String itens[] = matcher.group(1).split(regex);

        List<Map<String, String>> dados = new ArrayList<>();

        for(String item: itens){
            Map<String,String> itemAttributes = new HashMap<>();

            Matcher matcherAttributesJson = REGEX_ATTRIBUTES_JSON.matcher(item);
            while(matcherAttributesJson.find()){
                String key = matcherAttributesJson.group(1);
                String value = matcherAttributesJson.group(2);
                itemAttributes.put(key, value);
            }

            dados.add(itemAttributes);
        }

        return dados;
    }
}