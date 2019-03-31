package seedu.equipment.model.equipment;

import static java.util.Objects.requireNonNull;

import seedu.equipment.commons.util.AppUtil;

/**
 * Represents a Equipment's due date in the equipment book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */
public class Date implements Comparable<Date> {

    public static final String MESSAGE_CONSTRAINTS =
            "Next preventive maintenance due date should only contain alphanumeric characters and spaces, "
                    + "and it should not be blank" + "\n" + "It should be in a format [date] [month] [year].";

    /*
     * The first character of the preventive maintenance date must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Constructs an {@code Date}.
     *
     * @param date A valid date equipment.
     */
    public Date(String date) {
        requireNonNull(date);
        AppUtil.checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS);
        value = date;
    }

    /**
     * Returns if a given string is a valid date.
     */
    public static boolean isValidDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && value.equals(((Date) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int compareTo(Date otherDate) {
        return value.compareTo(otherDate.value);
    }

}
