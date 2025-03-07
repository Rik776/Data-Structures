public class Clinic {
    private Queue<Patient> normalAttentionPatient;
    private Queue<Patient> priorityAttentionPatient;
    private Queue<Patient> emergencyAttentionPatient;

    public Clinic() {
    normalAttentionPatient = new Queue<Patient>();
    priorityAttentionPatient = new Queue<Patient>();
    emergencyAttentionPatient = new Queue<Patient>();
    }

    public void addPatient(Patient patient){
        switch (patient.getAttention()) {
            case PatientType.NORMAL_ATTENTION:
                normalAttentionPatient.add(patient);
                break;
            case PatientType.PRIORITY_ATTENTION:
                priorityAttentionPatient.add(patient);
                break;
            case PatientType.EMERGENCY_ATTENTION:
                emergencyAttentionPatient.add(patient);
                break;
        }
    }

    public Patient attendPatient (){
        if (emergencyAttentionPatient.isEmpty()) {
            if (priorityAttentionPatient.isEmpty()) {
                if (normalAttentionPatient.isEmpty()) {
                    return null;
                }
                return normalAttentionPatient.get();
            }
            return priorityAttentionPatient.get();
        }
        return emergencyAttentionPatient.get();
    }
    public boolean isEmpty(){
        return (normalAttentionPatient.isEmpty())&&(priorityAttentionPatient.isEmpty())&&(emergencyAttentionPatient.isEmpty());
    }
    
}
