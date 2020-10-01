package com..rd.java.basic.practice7;

/**
 * The exception is thrown when a value
 * of a tag or an attribute is invalid.
 *
 * @author besko
 */
public class IllegalXmlException extends Exception {

    private static final long serialVersionUID = 1L;
    private final String element;
    private final boolean isAttribute;

    public IllegalXmlException(String value,
                               String element,
                               boolean isAttribute) {
        super(value);
        this.element = element;
        this.isAttribute = isAttribute;
    }

    @Override
    public String getMessage() {
        return "Value " + super.getMessage() +
                " is incorrect for " + (isAttribute ? "attribute" : "element") +
                element;
    }

}
