
package model;


public class FAMILY {
    
    private int ID;
    private String NAME;
    private String RELATION;
    private int AGE;
    private String GENDER;

    public FAMILY() {
        this.ID = 0;
        this.NAME = "";
        this.RELATION = "";
        this.AGE = 0;
        this.GENDER = "";
    
    public FAMILY(int ID, String NAME, String RELATION, int AGE, String GENDER) {
        this.ID = ID;
        this.NAME = NAME;
        this.RELATION = RELATION;
        this.AGE = AGE;
        this.GENDER = GENDER;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getRELATION() {
        return RELATION;
    }

    public void setRELATION(String RELATION) {
        this.RELATION = RELATION;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    @Override
    public String toString() {
        return "FAMILY{" + "ID=" + ID + ", NAME=" + NAME + ", RELATION=" + RELATION + ", AGE=" + AGE + ", GENDER=" + GENDER + '}';
    }
    
    
    
}
