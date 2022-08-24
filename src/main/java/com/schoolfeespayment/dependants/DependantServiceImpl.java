package com.schoolfeespayment.dependants;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependantServiceImpl implements DependantService {


    private DependantRepository dependantRepository;



    public DependantServiceImpl(DependantRepository dependantRepository) {
        super();
        this.dependantRepository = dependantRepository;
    }



    @Override
    public List<Dependant> getAllDependants() {
        // TODO Auto-generated method stub
        return dependantRepository.findAll();
    }



    @Override
    public Dependant saveDependant(Dependant dependant) {
        // TODO Auto-generated method stub
        return dependantRepository.save(dependant);
    }



    @Override
    public Dependant getDependantById(Long id) {
        // TODO Auto-generated method stub
        return dependantRepository.findById(id).get();
    }



    @Override
    public Dependant updateDependant(Dependant dependant) {
        // TODO Auto-generated method stub
        return dependantRepository.save(dependant);
    }



    @Override
    public void deleteDependantById(Long id) {
        // TODO Auto-generated method stub
        dependantRepository.deleteById(id);

    }
}
