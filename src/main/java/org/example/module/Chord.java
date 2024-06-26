package org.example.module;

import org.example.mainClasses.NoteOutOfRangeException;

// mutable POJO
public class Chord implements Cloneable {
//    int id;?

    public Key keyRoot; // final
    public Scale keyScale; // final
    private Degree chordDegree; // final
    private MelodicPosition melodicPosition;
    private Spacing spacing;
    private Inversion inversion;
    private ChordType chordType;
    private Alteration alteration;             // for additional features
    private Occurrence occurrence;          // for additional features


    private long tickStartTime;
    private long tickEndTime;

    private int soprano;
    private int alto;
    private int tenor;
    private int bass;




    // constructor for repository creation:
    public Chord(MelodicPosition melodicPosition, Spacing spacing, Inversion inversion, ChordType chordType, Alteration alteration, Occurrence occurrence, 
    int sopranoNote,
    int altoNote,
    int tenorNote,
    int bassNote) {

        this.melodicPosition = melodicPosition;
        this.spacing = spacing;
        this.inversion = inversion;
        this.chordType = chordType;
        this.alteration = alteration;
        this.occurrence = occurrence;
        this.soprano = sopranoNote;
        this.alto = altoNote;
        this.tenor = tenorNote;
        this.bass = bassNote;
    }

//    constructor for adding new Chord object to list in Main class
    public Chord(){}

    // maybe int values in all enums are not needed. but for now I leave it there.
    public void applyKeySwitch(byte KeySwitch){
        switch (KeySwitch){

            case 0: keyRoot = Key.C;       break;
            case 1: keyRoot = Key.C_Sharp; break;
            case 2: keyRoot = Key.D;       break;
            case 3: keyRoot = Key.D_Sharp; break;
            case 4: keyRoot = Key.E;       break;
            case 5: keyRoot = Key.F;       break;
            case 6: keyRoot = Key.F_Sharp; break;
            case 7: keyRoot = Key.G;       break;
            case 8: keyRoot = Key.G_Sharp; break;
            case 9: keyRoot = Key.A;       break;
            case 10: keyRoot = Key.A_Sharp;break;
            case 11: keyRoot = Key.B;      break;

            // Degree and scale:
            case 12: chordDegree = Degree.I;         break;
            case 13: keyScale = Scale.MAJOR_NATURAL; break;
            case 14: chordDegree = Degree.II;        break;
            case 15: keyScale = Scale.MAJOR_HARMONIC;break;
            case 16: chordDegree = Degree.III;       break;
            case 17: chordDegree = Degree.IV;        break;
            case 18: keyScale = Scale.MINOR_NATURAL; break;
            case 19: chordDegree = Degree.V;         break;
            case 20: keyScale = Scale.MINOR_HARMONIC;break;
            case 21: chordDegree = Degree.VI;        break;
            case 22: keyScale = Scale.MINOR_MELODIC; break;
            case 23: chordDegree = Degree.VII;       break;

            // a feature to add
//            case 108: alteration = null; break;
//            case 109: alteration = null; break;
//            case 110: alteration = null; break;
//            case 111: alteration = null; break;

            case 112: melodicPosition = MelodicPosition.I; break;
            case 113: melodicPosition = MelodicPosition.III; break;
            case 114: melodicPosition = MelodicPosition.V; break;
            case 115: melodicPosition = MelodicPosition.VII; break;
            case 116: melodicPosition = MelodicPosition.IX; break;


            case 117: chordType = ChordType.TRIAD;          break;
            case 118: chordType = ChordType.SEVENTH_CHORD;  break;
            case 119: chordType = ChordType.NINTH_CHORD;    break;

            case 120: inversion = Inversion.ROOT_POSITION;   break;
            case 121: inversion = Inversion.FIRST_INVERSION; break;
            case 122: inversion = Inversion.SECOND_INVERSION;break;
            case 123: inversion = Inversion.THIRD_INVERSION; break;

            case 124: spacing = Spacing.CLOSE;    break;
            case 125: spacing = Spacing.OPEN;   break;
            case 126: spacing = Spacing.MIXED_1; break;
            case 127: spacing = Spacing.MIXED_2; break;
        }

    }


    // getters and setters


    public Key getKeyRoot() {
        return keyRoot;
    }

    public void setKeyRoot(Key keyRoot) {
        // todo set tonality attributes only by static Chords.methods


        this.keyRoot = keyRoot;
    }

    public Scale getKeyScale() {
        return keyScale;
    }

    public void setKeyScale(Scale keyScale) {
        this.keyScale = keyScale;
    }

    public ChordType getChordType() {
        return chordType;
    }

    public void setChordType(ChordType chordType) {
        this.chordType = chordType;
    }

    public Degree getChordDegree() {
        return chordDegree;
    }

    public void setChordDegree(Degree chordDegree) {
        this.chordDegree = chordDegree;
    }

    public MelodicPosition getMelodicPosition() {
        return melodicPosition;
    }

    public void setMelodicPosition(MelodicPosition melodicPosition) {
        this.melodicPosition = melodicPosition;
    }

    public Spacing getSpacing() {
        return spacing;
    }

    public void setSpacing(Spacing spacing) {
        this.spacing = spacing;
    }

    public Inversion getInversion() {
        return inversion;
    }

    public void setInversion(Inversion inversion) {
        this.inversion = inversion;
    }

    public ChordType getType() {
        return chordType;
    }

    public void setType(ChordType type) {
        this.chordType = type;
    }

    public Alteration getAlteration() {
        return alteration;
    }

    public void setAlteration(Alteration alteration) {
        this.alteration = alteration;
    }

    public Occurrence getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Occurrence occurrence) {
        this.occurrence = occurrence;
    }

    public long getTickStartTime() {
        return tickStartTime;
    }

    public void setTickStartTime(long tickStartTime) {
        this.tickStartTime = tickStartTime;
    }

    public long getTickEndTime() {
        return tickEndTime;
    }

    public void setTickEndTime(long tickEndTime) {
        this.tickEndTime = tickEndTime;
    }




    public int getSoprano() {
        return soprano;
    }

    public void setSoprano(int soprano) {
        this.soprano = soprano;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor){
        this.tenor = tenor;
    }

    public int getBass() {
        return bass;
    }

    public void setBass(int bass) {
        this.bass = bass;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chord chord = (Chord) o;
        return  keyRoot == chord.keyRoot &&
                keyScale == chord.keyScale &&
                chordDegree == chord.chordDegree &&
                melodicPosition == chord.melodicPosition &&
                spacing == chord.spacing &&
                inversion == chord.inversion &&
                chordType == chord.chordType &&
                alteration == chord.alteration &&
                occurrence == chord.occurrence &&
                tickStartTime == chord.tickStartTime &&
                tickEndTime == chord.tickEndTime;
    }
          
    @Override
    public String toString() {
        return "Chord{" +
                " \n keyRoot =         " + keyRoot +
                " \n keyScale =        " + keyScale +
                " \n chordDegree =     " + chordDegree +
                " \n melodicPosition = " + melodicPosition +
                " \n spacing =         " + spacing +
                " \n inversion =       " + inversion +
                " \n chordType =       " + chordType +
                " \n alteration =      " + alteration +
                " \n occurrence =      " + occurrence +
                " \n tickStartTime =   " + tickStartTime +
                " \n tickEndTime =     " + tickEndTime +
                " \n soprano =         " + soprano +
                " \n alto =            " + alto +
                " \n tenor =           " + tenor +
                " \n bass =            " + bass +
                '}' +
                " \n" +
                " \n";
    }

    @Override
    public Chord clone() {
        Chord clonedChord = this;
        try {
            clonedChord = (Chord) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clonedChord.keyRoot = keyRoot;
        clonedChord.keyScale = keyScale;
        clonedChord.chordDegree = chordDegree;
        clonedChord.melodicPosition = melodicPosition;
        clonedChord.spacing = spacing;
        clonedChord.inversion = inversion;
        clonedChord.chordType = chordType;
        clonedChord.alteration = alteration;
        clonedChord.occurrence = occurrence;

        // clonedChord.tickStartTime = tickStartTime;
        // clonedChord.tickEndTime = tickEndTime;

        return clonedChord;
    }

}

















