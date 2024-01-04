package org.example.mainClasses;

import org.example.module.Chord;
import org.example.module.ChordRepository;
import org.example.module.Scale;

import java.util.ArrayList;
import java.util.List;

// This is a helper class with static methods on Chord objects

public class Chords {

    /* logic:
    filter chordRepository by chord "type"
    filter chordRepository by "chordDegree"
    filter chordRepository by "inversion"
    filter chordRepository by "alteration"
    if specified - filter chordRepository by "melodicPosition"
    if specified - filter chordRepository by "spacing"
    if specified - filter chordRepository by "inversion"


    check for parallels and other forbidden moves.
    last operation - transpose chosen chords in C to the "keyRoot"
    */

    // filter chords by keySwitches:
    public static ArrayList<Chord> filterByKeyswithch(ArrayList<Chord> allChords) {
        var filteredChords = new ArrayList<Chord>();
        allChords.stream().filter(a-> true);

        return filteredChords;
    }

    // add methods to cast int to enums using switch statement

    /* todo:- Отложить гармонизацию голосов на потом. Сейчас просто соеденять указанные аккорды.
            - Все указанные в учебнике ВИДЫ СОЕДЕНЕНИЙ долджны быть
        организованы в виде методов в этом вспомогательном классе,
        а не в виде enum как в других случаях.
            - Также должно быть учтено всё что связано с понятием "Приготовление"
            - Additional methods for each alteration. Do not take a altered chord.
            - inside a connection method, add an option to lower bass one octave lower.
            it will reduce the repository twice. If between tenor and bass is exact octave -
            raise bass octave higher in the repository.
            - add an operation to change octave of the whole chord if the previous chord is
            significantly far from current or next by all voices.

     */

    /*
    here is how to cast int to enum:

    public enum MyEnum {
    EnumValue1,
    EnumValue2;

    public static MyEnum fromInteger(int x) {
        switch(x) {
        case 0:
            return EnumValue1;
        case 1:
            return EnumValue2;
        }
        return null;
    }
}
     */
    public static int relativizeNote(Scale scale, int chordDegree, int octave) {

        int[] I = new int[]{24, 36, 48, 60, 72, 84, 96};
        int[] II = new int[]{26, 38, 50, 62, 74, 86, 98};
        int[] IIIb = new int[]{27, 39, 51, 63, 75, 87, 99};
        int[] III = new int[]{28, 40, 52, 64, 76, 88, 100};
        int[] IV = new int[]{29, 41, 53, 65, 77, 89, 101};
        int[] V = new int[]{31, 43, 55, 67, 79, 91, 103};
        int[] VIb = new int[]{32, 44, 56, 68, 80, 92, 104};
        int[] VI = new int[]{33, 45, 57, 69, 81, 93, 105};
        int[] VIIb = new int[]{34, 46, 58, 70, 82, 94, 106};
        int[] VII = new int[]{35, 47, 59, 71, 83, 95, 107};

        int[] outputNotesArray = new int[7];

        if (scale.ordinal() == 13) {                      // major natural
            outputNotesArray = switch (chordDegree) {
                default -> I;
                case 14 -> II;
                case 16 -> III;
                case 17 -> IV;
                case 19 -> V;
                case 21 -> VI;
                case 23 -> VII;
            };
        } else if (scale.ordinal() == 15) {                      // major harmonic
            outputNotesArray = switch (chordDegree) {
                default -> I;
                case 14 -> II;
                case 16 -> III;
                case 17 -> IV;
                case 19 -> V;
                case 21 -> VIb;
                case 23 -> VII;
            };
        } else if (scale.ordinal() == 18) {                      // minor natural
            outputNotesArray = switch (chordDegree) {
                default -> I;
                case 14 -> II;
                case 16 -> IIIb;
                case 17 -> IV;
                case 19 -> V;
                case 21 -> VIb;
                case 23 -> VIIb;
            };
        } else if (scale.ordinal() == 20) {                      // minor harmonic
            outputNotesArray = switch (chordDegree) {
                default -> I;
                case 14 -> II;
                case 16 -> IIIb;
                case 17 -> IV;
                case 19 -> V;
                case 21 -> VIb;
                case 23 -> VII;
            };
        } else if (scale.ordinal() == 22) {                      // ascending minor melodic. descending should be natural.
            outputNotesArray = switch (chordDegree) {
                default -> I;
                case 14 -> II;
                case 16 -> IIIb;
                case 17 -> IV;
                case 19 -> V;
                case 21 -> VI;
                case 23 -> VII;
            };
        }




        // returns the specific note on MIDI message as int from string argument
        return outputNotesArray[octave] + scale.ordinal();
    }
}
