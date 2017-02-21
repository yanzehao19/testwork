package visitor.pattern;

public interface ComputerPart {
	public void accept(ComputerPartVisitor computerPartVisitor);
}
