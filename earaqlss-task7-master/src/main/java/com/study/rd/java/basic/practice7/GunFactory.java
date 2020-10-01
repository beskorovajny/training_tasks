package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * @author besko
 */
@XmlRegistry
public class GunFactory {

    public Gun createGunDesc() {
        return new Gun();
    }

    public TacticalCharacteristics createTacticalCharacteristics() {
        return new TacticalCharacteristics();
    }

    public Scope createScope() {
        return new Scope();
    }

    public Range createRange() {
        return new Range();
    }

    public FireMode createFireMode() {
        return new FireMode();
    }

    public Gun.MaterialType createMaterial() {
        return new Gun.MaterialType();
    }

    public Guns createGuns() {
        return new Guns();
    }


}
