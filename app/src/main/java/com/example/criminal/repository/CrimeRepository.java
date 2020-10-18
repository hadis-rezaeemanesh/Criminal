package com.example.criminal.repository;

import com.example.criminal.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeRepository implements IRepository{

    private static final int CRIME_SIZE = 100;
    private static CrimeRepository sInstance;

    public static CrimeRepository getInstance() {
        if (sInstance==null)
            sInstance = new CrimeRepository();
        return sInstance;
    }

    private List<Crime> mCrimes;

    private CrimeRepository() {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < CRIME_SIZE; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime#" + (i + 1));
            crime.setSolved(i % 2 == 0);

            mCrimes.add(crime);
        }
    }

    @Override
    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public void setCrimes(List<Crime> crimes) {
        mCrimes = crimes;
    }

    @Override
    public Crime getCrime(UUID id){
        for (Crime crime: mCrimes){
            if (crime.getId().equals(id))
                return crime;
        }
        return null;
    }

    @Override
    public void insertCrime(Crime crime){
        mCrimes.add(crime);
    }

    @Override
    public void deleteCrime(Crime crime){
        for (int i=0; i<mCrimes.size(); i++){
            if (mCrimes.get(i).getId().equals(crime.getId())){
                mCrimes.remove(i);
                return;
            }
        }
    }
    @Override
    public void updateCrime(Crime crime){

    }

    @Override
    public int getPosition(UUID crimeId){
        for (int i=0; i<mCrimes.size(); i++){
            if (mCrimes.get(i).getId().equals(crimeId))
                return i;
        }
        return 0;
    }
}
