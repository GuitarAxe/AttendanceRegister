package mateuszaksjonow.Attendance;


import mateuszaksjonow.Participants.Participant;

import java.util.LinkedHashMap;
import java.util.Map;

public class AttendanceEntries {

    private String date;
    private String subject;
    private Map<Participant, Boolean> participantMap;

    public AttendanceEntries(String date, String subject) {
        this.date = date;
        this.subject = subject;
        participantMap = new LinkedHashMap<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<Participant, Boolean> getParticipantMap() {
        return participantMap;
    }

    public void setParticipantMap(Map<Participant, Boolean> participantMap) {
        this.participantMap = participantMap;
    }
}
