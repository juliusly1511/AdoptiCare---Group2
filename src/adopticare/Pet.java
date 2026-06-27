package adopticare;

public class Pet {

    private int petId;
    private String petName;
    private String species;
    private String breed;
    private int age;
    private String healthCondition;
    private String vaccinationStatus;
    private String lastVaccinationDate;
    private String nextVaccinationSchedule;
    private String adoptionStatus;
    private boolean archived;

    public Pet() {
    }

    public Pet(int petId, String petName,
               String species, String breed,
               int age, String healthCondition,
               String vaccinationStatus, String lastVaccinationDate,
               String nextVaccinationSchedule, String adoptionStatus,
               boolean archived) {
        
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.healthCondition = healthCondition;
        this.vaccinationStatus = vaccinationStatus;
        this.lastVaccinationDate = lastVaccinationDate;
        this.nextVaccinationSchedule = nextVaccinationSchedule;
        this.adoptionStatus = adoptionStatus;
        this.archived = archived;
        
    }
}
