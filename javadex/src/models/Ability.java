package models;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import utils.Constants;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Ability {
    private int id;
    private boolean is_main_series;
    /* private Generation generation;
    private ArrayList<Name> names;
    private ArrayList<VerboseEffect> effect_entries;
    private ArrayList<AbilityEffectChange> effect_changes;
    private ArrayList<AbilityFlavorText> flavor_text_entries;
    private ArrayList<AbilityPokemon> pokemon;

    private static Ability get(String url) {
        Ability obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), Ability.class);
        obj.setIsFetched(true);
        return obj;
    }

    public Ability get() {
        return Ability.get(this.getUrl());
    }

    public static NamedAPIResourceList getList(int limit, int offset) {
        return NamedAPIResourceList.getList("ability", limit, offset);
    }

    public static Ability getById(int id) {
        return get(Constants.URL_BASE + "ability/" + id);
    }

    public static Ability getByName(String name) {
        return get(Constants.URL_BASE + "ability/" + name);
    }
    */
}
