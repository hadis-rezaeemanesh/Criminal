package com.example.criminal.repository;

import com.example.criminal.model.Crime;

import java.util.List;
import java.util.UUID;

public interface IRepository {
    List<Crime> getCrimes();
    Crime getCrime(UUID crimeId);
    void insertCrime(Crime crime);
    void deleteCrime(Crime crime);
    void updateCrime(Crime crime);
    int getPosition(UUID crimeId);
}
