package com.example.Auto2.dto.track;

public class Commands {
    boolean IsTurnFor;
    boolean IsCongestion;
    boolean IsUphillFor;

    public boolean isTurnFor() {
        return IsTurnFor;
    }

    public void setTurnFor(boolean turnFor) {
        IsTurnFor = turnFor;
    }

    public boolean isCongestion() {
        return IsCongestion;
    }

    public void setCongestion(boolean congestion) {
        IsCongestion = congestion;
    }

    public boolean isUphillFor() {
        return IsUphillFor;
    }

    public void setUphillFor(boolean uphillFor) {
        IsUphillFor = uphillFor;
    }

    public Commands(boolean IsTurnFor) {
        this.IsTurnFor=IsTurnFor;
    }
}
