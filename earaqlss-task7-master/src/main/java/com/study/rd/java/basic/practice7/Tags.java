package com..rd.java.basic.practice7;

import java.util.Objects;

/**
 * @author besko
 */
public enum Tags {
    /**
     * all tags
     */
    ACOG("ACOG"),
    AUTO("auto"),
    EFFECTIVE_RANGE("effectiveRange"),
    FIRE_MODE("fireMode"),
    GUN("gun"),
    GUNS("guns"),
    GUN_DESC("gunDescription"),
    HANDY("handy"),
    LONG("1500"),
    MATERIAL("material"),
    MODEL("model"),
    NIGHT_VISION_SCOPE("nightVisionScope"),
    NO_SCOPE("noScope"),
    ORIGIN("origin"),
    PLASTIC("plastic"),
    MEDIUM("1000"),
    SHORT("500"),
    REGULAR("regular"),
    SCOPE("scope"),
    SEMI_AUTO("semi-auto"),
    SNIPER_SCOPE("sniperScope"),
    STEEL("steel"),
    TTC("tacticalCharacteristics"),
    WOOD("wood");

    private final String tagName;

    private Tags(String tagName) {
        this.tagName = tagName;
    }

    public static Tags getByName(String tagName) {
        Tags result = null;
        for (Tags tag : Tags.values()) {
            if (Objects.equals(tagName, tag.tagName)) {
                result = tag;
                break;
            }
        }
        return result;
    }


}
