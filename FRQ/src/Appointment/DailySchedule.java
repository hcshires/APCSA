package Appointment;

import java.util.ArrayList;

/**
 * A DailySchedule object contains a list of non-overlapping Appointment objects.
 * The DailySchedule class contains methods to clear all appointments that conflict
 * with a given appointment and to add an appointment to the schedule.
 */
public class DailySchedule {

    private ArrayList<Appointment> apptList;

    /**
     * Constructs a new DailySchedule with an empty list of appointments
     */
    public DailySchedule() {
        apptList = new ArrayList<Appointment>();
    }

    /**
     * Removes all appointments that overlap the given Appointment
     * Postcondition: all appointments that have a time conflict
     * with appt have been removed from this DailySchedule
     * @param appt the appointment to remove overlapping appointments from
     */
    public void clearConflicts(Appointment appt) {
        for (int i = 0; i < apptList.size(); i++) {
            if (appt.conflictsWith(apptList.get(i))) {
                apptList.remove(i);
                i--; // prevents skipping side-by-side conflicts in the ArrayList
            }
        }
    }

    /**
     * Add an appointment to this DailySchedule if emergency is true or if there are no conflicting appointments.
     * If emergency is true, all overlapping appointments are cleared before adding the appointment
     * @param appt the Appointment to be added
     * @param emergency if the appointment to be added is an emergency
     * @return true if the appointment was added, otherwise false
     */
    public boolean addAppt(Appointment appt, boolean emergency) {
        if (emergency) {
            clearConflicts(appt);
        } else {
            for (int i = 0; i < apptList.size(); i++) {
                if (appt.conflictsWith(apptList.get(i))) {
                    return false;
                }
            }
        }
        apptList.add(appt);
        return true;
    }

    // There may be fields, constructors, and methods that are not shown
}
