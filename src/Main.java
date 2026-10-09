import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {


    static final int SELESAI = -1;


    static int indexGrade(int nilai) {
        if (nilai >= 90) return 0; // A
        if (nilai >= 80) return 1; // B
        if (nilai >= 70) return 2; //C
        if (nilai >= 60) return 3; // D
        return 4;                  // E

