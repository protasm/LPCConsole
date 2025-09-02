package io.github.protasm.lpcconsole.cmd;

import io.github.protasm.lpc2j.fs.FSSourceFile;
import io.github.protasm.lpcconsole.LPCConsole;

public class CmdLoad extends Command {
	@Override
	public boolean execute(LPCConsole console, String... args) {
		System.out.println("Load");

		if (args.length == 0) {
			System.out.println("Error: No file specified.");

			return true;
		}

		String vPathStr = pathStrOfArg(console.vPath(), args[0]);
		FSSourceFile sf = console.load(vPathStr);

		if (sf == null) {
			return true;
		}

		console.objects().put(sf.dotName(), sf.lpcObject());

		System.out.println(sf.dotName() + " loaded.");

		return true;
	}

	@Override
	public String toString() {
		return "Load <source file>";
	}
}
