package guru.springframework.sgfpetclinic.services;

import guru.springframework.sgfpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findall();
}
