package homeworks.hw3.enums;


public enum PageMainData {
    URL("https://epam.github.io/JDI/index.html"),
    PAGE_TITLE("Home Page"),
    FIRST_MAIN_HEADER_TEXT("EPAM FRAMEWORK WISHES…"),
    SECOND_MAIN_HEADER_TEXT("LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
            "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
            "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
            "CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER_TEXT("JDI GITHUB"),
    SUB_HEADER_LINK("https://github.com/epam/JDI");


    private String text;

    PageMainData(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
