package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Coach {

    private Name name;
    private Unwanted unwanted;
    private final List<String> menus = new ArrayList<>();

    public Coach(Name name) {
        this.name = name;
    }

    public void addUnwanted(Set<String> unwanted) {
        this.unwanted = new Unwanted(unwanted);
    }

    public Set<String> unwanted() {
        return unwanted.unwanted();
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }

    public boolean isExists(String menu) {
        return menus.contains(menu);
    }

    public List<String> menus() {
        return Collections.unmodifiableList(menus);
    }

    public String getName() {
        return name.getName();
    }
}
