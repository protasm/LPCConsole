package io.github.protasm.lpcconsole.cmd;

import io.github.protasm.lpc2j.console.Console;
import io.github.protasm.lpc2j.fs.FSSourceFile;
import io.github.protasm.lpc2j.parser.ast.visitor.PrintVisitor;

public class CmdParse extends Command {
    @Override
    public boolean execute(Console console, String... args) {
	System.out.println("Parse");

	if (args.length < 1) {
	    System.out.println("Error: No file specified.");

	    return true;
	}

	String vPathStr = pathStrOfArg(console.vPath(), args[0]);
	FSSourceFile sf = console.parse(vPathStr);

	if (sf == null)
	    return true;

	sf.astObject().accept(new PrintVisitor());

	return true;
    }

    @Override
    public String toString() {
	return "Parse <source file>";
    }
}
