package org.example.petcarebackend.service.pet;

import lombok.RequiredArgsConstructor;
import org.example.petcarebackend.dto.pet.PetRequest;
import org.example.petcarebackend.dto.pet.PetResponse;
import org.example.petcarebackend.exception.ResourceNotFoundException;
import org.example.petcarebackend.model.pet.Pet;
import org.example.petcarebackend.repository.pet.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PetService {

    private final PetRepository petRepository;

    public List<PetResponse> findAll() {
        return petRepository.findAll()
                .stream()
                .map(PetResponse::from)
                .toList();
    }

    public PetResponse findById(Long id) {
        return PetResponse.from(getPet(id));
    }

    @Transactional
    public PetResponse create(PetRequest request) {
        Pet pet = Pet.builder()
                .name(request.getName())
                .species(request.getSpecies())
                .breed(request.getBreed())
                .dateOfBirth(request.getDateOfBirth())
                .build();

        return PetResponse.from(petRepository.save(pet));
    }

    @Transactional
    public PetResponse update(Long id, PetRequest request) {
        Pet pet = getPet(id);
        pet.setName(request.getName());
        pet.setSpecies(request.getSpecies());
        pet.setBreed(request.getBreed());
        pet.setDateOfBirth(request.getDateOfBirth());

        return PetResponse.from(petRepository.save(pet));
    }

    @Transactional
    public void delete(Long id) {
        Pet pet = getPet(id);
        petRepository.delete(pet);
    }

    private Pet getPet(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
    }
}
