package enums;

public enum ServiceMenuEnum {
    SUPPORT("Support"),
    Dates("Dates"),
    ComplexTable("Complex Table"),
    SimpleTable("Simple Table"),
    TableWithPages("Table with pages"),
    DifferentElements("Different elements");

    public String text;

    ServiceMenuEnum(String text) {
        this.text = text;
    }
}
