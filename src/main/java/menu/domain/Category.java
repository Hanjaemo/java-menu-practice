package menu.domain;

public enum Category {

    JAPANESE("일식"), KOREAN("한식"), CHINESE("중식"), ASIAN("아시안"), WESTERN("양식");

    private String value;

    Category(String value) {
        this.value = value;
    }
}
