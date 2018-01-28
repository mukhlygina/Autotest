package enums;

public enum PageTextEnum {
    HOME_PAGE("EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT" +
            " UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI" +
            " UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM" +
            " DOLORE EU FUGIAT NULLA PARIATUR.");

    public String mainHeader;
    public String mainText;

    PageTextEnum(String mainHeader, String mainText) {
        this.mainHeader = mainHeader;
        this.mainText = mainText;
    }
}

