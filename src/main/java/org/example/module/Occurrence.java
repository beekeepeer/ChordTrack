package org.example.module;


/*
Value of this enum reflects how often the chord or chord connection is used in music compositional practice.

It should be used for internal purpose of the application but not from an input midi file.

it can influence the priority or order of the output solutions.

it should receive a value only in the ChordRepository database.
 */
public enum Occurrence {
    COMMON,
    NOT_COMMON,
    RARE
}
