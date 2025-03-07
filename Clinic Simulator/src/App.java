public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Clinic clinic = new Clinic();
        clinic.addPatient(new Patient("Ricardo Forero Ortiz",4265158 , PatientType.NORMAL_ATTENTION));
        clinic.addPatient(new Patient("Ricardo Forero Silva",715712 , PatientType.EMERGENCY_ATTENTION));
        clinic.addPatient(new Patient("Martha Ortiz Cruz",67153761 , PatientType.PRIORITY_ATTENTION));
        clinic.addPatient(new Patient("Danna Bobadilla",42465158 , PatientType.NORMAL_ATTENTION));
        clinic.addPatient(new Patient("Maria Isabel Forero Silva",7125712 , PatientType.EMERGENCY_ATTENTION));
        clinic.addPatient(new Patient("Beatriz Forero Silva",7151712 , PatientType.EMERGENCY_ATTENTION));
        clinic.addPatient(new Patient("Oscar Bravo",7125712 , PatientType.PRIORITY_ATTENTION));


        while (!clinic.isEmpty()) {
            Patient patient  = clinic.attendPatient();
        System.out.println(patient.getName());
        System.out.println(patient.getId());
        }
    }
}
