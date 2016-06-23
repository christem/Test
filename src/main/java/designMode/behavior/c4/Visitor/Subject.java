package designMode.behavior.c4.Visitor;

public interface Subject {
    public void accept(Visitor visitor);

    public String getSubject();
}
