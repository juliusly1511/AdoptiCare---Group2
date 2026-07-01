package model;

public class Vaccination {
    
    private int vaccinationId;
    private int petId;
    private String vaccineName;
    private String lastVaccinationDate;
    private String nextVaccinationSchedule;
    

    public int getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(int vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getLastVaccinationDate() {
        return lastVaccinationDate;
    }

    public void setLastVaccinationDate(String lastVaccinationDate) {
        this.lastVaccinationDate = lastVaccinationDate;
    }

    public String getNextVaccinationSchedule() {
        return nextVaccinationSchedule;
    }

    public void setNextVaccinationSchedule(String nextVaccinationSchedule) {
        this.nextVaccinationSchedule = nextVaccinationSchedule;
    }
}
