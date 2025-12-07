package list.perso.PopCulture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import list.perso.PopCulture.model.Mangas;
import list.perso.PopCulture.repo.MangasRepository;

@Service
public class MangasService {

    @Autowired
    private MangasRepository mangasRepository;

    public List<Mangas> getAll() {
        return mangasRepository.findAll();
    }

    public Mangas getById(Integer id) throws RuntimeException {

        if(id == null)
        {
            throw new RuntimeException("L'ID d'un mangas ne peut pas être null"); //Il faut gérer le cas null ici car c'est une simple lecture.
        }
        return mangasRepository.findById(id).orElse(null);
    }

    public Mangas createMangas(Mangas mangas) {
        return mangasRepository.save(mangas);
    }

    public Mangas updateMangas(Integer id, Mangas mangasBody) {

    Mangas existing = mangasRepository.findById(id).orElse(null);

    if (existing == null) {
        return null; // On signale au controller que le manga n'existe pas
    }

    existing.setNom(mangasBody.getNom());
    existing.setAuteur(mangasBody.getAuteur());
    existing.setTomeLu(mangasBody.getTomeLu());
    existing.setTomeTotal(mangasBody.getTomeTotal());

    return mangasRepository.save(existing);

    }

    public boolean deleteMangasById(Integer id) {          // Pas besoin de gerer le cas null ici car c'est une "operation critique" donc Spring le gère tout seul.
        if (mangasRepository.existsById(id)) {
            mangasRepository.deleteById(id);
            return true;
        }
            return false;
    }

    public void deleteMangas(Mangas mangas) {
        mangasRepository.delete(mangas);
    }
    
}
