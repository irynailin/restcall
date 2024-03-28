package net.restcall.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import net.restcall.gui.actions.request.AddQueryParamAction;

public class CommandAction extends AbstractAction {
	
	private final int commandId;
	private final CommandExecutor commandExecutor;
	
	public CommandAction(int commandId, String name, String icon, CommandExecutor commandExecutor) {
		super("", new ImageIcon(AddQueryParamAction.class.getResource(icon)));
		this.commandExecutor = commandExecutor;
		putValue(SHORT_DESCRIPTION, name);
		this.commandId = commandId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		commandExecutor.execute(commandId);
		
	}
}
