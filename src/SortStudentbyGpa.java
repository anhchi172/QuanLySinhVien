import java.util.Comparator;

public class SortStudentbyGpa implements Comparator<StudentFix> {
    @Override
    public int compare(StudentFix a, StudentFix b){
        if (a.getGpa() > b.getGpa()){
            return 1;
        }
        return -1;
    }
}
