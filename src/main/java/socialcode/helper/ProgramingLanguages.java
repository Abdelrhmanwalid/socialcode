package socialcode.helper;

public enum ProgramingLanguages {
    // dummy
    ONE("One"), TWO("Two");

    private String string;

    ProgramingLanguages(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
