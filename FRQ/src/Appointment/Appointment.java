package Appointment;

/**
 * An Appointment object contains a time interval for the
 * appointment and a method that determines if there is a
 * time conflict between the current appointment and another appointment.
 */
public class Appointment {

    /**
     * @return the time interval of this appointment
     */
    public TimeInterval getTime() {
        /* Implementation not shown */
        return null;
    }

    /**
     * Checks if the time interval of this appointment overlaps with the time interval of other
     * @param other another Appointment
     * @return true if the time interval of this overlaps with other, otherwise false
     */
    public boolean conflictsWith(Appointment other) {
        return this.getTime().overlapsWith(other.getTime());
    }

    // There may be fields, constructors, and methods that are not shown.
}
