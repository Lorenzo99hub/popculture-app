package list.perso.PopCulture.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import list.perso.PopCulture.model.Mangas;

public interface MangasRepository extends JpaRepository<Mangas,Integer> { // Hérite de findAll, findById, save, deleteById et autres
    
}
