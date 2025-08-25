package io.github.protasm.lpcconsole.cmd;

import io.github.protasm.lpcconsole.LPCConsole;

public class CmdQuit extends Command {
	@Override
	public boolean execute(LPCConsole console, String... args) {
		System.out.println("Goodbye.");

		return false;
	}

	@Override
	public String toString() {
		return "Quit";
	}
}
