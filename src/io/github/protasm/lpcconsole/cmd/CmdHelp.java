package io.github.protasm.lpcconsole.cmd;

import io.github.protasm.lpcconsole.LPCConsole;

public class CmdHelp extends Command {
	@Override
	public boolean execute(LPCConsole console, String... args) {
		LPCConsole.commands().forEach((cmd, aliases) -> {
			System.out.printf("%-20s -> %s%n", String.join(", ", aliases), cmd);
		});

		return true;
	}

	@Override
	public String toString() {
		return "Display list of available commands";
	}
}
