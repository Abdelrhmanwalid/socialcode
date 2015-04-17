package socialcode.helper;

public enum ProgramingLanguages {
    C("C"),
    Csharp("C#"),
    Cpp("C++"),
    JAVA("Java"),
    OBJECTIVE_C("Objective-C"),
    PHP("PHP"),
    PYTHON("Python"),
    PYTHON_3("Python 3"),
    RUBY("Ruby"),
    SQL("SQL");

    private String string;

    ProgramingLanguages(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
