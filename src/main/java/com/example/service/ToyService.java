package com.example.service;

import com.example.dto.ToyDto;
import com.example.mapper.ToyMapper;
import com.example.model.Toy;
import com.example.repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToyService {

    @Autowired
    ToyRepository toyRepository;

    @Autowired
    ToyMapper toyMapper;

    public List<ToyDto> getToysList(){
        return toyRepository.findAll().stream()
                .map(e -> toyMapper.mapToyDto(e))
                .collect(Collectors.toList());
    }

    public ToyDto getToyById(int id) throws Exception {
        Toy toy = toyRepository.findById(id).get();
        return toyMapper.mapToyDto(toy);
    }

    public Toy saveToys(ToyDto toyDto){
        Toy toy = toyMapper.mapToy(toyDto);
        toyRepository.save(toy);
        return toy;
    }


    public void deleteToys(Toy toy){
        toyRepository.delete(toy);
    }
    public void deleteToysById(int id){
        toyRepository.deleteById(id);
    }




}
