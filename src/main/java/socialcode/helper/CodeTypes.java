package socialcode.helper;

public enum CodeTypes {
    // dummy
    ONE("One"), TWO("Two");

    private String string;

    CodeTypes(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
