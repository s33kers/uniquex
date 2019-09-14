package us.martink.uniquex.api.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public enum SortType {
    BUBBLE("bubble"),
    HEAP("heap"),
    MERGE("merge");

    private String key;

    SortType(String key) {
        this.key = key;
    }
}
