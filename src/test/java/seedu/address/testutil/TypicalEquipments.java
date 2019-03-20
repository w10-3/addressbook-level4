package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SERIAL_NUMBER_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SERIAL_NUMBER_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.EquipmentManager;
import seedu.address.model.equipment.Equipment;

/**
 * A utility class containing a list of {@code Equipment} objects to be used in tests.
 */
public class TypicalEquipments {

    public static final Equipment ANCHORVALECC = new EquipmentBuilder().withName("Anchorvale CC")
            .withAddress("59 Anchorvale Rd, Singapore 544965").withEmail("alice@example.com")
            .withPhone("94351253").withSerialNumber("A008844L").withTags("west").build();
    public static final Equipment HWIYOHCC = new EquipmentBuilder().withName("Hwi Yoh CC")
            .withAddress("535 Serangoon North Ave 4, #01-179, Singapore 550535")
            .withEmail("johnd@example.com").withPhone("98765432").withSerialNumber("A008855L")
            .withTags("urgent", "west").build();
    public static final Equipment TECKGHEECC = new EquipmentBuilder().withName("Teck Ghee CC").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("861 Ang Mo Kio Ave 10, Singapore 569734")
            .withSerialNumber("A0223344X").build();
    public static final Equipment AYERRAJAHCC = new EquipmentBuilder().withName("Ayer Rajah CC")
            .withPhone("87652533").withEmail("cornelia@example.com").withAddress("150 Pandan Gardens, Singapore 609335")
            .withSerialNumber("A008800L").withTags("west").build();
    public static final Equipment BUKITGCC = new EquipmentBuilder().withName("Bukit Gombak CC").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("386 Bukit Batok West Ave 5, Singapore 650386")
            .withSerialNumber("A008811L").build();
    public static final Equipment CHENGSANCC = new EquipmentBuilder().withName("Cheng San CC").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("6 Ang Mo Kio Street 53, Singapore 569205")
            .withSerialNumber("A008822L").build();
    public static final Equipment JURONGREENCC = new EquipmentBuilder().withName("Jurong Green CC").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("6 Jurong West Ave 1, Singapore 649520")
            .withSerialNumber("A008821L").build();

    // Manually added
    public static final Equipment HOON = new EquipmentBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").withSerialNumber("A008834L").build();
    public static final Equipment IDA = new EquipmentBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").withSerialNumber("A008865L").build();

    // Manually added - Equipment's details found in {@code CommandTestUtil}
    public static final Equipment AMY = new EquipmentBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withSerialNumber(VALID_SERIAL_NUMBER_AMY)
            .withTags(VALID_TAG_FRIEND).build();
    public static final Equipment BOB = new EquipmentBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withSerialNumber(VALID_SERIAL_NUMBER_BOB)
            .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();

    public static final String KEYWORD_MATCHING_CC = "CC"; // A keyword that matches MEIER
    public static final String KEYWORD_MATCHING_HWI = "Hwi"; // A keyword that matches Bukit

    private TypicalEquipments() {} // prevents instantiation

    /**
     * Returns an {@code EquipmentManager} with all the typical persons.
     */
    public static EquipmentManager getTypicalAddressBook() {
        EquipmentManager ab = new EquipmentManager();
        for (Equipment equipment : getTypicalPersons()) {
            ab.addPerson(equipment);
        }
        return ab;
    }

    public static List<Equipment> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ANCHORVALECC, HWIYOHCC, TECKGHEECC, AYERRAJAHCC, BUKITGCC, CHENGSANCC,
                JURONGREENCC));
    }
}