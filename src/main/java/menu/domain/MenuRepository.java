package menu.domain;

import static menu.domain.Category.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import menu.MenuConfig;

public class MenuRepository {

    private static final Map<Category, Menus> menusByCategory = new HashMap<>();

    public static void init(MenuConfig menuConfig) {
        menusByCategory.put(JAPANESE, new Menus(menuConfig.getJapaneseMenus()));
        menusByCategory.put(KOREAN, new Menus(menuConfig.getKoreanMenus()));
        menusByCategory.put(CHINESE, new Menus(menuConfig.getChineseMenus()));
        menusByCategory.put(ASIAN, new Menus(menuConfig.getAsianMenus()));
        menusByCategory.put(WESTERN, new Menus(menuConfig.getWesternMenus()));
    }

    public static boolean contains(String menu) {
        List<Menus> values = menusByCategory.values()
                .stream()
                .collect(Collectors.toUnmodifiableList());

        return values.stream()
                .anyMatch(menus -> menus.contains(menu));
    }

    public static List<String> get(Category category) {
        return toList(menusByCategory.get(category));
    }

    private static ArrayList<String> toList(Menus menus) {
        return new ArrayList<>(menus.getMenus());
    }
}
