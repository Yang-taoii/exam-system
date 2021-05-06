package com.exam.enums;

import java.util.HashMap;
import java.util.Map;
/**
 * 积分商城 商品类别
 *      1.电脑
 *      2.手机
 *      3.平板电脑
 */
public enum ProdClassEnum {

    Computer(1, "电脑"),
    Phone(2, "手机"),
    Ipad(3, "平板电脑");

    int code;
    String name;

    ProdClassEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, UserStatusEnum> keyMap = new HashMap<>();

    static {
        for (UserStatusEnum item : UserStatusEnum.values()) {
            keyMap.put(item.getCode(), item);
        }
    }

    public static UserStatusEnum fromCode(Integer code) {
        return keyMap.get(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
