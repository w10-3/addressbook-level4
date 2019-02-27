package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Before;
import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.equipment.Equipment;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddEquipmentCommand}.
 */
public class AddEquipmentCommandIntegrationTest {

    private Model model;
    private CommandHistory commandHistory = new CommandHistory();

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() {
        Equipment validEquipment = new PersonBuilder().build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addPerson(validEquipment);
        expectedModel.commitAddressBook();

        assertCommandSuccess(new AddEquipmentCommand(validEquipment), model, commandHistory,
                String.format(AddEquipmentCommand.MESSAGE_SUCCESS, validEquipment), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Equipment equipmentInList = model.getAddressBook().getPersonList().get(0);
        assertCommandFailure(new AddEquipmentCommand(equipmentInList), model, commandHistory,
                AddEquipmentCommand.MESSAGE_DUPLICATE_PERSON);
    }

}