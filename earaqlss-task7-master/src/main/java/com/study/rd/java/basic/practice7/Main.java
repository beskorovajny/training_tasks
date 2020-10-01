package com..rd.java.basic.practice7;


/**
 * @author besko
 */
public final class Main {

    public static void main(final String[] args) {

        /*GunFactory factory = new GunFactory();
        Guns list = factory.createGuns();

        Gun gun = factory.createGunDesc();

        Range range = factory.createRange();
        range.setEffectiveRange(EffectiveRange.MEDIUM);

        Scope scope = factory.createScope();
        scope.setType(ScopeType.ACOG);

        FireMode fireMode = factory.createFireMode();
        fireMode.setFireMode(FireModeType.AUTO);

        TacticalCharacteristics options = factory.createTacticalCharacteristics();
        options.setEffectiveRange(range);
        options.setScope(scope);
        options.setFireMode(fireMode);

        Gun.MaterialType material = factory.createMaterial();
        material.setMaterial(Material.PLASTIC);

        gun.setModel("M4A1");
        gun.setHandy(2);
        gun.setOrigin("USA");
        gun.setTacticalCharacteristics(options);
        gun.setMaterial(material);

        Gun gun1 = factory.createGunDesc();
        TacticalCharacteristics options1 = factory.createTacticalCharacteristics();
        FireMode fireMode1 = factory.createFireMode();
        Scope scope1 = factory.createScope();
        Range range1 = factory.createRange();
        Gun.MaterialType material1 = factory.createMaterial();
        material1.setMaterial(Material.WOOD);
        fireMode1.setFireMode(FireModeType.SEMI_AUTO);
        scope1.setType(ScopeType.NO_SCOPE);
        range1.setEffectiveRange(EffectiveRange.SHORT);
        options1.setFireMode(fireMode1);
        options1.setScope(scope1);
        options1.setEffectiveRange(range1);
        gun1.setModel("AK-47 beta");
        gun1.setHandy(1);
        gun1.setOrigin("Germany");
        gun1.setTacticalCharacteristics(options1);
        gun1.setMaterial(material1);

        Gun gun2 = factory.createGunDesc();
        TacticalCharacteristics options2 = factory.createTacticalCharacteristics();
        FireMode fireMode2 = factory.createFireMode();
        Scope scope2 = factory.createScope();
        Range range2 = factory.createRange();
        Gun.MaterialType material2 = factory.createMaterial();
        fireMode2.setFireMode(FireModeType.AUTO);
        scope2.setType(ScopeType.NIGHT_VISION_SCOPE);
        range2.setEffectiveRange(EffectiveRange.LONG);
        options2.setEffectiveRange(range2);
        options2.setScope(scope2);
        options2.setFireMode(fireMode2);
        material2.setMaterial(Material.PLASTIC);
        gun2.setModel("SCAR-H");
        gun2.setHandy(2);
        gun2.setOrigin("Belgium");
        gun2.setTacticalCharacteristics(options2);
        gun2.setMaterial(material2);

        list.getGunList().add(gun);
        list.getGunList().add(gun1);
        list.getGunList().add(gun2);


        XmlWriter.write(list, Constants.VALID_XML_FILE);

        list.getGunList().forEach(System.out::println);*/

        String inputFile = args[0];
        Guns guns = DOMController.parse(inputFile,
                GunXmlValidator.validate(inputFile, Constants.XSD_FILE));

        guns.getGunList().forEach(System.out::println);
        SortUtil.sortGunsByModel(guns);
        XmlWriter.write(guns, Constants.OUTPUT_DOM_XML);


        guns = SAXController.parse(inputFile,
                GunXmlValidator.validate(inputFile, Constants.XSD_FILE));
        SortUtil.sortGunsByMaterial(guns);
        XmlWriter.write(guns, Constants.OUTPUT_SAX_XML);
        guns.getGunList().forEach(System.out::println);

        guns = StAXController.parse(inputFile,
                GunXmlValidator.validate(inputFile,Constants.XSD_FILE));

        SortUtil.sortGunsByOrigin(guns);
        guns.getGunList().forEach(System.out::println);
        XmlWriter.write(guns, Constants.OUTPUT_STAX_XML);

        HtmlController.parseToHtml(inputFile,Constants.HTML_FILE,Constants.XSL_FILE);
    }
}
