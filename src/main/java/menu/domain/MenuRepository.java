package menu.domain;

import static menu.domain.Category.*;

import java.util.HashMap;
import java.util.Map;

import menu.MenuConfig;

public class MenuRepository {

    private static final Map<Category, Menus> menus = new HashMap<>();

    public static void init() {
        menus.put(JAPANESE, new Menus(MenuConfig.getJapaneseMenus()));
        menus.put(KOREAN, new Menus(MenuConfig.getKoreanMenus()));
        menus.put(CHINESE, new Menus(MenuConfig.getChineseMenus()));
        menus.put(ASIAN, new Menus(MenuConfig.getAsianMenus()));
        menus.put(WESTERN, new Menus(MenuConfig.getWesternMenus()));
    }
}
