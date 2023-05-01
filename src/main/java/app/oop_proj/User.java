package app.oop_proj;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -1107990144380118002L;
    int ageOfUser;
    int budgetOfUser;
    String nameOfUser;
    public void setMale(boolean male) {
        this.male = male;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public void setNon_binary(boolean non_binary) {
        this.non_binary = non_binary;
    }

    public void setAllergy(boolean allergy) {
        this.allergy = allergy;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

    public void setDisabilities(boolean disabilities) {
        this.disabilities = disabilities;
    }

    public void setLgbt(boolean lgbt) {
        this.lgbt = lgbt;
    }

    public int getAgeOfUser() {
        return ageOfUser;
    }

    public int getBudgetOfUser() {
        return budgetOfUser;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isFemale() {
        return female;
    }

    public boolean isNon_binary() {
        return non_binary;
    }

    public boolean isAllergy() {
        return allergy;
    }

    public boolean isPets() {
        return pets;
    }

    public boolean isChild() {
        return child;
    }

    public boolean isDisabilities() {
        return disabilities;
    }

    public boolean isLgbt() {
        return lgbt;
    }

    boolean male = false;
    boolean female = false;
    boolean non_binary = false;
    boolean allergy = false;
    boolean pets = false;
    boolean child = false;
    boolean disabilities = false;
    boolean lgbt = false;
    public void setSex(String sex) {
        switch (sex) {
            case "Male" -> this.male = true;
            case "Female" -> this.female = true;
            case "Non-binary" -> this.non_binary = true;
        }
    }
    public void setSpecificCharacteristics(String characteristics) {
        switch (characteristics) {
            case "Allergy" -> this.allergy = true;
            case "Pets" -> this.pets = true;
            case "Child" -> this.child = true;
            case "Disabilities" -> this.disabilities = true;
            case "Lgbt" -> this.lgbt = true;
        }
    }

    public void setAgeOfUser(int ageOfUser) {
        this.ageOfUser = ageOfUser;
    }

    public void setBudgetOfUser(int budgetOfUser) {
        this.budgetOfUser = budgetOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String isSpecialties() {
        String data= "";
        if(this.child)
            data += "Have child, some places you can go in just if you 18+.\n";
        if (this.allergy)
            data += "Some places can call an allergy reaction.\n";
        if (this.lgbt)
            data += "LGBTQ+, some grandpas can be dangerous...\n";
        if (this.disabilities)
            data += "Some places which do not provide support for people with disabilities can be inconvenient.\n";
        if (this.pets)
            data += "Some places do not afford to come in with pets, that is why can be problems.\n";
        if(data.equals(""))
            return "This member does not have any alerts.";
        return data;
    }

    public String isSex() {
        if (this.male) {
            return "He is male.";
        } else if (this.female) {
            return "She is female.";
        } else if (this.non_binary) {
            return "Non-binary.";
        } else {
            return "There is some mistakes";
        }
    }
}
