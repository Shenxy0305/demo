package com.example.demo.http.utils.enums;

import java.util.HashMap;
import java.util.Map;

public enum SexEnum {
    WOMAN(0, "女"),
    MAN(1, "男");

    public final Integer code;
    public final String name;
    private static final Map<String, SexEnum> NAME_MAP = new HashMap<>();
    private static final Map<Integer, SexEnum> CODE_MAP = new HashMap<>();

    static {
        for (SexEnum item : SexEnum.values()) {
            NAME_MAP.put(item.name, item);
            CODE_MAP.put(item.code, item);
        }
    }

    public static SexEnum getByName(String name) {
        return NAME_MAP.get(name);
    }

    public static SexEnum getByCode(Integer code) {
        return CODE_MAP.get(code);
    }

    SexEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
