package menu.domain;

import java.util.Set;

public class Menus {

    private final Set<String> menus;

    public Menus(Set<String> menus) {
        this.menus = menus;
    }

    public boolean contains(String menu) {
        return menus.contains(menu);
    }
}
