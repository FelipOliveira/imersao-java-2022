package models;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Constants;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class NamedAPIResourceList {
    private int count;
    private String next;
    private String previous;
    private ArrayList<NamedAPIResource> results;

    private static NamedAPIResourceList get(String url) throws IOException {
        return new ObjectMapper().readValue(new URL(url), NamedAPIResourceList.class);
    }

    public static NamedAPIResourceList getList(String endpoint, int limit, int offset) throws IOException {
        String json = Constants.URL_BASE + endpoint +
                Constants.LIMIT + Math.abs(limit) + Constants.OFFSET + Math.abs(offset);
        return new ObjectMapper().readValue(new URL(json), NamedAPIResourceList.class);
    }

    public static NamedAPIResourceList getByEndpoint(String endpoint) throws IOException {
        return get(Constants.URL_BASE + endpoint);
    }
}
