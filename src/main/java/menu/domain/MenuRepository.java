package menu.domain;

import static menu.domain.Category.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menu.MenuConfig;

public class MenuRepository {

    private static final Map<Category, List<String>> menus = new HashMap<>();

    public static void init(MenuConfig menuConfig) {
        menus.put(JAPANESE, menuConfig.getJapaneseMenus());
        menus.put(KOREAN, menuConfig.getKoreanMenus());
        menus.put(CHINESE, menuConfig.getChineseMenus());
        menus.put(ASIAN, menuConfig.getAsianMenus());
        menus.put(WESTERN, menuConfig.getWesternMenus());
    }
}
