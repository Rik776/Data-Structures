public class Patient {
  private String name;
  private int id;
  private PatientType attention;


public Patient(String name, int id, PatientType attention) {
    this.name = name;
    this.id = id;
    this.attention = attention;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public PatientType getAttention() {
    return attention;
}
public void setAttention(PatientType attention) {
    this.attention = attention;
}   
}
