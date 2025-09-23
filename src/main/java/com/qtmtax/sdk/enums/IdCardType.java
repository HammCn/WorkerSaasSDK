package com.qtmtax.sdk.enums;

import com.qtmtax.sdk.common.interfaces.IDictionary;

/**
 * <h1>证件类型</h1>
 *
 * @author Hamm.cn
 */
public enum IdCardType implements IDictionary {
    /**
     * <h2>中华人民共和国身份证</h2>
     */
    CHINA_ID_CARD(1, "中华人民共和国身份证"),

    /**
     * <h2>护照</h2>
     */
    PASSPORT(2, "护照"),

    /**
     * <h2>港澳通行证</h2>
     */
    HONG_KONG_AND_MACAO_PASSPORT(3, "港澳通行证"),

    /**
     * <h2>台湾通行证</h2>
     */
    TAIWAN_PASSPORT(4, "台湾通行证"),

    /**
     * <h2>中华人民共和国外国人永久居留身份证</h2>
     */
    FOREIGNER_PERMANENT_RESIDENCE_ID_CARD(5, "中华人民共和国外国人永久居留身份证");

    private final int key;
    private final String label;

    IdCardType(int key, String label) {
        this.key = key;
        this.label = label;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
