package seedu.equipment.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.equipment.logic.CommandHistory;
import seedu.equipment.logic.commands.exceptions.CommandException;
import seedu.equipment.logic.parser.CliSyntax;
import seedu.equipment.model.Model;
import seedu.equipment.model.equipment.Equipment;

/**
 * Adds an equipment to the equipment book.
 */
public class AddEquipmentCommand extends Command {

    public static final String COMMAND_WORD = "add-e";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an equipment to the Equipment Manager. "
            + "Parameters: "
            + CliSyntax.PREFIX_NAME + "NAME "
            + CliSyntax.PREFIX_PHONE + "PHONE "
            + CliSyntax.PREFIX_EMAIL + "EMAIL "
            + CliSyntax.PREFIX_ADDRESS + "ADDRESS "
            + CliSyntax.PREFIX_SERIALNUMBER + "SERIAL NUMBER "
            + "[" + CliSyntax.PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + CliSyntax.PREFIX_NAME + "John Doe "
            + CliSyntax.PREFIX_PHONE + "98765432 "
            + CliSyntax.PREFIX_EMAIL + "johnd@example.com "
            + CliSyntax.PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + CliSyntax.PREFIX_SERIALNUMBER + "A008866X "
            + CliSyntax.PREFIX_TAG + "west "
            + CliSyntax.PREFIX_TAG + "urgent";

    public static final String MESSAGE_SUCCESS = "New equipment added: %1$s";
    public static final String MESSAGE_DUPLICATE_EQUIPMENT = "Duplicated equipment serial number, "
            + "this equipment already exists in the equipment manager.";

    private final Equipment toAdd;

    /**
     * Creates an AddEquipmentCommand to add the specified {@code Equipment}
     */
    public AddEquipmentCommand(Equipment equipment) {
        requireNonNull(equipment);
        toAdd = equipment;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        if (model.hasEquipment(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_EQUIPMENT);
        }

        model.addEquipment(toAdd);
        model.commitEquipmentManager();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddEquipmentCommand // instanceof handles nulls
                && toAdd.equals(((AddEquipmentCommand) other).toAdd));
    }
}