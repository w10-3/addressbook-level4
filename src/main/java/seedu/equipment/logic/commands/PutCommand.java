package seedu.equipment.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.equipment.logic.CommandHistory;
import seedu.equipment.logic.commands.exceptions.CommandException;
import seedu.equipment.logic.parser.CliSyntax;
import seedu.equipment.model.Model;
import seedu.equipment.model.WorkListId;
import seedu.equipment.model.equipment.SerialNumber;

/**
 * Put an equipment into a WorkList in the Equipment Manager.
 */
public class PutCommand extends Command {

    public static final String COMMAND_WORD = "put";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Put an equipment into a WorkList in the Equipment Manager. "
            + "Parameters: "
            + CliSyntax.PREFIX_ID + "WORKLISTID "
            + CliSyntax.PREFIX_SERIALNUMBER + "EQUIPMENT \n"
            + "Example: " + COMMAND_WORD + " "
            + CliSyntax.PREFIX_ID + "1 "
            + CliSyntax.PREFIX_SERIALNUMBER + "A008866X ";

    public static final String MESSAGE_SUCCESS = "The equipment added into the worklist: %1$s";
    public static final String MESSAGE_EQUIPMENT_NOT_FOUND = "This equipment serial number is not found.";
    public static final String MESSAGE_WORKLIST_NOT_FOUND = "This worklist id is not found.";

    private final WorkListId id;
    private final SerialNumber sr;

    /**
     * Creates a PutCommand.
     */
    public PutCommand(WorkListId id, SerialNumber sr) {
        requireNonNull(id);
        requireNonNull(sr);
        this.id = id;
        this.sr = sr;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        model.putEquipment(id, sr);

        model.commitEquipmentManager();
        return new CommandResult(String.format(MESSAGE_SUCCESS, id, sr));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PutCommand // instanceof handles nulls
                && id.equals(((PutCommand) other).id)
                && sr.equals(((PutCommand) other).sr));
    }
}
