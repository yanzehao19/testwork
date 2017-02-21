package visitor.pattern;

import org.apache.coyote.http11.filters.VoidInputFilter;

public class Monitor implements ComputerPart {
@Override
public void accept(ComputerPartVisitor computerPartVisitor){
	computerPartVisitor.visit(this);
}
}
