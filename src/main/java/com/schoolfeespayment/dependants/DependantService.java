package com.schoolfeespayment.dependants;


import java.util.List;


public interface DependantService {


    List<Dependant> getAllDependants();

    Dependant saveDependant(Dependant dependant);

    Dependant getDependantById(Long id);

    Dependant updateDependant(Dependant dependant);

    void deleteDependantById(Long id);

}
